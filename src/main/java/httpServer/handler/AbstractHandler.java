package httpServer.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import service.HighScoresUsersService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alexey
 */
public abstract class AbstractHandler implements HttpContextHandler {
    private static final Logger LOGGER = Logger.getLogger(AbstractHandler.class.getName());

    protected final HighScoresUsersService highScoresUsersService;
    protected Map<String, String> requestParams;
    protected HttpExchange httpExchange;
    protected final String context;

    public AbstractHandler(String context, HighScoresUsersService highScoresUsersService) {
        this.context = context;
        this.highScoresUsersService = highScoresUsersService;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        try {
            this.httpExchange = httpExchange;
            requestParams = parseRequestParams(httpExchange.getRequestURI().getQuery());
            handle();
        } catch (Throwable throwable) {
            httpExchange.sendResponseHeaders(200, 0);
            httpExchange.getResponseBody().close();
            LOGGER.log(Level.SEVERE, "Exception", throwable);
        }
    }

    public abstract void handle() throws IOException;

    @Override
    public String getContext() {
        return context;
    }

    public static Map<String, String> parseRequestParams(String query) {
        Map<String, String> result = new HashMap<String, String>();
        if (query != null) {
            for (String param : query.split("&")) {
                String pair[] = param.split("=");
                if (pair.length > 1) {
                    result.put(pair[0], pair[1]);
                } else {
                    result.put(pair[0], "");
                }
            }
        }
        return result;
    }

    protected void logAndThrowException(Logger logger, Class<? extends HttpHandler> httpHandlerClass, Throwable e) {
        logger.log(Level.SEVERE, "Exception occurred in the handler " + httpHandlerClass.getName(), e);
        throw new RuntimeException(e);
    }
}
