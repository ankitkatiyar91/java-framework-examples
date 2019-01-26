package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JDBCDao {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	public void getData() {
		try {
			Connection connection = dataSource.getConnection();
			ResultSet resultSet = connection.createStatement().executeQuery(
					"SELECT * FROM address");
			while (resultSet.next()) {
				System.out.println("1->" + resultSet.getString(1) + " 2->"
						+ resultSet.getString(2));
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
