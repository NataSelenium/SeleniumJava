package taskFinal.util;

import com.github.javafaker.Faker;

import java.util.Objects;

public class Address {
    private String cell;
    private String street;
    private String city;
    private String state;
    private String zip;

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

        return new Address(faker.phoneNumber().cellPhone(), faker.address().streetAddress(),
                faker.address().city(), faker.address().state(), faker.address().zipCode());
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
