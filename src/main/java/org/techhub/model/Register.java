package org.techhub.model;

import java.sql.Blob;

public class Register {
	private int id;
	private String name;
	private String email;
	private String contact;
	private String address;
	private int age;
	private String username;
	private String password;
	
//	private Blob photo;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public Blob getPhoto() {
//		return photo;
//	}
//	public void setPhoto(Blob photo) {
//		this.photo = photo;
//	}
	
	

}
