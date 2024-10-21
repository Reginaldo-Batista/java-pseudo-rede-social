package classes;

import java.time.Instant;

public class Comment {
    private Post commentedPost;
    private User commentOwner;
    private String commentContent;
    private Instant commentCreationDate;

    public Comment(Post commentedPost, User commentOwner, String commentContent) {
        this.commentedPost = commentedPost;
        this.commentOwner = commentOwner;
        this.commentContent = commentContent;
        this.commentCreationDate =  Instant.now();
    }

    public Post getCommentedPost() {
        return commentedPost;
    }

    public User getCommentOwner() {
        return commentOwner;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Instant getCommentCreationDate() {
        return commentCreationDate;
    }

    public String toString() {
        return "\n-> " + this.commentOwner.getName() + ": " + this.commentContent + "\n";
    }

}
