package org.convertor.service.temperature;


/*
| Автор: Igor Novikov |
*/

import org.convertor.service.ConvertorServiceInterface;

public class FrToCe implements ConvertorServiceInterface {
    @Override
    public double handler(double value) {
        return (value - 32) * 5 / 9;
    }
}
