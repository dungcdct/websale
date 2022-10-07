package handleInforUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.log.addressException;
import exception.log.emailException;
import exception.log.fullnameException;
import exception.log.passwordException;
import exception.log.phoneException;
import exception.log.usernameException;

public class log {

//	check full name 
	public static boolean fullname(String fullname) throws fullnameException {
		boolean result = false;
		if (fullname == null) {
			return result;
		}
		if (fullname.length() < 9 || fullname.length() > 130) {
			return result;
		}

		CharSequence inputStr = fullname;
		Pattern pattern = Pattern.compile(new String("^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$"));
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new fullnameException("fullname not suitable");
		}

		return result;
	}

//	check username
	public static boolean username(String username) throws usernameException {
		boolean result = false;
		if(username == null || username.length() < 6 || username.length() > 100) {
			return result;
		}
		if (username != null) {

			CharSequence inputStr = username;
			Pattern pattern = Pattern.compile(new String("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"));
			Matcher matcher = pattern.matcher(inputStr);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new usernameException("username not suitable");
			}
		}
		return result;
	}
	
//	check password
	public static boolean password(String password) throws passwordException {
		boolean result = false;
		if (password != null) {

			CharSequence inputStr = password;
			Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
			Matcher matcher = pattern.matcher(inputStr);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new passwordException("password not suitable");
			}
		}
		return result;
	}
	
//	check email
	public static boolean email(String email) throws emailException {
		boolean result = false;
		if (email != null) {
			
			CharSequence inputStr = email;
			Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(inputStr);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new emailException("password not suitable");
			}
		}
		return result;
	}
	
//	check phone
	public static boolean phone(String phone) throws phoneException {
		boolean result = false;
		if (phone != null) {
			
			CharSequence inputStr = phone;
			Pattern pattern = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
			Matcher matcher = pattern.matcher(inputStr);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new phoneException("phone not suitable");
			}
		}
		return result;
	}
	
//	check address
	public static boolean address(String address) throws addressException {
		boolean result = false;
		if (address != null) {
			result = true;
			
		}
		else {
			throw new addressException("address not suitable");
		}
		return result;
	}

}
