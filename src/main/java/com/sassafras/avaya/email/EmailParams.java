package com.sassafras.avaya.email;

import java.util.Arrays;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * eamil的部分元信息
 * @author WuChenghao
 *
 */
@Component
@ConfigurationProperties(prefix = "email")
public class EmailParams {
	
	private String username;

	private String[] receivers;
	
	private String subject;
	
	private String text;
  

	public String[] getReceivers() {
		return receivers;
	}

	public void setReceivers(String[] receivers) {
		this.receivers = receivers;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "EmailParams [username=" + username + ", receivers=" + Arrays.toString(receivers) + ", subject="
				+ subject + ", text=" + text + "]";
	}

	
}
