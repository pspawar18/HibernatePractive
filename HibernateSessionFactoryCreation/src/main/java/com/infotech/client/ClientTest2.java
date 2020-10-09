package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest2 {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Employee employee = getEmployee();
			session.beginTransaction();
			//session.persist(employee);  //persist method is a void method it will not return primary key
			 Integer id  = (Integer)session.save(employee);  //save method methods return type is Serializable and it returns primary key
			 System.out.println("Employee is Created with: "+id);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Employee getEmployee() {

		Employee employee = new Employee();
		employee.setEmployeeName("Pramod Pawar");
		employee.setEmail("pramod@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;

	}

}
