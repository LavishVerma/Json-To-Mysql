package com.example.SpringBatchPractice.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Covid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String agebracket;
	private String contractedfromwhichpatientsuspected;
	private String currentstatus;
	private String dateannounced;
	private String detectedcity;
	private String detecteddistrict;
	private String detectedstate;
	private String entryid;
	private String gender;
	private String nationality;
	
	@Column(nullable = false, length = 4096)
	private String notes;
	private String numcases;
	private String patientnumber;
	private String source1;
	private String source2;
	private String source3;
	private String statecode;
	private String statepatientnumber;
	private String statuschangedate;
	private String typeoftransmission;
	
	
	


}
