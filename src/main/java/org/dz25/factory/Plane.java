package org.dz25.factory;

public class Plane implements Transport{
    private String factory;
    public final static String run = "Plane moving";


    public Plane(String factory) {
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
