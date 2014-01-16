package httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import httpServer.handler.AddUserLevelScoreHandler;
import httpServer.handler.GetLevelScoresByLevelHandler;
import service.HighScoresUsersService;
import service.HighScoresUsersServiceImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * @author Alexey
 */
public class ScalableHttpServer {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        HighScoresUsersService service = new HighScoresUsersServiceImpl();
        server.createContext("/postscore", new AddUserLevelScoreHandler(service));
        server.createContext("/levelscores", new GetLevelScoresByLevelHandler(service));
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started");
    }

}
