package jdk.parent;

import java.io.Serializable;

public class User extends SuperUser implements Serializable {

    private static final long serialVersionUID = 8700946356476439688L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
