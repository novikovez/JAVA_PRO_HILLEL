package org.dz16.MathOperation;


/**
 * Class org.dz16.MathOperation.MathOperation
 * author Igor Novikov
 * 24.10.24
 */

public class MathOperation {
    public int handle(int a, int b) {
        MathOperationInterface myObject = new MathOperationInterface() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        return myObject.operate(a, b);
    }
}
