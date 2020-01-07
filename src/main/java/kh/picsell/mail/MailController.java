package kh.picsell.mail;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mail")
public class MailController {
//		@Autowired
//	    private EmailSender emailSender;
		@Autowired
		private HttpSession session;

	    @RequestMapping(value="/mail.do", produces="text/html; charset=UTF-8")
		@ResponseBody
    
	 	    public void sendEmailAction(String email, HttpServletRequest request) throws Exception{
	 	        

	 	    	//String nickname = (String)session.getAttribute("loginInfo");
	 	    	String host = "smtp.naver.com";
	 			final String user = "picsell@naver.com"; 
	 			final String password = "Picsell123!";
	 			System.out.println(email);
	 			//���� ���� �ּ�
	 			String to_email = email;

	 			//SMTP ���� ������ �����Ѵ�.
	 			Properties props = new Properties();
	 			props.put("mail.smtp.host", host);
	 			props.put("mail.smtp.port", 465);
	 			props.put("mail.smtp.auth", "true");
	 			props.put("mail.smtp.ssl.enable", "true");

	 			//���� ��ȣ ������
	 			StringBuffer temp =new StringBuffer();
	 			Random rnd = new Random();
	 			for(int i=0;i<10;i++)
	 			{
	 				int rIndex = rnd.nextInt(3);
	 				switch (rIndex) {
	 				case 0:
	 					// a-z
	 					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
	 					break;
	 				case 1:
	 					// A-Z
	 					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
	 					break;
	 				case 2:
	 					// 0-9
	 					temp.append((rnd.nextInt(10)));
	 					break;
	 				}
	 			}
	 			String AuthenticationKey = temp.toString();
	 			//System.out.println(AuthenticationKey);

	 			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	 				protected PasswordAuthentication getPasswordAuthentication() {
	 					return new PasswordAuthentication(user,password);
	 				}
	 			});
	 	
	 			

	 			String title = "PicSell 비밀번호찾기 email인증입니다.";
	 		
	 			try {
	 				MimeMessage msg = new MimeMessage(session);
	 				msg.setFrom(new InternetAddress(user, "비밀번호찾기"));
	 				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));


	 				msg.setSubject(title);

	 				msg.setText("PicSell 비밀번호 email 인증번호는  ["+AuthenticationKey+"]입니다. 이 인증번호로 인증성공시 이 인증번호로 패스워드가 변경됩니다.");
	 				System.out.println(AuthenticationKey);
	 				HttpSession saveKey = request.getSession();
	 				saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
	 				Transport.send(msg);
	 				System.out.println("메일보내기성공");
	 				

	 			}catch (Exception e) {
	 				e.printStackTrace();
	 				System.out.println("실패");
	 			}

	 			//                request.setAttribute("id", memberId);

	 	    }
	    @RequestMapping(value="/signmail.do", produces="text/html; charset=UTF-8")
		@ResponseBody
    
	 	    public void sendsingupEmailAction(String email, HttpServletRequest request) throws Exception{
	 	        

	 	    	//String nickname = (String)session.getAttribute("loginInfo");
	 	    	String host = "smtp.naver.com";
	 			final String user = "picsell@naver.com"; 
	 			final String password = "Picsell123!";
	 			System.out.println(email);
	 			//���� ���� �ּ�
	 			String to_email = email;

	 			//SMTP ���� ������ �����Ѵ�.
	 			Properties props = new Properties();
	 			props.put("mail.smtp.host", host);
	 			props.put("mail.smtp.port", 465);
	 			props.put("mail.smtp.auth", "true");
	 			props.put("mail.smtp.ssl.enable", "true");

	 			//���� ��ȣ ������
	 			StringBuffer temp =new StringBuffer();
	 			Random rnd = new Random();
	 			for(int i=0;i<10;i++)
	 			{
	 				int rIndex = rnd.nextInt(3);
	 				switch (rIndex) {
	 				case 0:
	 					// a-z
	 					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
	 					break;
	 				case 1:
	 					// A-Z
	 					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
	 					break;
	 				case 2:
	 					// 0-9
	 					temp.append((rnd.nextInt(10)));
	 					break;
	 				}
	 			}
	 			String sign = temp.toString();
	 			//System.out.println(AuthenticationKey);

	 			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	 				protected PasswordAuthentication getPasswordAuthentication() {
	 					return new PasswordAuthentication(user,password);
	 				}
	 			});
	 	
	 			

	 			String title = "PicSell 회원가입 email인증입니다.";
	 		
	 			try {
	 				MimeMessage msg = new MimeMessage(session);
	 				msg.setFrom(new InternetAddress(user, "회원가입"));
	 				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));


	 				msg.setSubject(title);

	 				msg.setText("PicSell 회원가입 email 인증번호는  ["+sign+"]입니다. 올바르게 입력해주세요");
	 				System.out.println(sign);
	 				HttpSession saveKey = request.getSession();
	 				saveKey.setAttribute("sign", sign);
	 				Transport.send(msg);
	 				System.out.println("메일보내기성공");
	 				

	 			}catch (Exception e) {
	 				e.printStackTrace();
	 				System.out.println("실패");
	 			}

	 			//                request.setAttribute("id", memberId);

	 	    }
	    @RequestMapping(value="/valuecheck.do", produces="text/html; charset=UTF-8")
	    @ResponseBody
	 	    public String signupmail(String value, HttpServletRequest request) throws Exception{
	    	System.out.println(value);
	    	String goal = (String)session.getAttribute("sign");
	    	System.out.println(goal);
	    	if(value.contentEquals(goal)) {
	    		return"ㅇㅋ";
	    	}else {
	    		return"ㄴㄴ";
	    	}

	    }
	    
	    }

