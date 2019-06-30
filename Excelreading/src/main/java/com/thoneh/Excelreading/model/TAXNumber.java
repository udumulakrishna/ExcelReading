package com.thoneh.Excelreading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TAXNumber {

	private Long id;

	private String TAXNO;

	private String ICNO;

	private Staff staff;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTAXNO() {
		return TAXNO;
	}

	public void setTAXNO(String tAXNO) {
		TAXNO = tAXNO;
	}

	public String getICNO() {
		return ICNO;
	}

	public void setICNO(String iCNO) {
		ICNO = iCNO;
	}

	@OneToOne
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
