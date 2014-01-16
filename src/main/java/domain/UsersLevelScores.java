package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexey
 */
public class UsersLevelScores {
    private final Map<User, List<LevelScore>> userByLevelScores = new HashMap<User, List<LevelScore>>();
    private final Map<LevelScore, List<User>> levelScoreByUser = new HashMap<LevelScore, List<User>>();
    //todo: may be use org.apache.commons.collections.map.MultiValueMap

    public void addUserLevelScore (User user, LevelScore levelScore) {
        userByLevelScores.put(user, Arrays.asList(levelScore));
    }
}
