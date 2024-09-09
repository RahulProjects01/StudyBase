package mailapplication.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Mail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mailId;
	
	@Column(nullable = false)
	private int mailFrom;
	
	@Column(nullable = false)
	private int mailTo;
	
	private String mailSubject="Request From User To Conecting...";
	
	
	private String mailDescriptions;
	
	
	
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mail(int mailId, int mailFrom, int mailTo, String mailSubject, String mailDescriptions) {
		super();
		this.mailId = mailId;
		this.mailFrom = mailFrom;
		this.mailTo = mailTo;
		this.mailSubject = mailSubject;
		this.mailDescriptions = mailDescriptions;
	}

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	public int getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(int mailFrom) {
		this.mailFrom = mailFrom;
	}

	public int getMailTo() {
		return mailTo;
	}

	public void setMailTo(int mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMailDescriptions() {
		return mailDescriptions;
	}

	public void setMailDescriptions(String mailDescriptions) {
		this.mailDescriptions = mailDescriptions;
	}
	
	
	
	
	
}
