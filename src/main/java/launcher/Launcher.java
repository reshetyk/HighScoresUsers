package launcher;

import com.sun.net.httpserver.HttpServer;
import domain.UsersLevelScores;
import httpServer.ScalableHttpServer;
import httpServer.handler.AddUserIdLevelScoreHandler;
import httpServer.handler.GetLevelScoresByUserIdHandler;
import httpServer.handler.GetUserIdScoreByLevelHandler;
import service.HighScoresUsersServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author oreshetiuk
 */
public class Launcher {

    public static void  main (String [] args) throws IOException {
        final HighScoresUsersServiceImpl highScoresUsersService = new HighScoresUsersServiceImpl(new UsersLevelScores());

        ScalableHttpServer httpServer = new ScalableHttpServer(HttpServer.create(new InetSocketAddress(8080), 0));
        httpServer.addHttpContextHandler(new AddUserIdLevelScoreHandler("/postscore", highScoresUsersService));
        httpServer.addHttpContextHandler(new GetUserIdScoreByLevelHandler("/levelscore", highScoresUsersService));
        httpServer.addHttpContextHandler(new GetLevelScoresByUserIdHandler("/userscores", highScoresUsersService));
        httpServer.start();
    }
}
