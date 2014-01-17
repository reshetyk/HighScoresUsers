package httpServer;

import com.sun.net.httpserver.HttpServer;
import httpServer.handler.AddUserIdLevelScoreHandler;
import httpServer.handler.GetLevelScoresByUserIdHandler;
import httpServer.handler.GetUserIdScoreByLevel;
import service.HighScoresUsersService;
import service.HighScoresUsersServiceImpl;

import java.net.InetSocketAddress;

/**
 * @author Alexey
 */
public class ScalableHttpServer {

    public static void main(String[] args) throws Exception {
        final HighScoresUsersServiceImpl highScoresUsersService = new HighScoresUsersServiceImpl();

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/postscore", new AddUserIdLevelScoreHandler(highScoresUsersService));
        server.createContext("/levelscores", new GetUserIdScoreByLevel(highScoresUsersService));
        server.createContext("/userscores", new GetLevelScoresByUserIdHandler(highScoresUsersService));

        server.setExecutor(null); // creates a default executor

        server.start();

        System.out.println("Server started");
    }

}
