package com.lu2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass() + ": Doing My Db Work: MembershipDAO.addAccount");
	}
	
	public boolean addSillyMember() {
		System.out.println(getClass() + ": Doing My Db Work: MembershipDAO.addSillyMember");
		return true;
	}
}
