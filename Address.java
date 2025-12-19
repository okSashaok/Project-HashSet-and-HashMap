import java.util.Objects;

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

    @Override//Переопределение пары “boolean Map.equals(Object object)” и “int Map.hashCode()”
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Address address = (Address) object;
        return Objects.equals(country, address.country)
                && Objects.equals(city, address.city);
    }

    @Override//Переопределение пары “boolean Map.equals(Object object)” и “int Map.hashCode()”
    public int hashCode() {
        return Objects.hash(country, city);
    }
}
