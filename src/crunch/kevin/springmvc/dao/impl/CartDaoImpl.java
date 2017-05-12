package crunch.kevin.springmvc.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

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
		String sql = "insert into cart(customerNumber,productNumberList,productCount,price) values(?,?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { cart.getCustomerNumber(),
							cart.getProductNumberList(),
							cart.getProductCount(), cart.getPrice() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "update cart set productNumberList=?, productCount=?, price=? where cartCode=?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { cart.getProductNumberList(),
							cart.getProductCount(), cart.getPrice(),
							cart.getCartCode() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cart> getCartbyCustomerNumber(int number) {
		String sql = "select * from cart where customerNumber=?";
		List<Cart> lc = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate.queryForList(sql,
				new Object[] { number });
		for (Map<String, Object> rs : proRows) {
			Cart cart = new Cart();
			cart.setCartCode((Integer) rs.get("cartCode"));
			cart.setCustomerNumber((Integer) rs.get("customerNumber"));
			cart.setProductCount(Integer.parseInt((String) rs
					.get("productCount")));
			cart.setProductNumberList((String) rs.get("productNumberList"));
			BigDecimal p = (BigDecimal) rs.get("price");
			cart.setPrice(p.doubleValue());
			lc.add(cart);
		}
		return lc;
	}

	@Override
	public Map<String, Double> getItemPricebyCustomerNumber(int number) {
		// TODO Auto-generated method stub
		String sql = "select price,productCount from cart where customerNumber=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Double price = 0.00;
		int count = 0;
		List<Map<String, Object>> proRows = jdbcTemplate.queryForList(sql,
				new Object[] { number });
		for (Map<String, Object> rs : proRows) {
			count += Integer.parseInt((String) rs.get("productCount"));
			BigDecimal p = (BigDecimal) rs.get("price");
			BigDecimal c = new BigDecimal((String) rs.get("productCount"));
			price += p.multiply(c).doubleValue();
		}
		Map<String, Double> cp = new HashMap<>();
		cp.put("count", (double) count);
		cp.put("price", price);
		return cp;
	}

	@Override
	public void delectCart(int cart) {
		// TODO Auto-generated method stub
		String sql = "delete from cart where cartCode=?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(sql, new Object[] { cart });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
