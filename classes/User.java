package classes;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class User {
    private String name;
    private String email;
    private String password;
    private Instant dateAccountCreation;
    private List<Post> userPosts;
    private List<Comment> userComments;

    public User(String name, String email, String password) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.dateAccountCreation = Instant.now();
        this.userPosts = new LinkedList<>();
        this.userComments = new LinkedList<>();
    }

    public Post createPost(String postTitle, String postContent) {
        Post newPost = new Post(this, postTitle, postContent);
        this.userPosts.addFirst(newPost);
        return newPost;
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

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }

    public List<Comment> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<Comment> userComments) {
        this.userComments = userComments;
    }

}
