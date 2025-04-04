package com.example.demo.infrastructure.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderComponent {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String to, String subject, String body) throws Exception {

		var message = javaMailSender.createMimeMessage();

		var helper = new MimeMessageHelper(message, true, "UTF-8");

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);

		javaMailSender.send(message);
	}
}
