package mailapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mailapplication.model.Mail;
import mailapplication.model.User;

public interface MailRepository extends JpaRepository<Mail, Integer>{

}
