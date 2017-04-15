package graphEndpoint.service;

import java.util.*;

import graphEndpoint.entities.Customer;
import graphEndpoint.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public Iterable<Customer> findALl() {
       return customerRepository.findAll();
    }



}