/**
 * @author hamza
 * This is a service class intended to generate Email address, password & show credentials
 */
package com.greatlearning.itsupportapp.service;

import java.util.Random;

public class CredentialService {
	
	//This method returns the generated email address (as a string)
	public String generateEmailAddress (String firstName, String lastName, String dept)
	{
		return firstName + lastName + "@" + dept + ".greatlearning.com";
		
	}
	
	//This method returns the password (as char array) as per length specified in driver class
	public char[] generatePassword (int passwordLength)
	{
		Random rand = new Random();
		String charCap = "ABCDEFGHIJKLMNOPQRSTUVW";
		String charSmall = "abcdefghijklmnopqrstuvwxyz";
		String charNum = "1234567890";
		String charSymb = "!@#$%^&*?";
		
		String charAll = charCap + charSmall + charNum;
		
		//Using character based generation instead of string to protect privacy
		char[] passwordArray = new char [passwordLength];
		
		//To ensure minimum 1 capital letter, 1 small letter, 1 number, 1 symbol is present
		passwordArray[0] = charCap.charAt(rand.nextInt(charCap.length()));
		passwordArray[1] = charSmall.charAt(rand.nextInt(charSmall.length()));
		passwordArray[2] = charNum.charAt(rand.nextInt(charNum.length()));
		passwordArray[3] = charSymb.charAt(rand.nextInt(charSymb.length()));
		
		//Filling remainder characters(without symbols)
		for (int idx = 4; idx < passwordLength; idx++)
		{
			passwordArray[idx] += charAll.charAt(rand.nextInt(charAll.length()));
		}
		
		//Shuffle the character array to break patterns
		for (int i = 0; i < passwordArray.length; i++) {
			int randomIndexToSwap = rand.nextInt(passwordArray.length);
			char temp = passwordArray[randomIndexToSwap];
			passwordArray[randomIndexToSwap] = passwordArray[i];
			passwordArray[i] = temp;
		}
		return passwordArray;
	}
	
	//This method displays the final output ie Email & password generated
	public void showCredentials(String firstName, String emailID, char[] password)
	{
		System.out.println("Dear " + firstName +", your generated credentials are as follows:");
		System.out.println("Email  ---> " + emailID);
		String strPassword = String.valueOf(password);
		System.out.println("Password  ---> " + strPassword);
		System.out.println("");
	}

}
