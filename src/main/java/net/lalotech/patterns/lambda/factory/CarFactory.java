package net.lalotech.patterns.lambda.factory;

import net.lalotech.patterns.lambda.factory.model.Car;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface CarFactory extends Supplier<Car> {
   default Car newInstance(){
       return get();
   }
   default List<Car> createMoreCars(){
       return IntStream.range(0,3)
               .mapToObj(i -> newInstance())
               .collect(Collectors.toList());
   }
}
