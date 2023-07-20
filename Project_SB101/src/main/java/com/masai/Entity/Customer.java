package com.masai.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer_credential")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Name",nullable = false)
	private String name;
	@Column(name = "Email",nullable = false)
	private String email;
	@Column(name = "Mobile_No")
	private int MobNo;
	@Column(name = "Password",nullable = false)
	private String PassWord;
	
	public Customer(String name, String email, int mobNo, String passWord) {
		super();
		this.name = name;
		this.email = email;
		MobNo = mobNo;
		PassWord = passWord;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getMobNo() {
		return MobNo;
	}

	public void setMobNo(int mobNo) {
		MobNo = mobNo;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", MobNo=" + MobNo + ", PassWord="
				+ PassWord + "]";
	}
	
	
	
	
	
	
}
