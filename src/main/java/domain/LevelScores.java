package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alexey
 */
public class LevelScores {
    private final Map<Integer, Long> levelScoreMap = new ConcurrentHashMap<Integer, Long>();

    public void put (Integer level, Long score) {
        levelScoreMap.put(level, score);
    }

    public Map<Integer, Long> getLevelScoreMap() {
        return levelScoreMap;
    }

}
