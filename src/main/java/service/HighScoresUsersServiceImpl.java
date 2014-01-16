package service;

import domain.LevelScores;
import domain.User;
import domain.UsersLevelScores;
import httpServer.handler.GetLevelScoresByLevelHandler;

import java.util.List;
import java.util.Map;

/**
 * @author Alexey
 */
public class HighScoresUsersServiceImpl implements HighScoresUsersService {

    private static UsersLevelScores usersLevelScores = new UsersLevelScores();

    public void addUserLevelScore(int idUser, int level, long score) {
        usersLevelScores.addUserLevelScore(new User(idUser), level, score);
    }

    /**
     * Request: GET /levelscores?level=<levelid>
     * Response: list of <userid>=<score> separated by ‘;’
     * Example: GET http://localhost:8080/levelscores?level=12 -> 142=5661;23=5444;12=1200
     *
     * @param level
     * @return
     */
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

    /**
     * Request: GET /userscores?user=<userid>
     * Response: list of <levelid>=<score> separated by ‘;’
     * Example: GET http://localhost:8080/userscores?user=142 -> 12=5661;13=4912;11=1560
     *
     * @param userId
     * @return
     */
    public LevelScores getLevelScoresByUserId(int userId) {
        return usersLevelScores.getUserLevelScores().get(new User(userId));
    }


}
