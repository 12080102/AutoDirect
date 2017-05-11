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

import crunch.kevin.springmvc.dao.ProductlineDao;
import crunch.kevin.springmvc.javabean.ProductLine;

public class ProductlineDaoImpl implements ProductlineDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void addProductline(ProductLine productLine) {
		// TODO Auto-generated method stub
		String sql = "insert into productlines(productLine,textDescription,htmlDescription,image) values(?,?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { productLine.getProductLine(),
							productLine.getTextDescription(),
							productLine.getHtmlDescription(),
							productLine.getImage() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateProductline(ProductLine productline) {
		// TODO Auto-generated method stub
		String sql = "insert into productlines(productLine,textDescription,htmlDescription,image) values(?,?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { productline.getProductLine(),
							productline.getTextDescription(),
							productline.getHtmlDescription(),
							productline.getImage() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ProductLine getProductLinebyName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from productlines where productLine=?";
		final ProductLine line = new ProductLine();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(sql, new Object[] { name },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						line.setProductLine(rs.getString("productLine"));
						line.setTextDescription(rs.getString("textDescription"));
						line.setHtmlDescription(rs.getString("htmlDescription"));
						line.setImage(rs.getString("image"));
					}
				});
		return line;
	}

	@Override
	public List<ProductLine> getAllProductLine() {
		// TODO Auto-generated method stub
		String sql = "select * from productlines";
		List<ProductLine> lines = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate
				.queryForList(sql);
		for (Map<String, Object> rs : proRows) {
			ProductLine line = new ProductLine();
			line.setProductLine((String)rs.get("productLine"));
			line.setTextDescription((String)rs.get("textDescription"));
			line.setHtmlDescription((String)rs.get("htmlDescription"));
			line.setImage((String)rs.get("image"));
			lines.add(line);
		}
		return lines;
	}

}
