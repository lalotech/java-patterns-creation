package net.lalotech.patterns.factory.abs;

import net.lalotech.patterns.factory.abs.cars.Car;

public class AudiFactory extends CarFactory {
    @Override
    public Car getCart() {
        return null;
    }

    @Override
    public Integer getPerformanceScore() {
        return null;
    }
}
