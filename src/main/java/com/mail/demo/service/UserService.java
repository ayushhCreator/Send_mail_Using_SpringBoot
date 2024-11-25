package com.mail.demo.service;
import com.mail.demo.model.User;
import com.mail.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.mail.demo.model.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void registerUser(User user) throws MessagingException {
        // Save user to the database
        userRepository.save(user);

        // Send confirmation email
        sendConfirmationEmail(user.getEmail(), user.getName());
    }

    private void sendConfirmationEmail(String toEmail, String name) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        Context context = new Context();
        context.setVariable("name", name);

        String emailContent = templateEngine.process("email-confirmation", context);

        helper.setTo(toEmail);
        helper.setSubject("Registration Confirmation");
        helper.setText(emailContent, true);

        mailSender.send(message);
    }
}
