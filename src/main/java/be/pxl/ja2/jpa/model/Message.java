package be.pxl.ja2.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
	@Id
	private long id;
	private String text;


	public Message() {
	}

	public Message(long messageId, String text) {
		this.id = messageId;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", text='" + text + '\'' +
				'}';
	}
}
