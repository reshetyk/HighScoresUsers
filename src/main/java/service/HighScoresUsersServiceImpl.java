package service;

import domain.LevelScores;
import domain.User;
import domain.UsersLevelScores;
import java.util.Map;

/**
 * @author Alexey
 */
public class HighScoresUsersServiceImpl implements HighScoresUsersService {

    private static UsersLevelScores usersLevelScores = new UsersLevelScores();

    public void addUserLevelScore(int idUser, int level, long score) {
        usersLevelScores.addUserLevelScore(new User(idUser), level, score);
    }

    public UsersLevelScores getUserLevelScoresByLevel(int level) {
        UsersLevelScores usersLevelScoresFiltered = new UsersLevelScores();
        final Map<User, LevelScores> userLevelScores = usersLevelScores.getUserLevelScores();
        for (Map.Entry<User, LevelScores> userLevelScoresEntry : userLevelScores.entrySet()) {
            final Map<Integer, Long> levelScoreMap = userLevelScoresEntry.getValue().getLevelScoreMap();
            if (levelScoreMap.containsKey(level)) {
                final Long score = levelScoreMap.get(level);
                usersLevelScoresFiltered.addUserLevelScore(userLevelScoresEntry.getKey(), level, score);
            }
        }
        return usersLevelScoresFiltered;
    }

    public LevelScores getLevelScoresByUserId(int userId) {
        return usersLevelScores.getUserLevelScores().get(new User(userId));
    }


}
