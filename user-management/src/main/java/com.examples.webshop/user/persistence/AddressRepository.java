package com.examples.webshop.user.persistence;

import com.examples.webshop.user.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    Optional<Address> findByUserId(Integer userId);
}
