package be.pxl.ja2.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/** Many-to-Many relationship
 * Many readers read many magazines
 */
@Entity
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String subscriberNumber;
	private String name;

	@ManyToMany
	private Set<Magazine> magazines = new HashSet<>();

	public Reader() {
		// JPA only
	}

	public Reader(String subscriberNumber, String name) {
		this.subscriberNumber = subscriberNumber;
		this.name = name;
	}

	public Reader(String name) {
		this.name = name;
	}

	public void addMagazine(Magazine magazine) {
		magazines.add(magazine);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(name).append(" READS ").append("\n");
		magazines.stream().forEach(m -> result.append(m).append("\n"));
		return result.toString();
	}
}
