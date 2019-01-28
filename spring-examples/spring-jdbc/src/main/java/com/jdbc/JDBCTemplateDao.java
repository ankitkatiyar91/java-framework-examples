package com.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.domain.Address;

@Service
public class JDBCTemplateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void getData() {
		// jdbcTemplate=new JdbcTemplate();
		System.out.println("JDBCTemplateDao.getData() " + jdbcTemplate);
		List<Address> addresses = jdbcTemplate
				.query("SELECT * FROM address",
						new org.springframework.jdbc.core.BeanPropertyRowMapper<Address>(
								Address.class));
		for (Address address : addresses) {
			System.out.println(address);
		}

	}

	public Address getById(Integer id) {
		String query = "Select * FROM address WHERE addressId=?";
		Address address = null;
		//SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
		address = jdbcTemplate.queryForObject(query, new Object[] { id },
				new BeanPropertyRowMapper<Address>(Address.class));

		return address;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
