package org.dz18;

import java.util.*;

public class UserRepository {
    private final List<UserDTO> users;
    private int count;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void addUser(UserDTO userDTO) {
        this.users.add(userDTO);
        this.count++;
    }

    public Optional<UserDTO> findUserById(int id) {
        return this.users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<UserDTO> findUserByEmail(String email) {
        return this.users.stream()
                .filter(user -> Objects.equals(user.getEmail(), email))
                .findFirst();
    }

    public Optional<List<UserDTO>> findAllUsers() {
        return Optional.ofNullable(this.users.isEmpty() ? null : this.users);
    }

    public int getCount() {
        return this.count;
    }
}
