package stringFunctions;

import java.util.Scanner;

/**
 * @author nimesh
 *
 *This class uses functions of String class to operate on strings.
 */
public class UsingStringFunctions {

	private String initial=null;
	private String firstName=null;
	private String lastName=null;
	private String email=null;
	private String FullName=null;
	/**
	 * @author nimesh
	 * This function asks the user for the name...
	 */
	private void promptName(){

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the initials: Mr/Mrs/Ms.");
		initial=scan.next();
		
		if(initial.equalsIgnoreCase("Mr")|| initial.equalsIgnoreCase("Mrs")|| initial.equalsIgnoreCase("Ms")){
			System.out.println("Enter the First Name:");
			firstName=scan.next();
			System.out.println("Enter the Last Name: ");
			lastName=scan.next();
		}
		else{
			System.out.println("Please enter valid initials");
			promptName();
		}

	}
	private void promptEmail(){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your Email address:");
		email=scan.next();
	}
	/**
	 * This function returns the full name...
	 * @return String of full name
	 * @author nimesh
	 */
	private String fullName(){
		FullName=firstName+" "+lastName;
		return (initial.toUpperCase()+"."+" "+firstName.toUpperCase()+" "+lastName.toUpperCase());
	}
	/**
	 * @author nimesh
	 * @return boolean 
	 * if valid email returns true else returns false
	 */
	private boolean checkEmail(){
		if(email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b")){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * @author nimesh
	 * @return Array of String
	 * This funtion returns first name and last name in an array of String.
	 * 
	 */
	private String[] split_first_Last_Name(){
		String[] f_L_name=FullName.split(" ");
		return f_L_name;
	}
	/**
	 * @author nimesh
	 * @param name_type This parameter can be first name or last name
	 * @return int 		The return type returns the index of the parameter..
	 */
	private int findindex(String name_type){
		int i=FullName.indexOf(name_type);
		return i;
	}
	/**
	 * @author nimesh
	 * This function finds the total length of the full name..
	 * @return int It returns the length of the full name...
	 */
	private int find_Length(){
		return(FullName.length());
	}
	/**
	 * @author nimesh
	 * This function checks whether the two names(first name and last name) are identical...
	 * @return int 
	 */
	private int compare_Names(){

		return(firstName.compareTo(lastName));
	}
	/**
	 * @author nimesh
	 * This function displays the names in many formats 
	 */
	private void display(){
		System.out.println("Your Full Name is : \t "+fullName());
		
		if(checkEmail()){
			System.out.println("Your Email Address is : \t"+ email);
		}
		else{
			System.err.println("Your Email Address is not Valid...");
		}
		
		String[]names=split_first_Last_Name();
		System.out.println("Your First Name is : \t"+names[0]);
		System.out.println("Your Last Name is : \t"+names[1]);
		System.out.println("Your First Name is at index: \t"+findindex(firstName));
		System.out.println("Your Last Name is at index: \t"+findindex(lastName));
		System.out.println("The total Length of the Full Name is: \t"+find_Length());
		int value=compare_Names();
		
		if(value==0){
			System.out.println("The First Name and Last Name are both equal");
		}
		else if(value<0){
			System.out.println("The Last Name is greater than First Name");
		}
		else if(value>0){
			System.out.println("The First Name is greater than Last Name");
		}
		else{
			System.err.println("Error!!!");
		}


	}
	/**
	 * @author nimesh
	 * @param args
	 * This is the main class...
	 */
	public static void main(String[] args) {
		UsingStringFunctions sf=new UsingStringFunctions();
		sf.promptName();
		sf.promptEmail();
		sf.display();
	}
}
