import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Address implements Serializable {
    private static final String FILE_NAME = "Address.ser";
    private static ArrayList<Address> addressList = new ArrayList<>();

    static {loadAddress();}

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
        Validation.validateString(country, "Country cannot be null or empty");
        this.country = country;
        saveAddress();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        Validation.validateString(city, "City cannot be null or empty");
        this.city = city;
        saveAddress();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        Validation.validateString(street, "Street cannot be null or empty");
        this.street = street;
        saveAddress();
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        Validation.validateString(apartmentNumber, "ApartmentNumber cannot be null or empty");
        this.apartmentNumber = apartmentNumber;
        saveAddress();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        Validation.validateString(postalCode, "PostalCode cannot be null or empty");
        this.postalCode = postalCode;
        saveAddress();
    }

    public static void loadAddress(){
        addressList = Extent.loadClassList(FILE_NAME);
    }

    public static void saveAddress(){
        Extent.saveClassList(FILE_NAME, addressList);
    }

    public static List<Address> getAddressList(){
        return Extent.getImmutableClassList(addressList);
    }
}
