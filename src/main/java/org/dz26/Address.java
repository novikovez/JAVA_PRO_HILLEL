package org.dz26;

public class Address {
    private String address;

    public String setAddress(String address, boolean result) {
        this.address = address;
        if(result) {
            return this.address;
        }
        return "Set address successfully [" + this.address + "]";
    }

    public String getAddress(boolean result) {
        if(result) {
            return this.address;
        }
        return "Get address successfully: [" + this.address + "]";
    }

}
