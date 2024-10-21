import classes.User;
import classes.Post;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) {

        User userOne = new User("Reginaldo", "reginaldo@gmail.com", "123");
        User userTwo = new User("Maria", "maria@gmail.com", "456");

        Post firstPost_UserOne = userOne.createPost("Post inicial", "Olá mundo!");
        Post secondPost_UserOne = userOne.createPost("Segundo post!", "Olá mundo... de novo :D");

        userTwo.commentOnPost("Olá! Bem-vindo!", firstPost_UserOne);
        userOne.commentOnPost("Obrigado!", firstPost_UserOne);
        userOne.commentOnPost("Testaaaaaaando", firstPost_UserOne);

        System.out.println(firstPost_UserOne);

        System.out.println("--------------------------------");
        System.out.println("Printando todos os posts de " + userOne.getName());
        System.out.println(userOne.getUserPosts());
        System.out.println("--------------------------------");

    }
}