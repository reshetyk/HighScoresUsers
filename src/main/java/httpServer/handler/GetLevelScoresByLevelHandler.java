package httpServer.handler;

import service.HighScoresUsersService;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Alexey
 */
public class GetLevelScoresByLevelHandler extends AbstractHandler {

    public GetLevelScoresByLevelHandler(HighScoresUsersService highScoresUsersService) {
        super(highScoresUsersService);
    }

    @Override
    public void handle() throws IOException {
        final Integer level = new Integer(requestParams.get("level"));
        System.out.println("level=" + level);
//        String response = HighScoresUsersServiceImpl.getUserLevelScoresByLevel(level).toString();
        String response = "";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
