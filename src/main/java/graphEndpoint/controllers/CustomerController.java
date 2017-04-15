package graphEndpoint.controllers;

import graphEndpoint.entities.Customer;
import graphEndpoint.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Daniel on 15.04.2017.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {


    private @Autowired CustomerRepository customerRepository;



    @RequestMapping("/all")
    @ResponseBody
    public Iterable<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(
            @RequestParam(value = "name", defaultValue = "Namenloser Strolch") String name) {

        Customer customer=new Customer();
        customer.setName(name);
        customer=customerRepository.save(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/clear")
    @ResponseBody
    public ResponseEntity<?> deleteAllt()
    {
        customerRepository.deleteAll();
        return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);
    }
}
