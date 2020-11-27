package com.examples.webshop.user.service;

import com.examples.webshop.user.exception.AddressNotFoundException;
import com.examples.webshop.user.model.Address;
import com.examples.webshop.user.persistence.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

public class AddressServiceImpl implements AddressService {

    private static final String ADDRESS_NOT_FOUND_MESSAGE = "Address does not exist in the system";
    private static final String ADDRESS_DELETED_MESSAGE = "Address removed Successfully";

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address createOrUpdateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address fetchAddress(Integer id) throws AddressNotFoundException {
        return addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(ADDRESS_NOT_FOUND_MESSAGE));
    }

    @Override
    public String deleteAddress(Integer id) throws AddressNotFoundException {
        try{
            addressRepository.deleteById(id);
            return ADDRESS_DELETED_MESSAGE;
        } catch (EmptyResultDataAccessException exception) {
            throw new AddressNotFoundException(ADDRESS_NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public Optional<Address> fetchAddressByUserId(Integer userId) {
        return addressRepository.findByUserId(userId);
    }
}
