package org.convertor.service.distance;


/*
| Автор: Igor Novikov |
*/

import org.convertor.service.ConvertorInterface;

public class MilesToKm implements ConvertorInterface {
    @Override
    public double handler(double value) {
        return value * CONV_KM_MILES;
    }
}
