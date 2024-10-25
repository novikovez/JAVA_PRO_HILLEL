package org.dz16.StringListProcessor;


/**
 * Class org.dz16.StringListProcessor.StringListProcessor
 * author Igor Novikov
 * 24.10.24
 */

public class StringListProcessor {
    public static int countUppercase(String s) {
        int upperCaseCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCaseCount++;
            }
        }
        return upperCaseCount;
    }
}
