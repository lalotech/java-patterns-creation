package net.lalotech.patterns.factory.model;

public abstract class Car {

    private String engineSize;
    private String engineType;
    private String model;
    private String brand;
    private Integer doors;
    private Double price;

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(final String engineSize) {
        this.engineSize = engineSize;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(final String engineType) {
        this.engineType = engineType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(final Integer doors) {
        this.doors = doors;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }
}
