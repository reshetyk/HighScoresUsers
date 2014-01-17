package utils;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Alexey
 */
public class ConverterMapToString <K, V> {
    private Map<K, V> map;

    public ConverterMapToString(Map<K, V> map) {
        this.map = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<K, V>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<K, V> entry = iter.next();
            sb.append(entry.getKey()).append('=').append(entry.getValue());
            sb.append(';');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }
}