package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.masai.Entity.Csr;
import com.masai.Entity.Customer;
import com.masai.Exception.SomthingWentWrongException;
import com.masai.Utility.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;

public class CustomerDetail {
	
	
	public static void Customers(Scanner sf) throws SomthingWentWrongException {
		int num = 0;
		do {
			System.out.println("1. View All Customers");
			System.out.println("2. Delete Customer");
			System.out.println("3. Resolve Tickets");
			System.out.println("4. Customer Review");
			num = Integer.parseInt(sf.nextLine());
			
			switch (num) {
			case 1:
				getallCustomer();
				break;
				
			case 2:
				System.out.println("Enter Customer Id");
				Integer n = Integer.parseInt(sf.nextLine());
				DeleteCustomer(n);
				break;

			default:
				break;
			}
		} while (num!=0);
		
	}
	
	public static void getallCustomer() {
		try {
			
			String url="jdbc:mysql://localhost:3306/OnlineShopping";
			String user="root";
			String Password="Sunny@123";
			
			Connection cn1=DriverManager.getConnection(url,user,Password);
						
			
			String query="SELECT * FROM Customer_credential;";
			
			Statement stm=cn1.createStatement();
			
			ResultSet rd=stm.executeQuery(query);
			while(rd.next()) {
				System.out.println("id = "+rd.getInt(1)+", "+"name = "+rd.getString(5)+", "+"Email = "+rd.getString(4)+", "+"Mobile No = "+rd.getInt(2)+", "+"Password = "+rd.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	

	
	public static void DeleteCustomer(int id) throws SomthingWentWrongException {
	    EntityManager em = null;
	    EntityTransaction et = null;

	    try {
	        em = Util.getEntityManager();
	        et = em.getTransaction();

	        et.begin();

	        Customer customer = em.find(Customer.class, id);
	        
	        if (customer != null) {
	            em.remove(customer); 
	        } else {
	            throw new SomthingWentWrongException("Customer not found with id: " + id);
	        }

	        et.commit();
	        
	        System.out.println("Customer deleted successfully");
	        
	    } catch (PersistenceException e) {
	        if (et != null && et.isActive()) {
	            et.rollback();
	        }
	        throw new SomthingWentWrongException("Unable to delete Customer, try again later");
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}
	
	
	
	
	public static void coustmerLogin(String email) {
		
		try {
			
			String url="jdbc:mysql://localhost:3306/OnlineShopping";
			String user="root";
			String Password="Sunny@123";
			
			Connection cn1=DriverManager.getConnection(url,user,Password);
						
			
			String query="SELECT * FROM Csr WHERE Email = '"+email+"';";
			
			Statement stm=cn1.createStatement();
			
			
			ResultSet rd=stm.executeQuery(query);
			
			
			while(rd.next()) {
				System.out.println("Id = "+rd.getInt(1)+", mobile No = "+rd.getInt(2)+", Password = "+rd.getString(3)+", Email = "+rd.getString(4)+", Name = "+rd.getString(5));
				
			}
			stm.execute(query);
			cn1.close();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		
	}
	
	public static void main(String[] args) throws SomthingWentWrongException {
		ViewAllCsrs();
		
		
	}
	
	
	public static void updateCsr(String email,Scanner sg) throws SomthingWentWrongException {
		
		System.out.println("Enter New Name");
		String name = sg.next();
		System.out.println("Enter New Email");
		String ema = sg.next();
		System.out.println("Enter New Mobile No.");
		int mobileNo = sg.nextInt();
		System.out.println("Enter New Password");
		String password = sg.next();
		sg.nextLine();
		
	    EntityManager em = null;
	    EntityTransaction et = null;

	    try {
	        em = Util.getEntityManager();
	        et = em.getTransaction();

	        et.begin();
	        Csr customer = em.createQuery("SELECT c FROM Csr c WHERE c.email = :email", Csr.class).setParameter("email", email).getSingleResult();

	        customer.setName(name);
	        customer.setEmail(ema);
	        customer.setPassWord(password);
	        customer.setMobNo(mobileNo);

	        et.commit();
	        
	        System.out.println("Csr Details update successfully");
	    } catch (NoResultException e) {
	        throw new SomthingWentWrongException("Customer not found with email: " + email);
	    } catch (PersistenceException e) {
	        if (et != null && et.isActive()) {
	            et.rollback();
	        }
	        throw new SomthingWentWrongException("Unable to update Customer details, try again later");
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}
	
	
	public static void Csr(Scanner sf) throws SomthingWentWrongException {
		int num = 0;
		do {
			System.out.println("1. View All Csrs");
			System.out.println("2. Delete Csr");
			System.out.println("3. View All Resolve Tickets");			
			num = Integer.parseInt(sf.nextLine());
			
			switch (num) {
			case 1:
				ViewAllCsrs();
				break;
				
			case 2:
				System.out.println("Enter Csr Id");
				Integer n = Integer.parseInt(sf.nextLine());
				DeleteCsr(n);
				break;

			default:
				break;
			}
		} while (num!=0);
		
	}
	
	public static void ViewAllCsrs() {
		
		try {
			
			String url="jdbc:mysql://localhost:3306/OnlineShopping";
			String user="root";
			String Password="Sunny@123";
			
			Connection cn1=DriverManager.getConnection(url,user,Password);
						
			
			String query="SELECT * FROM Csr;";
			
			Statement stm=cn1.createStatement();
			
			
			ResultSet rd=stm.executeQuery(query);
			
			
			while(rd.next()) {
				System.out.println("Id = "+rd.getInt(1)+", Name = "+rd.getString(5)+", Email = "+rd.getString(4)+", Password = "+rd.getString(3)+", mobile No = "+rd.getInt(2));
				
			}
			stm.execute(query);
			cn1.close();
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	

	public static void DeleteCsr(int id) throws SomthingWentWrongException {
	    EntityManager em = null;
	    EntityTransaction et = null;

	    try {
	        em = Util.getEntityManager();
	        et = em.getTransaction();

	        et.begin();

	        Csr customer = em.find(Csr.class, id);
	        
	        if (customer != null) {
	            em.remove(customer); 
	        } else {
	            throw new SomthingWentWrongException("Csr not found with id: " + id);
	        }

	        et.commit();
	        
	        System.out.println("Csr deleted successfully");
	        
	    } catch (PersistenceException e) {
	        if (et != null && et.isActive()) {
	            et.rollback();
	        }
	        throw new SomthingWentWrongException("Unable to delete Csr, try again later");
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}
	
	
}
