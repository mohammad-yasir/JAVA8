package com.company.lambdas;

public class Vehicle {
    Integer modelNumber,price,weight;
    String color,type;

    public Integer getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(Integer modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "modelNumber=" + modelNumber +
                ", price=" + price +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

