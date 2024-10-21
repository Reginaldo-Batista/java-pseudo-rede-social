import classes.User;
import classes.Post;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) {

        User server = new User("localhost", "localhost@gmail.com", "admin");

        User userOne = new User("Reginaldo", "reginaldo@gmail.com", "123");

        userOne.createPost("Post 1", "Conteúdo 1");

        System.out.println(userOne.getUserPosts());
    }
}