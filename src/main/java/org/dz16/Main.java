package org.dz16;


import org.dz16.MathOperation.MathOperation;
import org.dz16.MathOperation.MathOperationInterface;
import org.dz16.RandomNumberGenerator.RandomNumberGenerator;
import org.dz16.StringListProcessor.StringListProcessor;
import org.dz16.StringManipulator.StringManipulator;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Class org.dz16.Main
 * author Igor Novikov
 * 24.10.24
 */

public class Main {
    public static void main(String[] args) {
        MathOperation mathOperation = new MathOperation();
        System.out.println("MathOperation: " + mathOperation.handle(5,3));

        StringManipulator manipulator = new StringManipulator();
        System.out.println("StringManipulator: " + manipulator.handle("hello"));

        Function<String, Integer> function = StringListProcessor::countUppercase;
        System.out.println("StringListProcessor: " + function.apply("Hello"));

        Supplier<Integer> supplier = () -> RandomNumberGenerator.generateRandomNumber(1,100);
        System.out.println("RandomNumberGenerator: " + supplier.get());
    }
}
