package com.examples.webshop.user.controller;


import com.examples.webshop.user.exception.AddressNotFoundException;
import com.examples.webshop.user.model.Address;
import com.examples.webshop.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.createOrUpdateAddress(address),HttpStatus.CREATED);
    }

    @GetMapping("/address/{address_id}")
    public ResponseEntity<Address> getAddressById(@PathVariable(name="address_id") String id){
        try {
            Address address = addressService.fetchAddress(Integer.valueOf(id));
            return new ResponseEntity<>(address,HttpStatus.OK);
        } catch (AddressNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PatchMapping("/address/{address_id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address , @PathVariable(name="address_id") String id){
        // TODO: Add logic to check if address exists or do you want to create new or error out ?
        return new ResponseEntity<>(addressService.createOrUpdateAddress(address),HttpStatus.OK);
    }

    @DeleteMapping("/address/{address_id}")
    public ResponseEntity<String> deleteAddress(@PathVariable(name="address_id") String id) {
        try{
            String result = addressService.deleteAddress(Integer.valueOf(id));
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (AddressNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
