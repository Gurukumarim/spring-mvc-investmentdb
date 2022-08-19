package com.investmentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentapp.model.Investment;
import com.investmentapp.repository.IInvestmentRepository;
@Service
public class InvestmentServiceImpl implements IInvestmentService {
	
	private IInvestmentRepository investmentRepository;
	
	
	
    @Autowired
	public void setInvestmentRepository(IInvestmentRepository investmentRepository) {
		this.investmentRepository= investmentRepository;
	}

	@Override
	public void addInvestment(Investment investment) {
		
		
		investmentRepository.addInvestment(investment);
		
	}

	@Override
	public void UpdateInvestment(int planId, double amount) {
		investmentRepository.UpdateInvestment(planId, amount);
		
	}

	@Override
	public void deleteInvestment(int planId) {
		investmentRepository.deleteInvestment(planId);
	}

	@Override
	public List<Investment> getByRisk(String risk, int term) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Investment> getByType(String type) {
		
		investmentRepository. getByType(type);
		
		return null;
	}

	@Override
	public List<Investment> getByPurpose(String purpose, int term) {
		investmentRepository.getByPurpose(purpose, term);
		return null;
	}

	@Override
	public List<Investment> getByRisk(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Investment> getByAll() {
		investmentRepository.getByAll();
		return null;
	}

}
