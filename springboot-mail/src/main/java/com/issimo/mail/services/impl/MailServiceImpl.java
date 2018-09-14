package com.issimo.mail.services.impl;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.issimo.mail.services.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	@Value("${spring.mail.username}")
	private String FROM_USER;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendTextMail(String touser, String subject, String content) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(FROM_USER);
		message.setTo(touser);
		message.setSubject(subject);
		message.setText(content);
		mailSender.send(message);

	}

	@Override
	public void sendHtmlMail(String toUser, String subject, String content) throws MessagingException {
		 MimeMessage mimeMessage = mailSender.createMimeMessage();

	        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(FROM_USER);
	        mimeMessageHelper.setTo(toUser);
	        mimeMessageHelper.setSubject(subject);
	        mimeMessageHelper.setText(content, true);

	        mailSender.send(mimeMessage);
		
	}

	 @Override
	    public void sendAttachmentMail(String toUser, String subject, String content, String filePath) throws MessagingException {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();

	        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(FROM_USER);
	        mimeMessageHelper.setTo(toUser);
	        mimeMessageHelper.setSubject(subject);
	        mimeMessageHelper.setText(content, true);

	        FileSystemResource file = new FileSystemResource(new File(filePath));
	        String fileName = file.getFilename();
	        mimeMessageHelper.addAttachment(fileName, file);

	        mailSender.send(mimeMessage);
	    }

	    @Override
	    public void sendImgMail(String toUser, String subject, String content, String imgId, String imgPath) throws MessagingException {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();

	        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(FROM_USER);
	        mimeMessageHelper.setTo(toUser);
	        mimeMessageHelper.setSubject(subject);
	        mimeMessageHelper.setText(content, true);

	        FileSystemResource img = new FileSystemResource(new File(imgPath));
	        mimeMessageHelper.addInline(imgId, img);

	        mailSender.send(mimeMessage);
	    }

	    @Override
	    public void sendTemplateMail(String toUser, String subject, String content) throws MessagingException {
	        this.sendHtmlMail(toUser, subject, content);
	}

}
