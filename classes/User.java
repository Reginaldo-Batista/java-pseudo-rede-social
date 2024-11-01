package classes;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import validations.Validation;

@SuppressWarnings("unused")
public class User {

    private static long numberOfUsers = 0L;

    private final long USER_ID;
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
        this.USER_ID = numberOfUsers;
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

    public Comment addComment(String comment, Post post) {
        Comment newComment = post.addComment(this, comment);
        this.userComments.add(newComment);
        return newComment;
    }

    public Boolean removeComment(Comment targetComment) {
        User remotionSolicitor = this;
        User commentOwner = targetComment.getCommentOwner();
        Boolean isSameUser = Validation.isSameUser(remotionSolicitor, commentOwner);

        if (isSameUser) {
            Post associatedPost = targetComment.getCommentedPost();
            associatedPost.removeComment(remotionSolicitor, associatedPost, targetComment);
            this.userComments.remove(targetComment);
            return true;
        }

        return false;
    }

    public long getUserId() {
        return USER_ID;
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
        return "ID: " + USER_ID + "\nNome: " + name + "\nEmail: " + email + "\nData de criação da conta: "
                + formatTime.format(dateAccountCreation);
    }

}
