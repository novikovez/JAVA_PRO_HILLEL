package org.convertor.service.weight;


/*
| Автор: Igor Novikov |
*/

import org.convertor.service.ConvertorInterface;

public class PoundsToKgs implements ConvertorInterface {

    @Override
    public double handler(double value) {
        return value / CONV_K;
    }
}
