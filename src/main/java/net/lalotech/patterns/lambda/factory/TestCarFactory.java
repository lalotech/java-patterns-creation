package net.lalotech.patterns.lambda.factory;

import net.lalotech.patterns.lambda.factory.model.Car;

import java.util.List;
import java.util.function.Supplier;

public class TestCarFactory {
    public static void main(String[] args) {
        //using the Supplier interface
        Supplier<Car> factory = () -> new Car();
        Car newCar = factory.get();
        System.out.println("the new car - "+newCar);

        //extending the Supplier interface and add more methods
        CarFactory carFactory = () -> new Car();
        Car carTwo = carFactory.newInstance();
        System.out.println("factory car two - "+carTwo);

        List<Car> moreCars = carFactory.createMoreCars();
        System.out.println("moreCars - "+moreCars);
    }
}
