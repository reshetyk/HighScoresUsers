package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey
 */
public class LevelScores {
    private final Map<Integer, Long> levelScoreMap = new HashMap<Integer, Long>();

    public void put (Integer level, Long score) {
        levelScoreMap.put(level, score);
    }

    public Map<Integer, Long> getLevelScoreMap() {
        return levelScoreMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LevelScores)) return false;

        LevelScores that = (LevelScores) o;

        if (levelScoreMap != null ? !levelScoreMap.equals(that.levelScoreMap) : that.levelScoreMap != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return levelScoreMap != null ? levelScoreMap.hashCode() : 0;
    }

    public int size() {
        return levelScoreMap.size();
    }
}
