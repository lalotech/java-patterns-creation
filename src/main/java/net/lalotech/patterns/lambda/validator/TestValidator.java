package net.lalotech.patterns.lambda.validator;

import net.lalotech.patterns.lambda.validator.model.User;

public class TestValidator {
    public static void main(String[] args) {

        //User user1 = new User(null,20,0F);
        //User user1 = new User("name1",17,0F);
        User user1 = new User(null,17,0F);

        Validator.validate(u -> u.getName()!=null,"Name is required")
                .thenValidate(u -> u.getAge() >= 18,"Age need to be greater than 18")
                .thenValidate(u -> u.getScore() > 0,"need score")
                .on(user1)
                .validate();

        System.out.println("user1 "+user1);

    }
}
