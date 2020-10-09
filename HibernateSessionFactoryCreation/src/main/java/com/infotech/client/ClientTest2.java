package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest2 {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			//Employee employee = getEmployee();
			session.beginTransaction();
			session.persist(getEmployee1());  //persist method is a void method it will not return primary key
			 Integer id  = (Integer)session.save(getEmployee2());  //save method methods return type is Serializable and it returns primary key
			 System.out.println("Employee is Created with: "+id);
			 
			 session.saveOrUpdate(getEmployee3());
			 
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Employee getEmployee1() {

		Employee employee = new Employee();
		employee.setEmployeeName("abc");
		employee.setEmail("abc@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}
	
	private static Employee getEmployee2() {

		Employee employee = new Employee();
		employee.setEmployeeName("pqr");
		employee.setEmail("pqr@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}
	
	private static Employee getEmployee3() {

		Employee employee = new Employee();
		employee.setEmployeeName("xyz");
		employee.setEmail("xyz@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}

}
