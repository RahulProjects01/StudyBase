package mailapplication.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import mailapplication.model.Mail;
import mailapplication.model.User;
import mailapplication.repository.UserRepository;
import mailapplication.service.GmailSender;

 
@Controller
@RequestMapping("/sender")
@CrossOrigin(origins = "http://localhost:3000")
public class MailController {

    @Autowired
    private GmailSender sender;
    @Autowired
    private UserRepository userRepository;

   
    @PostMapping("/EmailProcessing")
    public ResponseEntity<String> processEmail(@RequestBody Mail ml) {
        try {
            // Fetch users based on email IDs
            User u = userRepository.findById(ml.getMailTo())
                                   .orElseThrow(() -> new IllegalArgumentException("User with email " + ml.getMailTo() + " not found"));
            User u1 = userRepository.findById(ml.getMailFrom())
                                    .orElseThrow(() -> new IllegalArgumentException("User with email " + ml.getMailFrom() + " not found"));

            // Send email
            boolean sent = sender.sendMail(u.getEmailAddress(), u1.getEmailAddress(), ml.getMailSubject(), ml.getMailDescriptions(),ml);

            if (sent) {
                return ResponseEntity.ok("Mail sent successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Mail could not be sent.");
            }
        } catch (IllegalArgumentException e) {
          
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while sending the mail.");
        }
    }


}
