package httpServer.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import service.HighScoresUsersService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey
 */
public abstract class AbstractHandler implements HttpHandler {

    protected HighScoresUsersService highScoresUsersService;
    protected Map<String, String> requestParams;
    protected HttpExchange httpExchange;

    public AbstractHandler(HighScoresUsersService highScoresUsersService) {
        this.highScoresUsersService = highScoresUsersService;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        this.httpExchange = httpExchange;
        requestParams = parseRequestParams(httpExchange.getRequestURI().getQuery());
        handle();
    }

    public abstract void handle () throws IOException;

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
}
