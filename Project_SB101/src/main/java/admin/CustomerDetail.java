package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDetail {

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
//				System.out.print("| id = "+rd.getInt(1)+", ");
//				System.out.print("model_no = "+rd.getString(2)+", ");
//				System.out.print("company_name = "+rd.getString(3)+", ");
//				System.out.print("price = "+rd.getInt(4)+", ");
//				System.out.println("MFG = "+rd.getString(5)+" |");
				
				System.out.println("id = "+rd.getInt(1)+", "+"name = "+rd.getString(5)+", "+"Email = "+rd.getString(4)+", "+"Mobile No = "+rd.getInt(2)+", "+"Password = "+rd.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	public static void UpdateDetails() {
		
	}
	
	
	
	
	public static void main(String[] args) {
		getallCustomer();
	}

}
