package com.hibernate.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "customer_info")
public class Customer implements Serializable {

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", customerName=" + customerName + ", gender=" + gender + ", address="
				+ address + "]";
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int custId;
	
	private String customerName;
	
	
	private String gender;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="add_id")
	private Address address;
	
	@OneToMany(cascade =CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private List<Account> accountList;

}
