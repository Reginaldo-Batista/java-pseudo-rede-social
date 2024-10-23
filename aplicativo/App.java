package aplicativo;

import classes.User;
import classes.Post;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) {

        // Cadastrando novos usuários
        User reginaldo = new User("Reginaldo", "reginaldo@gmail.com", "123");
        User maria = new User("Maria", "maria@gmail.com", "456");

        // Criando posts a partir do usuário
        reginaldo.createPost("Post inicial", "Olá mundo!");
        reginaldo.createPost("Segundo post!", "Olá mundo... de novo :D");

        // Armazenando posts em variáveis para uso posterior
        Post firstPost_reginaldo = reginaldo.getUserPosts().get(0);
        Post secondPost_reginaldo = reginaldo.getUserPosts().get(1);

        // Comentando em posts existentes
        maria.commentOnPost("Olá! Bem-vindo!", firstPost_reginaldo);
        reginaldo.commentOnPost("Obrigado!", firstPost_reginaldo);

        // Imprimindo todos os posts do usuário, armazenados em uma LinkedList<Post>
        System.out.println(reginaldo.getUserPosts());

    }
}