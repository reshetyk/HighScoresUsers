package httpServer.handler;

import service.HighScoresUsersService;

import java.io.IOException;

/**
 * @author Alexey
 *
 * Request: GET /levelscores?level=<levelid>
 * Response: list of <userid>=<score> separated by ‘;’
 * Example: GET http://localhost:8080/levelscores?level=12 -> 142=5661;23=5444;12=1200
 */
public class GetUserLevelScoresByLevel extends AbstractHandler{

    public GetUserLevelScoresByLevel(HighScoresUsersService highScoresUsersService) {
        super(highScoresUsersService);
    }

    @Override
    public void handle() throws IOException {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
