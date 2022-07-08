package com.bill.bill.repository;

import com.bill.bill.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository <Bill ,Long>{

    //All crud methods
}
