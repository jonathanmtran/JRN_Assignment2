package cart;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dead
 */
public class EmailGmail {
    
    String from,pass,subject;
    
    public EmailGmail()
    { }
    
    public void sendIt(String to,String body)
    {
        from = "navatran424@gmail.com";
        pass = "navatranpassword";
        subject = "Thank you for your purchase !";
        try
        {
                sendMail(to, from, pass, subject, body, false);
        }
        catch(MessagingException e)
        {}
    }
	
    private void sendMail(String to, String from, String password, String subject, String body, boolean bodyIsHTML) throws MessagingException
    {
        // 1 - get a mail session
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);	// show more information or not in the output

        // 2 - create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML)
            message.setContent(body, "text/html");
        else
            message.setText(body);

        // 3 - address the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // 4 - send the message
        Transport transport = session.getTransport();
        transport.connect(from, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close(); 
	}
    
    public boolean isValidEmail(String email) throws AddressException
    {
        boolean isValid = false;
    
        try
        {
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			isValid = true;
        } 
        catch (AddressException e) 
        {
			e.printStackTrace();
        }
		
		return isValid;
    }
}

