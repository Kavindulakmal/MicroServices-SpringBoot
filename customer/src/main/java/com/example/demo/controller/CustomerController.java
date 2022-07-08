package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/c1/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //get all Customers
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    //create customer
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    //get customer by ID
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomeByid(@PathVariable long id){
        Customer customer =customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not exits by id"+id));
        return ResponseEntity.ok(customer);
    }

    //update Customer
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customerDetails){

        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not exits by id"+id));

        updateCustomer.setFname(customerDetails.getFname());
        updateCustomer.setLname(customerDetails.getLname());
        updateCustomer.setEmail(customerDetails.getEmail());
        updateCustomer.setAddress(customerDetails.getAddress());
        updateCustomer.setUsername(customerDetails.getUsername());
        updateCustomer.setPassword(customerDetails.getPassword());

        customerRepository.save(updateCustomer);

        return ResponseEntity.ok(updateCustomer);

    }
    //Delete Customer by id
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCutomer(@PathVariable long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not exits with id"+id));

        customerRepository.delete(customer);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
