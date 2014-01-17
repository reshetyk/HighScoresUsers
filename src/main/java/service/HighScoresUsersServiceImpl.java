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
        final Map<User, LevelScores> userLevelScores = usersLevelScores.getUserLevelScores();
        for (Map.Entry<User, LevelScores> userLevelScoresEntry : userLevelScores.entrySet()) {
            final Map<Integer, Long> levelScoreMap = userLevelScoresEntry.getValue().getLevelScoreMap();
            if (levelScoreMap.containsKey(level)) {
                final Integer userId = userLevelScoresEntry.getKey().getId();
                final Long score = levelScoreMap.get(level);
                result.put(userId, score);
            }
        }
        return result;
    }

    public Map<Integer, Long> getLevelScoresByUserId(int userId) {
        return usersLevelScores.getUserLevelScores().get(new User(userId)).getLevelScoreMap();

    }

    public UsersLevelScores getUsersLevelScores() {
        return usersLevelScores;
    }
}
