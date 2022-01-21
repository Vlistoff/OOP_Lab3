package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataProcessor<T extends Operation> {
    private List<T> CurrentList;

    public int low;
    public int high;
    public void setList(List<T> list){
        this.CurrentList = list;
    }

    public void setCurrentList(List<T> currentList) {
        CurrentList = currentList;
    }

    public void Processing(int executionTimeLow, int executionTimeHigh) throws ProcessorException {
        if (executionTimeLow > executionTimeHigh){
            low = executionTimeLow;
            high = executionTimeHigh;
            throw new ProcessorException(executionTimeLow);
        }
        List<Operation> List = CurrentList.stream()
                .map(element -> {
                    return new SimpleOperation(element.getNumber(), element.getExecutionTime());
                })
                .filter(element -> element.getExecutionTime() > executionTimeLow)
                .filter(element -> element.getExecutionTime() < executionTimeHigh)
                .limit(2)
                .sorted(Comparator.comparing(Operation::getExecutionTime).reversed())
                .peek(Operation -> System.out.print(Operation.getInfo()))
                .collect(Collectors.toList());
    }

    public Operation matching(int match){
        Optional<T> elementOptional = CurrentList.stream()
                .filter(element -> element.getExecutionTime() == match)
                .findFirst();
        Operation operation = null;
        if (elementOptional.isPresent()) { //Проверяем, что мы хоть что-то нашли
            operation = elementOptional.get(); //Получаем элемент
        }
        else
            System.out.println("Элемент не найден!");
        return operation;
    }




}
