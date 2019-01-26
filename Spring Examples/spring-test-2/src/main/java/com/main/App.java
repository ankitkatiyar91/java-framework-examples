package com.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.bean.Person;
import com.bean.PersonType;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		/*Employee employee=context.getBean("employee",Employee.class);
		System.out.println("employee->"+employee.getName());*/
		Person person=context.getBean("person", Person.class);
		System.out.println(person);
		if(person.getType().equals(PersonType.ENGINEER)){
			System.out.println("Yo you are an ENGINEER");
		}
		
		if(!person.getType().equals(PersonType.DESIGNER)){
			System.out.println("Yo you are not a DESIGNER");
		}
		
		System.out.println("Checking if we can use a alias");
		
		person=context.getBean("person1", Person.class);
		System.out.println("Yupiee we used person1->"+person);

	}

}
