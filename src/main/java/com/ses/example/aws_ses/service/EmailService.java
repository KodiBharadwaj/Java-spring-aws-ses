package com.ses.example.aws_ses.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmailService {

    @Autowired
    private AmazonSimpleEmailService amazonSimpleEmailService;

    public void sendEmail(SimpleMailMessage simpleMailMessage){
        Destination destination =  new Destination();
        destination.setToAddresses(Arrays.asList(simpleMailMessage.getTo()));

        Content content = new Content();
        content.setData(simpleMailMessage.getText());

        Content subject = new Content();
        subject.setData(simpleMailMessage.getSubject());

        Body body = new Body();
        body.setText(content);

        Message msg = new Message();
        msg.setBody(body);
        msg.setSubject(subject);

        SendEmailRequest emailRequest = new SendEmailRequest();
        emailRequest.setSource(simpleMailMessage.getFrom());
        emailRequest.setDestination(destination);
        emailRequest.setMessage(msg);

        amazonSimpleEmailService.sendEmail(emailRequest);
    }
}
