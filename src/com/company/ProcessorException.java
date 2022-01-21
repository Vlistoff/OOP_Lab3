package com.company;

public class ProcessorException extends Throwable {

    private final int lower;

    public ProcessorException(int lower) {
        this.lower = lower;
    }

    public int getLower() {
        return lower;
    }
}
