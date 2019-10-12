package com.neu.web.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drug {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="drugId",unique=true,nullable=false)
	private long drugId;
	
	@Column
	private String drugcomid;
	
	@Column
	private String drugName;
	
	@Column
	private String dosageValue;
	
	public Drug() {
		
	}
	
	public String getDrugcomid() {
		return drugcomid;
	}
	public void setDrugcomid(String drugcomid) {
		this.drugcomid = drugcomid;
	}
	
	public long getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDosageValue() {
		return dosageValue;
	}
	public void setDosageValue(String dosageValue) {
		this.dosageValue = dosageValue;
	}
	
	
}
