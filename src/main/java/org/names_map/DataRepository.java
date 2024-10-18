package org.names_map;


import java.util.HashMap;
import java.util.Map;

/**
 * Class org.names_map.DataRepository
 * author Igor Novikov
 * 18.10.24
 */

public class DataRepository {

    public Map<Integer, String> getData() {
        Map<Integer, String> map = new HashMap<>();
        map.put(387, "Lucy");
        map.put(231, "Alice");
        map.put(394, "Bob");
        map.put(172, "Tom");
        return map;
    }
}