package com.appraisalplatform.appraisalplatform.Service.Impl;

import com.appraisalplatform.appraisalplatform.DTO.EmployeeFormDTO;
import com.appraisalplatform.appraisalplatform.DTO.ManagerFormDTO;
import com.appraisalplatform.appraisalplatform.Model.*;
import com.appraisalplatform.appraisalplatform.Repository.EmployeeRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.Year;
import java.util.List;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Async
    public void sendEmailEmployeeForm(EmployeeFormDTO employeeFormData) {
        Employee employeeData = employeeRepo.getByEmpId(employeeFormData.getEmpId());

        try {
            String toAddress = employeeData.getEmail();
            String fromAddress = "gopinathkaiser@gmail.com";
            String senderName = "Admin";
            String subject = "Appraisal form submitted successfully";

            String mailContent = getString();

            MailSender(toAddress, fromAddress, senderName, subject, mailContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Async
    public void sendEmailManagerForm(ManagerFormDTO managerFormData) {
        Employee employeeData = employeeRepo.getByEmpId(managerFormData.getEmpId());

        try {
            String toAddress = employeeData.getEmail();
            String fromAddress = "gopinathkaiser@gmail.com";
            String senderName = "Admin";
            String subject = "Appraisal form submitted by Manager ";

            String mailContent = getStringForManager();

            MailSender(toAddress, fromAddress, senderName, subject, mailContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void MailSender(String toAddress, String fromAddress, String senderName, String subject, String mailContent) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(mailContent, true);

        javaMailSender.send(message);
    }

    private static String getStringForManager() {

        String mailContent = "<p> Your appraisal form has been evaluated and submitted by Manager</p>";

        mailContent += "<p>Thank you,<br>Admin</p>";
        return mailContent;

    }


    private static String getString() {

        String mailContent = "<p>Your form has been submitted successfully.</p>";
        mailContent += "<p>Kindly edit your form if any changes are needed <a href='https://appraisal.divum.in'>here</a> before " + "31-12-" + Year.now() + ".</p>";

        mailContent += "<p>Thank you,<br>Admin</p>";
        return mailContent;

    }


}
