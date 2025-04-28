package nhom_java.skincarebookingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("systemskincarebooking@gmail.com");  // Địa chỉ email gửi đi
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
            System.out.println("Email sent to " + to);
        } catch (Exception e) {
            // Log lỗi chi tiết
            System.out.println("Error while sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}