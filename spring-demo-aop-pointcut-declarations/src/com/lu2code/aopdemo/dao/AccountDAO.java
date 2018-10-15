package com.lu2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lu2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing My Db Work: AccountDAO.addAccount");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": Doing My Db Work: AccountDAO.doWork");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + " AccountDAO.getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " AccountDAO.setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + "AccountDAO.getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "AccountDAO.setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp2);
		
		
		return myAccounts;
	}
	
}

