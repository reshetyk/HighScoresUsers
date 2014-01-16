package service;

import httpServer.handler.GetLevelScoresByLevelHandler;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * @author Alexey
 */
public class HighScoresUsersServiceImplTest {

    HighScoresUsersService scoresUsersService = new HighScoresUsersServiceImpl();

    @Test
    public void testAddUserLevelScore() throws Exception {
        scoresUsersService.addUserLevelScore(1, 5, 5000);
        scoresUsersService.addUserLevelScore(1, 6, 4500);
        scoresUsersService.addUserLevelScore(1, 1, 9570);
        scoresUsersService.addUserLevelScore(3, 1, 9570);
        scoresUsersService.addUserLevelScore(2, 3, 8050);
        scoresUsersService.addUserLevelScore(2, 5, 5870);
    }

    @Test(dependsOnMethods = "testAddUserLevelScore")
    public void testGetLevelScores() throws Exception {
        Assert.assertEquals(2, scoresUsersService.getUserLevelScoresByLevel(5).size());
        Assert.assertEquals(1, scoresUsersService.getUserLevelScoresByLevel(6).size());
        Assert.assertEquals(2, scoresUsersService.getUserLevelScoresByLevel(1).size());
        Assert.assertEquals(1, scoresUsersService.getUserLevelScoresByLevel(3).size());
    }

    @Test(dependsOnMethods = "testAddUserLevelScore")
    public void testGetUserLevelScores() throws Exception {
        Assert.assertEquals(3, scoresUsersService.getLevelScoresByUserId(1).size());
        Assert.assertEquals(2, scoresUsersService.getLevelScoresByUserId(2).size());
        Assert.assertEquals(1, scoresUsersService.getLevelScoresByUserId(3).size());
    }
}
