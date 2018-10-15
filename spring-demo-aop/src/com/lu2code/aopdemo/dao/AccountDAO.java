package com.lu2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.lu2code.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing My Db Work: AccountDAO.addAccount");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": Doing My Db Work: AccountDAO.doWork");
		return false;
	}
}

