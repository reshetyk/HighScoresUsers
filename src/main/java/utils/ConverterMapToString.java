package utils;

import java.util.Map;

/**
 * @author Alexey
 */
public class ConverterMapToString<K, V> {
    private final Map<K, V> map;

    public ConverterMapToString(Map<K, V> map) {
        this.map = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append(entry.getKey()).append('=').append(entry.getValue()).append(';');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }
}