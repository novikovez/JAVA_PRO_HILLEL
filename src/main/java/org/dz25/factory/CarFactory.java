package org.dz25.factory;

public class CarFactory implements TransportFactory{
    @Override
    public Transport createTransport() {
        return new Car("CarFactory");
    }
}
