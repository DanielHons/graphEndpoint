package graphEndpoint.dataConnection.service;

import graphEndpoint.dataConnection.domain.Customer;
import graphEndpoint.dataConnection.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Transactional(readOnly = true)
    public Iterable<Customer> findAll() {
       return customerRepository.findAll();
    }



}