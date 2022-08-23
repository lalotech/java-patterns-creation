package net.lalotech.patterns.lambda.factory;



import net.lalotech.patterns.lambda.factory.model.Vehicle;

import java.awt.Color;
import java.util.List;

public class TestFactory {
    public static void main(String[] args) {

        // common way to implement
        //Factory<Vehicle> factory = ()-> new Vehicle();
        //Factory<Vehicle> factory = Factory.createFactory();
        //Factory<Vehicle> factory = Factory.createFactory(Color.RED);

        //sending the constructor as parameter
        //Factory<Vehicle> factory = Factory.createFactory((color)-> new Vehicle(color),Color.GREEN);

        Factory<Vehicle> factory = Factory.createFactory((color)-> new Vehicle(color),Color.GREEN);
        //with method reference
        Factory<Vehicle> factory2 = Factory.createFactory(Vehicle::new);
        Factory<Vehicle> factory3 = Factory.createFactory(Vehicle::new,Color.BLACK);

        Vehicle car = factory.newInstance();
        System.out.println("car - "+car);

        List<Vehicle> moreCars = factory.createMore();
        System.out.println("moreCars - "+moreCars);
    }
}
