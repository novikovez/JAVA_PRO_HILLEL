package org.dz18;

/**
 * Class org.names_list.Main
 * author Igor Novikov
 * 06.11.24
 */

public class Main {
    static UserRepository userRepository = new UserRepository();

    public static void main(String[] args) {
        addUsers();
        userRepository.findUserById(1).stream()
                .findFirst()
                .ifPresent(user -> System.out.println(user.getName()));

        userRepository.findUserByEmail("mail@mail.com").stream()
                .findFirst()
                .ifPresent(user -> System.out.println(user.getEmail()));

        userRepository.findAllUsers().stream()
                .findAny()
                .ifPresent(user -> {
                    long count = userRepository.getCount(); // Получаем количество пользователей
                    System.out.println("Users: " + count);
                });
    }

    private static void addUsers() {
        userRepository.addUser(new UserDTO(1,"Anna","mail@mail.com"));
        userRepository.addUser(new UserDTO(2,"Igor","mail2@mail.com"));
        userRepository.addUser(new UserDTO(3,"Ivan","mail3@mail.com"));
    }
}
