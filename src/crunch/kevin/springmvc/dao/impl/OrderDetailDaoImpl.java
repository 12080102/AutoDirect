package crunch.kevin.springmvc.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import crunch.kevin.springmvc.dao.OrderDetailDao;
import crunch.kevin.springmvc.javabean.Cart;
import crunch.kevin.springmvc.javabean.Customer;
import crunch.kevin.springmvc.javabean.OrderDetails;

public class OrderDetailDaoImpl implements OrderDetailDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void newOrderDetail(OrderDetails od) {
		System.out.println("od");
		// TODO Auto-generated method stub
		String sql = "insert into orderdetails(orderNumber,productCode,quantityOrdered,priceEach,orderLineNumber) values(?,?,?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { od.getOrderNumber(), od.getProductCode(),
							od.getQuantityOrdered(), od.getPriceEach(),
							od.getOrderLineNumber() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrderDetail(OrderDetails od) {
		// TODO Auto-generated method stub
		String sql = "update orderdetails set productCode=?,quantityOrdered=?,priceEach=?,orderLineNumber=?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { od.getProductCode(),
							od.getQuantityOrdered(), od.getPriceEach(),
							od.getOrderLineNumber() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public OrderDetails getOrderDetailbyNumber(int number) {
		// TODO Auto-generated method stub
		String sql = "select * from orderdetails where orderNumber = ?";
		final OrderDetails od = new OrderDetails();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(sql, new Object[] { number },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						od.setOrderNumber(rs.getInt("orderNumber"));
						od.setProductCode(rs.getString("productCode"));
						od.setQuantityOrdered(rs.getInt("quantityOrdered"));
						od.setPriceEach(rs.getDouble("priceEach"));
						od.setOrderNumber(rs.getInt("orderLineNumber"));
					}
				});
		return od;
	}

	@Override
	public List<OrderDetails> getAllOrderDetail() {
		// TODO Auto-generated method stub

		String sql = "select * from orderdetails";
		List<OrderDetails> lc = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> rs : proRows) {
			OrderDetails od = new OrderDetails();
			od.setOrderNumber((Integer)rs.get("orderNumber"));
			od.setProductCode((String)rs.get("productCode"));
			od.setQuantityOrdered((Integer)rs.get("quantityOrdered"));
			od.setPriceEach((Double)rs.get("priceEach"));
			od.setOrderNumber((Integer)rs.get("orderLineNumber"));
			lc.add(od);
		}
		return lc;
	}

}
