import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

    }
}

class User {

    private String name;
    private String email;
    private String password;
    private Instant dateAccountCreation = Instant.now();
    private List<Post> userPosts = new ArrayList<>();
    private List<Comment> userComments = new ArrayList<>();

    public Instant getDateAccountCreation() {
        return dateAccountCreation;
    }

    public User(String nome, String email, String password) {
        this.setName(password);
        this.setEmail(email);
        this.setPassword(password);
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

class Post {
    private User postOwner;
    private String postTitle;
    private String postContent;
    private Instant postCreationDate;
    private List<Comment> postComments = new ArrayList<>();
}

class Comment {
    private User commentOwner;
    private Post commentedPost;
    private String commentContent;
}