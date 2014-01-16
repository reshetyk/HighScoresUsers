package domain;

import java.util.List;

/**
 * @author Alexey
 */
public class User {
    private int id;
    private List<LevelScore> levelScores;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public List<LevelScore> getLevelScores() {
        return levelScores;
    }

    public void setLevelScores(List<LevelScore> levelScores) {
        this.levelScores = levelScores;
    }
}
