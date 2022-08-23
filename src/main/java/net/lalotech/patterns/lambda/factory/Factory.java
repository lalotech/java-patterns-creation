package net.lalotech.patterns.lambda.factory;


import net.lalotech.patterns.lambda.factory.model.Vehicle;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {


    default T newInstance(){
        return get();
    }

    default List<T> createMore(){
        return IntStream.range(0,3)
                .mapToObj(i -> newInstance())
                .collect(Collectors.toList());
    }

    /*static Factory<Vehicle> createFactory(){
        return ()-> new Vehicle();
    }
    static Factory<Vehicle> createFactory(Color color) {
        return ()-> new Vehicle(color);
    }*/

    static <T> Factory<T> createFactory(Supplier<T> supplier){
        //if you want a singleton here
        //T t = supplier.get();
        //return () -> t;

        return ()-> supplier.get();
    }
    static <P,T> Factory<T> createFactory(Function<P,T> construct, P color) {
        //by partial application
        //Function<Color,Vehicle> construct = c -> new Vehicle(c);
        return () -> construct.apply(color);
    }
}
