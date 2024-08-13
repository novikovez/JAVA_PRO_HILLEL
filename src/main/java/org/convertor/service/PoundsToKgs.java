package org.convertor.service;


/*
| Автор: Igor Novikov |
*/

public class PoundsToKgs implements ConvertorInterface {

    @Override
    public double handler(double value) {
        return value / CONV_K;
    }
}
