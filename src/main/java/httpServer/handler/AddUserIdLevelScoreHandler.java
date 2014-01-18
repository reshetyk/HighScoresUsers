package httpServer.handler;

import service.HighScoresUsersService;

import java.util.logging.Logger;

/**
 * @author Alexey
 *         <p/>
 *         Request: POST /postscore?user=<userid>&level=<levelid>&score=<score>
 *         Response: (nothing)
 *         Example: POST http://localhost:8080/postscore?user=142&level=12&score=5661
 */
public class AddUserIdLevelScoreHandler extends AbstractHandler {
    private static final Logger LOGGER = Logger.getLogger(AddUserIdLevelScoreHandler.class.getName());

    public AddUserIdLevelScoreHandler(String context, HighScoresUsersService highScoresUsersService) {
        super(context, highScoresUsersService);
    }

    @Override
    public void handle() {
        try {
            final Integer userId = new Integer(requestParams.get("user"));
            final Integer level = new Integer(requestParams.get("level"));
            final Long score = new Long(requestParams.get("score"));

            highScoresUsersService.addUserIdLevelScore(userId, level, score);

            httpExchange.sendResponseHeaders(200, 0);
            httpExchange.getResponseBody().close();

            LOGGER.info("added [userid=" + userId + "; level=" + level + "; score=" + score + "]");

        } catch (Exception e) {
            logAndThrowException(LOGGER, AddUserIdLevelScoreHandler.class, e);
        }
    }
}
