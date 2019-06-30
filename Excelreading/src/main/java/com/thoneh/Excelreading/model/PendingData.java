package com.thoneh.Excelreading.model;

import javax.persistence.Entity;

//@Entity
public class PendingData {

	private Long id;
	
	private String staffId;
	
	private String tableName;
	
	private String notExisting;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getNotExisting() {
		return notExisting;
	}

	public void setNotExisting(String notExisting) {
		this.notExisting = notExisting;
	}
	
	
	
}
