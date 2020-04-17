package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Gender;
import be.pxl.ja2.jpa.model.Person;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

public class Opdracht3SavePerson {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			entityManager = entityManagerFactory.createEntityManager();
			Person person = new Person();
			person.setFirstName("Sheldon");
			person.setLastName("Cooper");
			person.setBirthday(LocalDate.of(1980,2,26));
			person.setToken(UUID.randomUUID().toString());
			person.setMarried(true);
			person.setPicture(getImage(Paths.get("src/main/resources/avatar.jpg")));
			person.setGender(Gender.M);
			person.setComment("Sheldon Lee Cooper Ph.D., Sc.D., is a fictional character in the CBS television series The Big Bang Theory and its spin-off series Young Sheldon, portrayed by actors Jim Parsons in The Big Bang Theory and Iain Armitage in Young Sheldon (with Parsons as the latter series' narrator).[7] For his portrayal, Parsons has won four Primetime Emmy Awards, a Golden Globe Award, a TCA Award, and two Critics' Choice Television Awards. The character's childhood is the focus of Young Sheldon: the series' first season is set in 1989 when nine-year-old prodigy Sheldon has skipped ahead five grades, to start high school alongside his older brother.");
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(person);
			tx.commit();
		} catch (IOException e) {
			System.out.println("Error loading image...");
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

	public static byte[] getImage(Path path) throws IOException {
		BufferedImage bufferimage = ImageIO.read(path.toFile());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageIO.write(bufferimage, "jpg", output );
		return output.toByteArray();
	}

}
