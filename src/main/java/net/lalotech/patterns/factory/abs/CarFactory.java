package net.lalotech.patterns.factory.abs;

import net.lalotech.patterns.factory.abs.cars.Car;
import net.lalotech.patterns.factory.abs.model.CarMade;
import net.lalotech.patterns.factory.abs.model.EngineSize;
import net.lalotech.patterns.factory.abs.model.EngineType;

public abstract class CarFactory {

    public static CarFactory getCarManufacturer(final CarMade carMade, final EngineType engineType, final EngineSize engineSize) {
        switch (carMade) {
            case FRANCE:
                return new RenaultFactory(engineType, engineSize);
            case JAPAN:
                return new ToyotaFactory(engineType, engineSize);
            case GERMANY:
                return new AudiFactory();
            case USA:
                return new GMFactory();
            case SPAIN:
                return new SeatFactory();
            default:
                return null;
        }
    }

    public abstract Car getCart();

    public abstract Integer getPerformanceScore();

}
