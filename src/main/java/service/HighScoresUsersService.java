package service;

import java.util.Map;

/**
 * @author Alexey
 */
public interface HighScoresUsersService {

    void addUserIdLevelScore(int userId, int level, long score);

    Map<Integer, Long> getUserIdScoreByLevel(int level);

    Map<Integer, Long> getLevelScoresByUserId(int userId);

}
