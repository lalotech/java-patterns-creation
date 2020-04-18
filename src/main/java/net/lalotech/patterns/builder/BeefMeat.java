package net.lalotech.patterns.builder;

public class BeefMeat implements Meat {

    private String color;
    private String name;
    private String type;

    public BeefMeat(String name, String type, String color) {
        this.color = color;
        this.type = type;
        this.name = name;
    }

    public String getColor() {
        return this.color;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("name=%s, type=%s, color=%s", name, type, color);
    }
}
