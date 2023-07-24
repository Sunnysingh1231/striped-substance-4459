package com.masai.Ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import admin.*;
import com.masai.Entity.Customer;
import com.masai.Entity.Csr;
import com.masai.Exception.SomthingWentWrongException;
import com.masai.Service.CustomerService;
import com.masai.Service.CustomerServiceImpl;

public class Main {
	
	public static void coustmerRegistration(Scanner se) {
		
		
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
	
	public static void UpdateDetails(Scanner sg) {
		System.out.println("Enter Customer Email id");
		String Email = sg.next();
		sg.nextLine();
		
		System.out.println("Enter New Name");
		String name = sg.next();
		System.out.println("Enter New Email");
		String email = sg.next();
		System.out.println("Enter New Mobile No.");
		int mobileNo = sg.nextInt();
		System.out.println("Enter New Password");
		String password = sg.next();
		sg.nextLine();
		
		
		CustomerService customerService = new CustomerServiceImpl();
		
		try {
			customerService.UpdateDetails(Email,name,email,mobileNo,password);
			System.out.println("Customer updated successfully");
		} catch (SomthingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		
	}
	//**************************************************************
	public static void findCustomerByEmail(Scanner sg) {
		System.out.println("Enter Customer id");
		String emailString=sg.next();
		sg.nextLine();
	
		CustomerService customerService = new CustomerServiceImpl();
		
		try {
			Customer customer = customerService.getCustomerByEmail(emailString);
			System.out.println(customer);
		} catch (SomthingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		
	}
	
	
	
	//**************************************************************
	
	public static void coustmerLogin(Scanner sd) {
		System.out.println("Enter your Email Id");
		String email = sd.next();
		System.out.println("Enter your Password");
		String password = sd.next();
		sd.nextLine();	
		
		try {
			
			String url="jdbc:mysql://localhost:3306/OnlineShopping";
			String user="root";
			String Password="Sunny@123";
			
			Connection cn1=DriverManager.getConnection(url,user,Password);
						
			
			String query="SELECT * FROM Customer_credential;";
			
			Statement stm=cn1.createStatement();
			
			
			ResultSet rd=stm.executeQuery(query);
			
			String f = "n";
			
			while(rd.next()) {
//				System.out.println(rd.getString(3));
//				System.out.println(rd.getString(4));
				
				if(password.equals(rd.getString(3))&&email.equals(rd.getString(4))) {
					f="y";
				}
			}
			if(f.equals("y")) {
				System.out.println("Login successful");
				int nm=0;
				
				do {
					System.out.println("1. Update Details");
					System.out.println("2. Rais Ticket");
					System.out.println("3. viev status");
					System.out.println("4. Providing a feedback");
					System.out.println("0. LogOut");
					nm=Integer.parseInt(sd.nextLine());
					switch (nm) {
					case 1:
						UpdateDetails(sd);
						break;

					case 2:
						raisTicket();
						break;
					default:
						break;
					}
				} while (nm!=0);

			}else {
				System.out.println("Please check your Email or password");
			}
			
			stm.execute(query);
			cn1.close();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		
	}
	
	
	public static void loginCsr(Scanner sd) {
	
		System.out.println("Enter your Email Id");
		String email = sd.next();
		System.out.println("Enter your Password");
		String password = sd.next();
		sd.nextLine();	
		
		try {
			
			String url="jdbc:mysql://localhost:3306/OnlineShopping";
			String user="root";
			String Password="Sunny@123";
			
			Connection cn1=DriverManager.getConnection(url,user,Password);
						
			
			String query="SELECT * FROM csr;";
			
			Statement stm=cn1.createStatement();
			
			
			ResultSet rd=stm.executeQuery(query);
			
			String f = "n";
			
			while(rd.next()) {
	//			System.out.println(rd.getString(3));
	//			System.out.println(rd.getString(4));
				
				if(password.equals(rd.getString(3))&&email.equals(rd.getString(4))) {
					f="y";
				}
			}
			if(f.equals("y")) {
				System.out.println("Login successful.");
				int nm=0;
				
				do {
					System.out.println("1. View details");
					System.out.println("2. Update Details");
					System.out.println("3. viev tickets");
					System.out.println("4. Providing a feedback");
					System.out.println("0. LogOut");
					nm=Integer.parseInt(sd.nextLine());
					switch (nm) {
					case 1:
						System.out.println("Enter Email");
						String em = sd.next();
						sd.nextLine();
						CustomerDetail cd = new CustomerDetail();
						cd.coustmerLogin(em);
						break;

					case 2:
						System.out.println("Enter Email");
						String ema = sd.next();
						sd.nextLine();
						CustomerDetail ce = new CustomerDetail();
						ce.updateCsr(ema,sd);
						break;
					default:
						System.out.println("Please Enter a valid Number");
						break;
					}
				} while (nm!=0);
	
			}else {
				System.out.println("Please check your Email or password");
			}
			
			stm.execute(query);
			cn1.close();
		} catch (Exception e) {
			e.printStackTrace();	
		}
	
	
}
	
	
	
	
	
	
//**************************************************************
	
	
	public static void raisTicket() {
		System.out.println("ticket rais");
	}
	
	//*********************Admin*****************************************
	
	public static void adminLogin(Scanner sc) throws SomthingWentWrongException {
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		sc.nextLine();
		if(username.equals("admin")&&password.equals("admin")) {
			System.out.println("login successfull");
			
			int inpcus=0;
			
			System.out.println("1. CSR.");
			
			System.out.println("2. Customers.");
			
			do {
				inpcus = Integer.parseInt(sc.nextLine());
				
				switch (inpcus) {
				case 1:
					CustomerDetail getcsr = new CustomerDetail();
					getcsr.Csr(sc);
					break;
				case 2:
					
					CustomerDetail getcust = new CustomerDetail();
					getcust.Customers(sc);
					break;
					
				default:
					break;
				}
				
				
				
			} while (inpcus!=0);
			
			
		}
	}
	
	//********************CsrLogin******************************************
	
	public static void CsrLogin(Scanner sd) {
		System.out.println("Enter your Email Id");
		String email = sd.next();
		System.out.println("Enter your Password");
		String password = sd.next();
		sd.nextLine();	
		
		try {
			
			String url="jdbc:mysql://localhost:3306/OnlineShopping";
			String user="root";
			String Password="Sunny@123";
			
			Connection cn1=DriverManager.getConnection(url,user,Password);
						
			
			String query="SELECT * FROM Csr;";
			
			Statement stm=cn1.createStatement();
			
			
			ResultSet rd=stm.executeQuery(query);
			
			String f = "n";
			
			while(rd.next()) {
//				System.out.println(rd.getString(3));
//				System.out.println(rd.getString(4));
				
				if(password.equals(rd.getString(3))&&email.equals(rd.getString(4))) {
					f="y";
				}
			}
			if(f.equals("y")) {
				System.out.println("Login successful");
				int nm=0;
				
				do {
					System.out.println("1. Update Details");
					System.out.println("2. Rais Ticket");
					System.out.println("3. viev status");
					System.out.println("4. Providing a feedback");
					System.out.println("0. LogOut");
					nm=Integer.parseInt(sd.nextLine());
					switch (nm) {
					case 1:
						UpdateDetails(sd);
						break;

					case 2:
						raisTicket();
						break;
					default:
						break;
					}
				} while (nm!=0);

			}else {
				System.out.println("Please check your Email or password");
			}
			
			stm.execute(query);
			cn1.close();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		
	}
	
	//**************************************************************
	
	public static void CsrRegistration(Scanner se) {
		
		
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
			Csr addCustomer = new Csr(name,email,mobileNo,password);
			customerService.CsrLogin(addCustomer);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println("Registration successful");
	}
	
	
	//**************************************************************
	
	
	
	public static void main(String[] args) throws SomthingWentWrongException {
		Scanner sc =new Scanner(System.in);
		int n=0;
		do {
			System.out.println("Welcome in CustomerDetail Support Services.");
			System.out.println("1. Admin");
			System.out.println("2. CustomerDetail Support Presentative");
			System.out.println("3. CustomerDetail");
			System.out.println("4. Find customer by email");
			System.out.println("0. Exit");
			n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				adminLogin(sc);
				break;
			case 2:
				CsrSide(sc);
				break;
			case 3:
				CustomerSide(sc);
				break;
				
			case 4:
				findCustomerByEmail(sc);
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
	
	public static void CustomerSide(Scanner sf) {
		int nn=0;

		
		System.out.println("1. Login");
		System.out.println("2. Sign Up (No Account)");
		int inp = Integer.parseInt(sf.nextLine());
//		System.out.println("0. Exit");
		switch (inp) {
		case 1:
			coustmerLogin(sf);
			break;
		case 2:
			coustmerRegistration(sf);
			break;

		default:
			System.out.println("Please Enter a valid Number.");
			break;
		}
	}
		
		
	//**************************************************************
	public static void CsrSide(Scanner sg) {
		int nn=0;

		
		System.out.println("1. Login");
		System.out.println("2. Sign Up (No Account)");
		int inp = Integer.parseInt(sg.nextLine());
//		System.out.println("0. Exit");
		switch (inp) {
		case 1:
			loginCsr(sg);
			break;
		case 2:
			CsrRegistration(sg);
			break;
		default:
			System.out.println("Please Enter a valid Number.");
			break;
		}
	}
	
}
