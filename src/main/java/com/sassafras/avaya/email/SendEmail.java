package com.sassafras.avaya.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 设置eamil内容与元信息，并发送
 * @author WuChenghao
 *
 */
@Component
public class SendEmail {

	private final static Logger logger =  Logger.getLogger(SendEmail.class);

	@Autowired
	private EmailParams ep;

	@Autowired
	private PackagingAttchment pa;

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleMail() {
		MimeMessage message = null;
		try {
			logger.info("send begin");

			message = mailSender.createMimeMessage();

			MimeMessageHelper helper =new MimeMessageHelper(message,true);

			helper.setFrom(ep.getUsername());

			helper.setTo(ep.getReceivers());

			helper.setSubject(ep.getSubject());

			helper.setText(ep.getText(),true);

			helper.addAttachment(pa.getAttchmentName(),new File(pa.getAttchmentName()));

		} catch (MessagingException e) {
			logger.info(e);
		}
		mailSender.send(message);

		logger.info("send over");
	}

}
