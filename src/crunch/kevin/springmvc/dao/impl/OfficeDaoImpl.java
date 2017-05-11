package crunch.kevin.springmvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import crunch.kevin.springmvc.dao.OfficeDao;
import crunch.kevin.springmvc.javabean.Offices;

public class OfficeDaoImpl implements OfficeDao {

	@Override
	public Offices getOfficebyCode(int code) {
		// TODO Auto-generated method stub
		String sql="select * from offices where officeCode = ?";
		JdbcTemplate jdbc = new JdbcTemplate();
		final Offices o = new Offices();
		jdbc.query(sql, new Object[]{code}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				o.setOfficeCode(rs.getInt("officeCode"));
				o.setCity(rs.getString("city"));
				o.setPhone(rs.getString("phone"));
				o.setAddressLine1(rs.getString("addressLine1"));
				o.setAddressLine2(rs.getString("addressLine2"));
				o.setState(rs.getString("state"));
				o.setCountry(rs.getString("country"));
				o.setPostalCode(rs.getString("postalCode"));
				o.setTerritory(rs.getString("territory"));
			}
		});
		return o;
	}

}
