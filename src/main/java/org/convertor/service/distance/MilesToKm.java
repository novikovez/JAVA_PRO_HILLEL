package org.convertor.service.distance;


/*
| Автор: Igor Novikov |
*/

import org.convertor.service.ConvertorServiceInterface;

public class MilesToKm implements ConvertorServiceInterface {
    @Override
    public double handler(double value) {
        return value * CONV_KM_MILES;
    }
}
