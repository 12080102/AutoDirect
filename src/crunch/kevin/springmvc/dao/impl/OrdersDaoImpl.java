package crunch.kevin.springmvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import crunch.kevin.springmvc.dao.OrdersDao;
import crunch.kevin.springmvc.javabean.Orders;

public class OrdersDaoImpl implements OrdersDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void newOrder(Orders order) {
		// TODO Auto-generated method stub
		String sql = "insert into order(orderDate,requiredDate,shippedDate,status,comments,customerNumber) values(?,?,?,?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { order.getOrderDate(),
							order.getRequiredDate(), order.getShippedDate(),
							order.getStatus(), order.getComments(),
							order.getCustomerNumber() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrder(Orders order) {
		// TODO Auto-generated method stub
		String sql = "update order set orderDate=?,requiredDate=?,shippedDate=?,status=?,comments=?,customerNumber=? where orderNumber=?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { order.getOrderDate(),
							order.getRequiredDate(), order.getShippedDate(),
							order.getStatus(), order.getComments(),
							order.getCustomerNumber(),order.getOrderNumber() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Orders getOrderbyNumber(int number) {
		String sql = "select * from orders where orderNumber = ?";
		final Orders order = new Orders();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(sql, new Object[] { number },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						order.setOrderNumber(rs.getInt("orderNumber"));
						order.setOrderDate(rs.getDate("orderDate"));
						order.setRequiredDate(rs.getDate("requiredDate"));
						order.setShippedDate(rs.getDate("shippedDate"));
						order.setStatus(rs.getString("status"));
						order.setComments(rs.getString("comments"));
						order.setCustomerNumber(rs.getInt("customerNumber"));
					}
				});
		return order;
	}

	@Override
	public List<Orders> getOrdersbyCustomer(int number) {
		String sql = "select * from orders where customerNumber = ?";
		List<Orders> order = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate.queryForList(sql,
				new Object[] { number });
		for (Map<String, Object> rs : proRows) {
			Orders o = new Orders();
			o.setOrderNumber((Integer) rs.get("orderNumber"));
			o.setOrderDate((Date) rs.get("orderDate"));
			o.setRequiredDate((Date) rs.get("requiredDate"));
			o.setShippedDate((Date) rs.get("shippedDate"));
			o.setStatus((String) rs.get("status"));
			o.setComments((String) rs.get("comments"));
			o.setCustomerNumber((Integer) rs.get("customerNumber"));
			order.add(o);
		}
		return order;
	}

	@Override
	public List<Orders> getOrdersbyDate(Date orderDate) {
		String sql = "select * from orders where orderDate = ?";
		List<Orders> order = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate.queryForList(sql,
				new Object[] { orderDate });
		for (Map<String, Object> rs : proRows) {
			Orders o = new Orders();
			o.setOrderNumber((Integer) rs.get("orderNumber"));
			o.setOrderDate((Date) rs.get("orderDate"));
			o.setRequiredDate((Date) rs.get("requiredDate"));
			o.setShippedDate((Date) rs.get("shippedDate"));
			o.setStatus((String) rs.get("status"));
			o.setComments((String) rs.get("comments"));
			o.setCustomerNumber((Integer) rs.get("customerNumber"));
			order.add(o);
		}
		return order;
	}

	@Override
	public List<Orders> getAllOrder() {
		// TODO Auto-generated method stub
		String sql = "select * from orders";
		List<Orders> order = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> rs : proRows) {
			Orders o = new Orders();
			o.setOrderNumber((Integer) rs.get("orderNumber"));
			o.setOrderDate((Date) rs.get("orderDate"));
			o.setRequiredDate((Date) rs.get("requiredDate"));
			o.setShippedDate((Date) rs.get("shippedDate"));
			o.setStatus((String) rs.get("status"));
			o.setComments((String) rs.get("comments"));
			o.setCustomerNumber((Integer) rs.get("customerNumber"));
			order.add(o);
		}
		return order;
	}

}
