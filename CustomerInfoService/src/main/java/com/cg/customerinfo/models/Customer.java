package com.cg.customerinfo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="Customer Details Model")
@Entity(name="customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

	@Id
	@Column(name = "cust_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long custId;

	@Column(name = "cust_name")
	@Size(max=20,min=2)
	private String custName;

	@Column(name = "city")
	private String city;

	@Column(name="age")
	@Min(value=21, message="Age must be equal or greater than 21")
	@Max(value=60, message="Age must be equal or less than 60")
//	@ApiModelProperty(notes="Customer age property",
//						dataType="Integer", 
//						allowableValues="range[20,60]")
	private Integer age;
	
	@Size(max=12, min=10)
	@Column(name = "phone")
	private String phone;

	public Customer(
			Long custId, 
			String custName, 
			String city, 
			Integer age, 
			String phone) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.city = city;
		this.age = age;
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Customer() {
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

