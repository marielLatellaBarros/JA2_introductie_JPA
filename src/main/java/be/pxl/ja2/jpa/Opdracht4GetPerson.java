package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;

public class Opdracht4GetPerson {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Person person = entityManager.find(Person.class, 6l);
			System.out.println(person.getFirstName());
			System.out.println(person.getComment());
			System.out.println(person.getToken());
			displayImage(person.getPicture());
			tx.commit();
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

	private static void displayImage(byte[] image) {
		ImageIcon icon=new ImageIcon(image);
		JFrame frame=new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(200,300);
		JLabel lbl=new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
