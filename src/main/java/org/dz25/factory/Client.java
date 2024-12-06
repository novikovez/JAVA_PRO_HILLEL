package org.dz25.factory;

import java.util.Objects;

public class Client {
    public void run() {
        CarFactory carFactory = new CarFactory();
        PlaneFactory planeFactory = new PlaneFactory();
        Transport car = carFactory.createTransport();
        Transport plane = planeFactory.createTransport();

        System.out.println(car.move());
        System.out.println(plane.move());

        checkFactory(car, "CarFactory");
        checkFactory(plane, "PlaneFactory");

        checkMethod(car, Car.run);
        checkMethod(plane, Plane.run);


    }

    private void checkFactory(Transport transport, String expectedFactory) {
        if (!transport.getFactory().equals(expectedFactory)) {
            throw new IllegalStateException("Об’єкт не було створено очікуваною фабрикою. Очікується: " +
                    expectedFactory + ", але створено: " + transport.getFactory());
        }
        System.out.println(transport.getClass().getSimpleName() + " створено " + expectedFactory);
    }

    private void checkMethod(Transport transport, String methodResult) {
        if(!(Objects.equals(transport.move(), methodResult))) {
            throw new IllegalStateException("Метод дає некоректний результат!");
        }
    }

}
