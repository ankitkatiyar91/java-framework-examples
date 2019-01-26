package com.persist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.Employee;

@Repository
public class EmployeePersist {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void save(Employee employee){
		mongoTemplate.insert(employee);
	}
	
	
	public void findAll(){
		List<Employee> employees =mongoTemplate.findAll(Employee.class);
		System.out.println("%%%%%%%%%% All Employees %%%%%%%%%");
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
}
