package servlets_hibernate_eb9_task_prc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servlets_hibernate_eb9_task_prc.dto.Employee;

public class EmployeeDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveEmployee(Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	public void updateEmployee(int id,Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employee receivedEmployee=entityManager.find(Employee.class, id);
		if(receivedEmployee!=null) {
			employee.setId(id);
			
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Employee doesn't exists");
		}
	}
	
	public Employee getEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		String jpql="SELECT e FROM Employee e WHERE e.id=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, id);
		Employee employee=(Employee)query.getSingleResult();
		return employee;
	}

}
