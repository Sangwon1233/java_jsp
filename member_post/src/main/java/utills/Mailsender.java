package utills;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import jakarta.mail.Address;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Mailsender {
	private static final String ENCODE = "utf-8";
	
	public static void main(String[] args) {
        Session session = new Mailsender().init();
        String rndText = String.format("%08d", (int)(Math.random() * 100000000));
        System.out.println(rndText);
        send(session, "메일발송테스트", "내용맨" + rndText, "tkddnjs8097@gmail.com", "tkddnjs3351@naver.com", "ghj1150@naver.com");
    }
	public static Address[] converToInternetAddressArrayy(String[] emailAddresses) {
		InternetAddress[] internetAddresses = new InternetAddress[emailAddresses.length];
		
		
		for(int i =0; i<emailAddresses.length;i++) {
			try {
				internetAddresses[i] = new InternetAddress(emailAddresses[i]);
			}catch(AddressException e) {
				System.out.println("Invalid email address: " + emailAddresses[i]);
				e.printStackTrace();
			}
		}
		return internetAddresses;
	}
	public Session init() {
		Properties props = new Properties();
		Properties authProps = new Properties();
		try {
			props.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
			authProps.load(getClass().getClassLoader().getResourceAsStream("mail_auth.properties"));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Session session = Session.getInstance(props, new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(authProps.getProperty("username"),authProps.getProperty("password"));
			}
		});
		return session;
	}
	public static void send(Session session, String title,String content,String... to) {
		Message msg = new MimeMessage(session);
		try {
			InternetAddress address = new InternetAddress("admin@javaman.shop","관리자",ENCODE);
			msg.setFrom(address);
			msg.addRecipients(Message.RecipientType.TO, converToInternetAddressArrayy(to));
			msg.setSubject(title);
			msg.setContent(content,"text/html; charset=" + ENCODE);
			
			Transport.send(msg);
		}catch (UnsupportedEncodingException | MessagingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
	
