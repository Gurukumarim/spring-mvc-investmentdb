package com.investmentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentapp.exceptions.PlanNotFoundException;
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
		
		return investmentRepository.getByRisk(risk,term);
	}

	@Override
	public List<Investment> getByType(String type) {
	
		return investmentRepository. getByType(type);
	}

	@Override
	public List<Investment> getByPurpose(String purpose, int term) {
	
		return 	investmentRepository.getByPurpose(purpose, term);
	}

	@Override
	public List<Investment> getByRisk(String type) {
		
		return investmentRepository.getByRisk(type);
	}

	@Override
	public List<Investment> getByAll() {
		
		return investmentRepository.getByAll();
	}

	@Override
	public double calculateMaturity(Investment investment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Investment getById(int planId) {
		
		Investment investment= investmentRepository.getById(planId);
		if(investment==null)
			throw new PlanNotFoundException();
		return investment;
	}

}
