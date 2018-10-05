package com.netogerbi.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.netogerbi.cursomc.domain.Pedido;

public interface EmailService {
 	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
