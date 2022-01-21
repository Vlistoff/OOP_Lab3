package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        StringBuilder matchedList = new StringBuilder();

        List<Operation> operations = new ArrayList<>();
        operations.add(new ComplexOperation(1,10, 100));
        operations.add(new ComplexOperation(2,30, 300));
        operations.add(new ComplexOperation(3,25, 400));
        operations.add(new ComplexOperation(4,15, 100));
        operations.add(new ComplexOperation(5,15, 100));
        operations.add(new ComplexOperation(6,10, 100));
        operations.add(new ComplexOperation(7,5, 20));
        operations.add(new ComplexOperation(8,15, 100));
        operations.add(new ComplexOperation(9,5, 20));
        operations.add(new SimpleOperation(1,10));
        operations.add(new SimpleOperation(2,5));
        operations.add(new SimpleOperation(3,15));
        operations.add(new SimpleOperation(4,30));
        operations.add(new SimpleOperation(5,25));

        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Угрюмов", "Арсений", 2));
        workers.add(new Worker("Голубков", "Никита", 3));
        workers.add(new Worker("Тюленев", "Сергей", 1));
        workers.add(new Worker("Кузьменко", "Илья", 2));
        workers.add(new Worker("Смирнов", "Андрей", 1));

        List<InfoGiver> objects = new ArrayList<>();
        objects.addAll(operations);
        objects.addAll(workers);
//        int[] chainOfOperations = new int[]{9, 3, 4, 2, 5, 0, 8, 7, 1, 6};
//        int totalTime = 0;
//        int totalCost = 0;
//
//        int[] chainOfTemporary = new int[chainOfOperations.length - 1];
//        int[] chainOfCosts = new int[chainOfOperations.length - 1];
//
//        for (int i=0; i < (chainOfOperations.length - 1); i++){
//            totalTime = totalTime + operations.get(chainOfOperations[i]).getExecutionTime();
//            totalCost = totalCost + operations.get(chainOfOperations[i]).getCost();
//            chainOfTemporary[i] = operations.get(chainOfOperations[i]).getExecutionTime();
//            chainOfCosts[i] = operations.get(chainOfOperations[i]).getCost();
//        }

        DataProcessor<Operation> operationDataProcessorStream = new DataProcessor<>();
        operationDataProcessorStream.setCurrentList(operations);



//        System.out.println("Общее время выполнения: " + totalTime);
//        System.out.println("Общая стоимость выполнения: " + totalCost);
//        System.out.println("Цепочка времени:" + Arrays.toString(chainOfTemporary));
//        System.out.println("цепочка затрат:" + Arrays.toString(chainOfCosts));
//
        try {
            operationDataProcessorStream.Processing(10, 30);
        } catch (ProcessorException e) {
            System.out.println("ОШИБКА!!!\n" + e.getLower() + " > "
                    + operationDataProcessorStream.high + " !!!");
        }

//        Operation match = operationDataProcessorStream.matching(15);
//        if (match.getNumber() != -1) {
//            match.getInfo();
//        }
//        else {
//            System.out.println("Не найден элемент по заданному параметру");
//        }
        List<Operation> matched = new ArrayList<>();
        matched.add(operationDataProcessorStream.matching(15));


        for (InfoGiver element : matched) {
            if (element != null) {
                matchedList.append(element.getInfo());
            }
        }

        System.out.println(matchedList);
    }
}
