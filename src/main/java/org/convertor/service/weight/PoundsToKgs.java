package org.convertor.service.weight;


/*
| Автор: Igor Novikov |
*/

import org.convertor.service.ConvertorServiceInterface;

public class PoundsToKgs implements ConvertorServiceInterface {

    @Override
    public double handler(double value) {
        return value / CONV_K;
    }
}
