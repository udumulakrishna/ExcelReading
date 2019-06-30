package com.thoneh.Excelreading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SocsoNumber {

	private Long id;
	
	private String SocsoNo;
	
	private String SOCSO_EMPLOYER_NO;
	
	private Staff staff;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSocsoNo() {
		return SocsoNo;
	}

	public void setSocsoNo(String socsoNo) {
		SocsoNo = socsoNo;
	}

	public String getSOCSO_EMPLOYER_NO() {
		return SOCSO_EMPLOYER_NO;
	}

	public void setSOCSO_EMPLOYER_NO(String sOCSO_EMPLOYER_NO) {
		SOCSO_EMPLOYER_NO = sOCSO_EMPLOYER_NO;
	}

	@OneToOne
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
	
	
}
