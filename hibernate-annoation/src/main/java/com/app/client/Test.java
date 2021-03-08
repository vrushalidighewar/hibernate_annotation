package com.app.client;

import org.hibernate.Session;

import com.app.entity.Employee;
import com.app.utility.HibernateUtility;

public class Test {

		public void save() {
			Session session=HibernateUtility.getSession().openSession();
			
			Employee employee=new Employee();
			employee.setName("Motu");
			employee.setSalary(40000f);
			
			session.save(employee);
			session.beginTransaction().commit();
			
			System.out.println("success");
		}
		
		public void update() {
			Session session=HibernateUtility.getSession().openSession();
			
			Employee employee=(Employee) session.get(Employee.class,4);
			employee.setName("Molshree");
			employee.setSalary(65000f);
			session.update(employee);
			session.beginTransaction().commit();
		}
	
		@SuppressWarnings("unchecked")
		public void  selectAll() {
		 HibernateUtility.getSession().openSession().createCriteria(Employee.class).list().forEach(System.out::println);
		}
		
		public void findAllEmployee() {
			Session session=HibernateUtility.getSession().openSession();
			session.getNamedQuery("findAll").list().forEach(System.out::println);
			System.out.println("___________________________________________");
			session.getNamedQuery("findByName").setParameter("ename", "chotu").list().forEach(System.out::println);
            session.close();
		}
		
		public static void main(String[] args) {
			
			Test t=new Test();
			t.save();
			t.update();
			t.selectAll();
			//t.findAllEmployee();
	}

}
