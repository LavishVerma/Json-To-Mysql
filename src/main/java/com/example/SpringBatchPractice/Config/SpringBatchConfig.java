package com.example.SpringBatchPractice.Config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.SpringBatchPractice.Models.Covid;

@EnableBatchProcessing
@Configuration
public class SpringBatchConfig {

@Autowired
StepBuilderFactory stepbuilderfactory;

@Autowired 
JobBuilderFactory jobbuilderfactory;
	
@Bean
public Job FirstJob(JsonItemReader<Covid> jsonitemReader, ItemWriter<Covid> itemwriter,ItemProcessor<Covid, Covid> itemprocessor,JobExecutionListener listener)
{
	System.out.println("Inside JOB");
	Step step1 =stepbuilderfactory.get("FirstStep")
			.<Covid,Covid>chunk(500)
			.reader(jsonitemReader)
			.processor(itemprocessor)
			.writer(itemwriter)
			.build();
	
	return jobbuilderfactory.get("FirstJob")
			.incrementer(new RunIdIncrementer())
			.listener(listener)
			.flow(step1)
			.end()
			.build();
}


@Bean
public JsonItemReader<Covid> jsonItemReader() {
	
	System.out.println("Inside Reader");
	
	return new JsonItemReaderBuilder<Covid>()
			.jsonObjectReader(new JacksonJsonObjectReader<>(Covid.class))
			.resource(new ClassPathResource("covid.json"))
			.strict(false)
			.name("JsonItemReader")
			.build();
}

	
}
