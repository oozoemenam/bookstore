package com.bookshop.model;

import jakarta.persistence.AttributeConverter;

public class AddressConverter implements AttributeConverter<Address, String> {

    @Override
    public String convertToDatabaseColumn(Address address) {
        if (address == null) return "";
        return address.getStreetAddress() + ", " +
                address.getCity() + ", " +
                address.getCountry();
    }

    @Override
    public Address convertToEntityAttribute(String value) {
        Address address = null;
        if (value != null && value.contains(",")) {
            String[] tokens = value.split(",");
            address = new Address();
            address.setStreetAddress(tokens[0]);
            address.setCity(tokens[1]);
            address.setCountry(tokens[2]);
        }
        return address;
    }
}
