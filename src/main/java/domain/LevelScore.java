package domain;

import java.util.List;

/**
 * @author Alexey
 */
public class LevelScore {
    private int level;
    private long score;
    private List<User> users;

    public LevelScore() {
    }

    public LevelScore(int level, long score) {
        setLevelScore(level, score);
    }

    public void setLevelScore(int level, long score) {
        this.level = level;
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LevelScore)) return false;

        LevelScore that = (LevelScore) o;

        if (level != that.level) return false;
        if (score != that.score) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = level;
        result = 31 * result + (int) (score ^ (score >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return level + "=" + score;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
