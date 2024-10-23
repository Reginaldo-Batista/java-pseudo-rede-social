package classes;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Post {
    private User postOwner;
    private String postTitle;
    private String postContent;
    private Instant postCreationDateTime;
    private DateTimeFormatter formatTime;
    private List<Comment> postComments;

    protected Post(User postOwner, String postTitle, String postContent) {
        this.postOwner = postOwner;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postCreationDateTime = Instant.now();
        this.formatTime = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm").withZone(ZoneId.systemDefault());
        this.postComments = new LinkedList<>();
    }

    public Comment addComment(User commentOwner, String content) {
        Comment newComment = new Comment(this, commentOwner, content);
        this.postComments.add(newComment);
        return newComment;
    }

    public Boolean removeComment(User remotionSolicitant, Post associatedPost, Comment targetComment) {
        Boolean isValid = (targetComment.getCommentOwner().getiD() == remotionSolicitant.getiD());
        if (isValid) {
            this.postComments.remove(targetComment);
        }
        return isValid;
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

    public Instant getPostCreationDateTime() {
        return postCreationDateTime;
    }

    public List<Comment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<Comment> postComments) {
        this.postComments = postComments;
    }

    public String toString() {
        return "\nPost de " + postOwner.getName() +  
                "\nTítulo: " + postTitle +
                "\nConteúdo: " + postContent +
                "\nData de postagem: " + formatTime.format(postCreationDateTime) +
                "\n\n" +
                "Comentários:\n" + postComments + "\n";
    }
}
