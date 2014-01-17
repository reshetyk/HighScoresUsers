package httpServer.handler;

import service.HighScoresUsersService;
import utils.ConverterMapToString;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author Alexey
 *
 * Request: GET /userscores?user=<userid>
 * Response: list of <levelid>=<score> separated by ‘;’
 * Example: GET http://localhost:8080/userscores?user=142 -> 12=5661;13=4912;11=1560
 */
public class GetLevelScoresByUserIdHandler extends AbstractHandler {

    public GetLevelScoresByUserIdHandler(String context, HighScoresUsersService highScoresUsersService) {
        super(context, highScoresUsersService);
    }

    @Override
    public void handle() throws IOException {
        final Integer userId = new Integer(requestParams.get("userid"));

        final Map<Integer, Long> levelScoreMap = highScoresUsersService.getLevelScoresByUserId(userId);
        String response = new ConverterMapToString(levelScoreMap).toString();

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
