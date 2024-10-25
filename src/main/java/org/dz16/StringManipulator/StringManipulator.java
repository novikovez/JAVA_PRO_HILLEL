package org.dz16.StringManipulator;


/**
 * Class org.dz16.StringManipulator.StringManipulator
 * author Igor Novikov
 * 24.10.24
 */

public class StringManipulator {
    public String handle(String string) {
        StringManipulatorInterface myFunction = (s) -> {
            return s.toUpperCase();
        };
        return myFunction.manipulate(string);
    }

}
