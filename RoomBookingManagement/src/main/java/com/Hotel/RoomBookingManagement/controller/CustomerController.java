package com.Hotel.RoomBookingManagement.controller;

import com.Hotel.RoomBookingManagement.Model.Customer;
import com.Hotel.RoomBookingManagement.Model.Interface.CustomerRepository;
import com.Hotel.RoomBookingManagement.Model.Interface.service.CustomerService;
import com.Hotel.RoomBookingManagement.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list = service.getAllCustomers();

        return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Customer entity = service.getCustomerById(id);

        return new ResponseEntity<Customer>(entity, new HttpHeaders(), HttpStatus.OK);
    }




    @PostMapping("/customer")
    public ResponseEntity<Customer> createOrUpdateCustomer(Customer customer)
            throws RecordNotFoundException {
        Customer updated = service.createOrUpdateCustomer(customer);
        return new ResponseEntity<Customer>(updated, new HttpHeaders(), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public HttpStatus deleteCustomerById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteCustomerById(id);
        return HttpStatus.FORBIDDEN;
    }

}
