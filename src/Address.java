import java.io.Serializable;

public class Address implements Serializable {
    private String country;
    private String city;
    private String street;
    private String apartmentNumber;
    private String postalCode;

    /*
    public Address(String country, String city, String street, String apartmentNumber, String postalCode) {
        Validation.validateString(country, "country");
        Validation.validateString(city, "city");
        Validation.validateString(street, "street");
        Validation.validateString(apartmentNumber, "apartmentNumber");
        Validation.validateString(postalCode, "postalCode");

        this.country = country;
        this.city = city;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.postalCode = postalCode;
    }
     */

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
