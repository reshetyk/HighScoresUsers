package service;

import domain.LevelScore;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author Alexey
 */
public interface HighScoresUsersService {

    void addUserLevelScore(int idUser, int level, long score);

    Map<User, LevelScore> getUserLevelScoresByLevel(int level);

    List<LevelScore> getLevelScoresByUserId(int userId);

}
