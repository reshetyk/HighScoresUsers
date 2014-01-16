package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey
 */
public class UsersLevelScores {
    private final Map<User, LevelScores> userLevelScores = new HashMap<User, LevelScores>();

    public void addUserLevelScore(User user, Integer level, Long score) {
        LevelScores levelScores = new LevelScores();
        if (userLevelScores.containsKey(user)) {
            levelScores = userLevelScores.get(user);
        }
        levelScores.put(level, score);
        userLevelScores.put(user, levelScores);
    }

    public Map<User, LevelScores> getUserLevelScores() {
        return userLevelScores;
    }

    public int size() {
        return userLevelScores.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersLevelScores)) return false;

        UsersLevelScores that = (UsersLevelScores) o;

        if (userLevelScores != null ? !userLevelScores.equals(that.userLevelScores) : that.userLevelScores != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userLevelScores != null ? userLevelScores.hashCode() : 0;
    }
}
