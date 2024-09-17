package org.shop_research;


/**
 * Class org.shop_research.DataHandler
 * author Igor Novikov
 * 17.09.24
 */

public class DataHandler {
    public <T> String handleData(T[] type) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (T item : type) {
            count++;
            sb.append(String.format("(%d) %s ", count, item));
        }
        return sb.toString();
    }
}
