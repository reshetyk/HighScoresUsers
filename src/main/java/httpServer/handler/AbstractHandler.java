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
public abstract class AbstractHandler implements HttpContextHandler {

    protected HighScoresUsersService highScoresUsersService;
    protected Map<String, String> requestParams;
    protected HttpExchange httpExchange;
    protected String context;

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
            throwable.printStackTrace();
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

}
