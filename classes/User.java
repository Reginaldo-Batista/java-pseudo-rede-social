package classes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class User {
    private String name;
    private String email;
    private String password;
    private Instant dateAccountCreation = Instant.now();

    private List<Post> userPosts = new ArrayList<>();
    private List<Comment> userComments = new ArrayList<>();

    public User(String nome, String email, String password) {
        this.setName(password);
        this.setEmail(email);
        this.setPassword(password);
    }

    public Instant getDateAccountCreation() {
        return dateAccountCreation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
