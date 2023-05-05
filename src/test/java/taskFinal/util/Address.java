package taskFinal.util;

import com.github.javafaker.Faker;

import java.util.Objects;

public class Address {
    private static String cell;
    private static String street;
    private static String city;
    private static String state;
    private static String zip;

    public Address(String cellNumber, String streetAddress, String cityAddress, String stateAddress, String zipCode)
    {
        cell = cellNumber;
        street = streetAddress;
        city = cityAddress;
        state = stateAddress;
        zip = zipCode;
    }

    public String getCell() {return cell;}
    public String getStreet() {return street;}
    public String getCity() {return city;}
    public String getState() {return state;}
    public String getZip() {return zip;}

    public static Address getDefaultAddress()
    {
        Faker faker = new Faker();

        cell = faker.phoneNumber().cellPhone();
        street = faker.address().streetAddress();
        city = faker.address().city();
        state = faker.address().state();
        zip = faker.address().zipCode();

        return new Address(cell, street, city, state, zip);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return  Objects.equals(cell, address.getCell()) &&
                Objects.equals(street, address.getStreet()) &&
                Objects.equals(city, address.getCity()) &&
                Objects.equals(state, address.getState()) &&
                Objects.equals(zip, address.getZip()) ;
    }
}
