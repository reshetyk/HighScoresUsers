package httpServer;

import com.sun.net.httpserver.HttpServer;
import httpServer.handler.HttpContextHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author Alexey
 */
public class ScalableHttpServer {
    private static final Logger LOGGER = Logger.getLogger(ScalableHttpServer.class.getName());
    private HttpServer server;
    private Properties config;

    public ScalableHttpServer() throws IOException {
        loadDefaultConfig();
        create();
    }

    public ScalableHttpServer(Properties config) throws IOException {
        this.config = config;
        create();
    }

    private void create() throws IOException {
        server = HttpServer.create(
                new InetSocketAddress(Integer.parseInt(config.getProperty("port"))),
                Integer.parseInt(config.getProperty("backlog"))
        );
        server.setExecutor(Executors.newFixedThreadPool(Integer.parseInt(config.getProperty("poolsize"))));
    }

    public void start() {
        server.start();
        LOGGER.info("Server started");
    }

    public void addHttpContextHandler(HttpContextHandler handler) {
        server.createContext(handler.getContext(), handler);
    }

    private void loadDefaultConfig() {
        config.put("port", 8080);
        config.put("poolsize", 10);
        config.put("backlog", 5);
    }
}
