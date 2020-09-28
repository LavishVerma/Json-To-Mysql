package com.example.SpringBatchPractice.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBatchPractice.Models.Covid;

@Repository
public interface CovidRepository extends CrudRepository<Covid, Long> {

}
