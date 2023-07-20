package com.masai.Ui;

import java.util.Scanner;

import com.masai.Entity.Customer;
import com.masai.Service.CustomerService;
import com.masai.Service.CustomerServiceImpl;

public class Main {
	
	public static void coustmerRegistration(Scanner sd) {
		System.out.println("Enter your Email Id");
		String email = sd.next();
		System.out.println("Enter your Password");
		String password = sd.next();
	}
	
	//**************************************************************
	
	public static void coustmerLogin(Scanner se) {
		System.out.println("Enter your Name");
		String name = se.next();
		System.out.println("Enter your Email");
		String email = se.next();
		System.out.println("Enter your Mobile No.");
		int mobileNo = se.nextInt();
		System.out.println("Enter your Password");
		String password = se.next();
		se.nextLine();
		
		CustomerService customerService = new CustomerServiceImpl();
		
		try {
			Customer addCustomer = new Customer(name,email,mobileNo,password);
			customerService.coustmerLogin(addCustomer);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println("Registration successful");
	}
	
	//**************************************************************

	
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=0;
		do {
			System.out.println("Welcome in Customer Support Services.");
			System.out.println("1. Admin");
			System.out.println("2. Customer Support Presentative");
			System.out.println("3. Customer");
			System.out.println("0. Exit");
			n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				System.out.println("1. Admin");
				break;
			case 2:
				System.out.println("1. Admin");
				break;
			case 3:
				CustomerSide(sc);
				break;
			case 0:
				System.out.println("Exiting the application. Goodbye!");
				break;

			default:
				System.out.println("Please Enter a valid Number.");
				break;
			}
			
			
			
		} while (n!=0);
		
		
	}
	//**************************************************************
	
	public static void CustomerSide(Scanner sc) {
		
		
			System.out.println("1. Login (Alredy have an Account)");
			System.out.println("2. Resistration (New Customer)");
			int inp = Integer.parseInt(sc.nextLine());
//			System.out.println("0. Exit");
			switch (inp) {
			case 1:
				coustmerRegistration(sc);
				break;
			case 2:
				coustmerLogin(sc);
				break;

			default:
				System.out.println("Please Enter a valid Number.");
				break;
			}
			
	}
	//**************************************************************
}
