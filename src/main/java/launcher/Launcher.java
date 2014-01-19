package launcher;

import domain.UsersLevelScores;
import httpServer.ScalableHttpServer;
import httpServer.handler.AddUserIdLevelScoreHandler;
import httpServer.handler.GetLevelScoresByUserIdHandler;
import httpServer.handler.GetUserIdScoreByLevelHandler;
import service.HighScoresUsersServiceImpl;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.LogManager;

/**
 * @author oreshetiuk
 */
public class Launcher {

    public static void  main (String [] args) throws IOException {
        LogManager.getLogManager().readConfiguration(Launcher.class.getResourceAsStream("/logging.properties"));

        Properties properties = new Properties();
        properties.load(Launcher.class.getResourceAsStream("/httpserver-config.properties"));

        final HighScoresUsersServiceImpl highScoresUsersService = new HighScoresUsersServiceImpl(new UsersLevelScores());

        ScalableHttpServer httpServer = new ScalableHttpServer(properties);
        httpServer.addHttpContextHandler(new AddUserIdLevelScoreHandler("/postscore", highScoresUsersService));
        httpServer.addHttpContextHandler(new GetUserIdScoreByLevelHandler("/levelscore", highScoresUsersService));
        httpServer.addHttpContextHandler(new GetLevelScoresByUserIdHandler("/userscores", highScoresUsersService));
        httpServer.start();
    }
}
