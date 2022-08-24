package net.lalotech.patterns.lambda.registry;

import net.lalotech.patterns.lambda.factory.Factory;
import net.lalotech.patterns.lambda.registry.model.Boat;
import net.lalotech.patterns.lambda.registry.model.Car;
import net.lalotech.patterns.lambda.registry.model.Vehicle;

import java.util.function.Consumer;
import java.util.function.Function;

public class TestRegistry {
    public static void main(String[] args) {
        Consumer<Builder<Vehicle>> consumer1 = carBuilder ->
                carBuilder.registry("car",Car::new);
        Consumer<Builder<Vehicle>> consume2 = carBuilder ->
                carBuilder.registry("boat", Boat::new);

        Consumer<Builder<Vehicle>> consumer = consumer1.andThen(consume2);

        Function<String,Factory<Vehicle>> errorFunction = s -> {
            throw new IllegalArgumentException("Unknown vehicle: "+s);
        };
        Registry registry = Registry.createRegistry(consumer,errorFunction);

        Factory<Car> carFactory = (Factory<Car>)registry.buildFactory("car");
        Car car = carFactory.newInstance();
        System.out.println("car "+car);

        Factory<Boat> boatFactory = (Factory<Boat>)registry.buildFactory("boat");
        Boat boat = boatFactory.newInstance();
        System.out.println("boat "+boat);

        Factory<Vehicle> vehicleFactory = (Factory<Vehicle>)registry.buildFactory("airplane");
        //Vehicle vehicle = vehicleFactory.newInstance();
    }
}
