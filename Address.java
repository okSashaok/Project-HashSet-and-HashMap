public class Address {
    private final String country;
    private final String city;

    public Address(String setCountry, String setCity) {
        country = setCountry;
        city = setCity;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
