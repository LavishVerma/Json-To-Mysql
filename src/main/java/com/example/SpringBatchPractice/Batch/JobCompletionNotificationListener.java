package com.example.SpringBatchPractice.Batch;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

	@Override
	public void afterJob(JobExecution jobExecution) {
		Date start=jobExecution.getEndTime();
		System.out.println("Job stared on ... "+start);
		System.out.println(jobExecution.getJobConfigurationName());
		System.out.println(jobExecution.getId());
		System.out.println(jobExecution.getJobId());
		System.out.println(jobExecution.getJobId());
		System.out.println(jobExecution.getStatus());
		
	}

	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Inside Before Job");
		System.out.println("Job started on"+ jobExecution.getStartTime());
	}
}
