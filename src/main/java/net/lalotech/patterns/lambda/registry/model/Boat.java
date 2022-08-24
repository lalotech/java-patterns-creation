package net.lalotech.patterns.lambda.registry.model;

public class Boat extends Vehicle{
    @Override
    public void start() {
        System.out.printf("starting Boat");
    }

    @Override
    public String toString() {
        return "Boat{}";
    }
}
