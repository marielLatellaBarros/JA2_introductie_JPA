package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/** Demo4:
 * Use EntityManager to find a message by Id, within a transaction, and remove it => commit!
 * Use a second EntityManager to check what happened in the database with the transactions executed
 */
public class Demo4EntityManager {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("musicdb_pu");
	private static final long MESSAGE_ID = 100L;

	public static void print(int pos, Message memMessage) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		Message dbMessage = entityManager.find(Message.class, memMessage.getId());
		entityManager.close();
		System.out.println(pos + ":" + memMessage.getText() + "\t" + ((dbMessage != null) ? dbMessage.getText() : "not available"));
	}

	public static void main(String[] args) {
		EntityManager entityManager = null;
		try {
			entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

			// remove existing message with id 100
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Message message = entityManager.find(Message.class, MESSAGE_ID);
			if (message != null) {
				entityManager.remove(message);
			}
			tx.commit();

			tx.begin();
			message = new Message(MESSAGE_ID, "AAA");
			print(1, message);
			entityManager.persist(message);
			tx.commit();
			print(2, message);
			message.setText("BBB");
			tx.begin();
			entityManager.refresh(message);
			print(3, message);
			entityManager.detach(message);
			message.setText("CCC");
			print(4, message);
			tx.commit();
			print(5, message);
			tx.begin();
			message = entityManager.merge(message);
			print(6, message);
			tx.commit();
			print(7, message);
			entityManager.clear();
			message.setText("DDD");
			print(8, message);
			tx.begin();
			tx.commit();
			print(9, message);
			message = entityManager.find(Message.class, MESSAGE_ID);
			print(10, message);
			message.setText("EEE");
			print(11, message);
			tx.begin();
			tx.commit();
			tx.begin();
			message.setText("FFF");
			entityManager.flush();
			message.setText("GGG");
			print(12, message);
			entityManager.refresh(message);
			print(13, message);
			tx.rollback();
			print(14, message);
			tx.begin();
			message.setText("HHH");
			print(15, message);
			tx.commit();
			print(16, message);
			tx.begin();
			message = entityManager.merge(message);
			print(17, message);
			tx.commit();
			print(18, message);
			entityManager.close();
		}
		finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (ENTITY_MANAGER_FACTORY != null) {
				ENTITY_MANAGER_FACTORY.close();
			}
		}
	}

}
