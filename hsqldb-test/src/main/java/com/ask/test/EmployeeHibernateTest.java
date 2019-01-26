package com.ask.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ask.domain.Employee;

public class EmployeeHibernateTest
{

    private static SessionFactory factory;
    
    static{
        factory=new Configuration().configure().buildSessionFactory();
    }
    
    @SuppressWarnings("unchecked")
	public static void main(String[] args)
    {
        Session session=factory.openSession();
        session.beginTransaction();
        for (int i = 0; i < 6; i++)
        {
            session.save(new Employee("Gaurav-"+i, (int)(Math.random()*10000)));
            
        }
        session.getTransaction().commit();
        session.close();
        session=factory.openSession();
        
        System.out.println("All Employees\nID NAME   SALARY");
        for (Employee emp: (List<Employee>)session.createQuery("from Employee").list())
        {
        System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getSalary());    
        }
        session.close();
        factory.close();
    }
}
