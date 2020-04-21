package net.lalotech.patterns.factory.abs;

import net.lalotech.patterns.factory.abs.cars.Car;
import net.lalotech.patterns.factory.abs.model.EngineSize;
import net.lalotech.patterns.factory.abs.model.EngineType;
import net.lalotech.patterns.factory.abs.model.RenaultCar;

public class RenaultFactory extends CarFactory {
    private EngineSize engineSize;
    private EngineType engineType;

    protected RenaultFactory(final EngineType engineType, final EngineSize engineSize) {
        this.engineSize = engineSize;
        this.engineType = engineType;
    }

    @Override
    public Car getCart() {
        RenaultCar car = new RenaultCar();
        car.setBrand("Renault");
        car.setDoors(4);
        car.setModel("clio");
        car.setPrice(15000.00);
        car.setEngineSize(engineSize.name());
        car.setEngineType(engineType.name());
        return car;
    }

    @Override
    public Integer getPerformanceScore() {
        return 170;
    }
}
