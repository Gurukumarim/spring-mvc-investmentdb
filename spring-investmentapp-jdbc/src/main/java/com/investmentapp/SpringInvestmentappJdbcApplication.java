package com.investmentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.investmentapp.model.Investment;
import com.investmentapp.model.Nominee;
import com.investmentapp.model.PlanType;
import com.investmentapp.model.Purpose;
import com.investmentapp.model.Risk;
import com.investmentapp.service.IInvestmentService;

import ch.qos.logback.core.subst.Token.Type;

@SpringBootApplication
public class SpringInvestmentappJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringInvestmentappJdbcApplication.class, args);
		
		
	}

	@Autowired
	IInvestmentService iInvestmentService;
	@Override
	public void run(String... args) throws Exception {
		
		Investment investment= new Investment("Voya Mutual",25,PlanType.fd.type, 35000, Purpose.SAVINGS.name(),Risk.HIGH.name(), Nominee.WIFE.name(),10);
		iInvestmentService.addInvestment(investment);
		
		//Investment investments=new Investment("Karnataka Mutual",24,PlanType.fd.type,85000,Purpose.EDUCATION.name(),Risk.LOW.name(),Nominee.DAUGHTER.name(),20);
		
	}
   
	
}
