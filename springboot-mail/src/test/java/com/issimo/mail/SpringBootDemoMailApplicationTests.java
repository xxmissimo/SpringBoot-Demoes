package com.issimo.mail;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.issimo.mail.services.impl.MailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoMailApplicationTests {

	@Autowired
	MailServiceImpl MailService;
	
	@Resource
	TemplateEngine templateEngine;
	
	@Test
	public void SimpleMailTest(){
		MailService.sendTextMail("763019432@qq.com", "Springboot1","简单的文本邮件内容1");
	}
	@Test
	public void HtmlMailTest() throws MessagingException{
		//MailService.sendHtmlMail(toUser, subject, content);
		Context context=new Context();
		context.setVariable("text","Jmail demos" );
		String content=templateEngine.process("mail_template", context);
		MailService.sendTemplateMail("763019432@qq.com", "Springboot1", content);
	}
}
