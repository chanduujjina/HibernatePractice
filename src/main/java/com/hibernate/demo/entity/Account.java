package com.hibernate.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_info")
public class Account implements Serializable{

	public int getAccountId() {
		return accountId;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", account_name=" + account_name + ", accountType=" + accountType
				+ "]";
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accountId;
	
	private String account_name;
	
	private String accountType;
	
	
	
	
	

}
