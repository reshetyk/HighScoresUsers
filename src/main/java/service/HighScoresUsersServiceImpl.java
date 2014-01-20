package service;

import domain.LevelScores;
import domain.User;
import domain.UsersLevelScores;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey
 */
public class HighScoresUsersServiceImpl implements HighScoresUsersService {

    private final UsersLevelScores usersLevelScores;

    public HighScoresUsersServiceImpl(UsersLevelScores usersLevelScores) {
        this.usersLevelScores = usersLevelScores;
    }

    public void addUserIdLevelScore(int userId, int level, long score) {
        usersLevelScores.addUserLevelScore(new User(userId), level, score);
    }

    public Map<Integer, Long> getUserIdScoreByLevel(int level) {
        Map<Integer, Long> result = new HashMap<Integer, Long>();
        for (Map.Entry<User, LevelScores> userLevelScoresEntry : usersLevelScores.entrySet()) {
            final LevelScores levelScores = userLevelScoresEntry.getValue();
            if (levelScores.containsKey(level)) {
                final Integer userId = userLevelScoresEntry.getKey().getId();
                final Long score = levelScores.get(level);
                result.put(userId, score);
            }
        }
        return result;
    }

    public Map<Integer, Long> getLevelScoresByUserId(int userId) {
        Map<Integer, Long> result = new HashMap<Integer, Long>();
        final LevelScores levelScores = usersLevelScores.get(new User(userId));
        for (Map.Entry<Integer, Long> levelScoresEntry : levelScores.entrySet()) {
            result.put(levelScoresEntry.getKey(), levelScoresEntry.getValue());
        }
        return result;
    }
}
