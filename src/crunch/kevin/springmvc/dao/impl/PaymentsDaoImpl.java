package crunch.kevin.springmvc.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import crunch.kevin.springmvc.dao.PaymentsDao;
import crunch.kevin.springmvc.javabean.Payments;

public class PaymentsDaoImpl implements PaymentsDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void newPayment(Payments payment) {
		// TODO Auto-generated method stub
		String sql = "insert into payment(customerNumber,checkNumber,paymentDate,amount) values(?,?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { payment.getCustomerNumber(),
							payment.getCheckNumber(), payment.getPaymentDate(),payment.getAmount() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Payments> getPaymentbyCustomerNumber(int number) {
		String sql="select * from payments where customerNumber = ?";
		List<Payments> payments = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String,Object>> proRows=jdbcTemplate.queryForList(sql, new Object[] {number});
		for(Map<String, Object> rs : proRows){
			Payments o = new Payments();
			o.setCheckNumber((String)rs.get("checkNumber"));
			o.setPaymentDate((Date)rs.get("paymentDate"));
			o.setAmount((Double)rs.get("amount"));
			o.setCustomerNumber((Integer)rs.get("customerNumber"));
		}
		return payments;
	}

	@Override
	public List<Payments> getPaymentbyPaymentDate(Date date) {
		String sql="select * from payments where paymentDate = ?";
		List<Payments> payments = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String,Object>> proRows=jdbcTemplate.queryForList(sql, new Object[] {date});
		for(Map<String, Object> rs : proRows){
			Payments o = new Payments();
			o.setCheckNumber((String)rs.get("checkNumber"));
			o.setPaymentDate((Date)rs.get("paymentDate"));
			o.setAmount((Double)rs.get("amount"));
			o.setCustomerNumber((Integer)rs.get("customerNumber"));
		}
		return payments;
	}

}
