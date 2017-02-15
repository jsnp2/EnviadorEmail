package br.com.alura.enviadoEmail;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	
	public void enviar(String nome, String EmailDestinatario ){
		
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.sendgrid.net");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("jsnp22", "mudar@123"));
			email.setSSL(true);
			
			
			email.setFrom("projetoprogress@gmail.com");
			email.setSubject("Você foi convidado pelo Listavip");
			email.setMsg("Ola " + nome + ", você acaba de ser convidado pelo listavip");
			email.addTo(EmailDestinatario);
			email.send();
			
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
