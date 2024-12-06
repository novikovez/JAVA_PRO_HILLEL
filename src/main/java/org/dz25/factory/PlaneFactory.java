package org.dz25.factory;

public class PlaneFactory implements TransportFactory{
    @Override
    public Transport createTransport() {
        return new Plane("PlaneFactory");
    }
}
