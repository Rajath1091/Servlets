package servlets_hibernate_student_prc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servlets_hibernate_student_prc.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}

//	public void updateStudent(int id, Student student) {
//		EntityManager entityManager = getEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		Student receivedStudent = entityManager.find(Student.class, id);
//		if (receivedStudent != null) {
//			student.setId(id);
//
//			entityTransaction.begin();
//			entityManager.merge(student);
//			entityTransaction.commit();
//		}
//	}

	public Student getStudent(int id) {
		EntityManager entityManager = getEntityManager();
		String jpql = "SELECT s FROM Student s WHERE s.id=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, id);
		Student student = (Student) query.getSingleResult();
		return student;
	}

}
