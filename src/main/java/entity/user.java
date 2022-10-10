package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class user {

	private String username = "";
	private String fullname = "";
	private String address = "";
	private String phone = "";
	private String category = "";
	private String email = "";
	private String timeCreate;
	private String nameAvatar = "";

	public user() {
	}

	public user(String username, String fullname, String address, String phone, String category, String email
			,String nameAvatar) {
		this.username = username;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		this.category = category;
		this.email = email;
		this.nameAvatar = nameAvatar;
		
//		format date time yyyy-mm-dd hh:mm:ss to stored in DB
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
		this.timeCreate = formatDateTime;
	}

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();

        System.out.println("Before : " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = now.format(formatter);

        System.out.println("After : " + formatDateTime);
	}
	
	public String getNameAvatar() {
		return nameAvatar;
	}

	public void setNameAvatar(String nameAvatar) {
		this.nameAvatar = nameAvatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(String timeCreate) {
		this.timeCreate = timeCreate;
	}

	@Override
	public String toString() {
		return "user [username=" + username + ", fullname=" + fullname + ", address=" + address + ", phone=" + phone
				+ ", category=" + category + ", email=" + email + ", timeCreate=" + timeCreate + "]";
	}

}
