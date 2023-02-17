package servlets_hibernate_eb9_prc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servlets_hibernate_eb9_prc.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(String email, Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person receivedPerson = entityManager.find(Person.class, email);
		if (receivedPerson != null) {
			person.setEmail(email);

			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
		} else {
			System.out.println("Person doesn't exists");
		}
	}

	public String getPassword(String email) {
		EntityManager entityManager = getEntityManager();
		String jpql = "SELECT p FROM Person p WHERE p.email=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		Person person = (Person) query.getSingleResult();
		return person.getPassword();
	}

}
