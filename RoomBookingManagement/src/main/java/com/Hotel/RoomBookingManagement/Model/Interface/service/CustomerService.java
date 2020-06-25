package com.Hotel.RoomBookingManagement.Model.Interface.service;

import com.Hotel.RoomBookingManagement.Model.Customer;
import com.Hotel.RoomBookingManagement.Model.Interface.CustomerRepository;
import com.Hotel.RoomBookingManagement.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;


    public List<Customer> getAllCustomers()
    {
        List<Customer> customerList = repository.findAll();

        if(customerList.size() > 0) {
            return customerList;
        } else {
            return new ArrayList<Customer>();
        }
    }

    public Customer getCustomerById(Long id) throws RecordNotFoundException
    {
        Optional<Customer> customer = repository.findById(id);

        if(customer.isPresent()) {
            return customer.get();
        } else {
            throw new RecordNotFoundException("No Customer record exist for given id");
        }
    }


    public Customer createOrUpdateCustomer(Customer entity) throws RecordNotFoundException
    {
        Optional<Customer> customer = repository.findById(entity.getId());

        if(customer.isPresent())
        {
            Customer  newEntity = customer.get();

            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setDob(entity.getDob());
            newEntity.setEmail(entity.getEmail());
            newEntity.setPassword(entity.getPassword());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteCustomerById(Long id) throws RecordNotFoundException
    {
        Optional<Customer> customer = repository.findById(id);

        if(customer.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    }

}
