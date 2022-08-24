package net.lalotech.patterns.lambda.registry.model;

public class Car extends Vehicle{
    @Override
    public void start() {
        System.out.printf("starting Car");
    }

    @Override
    public String toString() {
        return "Car{}";
    }
}
