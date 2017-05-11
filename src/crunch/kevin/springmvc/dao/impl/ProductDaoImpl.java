package crunch.kevin.springmvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import crunch.kevin.springmvc.dao.ProductDao;
import crunch.kevin.springmvc.javabean.Product;

public class ProductDaoImpl implements ProductDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static final String SEARCH_PRODUCT_BY_ID = "select * from products order by productLine";

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> product = new ArrayList<Product>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate
				.queryForList(SEARCH_PRODUCT_BY_ID);
		for (Map<String, Object> row : proRows) {
			Product pro = new Product();
			pro.setProductCode(String.valueOf(row.get("productCode")));
			pro.setProductName(String.valueOf(row.get("productName")));
			pro.setProductLine((String) row.get("productLine"));
			pro.setProductVendor(String.valueOf(row.get("productVendor")));
			pro.setProductDescription(String.valueOf(row
					.get("productDescription")));
			pro.setQuantityInStock((Integer) row.get("quantityInStock"));
			pro.setBuyPrice(row.get("buyPrice").toString());
			pro.setMSRP(row.get("MSRP").toString());
			pro.setPicurl((String)row.get("picUrl"));
			product.add(pro);
		}
		return product;
	}

	public List<Product> searchProductsbyTypes(String type) {
		// TODO Auto-generated method stub
		String sql = "select * from products where 1=1 ";
		switch (type) {
		case "Classic Cars":
			sql += "and productLine='Classic Cars'";
			System.out.println("Classic Cars");
			break;
		case "Motorcycles":
			sql += "and productLine='Motorcycles'";
			System.out.println("Motorcycles");
			break;
		case "Planes":
			sql += "and productLine='Planes'";
			System.out.println("Planes");
			break;
		case "Ships":
			sql += "and productLine='Ships'";
			System.out.println("1");
			break;
		case "Trucks and Buses":
			sql += "and productLine='Trucks and Buses'";
			System.out.println("2");
			break;
		case "Vintage Cars":
			sql += "and productLine='Vintage Cars'";
			System.out.println("3");
			break;
		case "Boats":
			sql += "and productLine='Boats'";
			System.out.println("4");
			break;
		case "Trains":
			sql += "and productLine='Trains'";
			System.out.println("Trains");
			break;
		default:
			System.out.println("5");
			break;
		}
		List<Product> product = new ArrayList<Product>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : proRows) {
			Product pro = new Product();
			pro.setProductCode(String.valueOf(row.get("productCode")));
			pro.setProductName(String.valueOf(row.get("productName")));
			pro.setProductLine((String) row.get("productLine"));
			pro.setProductVendor(String.valueOf(row.get("productVendor")));
			pro.setProductDescription(String.valueOf(row
					.get("productDescription")));
			pro.setQuantityInStock((Integer) row.get("quantityInStock"));
			pro.setBuyPrice(row.get("buyPrice").toString());
			pro.setMSRP(row.get("MSRP").toString());
			pro.setPicurl((String)row.get("picUrl"));
			product.add(pro);
		}
		return product;
	}

	@Override
	public Product getProductbyCode(String Code) {
		// TODO Auto-generated method stub
		String sql = "select * from products where productCode = ?";
		final Product pro = new Product();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(sql, new Object[] { Code },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						pro.setProductCode(rs.getString("productCode"));
						pro.setProductName(rs.getString("productName"));
						pro.setProductLine(rs.getString("productLine"));
						pro.setProductVendor(rs.getString("productVendor"));
						pro.setProductDescription(rs
								.getString("productDescription"));
						pro.setQuantityInStock(rs.getInt("quantityInStock"));
						pro.setBuyPrice(rs.getObject("buyPrice").toString());
						pro.setMSRP(rs.getObject("MSRP").toString());
						pro.setPicurl(rs.getString("picUrl"));
					}
				});
		return pro;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		String sql = "insert into products(productCode,productName,productLine,productScale,productVendor,productDescription,quantityInStock,buyPrice,MSRP,picUrl) values(?,?,?,?,?,?,?,?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { product.getProductCode(),
							product.getProductName(), product.getProductLine(),
							product.getProductScale(),
							product.getProductVendor(),
							product.getProductDescription(),
							product.getQuantityInStock(),
							product.getBuyPrice(), product.getMSRP(), product.getPicurl() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		String sql = "update products set productName=?, productLine=?, productScale=?, productVendor=?, productDescription=?, quantityInStock=?, buyPrice=?, MSRP=?,picUrl=? where productCode=?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { product.getProductName(),
							product.getProductLine(),
							product.getProductScale(),
							product.getProductVendor(),
							product.getProductDescription(),
							product.getQuantityInStock(),
							product.getBuyPrice(), product.getMSRP(), product.getPicurl(),
							product.getProductCode() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getPagedProducts(int start, int totle) {
		// TODO Auto-generated method stub
		String sql = "select * from products limit " + start + ", " + totle;
		List<Product> product = new ArrayList<Product>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : proRows) {
			Product pro = new Product();
			pro.setProductCode(String.valueOf(row.get("productCode")));
			pro.setProductName(String.valueOf(row.get("productName")));
			pro.setProductLine((String) row.get("productLine"));
			pro.setProductVendor(String.valueOf(row.get("productVendor")));
			pro.setProductDescription(String.valueOf(row
					.get("productDescription")));
			pro.setQuantityInStock((Integer) row.get("quantityInStock"));
			pro.setBuyPrice(row.get("buyPrice").toString());
			pro.setMSRP(row.get("MSRP").toString());
			pro.setPicurl((String)row.get("picUrl"));
			product.add(pro);
		}
		return product;
	}

	@Override
	public int getProductsCount(String type) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from products where 1=1 ";
		switch (type) {
		case "Classic Cars":
			sql += "and productLine='Classic Cars'";
			System.out.println("Classic Cars");
			break;
		case "Motorcycles":
			sql += "and productLine='Motorcycles'";
			System.out.println("Motorcycles");
			break;
		case "Planes":
			sql += "and productLine='Planes'";
			System.out.println("Planes");
			break;
		case "Ships":
			sql += "and productLine='Ships'";
			System.out.println("1");
			break;
		case "Trucks and Buses":
			sql += "and productLine='Trucks and Buses'";
			System.out.println("2");
			break;
		case "Vintage Cars":
			sql += "and productLine='Vintage Cars'";
			System.out.println("3");
			break;
		case "Boats":
			sql += "and productLine='Boats'";
			System.out.println("4");
			break;
		case "Trains":
			sql += "and productLine='Trains'";
			System.out.println("Trains");
			break;
		default:
			System.out.println("5");
			break;
		}
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void addURl(String type, int c) {
		// TODO Auto-generated method stub
		String sql;
		sql="drop table if exists temp; ";
		sql +="create TEMPORARY table `temp` select productCode from products where";
		switch (type) {
		case "Classic Cars":
			sql += " productLine='Classic Cars'";
			System.out.println("Classic Cars");
			break;
		case "Motorcycles":
			sql += " productLine='Motorcycles'";
			System.out.println("Motorcycles");
			break;
		case "Planes":
			sql += " productLine='Planes'";
			System.out.println("Planes");
			break;
		case "Ships":
			sql += " productLine='Ships'";
			System.out.println("1");
			break;
		case "Trucks and Buses":
			sql += " productLine='Trucks and Buses'";
			System.out.println("2");
			break;
		case "Vintage Cars":
			sql += " productLine='Vintage Cars'";
			System.out.println("3");
			break;
		case "Boats":
			sql += " productLine='Boats'";
			System.out.println("4");
			break;
		case "Trains":
			sql += " productLine='Trains'";
			System.out.println("Trains");
			break;
		default:
			System.out.println("5");
			break;
		} 
		sql+=" order by productCode asc limit ?, 1 ; ";
		sql += "update products set picUrl = 'image/cars/classiccars/"+c+1+".jpg' where productCode = (select * from temp ); ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[]{c});
	}
}
