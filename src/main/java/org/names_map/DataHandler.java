package org.names_map;


import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class org.names_map.DataHandler
 * author Igor Novikov
 * 18.10.24
 */

public class DataHandler {
    private final DataRepository repository = new DataRepository();
    private final Map<Integer, String> data = this.repository.getData();

    public String getAll() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        data.forEach((id, name) ->
                sb.append(String.format("%d) %d, %s%n",
                        count.incrementAndGet(),id, name)
        ));
        return "\nALL NAMES:\n" + sb;
    }

    public String getById(int id) {
        if (this.data.containsKey(id)) {
            return "NAME: id " + id + ", " +
                    data.get(id) + "\n";
        } else return "No data!";
    }
}
