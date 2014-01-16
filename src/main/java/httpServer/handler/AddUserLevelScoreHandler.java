package httpServer.handler;

import service.HighScoresUsersService;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Alexey
 */
public class AddUserLevelScoreHandler extends AbstractHandler {

    public AddUserLevelScoreHandler(HighScoresUsersService highScoresUsersService) {
        super(highScoresUsersService);
    }

    @Override
    public void handle() throws IOException {
        final Integer userId = new Integer(requestParams.get("user"));
        final Integer level = new Integer(requestParams.get("level"));
        final Long score = new Long(requestParams.get("score"));
        System.out.println("userid=" + userId + "; level=" + level + "; score" + score);
//            TODO:  highScoresUsersService.addUserLevelScore(userId, level, score);
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();
        os.close();
    }
}
