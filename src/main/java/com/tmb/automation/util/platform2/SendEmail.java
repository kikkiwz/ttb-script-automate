package com.tmb.automation.util.platform2;

import com.sun.mail.smtp.SMTPTransport;
import com.tmb.automation.helper.Setting;
import scala.App;


import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class SendEmail  {
    public String get = "";
    String EMAIL_TO = "to";
    String EMAIL_TO_CC = "";
    String EMAIL_SUBJECT = "";
    String EMAIL_TEXT = "";
    String FILE_PATH = "";
    Boolean isSuccess = false;


    public void SendEmail(String to, String cc, String subject, String detail,String filePath) throws IOException {
        this.EMAIL_TO = to;
        this.EMAIL_TO_CC = cc;
        this.EMAIL_SUBJECT = subject;
        this.EMAIL_TEXT = detail;
        this.FILE_PATH = filePath;

        Properties prop = System.getProperties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.host", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");


        Session session = Session.getInstance(prop, null);
        MimeMessage msg = new MimeMessage(session);
        prop.load(App.class.getClassLoader().getResourceAsStream("Platform2ConfigEmail.properties"));
        Setting.EmailConfig.USER_NAME = prop.getProperty("username");
        Setting.EmailConfig.PASSWORD = prop.getProperty("password");
        Setting.EmailConfig.SMTP_SERVER = prop.getProperty("smtp_server");
        Setting.EmailConfig.EMAIL_FROM = prop.getProperty("email_from");
        try {

            msg.setFrom(new InternetAddress(Setting.EmailConfig.EMAIL_FROM));
            msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(EMAIL_TO, false));
            msg.setRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(EMAIL_TO_CC, false));
            msg.setSubject(EMAIL_SUBJECT);

            // text
            MimeBodyPart p1 = new MimeBodyPart();

            p1.setContent(EMAIL_TEXT, "text/html; charset=UTF-8");
//            p1.setText(EMAIL_TEXT);


            // file
            MimeBodyPart p2 = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(System.getProperty("user.dir") +FILE_PATH);
            p2.setDataHandler(new DataHandler(fds));
            p2.setFileName(fds.getName());

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(p1);
            mp.addBodyPart(p2);

            msg.setContent(mp);

            //msg.setDataHandler(new DataHandler(fds));
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

            // connect
            t.connect(Setting.EmailConfig.SMTP_SERVER, Setting.EmailConfig.USER_NAME, Setting.EmailConfig.PASSWORD);

            // send
            t.sendMessage(msg, msg.getAllRecipients());

            //System.out.println("Response: " + t.getLastServerResponse());
            isSuccess = (t.getLastReturnCode() == 250);
            System.err.println("----------------------> "+t.getLastReturnCode());
            t.close();
            //notify();
        } catch (MessagingException e) {
            isSuccess = false;
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }


}
