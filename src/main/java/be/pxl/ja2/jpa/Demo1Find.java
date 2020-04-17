package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/** Demo1:
 *  Use entityManager to get contact based on id
 *  Close connections
 */
public class Demo1Find {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			entityManager = entityManagerFactory.createEntityManager();

			Contact contact = entityManager.find(Contact.class, 1);
			System.out.println(contact);
		}
		finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
		}
	}

}
