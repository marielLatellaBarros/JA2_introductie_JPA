package be.pxl.ja2.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/** Many-to-Many relationship
 * Many magazines are read by many readers
 */
@Entity
public class Magazine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	public Magazine() {
		// JPA only
	}

	public Magazine(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Magazine{" +
				"id=" + id +
				", title='" + title + '\'' +
				'}';
	}
}
