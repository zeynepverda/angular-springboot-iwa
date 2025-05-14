package pl.dmcs.zva.springbootjsp_iwa2025.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.zva.springbootjsp_iwa2025.model.Address;
import pl.dmcs.zva.springbootjsp_iwa2025.repository.AddressRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/addresses")
public class AddressRESTController {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressRESTController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        addressRepository.save(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable("id") long id) {
        Address address = addressRepository.findById(id);
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Address> updateAddress(@RequestBody Address address,
                                                 @PathVariable("id") long id) {
        address.setId(id);
        addressRepository.save(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Address> updatePartOfAddress(@RequestBody Map<String, Object> updates,
                                                       @PathVariable("id") long id) {
        Address address = addressRepository.findById(id);
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        partialUpdate(address, updates);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private void partialUpdate(Address address, Map<String, Object> updates) {
        if (updates.containsKey("studentList")) {
            address.setStudentList((List<pl.dmcs.zva.springbootjsp_iwa2025.model.Student>) updates.get("studentList"));
        }
        addressRepository.save(address);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Address> getAddress(@PathVariable("id") long id) {
        Address address = addressRepository.findById(id);
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAllAddresses() {
        addressRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<List<Address>> updateAllAddresses(@RequestBody List<Address> addresses) {
        addressRepository.deleteAll();
        List<Address> updated = addressRepository.saveAll(addresses);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}