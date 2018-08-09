package com.haojg.reflect;

public class Car {
    private String brand; //品牌
    private String color; //颜色
    private int maxSpeed; //转速

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    public Car() {
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void say() {
        System.out.println("brand:" + brand + ", color:" + color + ", maxSpeed:" + maxSpeed);
    }

}