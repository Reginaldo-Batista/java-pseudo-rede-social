package classes;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class User {

    private static long numberOfUsers = 0;

    private long iD;
    private String name;
    private String email;
    private String password;
    private Instant dateAccountCreation;
    private DateTimeFormatter formatTime;
    private List<User> friendsList;
    private List<Post> userPosts;
    private List<Comment> userComments;

    public User(String name, String email, String password) {
        numberOfUsers++;
        this.iD = numberOfUsers;
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.dateAccountCreation = Instant.now();
        this.formatTime = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")
        .withZone(ZoneId.systemDefault());
        this.friendsList = new LinkedList<>();
        this.userPosts = new LinkedList<>();
        this.userComments = new LinkedList<>();
    }

    public Post createPost(String postTitle, String postContent) {
        Post newPost = new Post(this, postTitle, postContent);
        this.userPosts.add(newPost);
        return newPost;
    }

    public Post removePost(Post targetPost) {
        this.userPosts.remove(targetPost);
        return targetPost;
    }

    public Comment commentOnPost(String comment, Post post) {
        Comment newComment = post.addComment(this, comment);
        this.userComments.addFirst(newComment);
        return newComment;
    }

    public Boolean removeComment(Comment targetComment) {
        User remotionSolicitor = this;
        Post associatedPost = targetComment.getCommentedPost();

        Boolean isRemoved = associatedPost.removeComment(remotionSolicitor, associatedPost, targetComment);

        if (isRemoved) {
            this.userComments.remove(targetComment);
        }
        return isRemoved;
    }

    public long getiD() {
        return iD;
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

    public String toString() {
        return "ID: " + iD + "\nNome: " + name + "\nEmail: " + email + "\nData de criação da conta: "
                + formatTime.format(dateAccountCreation);
    }

}
