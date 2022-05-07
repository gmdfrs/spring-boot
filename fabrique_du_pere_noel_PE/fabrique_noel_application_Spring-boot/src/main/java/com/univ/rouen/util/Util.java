package com.univ.rouen.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Util pour le format de mot de passe et email
 * @author GROUPE JEE
 */
public class Util {
	public static boolean isEmailValid(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex);


		Matcher matcher = pattern.matcher(email);
		return matcher.matches();

	}
	
	public static boolean isPasswordValid(String password) {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		
		return password.matches(pattern);
	}
}
