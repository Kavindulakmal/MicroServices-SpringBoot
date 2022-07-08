package com.payment.payment.repository;

import com.payment.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PaymentRepository extends JpaRepository<Payment,Long> {

    //all crud methods
}
