package com.appHub.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.appHub.daoImpl.SubjectDAOImpl;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordUtil {

	private final static Logger logger = Logger.getLogger(PasswordUtil.class.getName());

	public static String encodePassword(String passwordToHash) {

		String generatedPassword = null;

	    try 
	    {
	      // Create MessageDigest instance for MD5
	      MessageDigest md = MessageDigest.getInstance("MD5");

	      // Add password bytes to digest
	      md.update(passwordToHash.getBytes());

	      // Get the hash's bytes
	      byte[] bytes = md.digest();

	      // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
	      StringBuilder sb = new StringBuilder();
	      for (int i = 0; i < bytes.length; i++) {
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	      }

	      // Get complete hashed password in hex format
	      generatedPassword = sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	    	logger.log(Level.SEVERE, e.getMessage());
	    }
	    
	    return generatedPassword;
		 
		 
	}
	
	
}
