package domain;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alexey
 */
public class UsersLevelScores {
    private final Map<User, LevelScores> userLevelScores = new ConcurrentHashMap<User, LevelScores>();

    public void addUserLevelScore(User user, Integer level, Long score) {
        synchronized (userLevelScores) {
            LevelScores levelScores;
            if (userLevelScores.containsKey(user)) {
                levelScores = userLevelScores.get(user);
            } else {
                levelScores = new LevelScores();
            }
            levelScores.put(level, score);
            userLevelScores.put(user, levelScores);
        }
    }

    public LevelScores get(Object key) {
        return userLevelScores.get(key);
    }

    public Set<Map.Entry<User,LevelScores>> entrySet() {
        return userLevelScores.entrySet();
    }

    public int size() {
        return userLevelScores.size();
    }
}
