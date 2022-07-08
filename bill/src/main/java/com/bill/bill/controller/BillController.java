package com.bill.bill.controller;

import com.bill.bill.exception.ResourceNotFoundException;
import com.bill.bill.model.Bill;
import com.bill.bill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/b1/bills")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping
    public List<Bill> getAllBills(){

        return billRepository.findAll();
    }

    //Create Bill
    @PostMapping
    public Bill createBill(@RequestBody Bill bill){
        return billRepository.save(bill);
    }

    //get bill by id
    @GetMapping("{id}")
    public ResponseEntity<Bill> getBillByid(@PathVariable long id){

        Bill bill = billRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Bill not exits by id "+id));
        return ResponseEntity.ok(bill);

    }

    //update bill by id
    @PutMapping("{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable long id,@RequestBody Bill billDetails){

        Bill updateBill = billRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Bill not exits by id"+id));

        updateBill.setFirstName(billDetails.getFirstName());
        updateBill.setLastName(billDetails.getLastName());
        updateBill.setUnits(billDetails.getUnits());
        updateBill.setBillAmount(billDetails.getBillAmount());
        updateBill.setCusEmail(billDetails.getCusEmail());

        billRepository.save(updateBill);

        return ResponseEntity.ok(updateBill);

    }

    //Delete Bill By ID
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBill(@PathVariable long id){

        Bill bill = billRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Bill not exits by id"+id));
        billRepository.delete(bill);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
