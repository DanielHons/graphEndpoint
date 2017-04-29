
package graphEndpoint.dataConnection.controller;

import graphEndpoint.dataConnection.domain.Customer;
import graphEndpoint.dataConnection.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;




/**
 * Created by Daniel on 15.04.2017.
 */
@Controller
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    /*
    @Autowired
    private CustomerService customerService;
    */
    @RequestMapping("/all")
    @ResponseBody
    public Iterable<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<?> create(
            @RequestBody Customer customer) {
        if (customer!=null) customer=customerRepository.save(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/clear")
    @ResponseBody
    public ResponseEntity<?> deleteAll()
    {
        customerRepository.deleteAll();
        return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);
    }


}
