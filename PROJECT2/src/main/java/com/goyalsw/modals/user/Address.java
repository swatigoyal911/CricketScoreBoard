package main.java.com.goyalsw.modals.user;

public class Address {
    String streetAddress;
    String city;
    String state;
    String country;
    String zipCode;

    public Address(String streetAddress, String city, String state, String country, String zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
