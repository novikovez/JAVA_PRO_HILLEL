package org.dz27;

import org.dz27.entity.User;

import java.util.List;

public class Main {
    private static final DataBase dataBase = new DataBase();

    public static void main(String[] args) {
        User user = new User();
        user.setName("John");
        user.setAge(30);
        user.setEmail("john@example.com");

        User user2 = new User();
        user2.setName("Alice");
        user2.setAge(25);
        user2.setEmail("alice@example.com");

        User user3 = new User();
        user3.setName("Bob");
        user3.setAge(35);
        user3.setEmail("bob@example.com");

        dataBase.store(user);
        System.out.println("Created user: " + user.getId());
        dataBase.store(user2);
        System.out.println("Created user: " + user2.getId());
        dataBase.store(user3);
        System.out.println("Created user: " + user3.getId());

        System.out.println("All users: ");
        List<User> users = dataBase.index(User.class);
        for (User userItem : users) {
            System.out.println(userItem.getId() + " " +userItem.getName() + " " + userItem.getAge() + " " + userItem.getEmail());
        }

        System.out.println("Delete Bob..");
        dataBase.destroy(user3);

        System.out.println("New All Users: ");
        List<User> usersFinal = dataBase.index(User.class);
        for (User userItem : usersFinal) {
            System.out.println(userItem.getId() + " " +userItem.getName() + " " + userItem.getAge() + " " + userItem.getEmail());
        }

    }

}
