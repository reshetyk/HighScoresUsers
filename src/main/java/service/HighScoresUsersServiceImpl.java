package service;

import domain.LevelScore;
import domain.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexey
 */
public class HighScoresUsersServiceImpl implements HighScoresUsersService {
    private static Map<User, LevelScore> userLevelScoreMap = new LinkedHashMap<User, LevelScore>();

    public void addUserLevelScore(int idUser, int level, long score) {
        userLevelScoreMap.put(new User(idUser), new LevelScore(level, score));
    }

    /**
     * Request: GET /levelscores?level=<levelid>
     * Response: list of <userid>=<score> separated by ‘;’
     * Example: GET http://localhost:8080/levelscores?level=12 -> 142=5661;23=5444;12=1200
     *
     * @param level
     * @return
     */
    public Map<User, LevelScore> getUserLevelScoresByLevel(int level) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Request: GET /userscores?user=<userid>
     * Response: list of <levelid>=<score> separated by ‘;’
     * Example: GET http://localhost:8080/userscores?user=142 -> 12=5661;13=4912;11=1560
     *
     * @param userId
     * @return
     */
    public List<LevelScore> getLevelScoresByUserId(int userId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }


}
