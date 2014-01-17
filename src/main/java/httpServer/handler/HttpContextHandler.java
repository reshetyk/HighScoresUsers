package httpServer.handler;

import com.sun.net.httpserver.HttpHandler;

/**
 * @author oreshetiuk
 */
public interface HttpContextHandler extends HttpHandler {
    String getContext();
}
