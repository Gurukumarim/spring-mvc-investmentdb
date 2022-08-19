package com.investmentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.investmentapp.model.Investment;
import com.investmentapp.util.DBQueries;

@Repository
public class InvestmentRepositoryImpl implements IInvestmentRepository {


	private JdbcTemplate jdbcTemplete;
	private ResultSet rs;
	private ResultSetExtractor getById;



	@Autowired
	public void setJdbcTemplete(JdbcTemplate jdbcTemplete) {
		this.jdbcTemplete = jdbcTemplete;
	}

	@Override
	public void addInvestment(Investment investment) {

		//String sql=DBQueries.INSERTQUERY;
		Object[]investmentArray= {

				investment.getPlanName(),investment.getEntryAge(),investment.getType(),investment.getAmount(),investment.getPurpose(),investment.getRisk(),investment.getNominee(),investment.getTerm()

		};
		jdbcTemplete.update(DBQueries.INSERTQUERY,investmentArray);


	}

	@Override
	public void UpdateInvestment(int planId, double amount) {
		String sql=DBQueries.UPDATEQUERY;
		jdbcTemplete.update(sql,amount,planId);
	}

	@Override
	public void deleteInvestment(int planId) {
		jdbcTemplete.update(DBQueries.DELETEQUERY,planId);

	}

	@Override
	public List<Investment> getByRisk(String risk, int term) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Investment> getByType(String type) {
		List<Investment>investments=jdbcTemplete.query(DBQueries.SELECTBYTYPE,(RS,rowNum)->{



			Investment investment=new Investment();
			investment.setPlanName(rs.getString("plan_name"));
			investment.setPurpose(rs.getString("purpose"));
			investment.setAmount(rs.getDouble("amount"));
			investment.setEntryAge(rs.getInt("entry_age"));
			investment.setRisk(rs.getString("risk"));
			investment.setNominee(rs.getString("nominee"));
			investment.setType(rs.getString("type"));
			investment.setTerm(rs.getInt("term"));


			int planId=rs.getInt("plan_id");
			investment.setPlanId(planId);
			return investment;
		},type);
		return investments;
	}

	@Override
	public List<Investment> getByPurpose(String purpose,int term) {
		List<Investment> investments=jdbcTemplete.query(DBQueries.SELECTBYPURPOSE, new RowMapper<Investment>(){

			@Override
			public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {

				Investment investment=new Investment();
				investment.setPlanName(rs.getString("plan_name"));
				investment.setPurpose(rs.getString("purpose"));
				investment.setAmount(rs.getDouble("amount"));
				investment.setEntryAge(rs.getInt("entry_age"));
				investment.setRisk(rs.getString("risk"));
				investment.setNominee(rs.getString("nominee"));
				investment.setType(rs.getString("type"));
				investment.setTerm(rs.getInt("term"));


				int planId=rs.getInt("plan_id");
				investment.setPlanId(planId);

				return investment;
			}
		},purpose);



		return investments;
	}

	@Override
	public List<Investment> getByRisk(String type) {
	
		List<Investment> investments=jdbcTemplete.query(DBQueries.SELECTBYRISKTERM, new RowMapper<Investment>(){

			@Override
			public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {

				Investment investment=new Investment();
				investment.setPlanName(rs.getString("plan_name"));
				investment.setPurpose(rs.getString("purpose"));
				investment.setAmount(rs.getDouble("amount"));
				investment.setEntryAge(rs.getInt("entry_age"));
				investment.setRisk(rs.getString("risk"));
				investment.setNominee(rs.getString("nominee"));
				investment.setType(rs.getString("type"));
				investment.setTerm(rs.getInt("term"));


				int planId=rs.getInt("plan_id");
				investment.setPlanId(planId);

				return investment;
			}
		},type);



		return investments;
		
	}

	@Override
	public List<Investment> getByAll() {
		RowMapper<Investment>mapper =new InvestmentMapper();
		List<Investment> investments=jdbcTemplete.query(DBQueries.SELECTQUERY, mapper);

		return investments;
	}

	@Override
	public Investment getById(int planId) {
		
		Investment investments=jdbcTemplete.queryForObject(DBQueries.SELECTBYID, new RowMapper<Investment>(){

			@Override
			public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {

				Investment investment=new Investment();
				investment.setPlanName(rs.getString("plan_name"));
				investment.setPurpose(rs.getString("purpose"));
				investment.setAmount(rs.getDouble("amount"));
				investment.setEntryAge(rs.getInt("entry_age"));
				investment.setRisk(rs.getString("risk"));
				investment.setNominee(rs.getString("nominee"));
				investment.setType(rs.getString("type"));
				investment.setTerm(rs.getInt("term"));


				int planId=rs.getInt("plan_id");
				investment.setPlanId(planId);

				return investment;
			}
		},planId);



		return  investments;
	}

}
