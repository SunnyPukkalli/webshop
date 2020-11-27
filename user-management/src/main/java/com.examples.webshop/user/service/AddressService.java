package com.examples.webshop.user.service;

import com.examples.webshop.user.exception.AddressNotFoundException;
import com.examples.webshop.user.model.Address;

import java.util.Optional;

public interface AddressService {

    Address createOrUpdateAddress(Address address);

    Address fetchAddress(Integer id) throws AddressNotFoundException;

    String deleteAddress(Integer id) throws AddressNotFoundException;

    Optional<Address> fetchAddressByUserId(Integer userId);
}
