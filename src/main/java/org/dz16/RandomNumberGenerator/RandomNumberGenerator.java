package org.dz16.RandomNumberGenerator;


import java.util.Random;

/**
 * Class org.dz16.RandomNumberGenerator.RandomNumberGenerator
 * author Igor Novikov
 * 25.10.24
 */

public class RandomNumberGenerator {
    public static int generateRandomNumber(int min, int max)
    {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
