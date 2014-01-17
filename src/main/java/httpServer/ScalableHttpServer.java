package httpServer;

import com.sun.net.httpserver.HttpServer;
import domain.UsersLevelScores;
import httpServer.handler.AddUserIdLevelScoreHandler;
import httpServer.handler.GetLevelScoresByUserIdHandler;
import httpServer.handler.GetUserIdScoreByLevelHandler;
import httpServer.handler.HttpContextHandler;
import service.HighScoresUsersServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey
 */
public class ScalableHttpServer {

    private HttpServer server;

    public ScalableHttpServer(HttpServer server) {
        this.server = server;
    }

    public void start() throws IOException {
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started");
    }

    public void addHttpContextHandler(HttpContextHandler handler) {
        server.createContext(handler.getContext(), handler);
    }


}
