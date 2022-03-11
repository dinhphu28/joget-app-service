package com.ndp.campaignmanagement.utils.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendMailUtil {
    @Autowired
    private JavaMailSender emailSender;

    public Boolean sendHtmlEmail(String htmlMsgContent, String[] receiver) throws MessagingException {
        // Boolean success = false;

        MimeMessage message = emailSender.createMimeMessage();

        Boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<h3>Email from Joget - Campaign Management System</h3>" +
            "<img src='https://2sao.vietnamnetjsc.vn/images/2020/07/06/17/45/IU.jpg' alt='My Idol IU' />";

        if(htmlMsgContent != null) {
            htmlMsg = htmlMsgContent;
        }

        message.setContent(htmlMsg, "text/html");

        // helper.setTo(receiver);
        helper.setTo(receiver);

        helper.setSubject("Joget - Marketing Email");

        emailSender.send(message);

       return true;
    }
}
