package net.lalotech.patterns.factory.abs;

import net.lalotech.patterns.factory.abs.cars.Car;

public class GMFactory extends CarFactory{
    @Override
    public Integer getPerformanceScore() {
        return null;
    }

    @Override
    public Car getCart() {
        return null;
    }
}
