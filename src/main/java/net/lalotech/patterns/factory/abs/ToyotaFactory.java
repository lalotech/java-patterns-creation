package net.lalotech.patterns.factory.abs;

import net.lalotech.patterns.factory.abs.cars.Car;
import net.lalotech.patterns.factory.abs.cars.ToyotaCar;
import net.lalotech.patterns.factory.abs.model.EngineSize;
import net.lalotech.patterns.factory.abs.model.EngineType;

public class ToyotaFactory extends CarFactory {

    private EngineSize engineSize;
    private EngineType engineType;

    protected ToyotaFactory(final EngineType engineType, final EngineSize engineSize) {
        this.engineSize = engineSize;
        this.engineType = engineType;
    }

    @Override
    public Integer getPerformanceScore() {
        return 250;
    }

    @Override
    public Car getCart() {
        ToyotaCar car = new ToyotaCar();
        car.setBrand("Toyota");
        car.setDoors(4);
        car.setModel("Camry");
        car.setPrice(18000.00);
        car.setEngineSize(engineSize.name());
        car.setEngineType(engineType.name());
        return car;
    }
}
