package net.lalotech.patterns.factory.abs;

import net.lalotech.patterns.factory.abs.model.CarMade;
import net.lalotech.patterns.factory.abs.model.EngineSize;
import net.lalotech.patterns.factory.abs.model.EngineType;

public class TestAbstractFactory {

    public static void main(final String arg[]) {

        CarFactory carFactory = CarFactory.getCarManufacturer(CarMade.FRANCE, EngineType.INLINE, EngineSize.FOUR);

        System.out.println(carFactory);
        System.out.println(carFactory.getCart());
        System.out.println(carFactory.getPerformanceScore());

        CarFactory carFactory2 = CarFactory.getCarManufacturer(CarMade.JAPAN, EngineType.ROTATORY, EngineSize.EIGHT);

        System.out.println(carFactory2);
        System.out.println(carFactory2.getCart());
        System.out.println(carFactory2.getPerformanceScore());
    }
}
