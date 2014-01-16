package service;

import domain.LevelScores;
import domain.User;
import domain.UsersLevelScores;

import java.util.List;
import java.util.Map;

/**
 * @author Alexey
 */
public interface HighScoresUsersService {

    void addUserLevelScore(int idUser, int level, long score);

    UsersLevelScores getUserLevelScoresByLevel(int level);

    LevelScores getLevelScoresByUserId(int userId);

}
