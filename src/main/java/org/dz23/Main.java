package org.dz23;

import org.password_generator.PasswordGenerator;

public class Main {
    public static void main(String[] args) {
        String pass = PasswordGenerator.generatePassword(15);
        System.out.println(pass);
    }
}
