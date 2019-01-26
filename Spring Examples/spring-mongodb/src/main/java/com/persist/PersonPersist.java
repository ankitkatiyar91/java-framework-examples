package com.persist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.Person;

@Repository
public class PersonPersist {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void savePerson(Person person){
		mongoTemplate.insert(person);
	}
	
	public void getPersons(){
		List<Person> persons=mongoTemplate.findAll(Person.class);
		System.out.println("%%%%%% All Persons %%%%%%");
		for (Person person : persons) {
			System.out.println(person);
		}
	}
	
	public Person findPersonById(String id){
		return mongoTemplate.findById(id,Person.class);
	}
}
