package org.dz26;

public class User {
    public Address address;
    public String className = "User";

    public User(Address address) {
        this.address = address;
    }

    public String setAddress(String address, boolean result) {
        return this.address.setAddress(address, result);
    }

    public String getAddress(boolean result) {
        return this.address.getAddress(result);
    }

    public String className() {
        return this.getClass().getSimpleName();
    }
}
