package org.convertor.service.temperature;


/*
| Автор: Igor Novikov |
*/

import org.convertor.service.ConvertorServiceInterface;

public class CeToFr implements ConvertorServiceInterface {
    @Override
    public double handler(double value) {
        return value * 9 / 5 + 32;
    }
}
