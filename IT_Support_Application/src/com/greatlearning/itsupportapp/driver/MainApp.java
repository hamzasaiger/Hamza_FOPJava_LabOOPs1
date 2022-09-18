/**
 * @author hamza
 * This is the main driver class
 */
package com.greatlearning.itsupportapp.driver;
import com.greatlearning.itsupportapp.model.Employee;
import com.greatlearning.itsupportapp.service.CredentialService;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("||-----------------------------||");
		System.out.println("||Welcome to IT Support Service||");
		System.out.println("||-----------------------------||");
		System.out.println("Enter your first name:");
		String firstName = sc.next();
		System.out.println("Enter your last name:");
		String lastName = sc.next();
		Employee emp = new Employee(firstName,lastName);
		String dept = "";
		CredentialService service = new CredentialService();
		int option = 0;
		System.out.println("Please Enter your department:");
		do{
				if(emp.getFirstName().length()>= 4 && emp.getLastName().length()>= 4)
				{
					System.out.println("1. Technical");
					System.out.println("2. Admin");
					System.out.println("3. Human Resource");
					System.out.println("4. Legal");
					System.out.println("5. Exit the program");
				}
				else if (emp.getFirstName().length()== 0 && emp.getLastName().length()== 0) System.out.println("No name or last name entered. Please use minimum 4 characters");
				else System.out.println("Name /last name length is very small. Please use minimum 4 characters");
				
				option = sc.nextInt();
				
				switch(option)
				{
					case 1:
						dept = "tech";
						break;
					case 2:
						dept = "admin";
						break;
					case 3:
						dept = "hr";
						break;
					case 4:
						dept = "legal";
						break;
					default:
						break;
				}
				
				if (option >= 1 && option <= 4)
				{
					String emailID = service.generateEmailAddress(emp.getFirstName(), emp.getLastName(), dept);
					emailID = emailID.toLowerCase();
					char[] password = service.generatePassword(8);
					service.showCredentials(emp.getFirstName(), emailID, password);
					System.out.println("");
					System.out.println("Enter 1 to 4 to generate email & password again. Enter 5 to exit");
				}
				else if (option == 5)
				{
					System.out.println("Program exited sucessfully. Thank you for using IT Support");
					System.out.println("----------------------------------------------------------");
				}
				else
				{
					System.out.println("Incorrect Input. Enter from assigned values...");
					System.out.println("");
				}		
		}while (option != 5);
	}

}
