package com.lu2code.aopdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.lu2code.aopdemo.dao.AccountDAO;



@Configuration // for pure java configuration 
@EnableAspectJAutoProxy
@ComponentScan("com.lu2code.aopdemo")
public class DemoConfig {
//	@Bean
//	public AccountDAO accountDAO() {
//		return new AccountDAO();
//	}
}
