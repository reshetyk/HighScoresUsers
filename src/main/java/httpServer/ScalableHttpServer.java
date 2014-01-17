package httpServer;

import com.sun.net.httpserver.HttpServer;
import httpServer.handler.HttpContextHandler;

import java.io.IOException;
import java.util.concurrent.Executors;

/**
 * @author Alexey
 */
public class ScalableHttpServer {

    private final HttpServer server;

    public ScalableHttpServer(HttpServer server) {
        this.server = server;
    }

    public void start() {
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Server started");
    }

    public void addHttpContextHandler(HttpContextHandler handler) {
        server.createContext(handler.getContext(), handler);
    }


}
