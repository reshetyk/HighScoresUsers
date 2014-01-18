package domain;

/**
 * @author Alexey
 */
public class User {
    private int id;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (!User.class.equals(o.getClass())) return false;

        User user = (User) o;

        if (id != user.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
