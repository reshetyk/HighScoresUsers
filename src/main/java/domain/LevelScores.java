package domain;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alexey
 */
public class LevelScores {
    private final Map<Integer, Long> levelScoreMap = new ConcurrentHashMap<Integer, Long>();

    public void put(Integer level, Long score) {
        levelScoreMap.put(level, score);
    }

    public Long get(Object key) {
        return levelScoreMap.get(key);
    }

    public boolean containsKey(Object key) {
        return levelScoreMap.containsKey(key);
    }

    public Set<Map.Entry<Integer, Long>> entrySet() {
        return levelScoreMap.entrySet();
    }
}
