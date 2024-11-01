package print_controller;

import classes.*;

public class Printer {

    public static void printUserPosts(User user) {
        for (Post posts : user.getUserPosts()) {
            Printer.printPost(posts);
        }
    }

    public static void printPost(Post choosenPost) {
        System.out.println(choosenPost);
        for (Comment comments : choosenPost.getPostComments()) {
            Printer.printComment(comments);
        }
    }

    private static void printComment(Comment comment) {
        System.out.println(comment);
    }

    private Printer() {
    }

}
