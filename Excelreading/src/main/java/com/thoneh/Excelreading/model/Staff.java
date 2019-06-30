package com.thoneh.Excelreading.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Staff {

	private Long id;

	private String staffId;

	private String fullName;

	private BankAccount bankAccount;
	
	private TAXNumber taxNumber;
	
	private EPFNumber epfNumber;
	
	private ESINumber esiNUmber;
	
	private SocsoNumber socsoNumber;
	
	private Data_Designation data_designation;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@OneToOne(mappedBy="staff")
	public TAXNumber getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(TAXNumber taxNumber) {
		this.taxNumber = taxNumber;
	}

	@OneToOne(mappedBy="staff")
	public EPFNumber getEpfNumber() {
		return epfNumber;
	}

	public void setEpfNumber(EPFNumber epfNumber) {
		this.epfNumber = epfNumber;
	}

	@OneToOne(mappedBy="staff")
	public ESINumber getEsiNUmber() {
		return esiNUmber;
	}

	public void setEsiNUmber(ESINumber esiNUmber) {
		this.esiNUmber = esiNUmber;
	}

	@OneToOne(mappedBy="staff")
	public SocsoNumber getSocsoNumber() {
		return socsoNumber;
	}

	public void setSocsoNumber(SocsoNumber socsoNumber) {
		this.socsoNumber = socsoNumber;
	}

	@OneToOne(mappedBy="staff")
	public Data_Designation getData_designation() {
		return data_designation;
	}

	public void setData_designation(Data_Designation data_designation) {
		this.data_designation = data_designation;
	}
	@OneToOne(mappedBy="staff")
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}


}
