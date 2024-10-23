package classes;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Comment {
    private Post commentedPost;
    private User commentOwner;
    private String commentContent;
    private Instant commentCreationDate;
    private DateTimeFormatter formatTime;

    protected Comment(Post commentedPost, User commentOwner, String commentContent) {
        this.commentedPost = commentedPost;
        this.commentOwner = commentOwner;
        this.commentContent = commentContent;
        this.commentCreationDate =  Instant.now();
        this.formatTime = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm").withZone(ZoneId.systemDefault());
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
        return "\n-> " + this.commentOwner.getName() + ": " + this.commentContent + "\n"
        + formatTime.format(commentCreationDate);
    }

}
