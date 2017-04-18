package graphEndpoint.dataConnection.service;

import graphEndpoint.dataConnection.entity.Customer;
import graphEndpoint.dataConnection.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@ComponentScan("graphEndpoint.dataConnection.repository")
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Transactional(readOnly = true)
    public Iterable<Customer> findALl() {
       return customerRepository.findAll();
    }



}