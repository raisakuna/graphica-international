package com.graphicaInternational.datajpa.entity;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="person")
public class Person {
	@Id
	@Column(name="person_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="person_name")
	private String personName;
	
	@Column(name="mobilenumber")
	private long mobileNumber;
	
	@Column(name="address")
	private String address ;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return personName;
	}
	public void setStudentName(String studentName) {
		this.personName = studentName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + personName + ", mobileNumber=" + mobileNumber + ", address="
				+ address + "]";
	}
	
	

}
