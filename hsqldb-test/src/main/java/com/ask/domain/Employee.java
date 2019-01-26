package com.ask.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer salary;

    public Employee()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employee(Integer id, String name, Integer salary)
    {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, Integer salary)
    {
        super();
        this.name = name;
        this.salary = salary;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getSalary()
    {
        return salary;
    }

    public void setSalary(Integer salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }

}
