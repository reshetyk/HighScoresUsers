package service;

import domain.UsersLevelScores;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Alexey
 */
public class HighScoresUsersServiceImplTest {

    private HighScoresUsersService scoresUsersService;
    private UsersLevelScores usersLevelScores = new UsersLevelScores();

    @BeforeClass
    public void setUp() throws Exception {
        scoresUsersService = new HighScoresUsersServiceImpl(usersLevelScores);
    }


    @Test
    public void testAddUserLevelScoreSize() throws Exception {
        scoresUsersService.addUserIdLevelScore(1, 5, 5000);
        scoresUsersService.addUserIdLevelScore(1, 6, 4500);
        scoresUsersService.addUserIdLevelScore(1, 1, 9570);
        scoresUsersService.addUserIdLevelScore(3, 1, 9570);
        scoresUsersService.addUserIdLevelScore(2, 3, 8050);
        scoresUsersService.addUserIdLevelScore(2, 5, 5870);
        Assert.assertEquals(usersLevelScores.size(), 3);
    }

    @Test(dependsOnMethods = "testAddUserLevelScoreSize")
    public void testGetLevelScoresSize() throws Exception {
        Assert.assertEquals(2, scoresUsersService.getUserIdScoreByLevel(5).size());
        Assert.assertEquals(1, scoresUsersService.getUserIdScoreByLevel(6).size());
        Assert.assertEquals(2, scoresUsersService.getUserIdScoreByLevel(1).size());
        Assert.assertEquals(1, scoresUsersService.getUserIdScoreByLevel(3).size());
    }

    @Test(dependsOnMethods = "testAddUserLevelScoreSize")
    public void testGetUserLevelScoresSize() throws Exception {
        Assert.assertEquals(3, scoresUsersService.getLevelScoresByUserId(1).size());
        Assert.assertEquals(2, scoresUsersService.getLevelScoresByUserId(2).size());
        Assert.assertEquals(1, scoresUsersService.getLevelScoresByUserId(3).size());
    }
}
