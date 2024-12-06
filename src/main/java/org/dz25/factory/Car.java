package org.dz25.factory;

public class Car implements Transport{
    public final static String run = "Car moving";

    private String factory;

    public Car(String factory) {
        this.factory = factory;
    }

    @Override
    public String move() {
       return run;
    }

    @Override
    public String getFactory() {
        return this.factory;
    }
}
