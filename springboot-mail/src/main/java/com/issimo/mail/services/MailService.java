package com.issimo.mail.services;

import javax.mail.MessagingException;

public interface MailService {
	void sendTextMail(String touser,String subject,String content);
	
	void sendHtmlMail(String toUser, String subject, String content) throws MessagingException;

    void sendAttachmentMail(String toUser, String subject, String content, String filePath) throws MessagingException;

    void sendImgMail(String toUser, String subject, String content, String imgId, String imgPath) throws MessagingException;

    void sendTemplateMail(String toUser, String subject, String content) throws MessagingException;
}
