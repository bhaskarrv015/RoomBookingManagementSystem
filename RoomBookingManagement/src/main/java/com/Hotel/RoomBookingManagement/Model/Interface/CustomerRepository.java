package com.Hotel.RoomBookingManagement.Model.Interface;

import com.Hotel.RoomBookingManagement.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
