package httpServer;

import com.sun.net.httpserver.HttpServer;
import httpServer.handler.HttpContextHandler;

import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author Alexey
 */
public class ScalableHttpServer {
    private static final Logger LOGGER = Logger.getLogger(ScalableHttpServer.class.getName());
    private final HttpServer server;

    public ScalableHttpServer(HttpServer server) {
        this.server = server;
    }

    public void start() {
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();
        LOGGER.info("Server started");
    }

    public void addHttpContextHandler(HttpContextHandler handler) {
        server.createContext(handler.getContext(), handler);
    }


}
