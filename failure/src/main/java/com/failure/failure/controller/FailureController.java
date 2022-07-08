package com.failure.failure.controller;

import com.failure.failure.exception.ResourceNotFoundException;
import com.failure.failure.model.Failure;
import com.failure.failure.repository.FailureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/s1/failure")
public class FailureController {

    @Autowired
    private FailureRepository failureRepository;

    @GetMapping
    public List<Failure> getAllFailure(){
        return failureRepository.findAll();
    }

    //crate failure
    @PostMapping
    public Failure createFailure(@RequestBody Failure failure){
        return failureRepository.save(failure);
    }

    //get failure by id
    @GetMapping("{id}")
    public ResponseEntity<Failure> getFailureById(@PathVariable long id){
        Failure failure = failureRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Failure Not exits by id"+id));

        return ResponseEntity.ok(failure);

    }

    //Update failure
    @PutMapping("{id}")
    public ResponseEntity<Failure> updateFailure(@PathVariable long id ,@RequestBody Failure filureDetails){

        Failure updateFailure = failureRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Failure Not exits by id"+id));
        updateFailure.setName(filureDetails.getName());
        updateFailure.setEmail(filureDetails.getEmail());
        updateFailure.setPhone(filureDetails.getPhone());
        updateFailure.setMessage(filureDetails.getMessage());
        updateFailure.setAddress(filureDetails.getAddress());

        failureRepository.save(updateFailure);

        return ResponseEntity.ok(updateFailure);

    }

    //delete failure
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteFailure(@PathVariable long id){

        Failure failure = failureRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Failure not exits by id"+id));

        failureRepository.delete(failure);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
