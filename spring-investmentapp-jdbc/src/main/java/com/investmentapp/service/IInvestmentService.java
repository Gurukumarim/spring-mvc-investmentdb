package com.investmentapp.service;

import java.util.List;

import com.investmentapp.model.Investment;

public interface IInvestmentService {

	void addInvestment(Investment investment);
	void UpdateInvestment(int planId,double amount);
	void deleteInvestment(int  planId);

	List<Investment>getByRisk(String risk, int term);
	List<Investment>getByType(String type);
	List<Investment>getByPurpose(String risk,int term);
	List<Investment>getByRisk(String  type);
	List<Investment>getByAll();


}
