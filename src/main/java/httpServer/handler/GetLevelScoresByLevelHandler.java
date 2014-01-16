package httpServer.handler;

import domain.LevelScores;
import domain.User;
import domain.UsersLevelScores;
import service.HighScoresUsersService;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

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
        final UsersLevelScores userLevelScores = highScoresUsersService.getUserLevelScoresByLevel(level);
        String response = makeUserIdByScoreAsString(userLevelScores);
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public static String makeUserIdByScoreAsString(UsersLevelScores usersLevelScores) {
        StringBuilder stringBuilder = new StringBuilder();
        final Map<User, LevelScores> userLevelScores = usersLevelScores.getUserLevelScores();
        for (Map.Entry<User, LevelScores> userLevelScoresEntry : userLevelScores.entrySet()) {
            for (Long score : userLevelScoresEntry.getValue().getLevelScoreMap().values()) {
                stringBuilder.append(userLevelScoresEntry.getKey().getId()).append("=").append(score).append(";");
            }
        }
        return stringBuilder.toString();
    }
}
