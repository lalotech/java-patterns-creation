package net.lalotech.patterns.lambda.registry;

import net.lalotech.patterns.lambda.factory.Factory;
import net.lalotech.patterns.lambda.registry.model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Registry {
    Factory<? extends Vehicle> buildFactory(String name);

    static Registry createRegistry(Consumer<Builder<Vehicle>> consumer,Function<String,Factory<Vehicle>> errorFunction){
        Map<String,Factory<Vehicle>> map = new HashMap<>();
        Builder<Vehicle> builder = (label,factory)-> map.put(label,factory);
        consumer.accept(builder);

        //System.out.println("map "+map);

        //return vehicle -> map.get(vehicle);

        //option 1
        //return vehicle -> map.getOrDefault(vehicle,()-> {throw new IllegalArgumentException("Unknown vehicle: "+vehicle);});

        //option 2 - using function
        //return vehicle -> map.computeIfAbsent(vehicle,s -> {throw new IllegalArgumentException("Unknown vehicle: "+vehicle);});

        //option 3 - using functions as parameter - allow the errorHandler from outside
        //Function<String,Factory<Vehicle>> errorFunction = s -> {throw new IllegalArgumentException("Unknown vehicle: "+s);};
        return vehicle -> map.computeIfAbsent(vehicle,errorFunction);
    }
}
