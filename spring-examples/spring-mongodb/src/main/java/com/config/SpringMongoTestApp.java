package com.config;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.CommandLineAddApp;
import com.persist.EmployeePersist;
import com.persist.PersonPersist;
import com.pojo.Address;
import com.pojo.Employee;
import com.pojo.Person;

public class SpringMongoTestApp {
	private static AbstractApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();

		//employeeTest();
		varTest();
	}

	private static void personTest() {
		/*
		 * Save a simple personn
		 */
		Person person = context.getBean(Person.class);
		person.setName("Ankit");
		person.setAge(23);
		PersonPersist persist = context.getBean(PersonPersist.class);
		/* persist.savePerson(person); */
		persist.getPersons();
		System.out.println("Person With ID(53aa766eda7dc220b54388fc) -"
				+ persist.findPersonById("53aa766eda7dc220b54388fc"));
	}

	
	private static void employeeTest(){
		Employee employee=context.getBean(Employee.class);
		Address address=new Address("My First Address");
		Address address1=new Address("My Second Address");
		employee.setName("Ankit Employee");
		employee.getAddresses().add(address);
		employee.getAddresses().add(address1);
		EmployeePersist employeePersist=context.getBean(EmployeePersist.class);
		employeePersist.save(employee);
		
		employeePersist.findAll();
	}
	
	private static void varTest(){
		CommandLineAddApp addApp=context.getBean(CommandLineAddApp.class);
		addApp.startApp();
	}
}
