package classes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private User postOwner;
    private String postTitle;
    private String postContent;
    private Instant postCreationDate = Instant.now();

    private List<Comment> postComments = new ArrayList<>();

    public Post(User postOwner, String postTitle, String postContent) {
        this.postOwner = postOwner;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public User getPostOwner() {
        return postOwner;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Instant getPostCreationDate() {
        return postCreationDate;
    }

    public List<Comment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<Comment> postComments) {
        this.postComments = postComments;
    }
}
