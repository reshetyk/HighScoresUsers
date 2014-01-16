package httpServer;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey
 */
public class HttpServerUtils {
    public static String getRequestParam(URI uri, String paramName) {
        final Map<String, String> requestParams = parseRequestParams(uri.getQuery());
        String param = requestParams.get(paramName);
        if (param == null) {
            return null;
        }

        return param;

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
