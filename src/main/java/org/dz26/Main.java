package org.dz26;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        User user = new User(new Address());
        System.out.println(user.setAddress("Odesa", false));
        System.out.println(user.getAddress(false));

        // Test
        System.out.println("Переконайтеся, що адреса користувача належить об'єкту класу User: "
                + Objects.equals(user.className(), user.className));

        System.out.print("Переконайтеся, що клас User відповідає за доступ до адреси та виконує необхідні дії: " + Objects.equals(
                user.setAddress("test", true),
                user.getAddress(true)
        ));
        // Test
    }
}
