package org.convertor.service;


/*
| Автор: Igor Novikov |
*/

public interface ConvertorServiceInterface {
    final static double CONV_K = 2.20262;
    final static double CONV_KM_MILES = 1.60934;
    double handler(double value);
}
