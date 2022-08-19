package com.investmentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Investment {
	
	private String planName;
	private Integer planId;
	private int entryAge;
	private String type;//mutual,ulip,ppf.fd,rd,
	private double amount;
	private String purpose;//education,retirement,marriage
	private String risk;
	private String nominee;//father,son,daughter,
	private int term;
	
	public Investment(String planName, int entryAge, String type, double amount, String purpose, String risk,
			String nominee, int term) {
		super();
		this.planName = planName;
		this.entryAge = entryAge;
		this.type = type;
		this.amount = amount;
		this.purpose = purpose;
		this.risk = risk;
		this.nominee = nominee;
		this.term = term;
	}
	

	
}
