package com.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.domain.Address;

public class JDBCDaoSupportImpl extends JdbcDaoSupport {

	public JDBCDaoSupportImpl(DataSource dataSource){
		super.setDataSource(dataSource);
	}
	
	public void getData() {
		// jdbcTemplate=new JdbcTemplate();
		System.out.println("JDBCDaoSupportImpl.getData() " + getJdbcTemplate());
		List<Address> addresses = getJdbcTemplate()
				.query("SELECT * FROM address",
						new org.springframework.jdbc.core.BeanPropertyRowMapper<Address>(
								Address.class));
		for (Address address : addresses) {
			System.out.println(address);
		}

	}
}
