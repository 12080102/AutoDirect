package crunch.kevin.springmvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import crunch.kevin.springmvc.dao.CartDao;
import crunch.kevin.springmvc.javabean.Cart;

public class CartDaoImpl implements CartDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void newCart(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "insert into cart(customerNumber,productNumberList,productCount) values(?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { cart.getCustomerNumber(),
							cart.getProductNumberList(), cart.getProductCount() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "update cart set productNumberList=?, productCount=? where customerNumber=?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { cart.getProductNumberList(),
							cart.getProductCount(), cart.getCustomerNumber() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Cart getCartbyCustomerNumber(int number) {
		String sql = "select * from cart where customerNumber=?";
		final Cart cart = new Cart();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(sql, new Object[] { number },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						cart.setCustomerNumber(rs.getInt("customerNumber"));
						cart.setProductCount(rs.getInt("productCount"));
						cart.setProductNumberList(rs
								.getString("productNumberList"));
					}
				});
		return cart;
	}

}
