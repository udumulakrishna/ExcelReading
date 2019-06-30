package com.thoneh.Excelreading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ESINumber {

	private Long id;

	private String ESINO;

	private String EIS_EMPLOYER_NO;

	private Staff staff;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getESINO() {
		return ESINO;
	}

	public void setESINO(String eSINO) {
		ESINO = eSINO;
	}

	public String getEIS_EMPLOYER_NO() {
		return EIS_EMPLOYER_NO;
	}

	public void setEIS_EMPLOYER_NO(String eIS_EMPLOYER_NO) {
		EIS_EMPLOYER_NO = eIS_EMPLOYER_NO;
	}

	@OneToOne
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
