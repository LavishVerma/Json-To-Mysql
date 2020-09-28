package com.example.SpringBatchPractice.Batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.SpringBatchPractice.Models.Covid;

@Component
public class Processor implements ItemProcessor<Covid, Covid> {

	@Override
	public Covid process(Covid item) throws Exception {
		//System.out.println("Inside Processor");
		return item; 
	}

}
