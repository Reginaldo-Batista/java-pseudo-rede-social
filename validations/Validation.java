package validations;

import classes.User;

public class Validation {

    public static Boolean isSameUser(User userOne, User userTwo) {
        return userOne.getUserId() == userTwo.getUserId();
    }

    private Validation() {}

}
