package com.thoneh.Excelreading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Data_Designation {

	private Long id;

	private String reportno;

	private String currentDesignatonStartData;

	private String currentDesignatonEndData;
	
	private String currentPosition;
	
	private String datejoined;
	
	private Category category;
	
	private Staff staff;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReportno() {
		return reportno;
	}

	public void setReportno(String reportno) {
		this.reportno = reportno;
	}

	public String getCurrentDesignatonStartData() {
		return currentDesignatonStartData;
	}

	public void setCurrentDesignatonStartData(String currentDesignatonStartData) {
		this.currentDesignatonStartData = currentDesignatonStartData;
	}

	public String getCurrentDesignatonEndData() {
		return currentDesignatonEndData;
	}

	public void setCurrentDesignatonEndData(String currentDesignatonEndData) {
		this.currentDesignatonEndData = currentDesignatonEndData;
	}

	public String getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getDatejoined() {
		return datejoined;
	}

	public void setDatejoined(String datejoined) {
		this.datejoined = datejoined;
	}

	@ManyToOne
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@OneToOne
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	

}
