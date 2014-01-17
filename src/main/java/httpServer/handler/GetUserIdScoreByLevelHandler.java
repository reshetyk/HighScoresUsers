package httpServer.handler;

import service.HighScoresUsersService;
import utils.ConverterMapToString;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author Alexey
 *
 * Request: GET /levelscores?level=<levelid>
 * Response: list of <userid>=<score> separated by ‘;’
 * Example: GET http://localhost:8080/levelscores?level=12 -> 142=5661;23=5444;12=1200
 */
public class GetUserIdScoreByLevelHandler extends AbstractHandler{

    public GetUserIdScoreByLevelHandler(String context, HighScoresUsersService highScoresUsersService) {
        super(context, highScoresUsersService);
    }

    @Override
    public void handle() throws IOException {
        final Integer level = new Integer(requestParams.get("level"));

        final Map<Integer, Long> userIdByScore = highScoresUsersService.getUserIdScoreByLevel(level);
        String response = new ConverterMapToString(userIdByScore).toString();

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

        System.out.println("get userid score by [level=" + level + "]");
    }
}
