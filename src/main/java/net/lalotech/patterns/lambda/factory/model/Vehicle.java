package net.lalotech.patterns.lambda.factory.model;

import java.awt.Color;

public class Vehicle {
    private Color color;
    public Vehicle(){
        this(Color.BLUE);
    }
    public Vehicle(Color color){
        this.color =  color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "color=" + color +
                '}';
    }
}
