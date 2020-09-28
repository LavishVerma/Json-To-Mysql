package com.example.SpringBatchPractice.Batch;

import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.JsonObjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.SpringBatchPractice.Models.Covid;
import com.example.SpringBatchPractice.Repository.CovidRepository;

@Component
public class Writer implements ItemWriter<Covid> {
	
	@Autowired
	CovidRepository repo;

	@Override
	public void write(List<? extends Covid> items) throws Exception {
		//System.out.println("Inside writer");
		//repo.saveAll(items);
		
	}

	

}
