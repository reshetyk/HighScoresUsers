package httpServer.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import httpServer.HttpServerUtils;
import service.HighScoresUsersService;

import java.io.IOException;
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
        requestParams = HttpServerUtils.parseRequestParams(httpExchange.getRequestURI().getQuery());
        handle();
    }

    public abstract void handle () throws IOException;


}
