package com.failure.failure.repository;

import com.failure.failure.model.Failure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FailureRepository extends JpaRepository<Failure,Long> {

    //All the Crud Operation
}
