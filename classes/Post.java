package classes;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class Post {
    private User postOwner;
    private String postTitle;
    private String postContent;
    private Instant postCreationDate;
    private List<Comment> postComments;

    public Post(User postOwner, String postTitle, String postContent) {
        this.postOwner = postOwner;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postCreationDate = Instant.now();
        this.postComments = new LinkedList<>();
    }

    public Comment addComment(User commentOwner, String content) {
        Comment newComment = new Comment(this, commentOwner, content);
        this.postComments.add(newComment);
        return newComment;
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

    public String toString() {
        return "\nPost de " + postOwner.getName() +  
                "\nTítulo: " + postTitle +
                "\nConteúdo: " + postContent +
                "\nData de postagem: " + postCreationDate +
                "\n\n" +
                "Comentários:\n" + postComments + "\n";
    }
}
