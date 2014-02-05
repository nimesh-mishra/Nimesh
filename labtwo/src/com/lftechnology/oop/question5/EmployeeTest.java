package com.lftechnology.oop.question5;

/**
 * This class demonstrates the capabilities of Employee Class
 * @author nimesh
 *
 */
public class EmployeeTest{
	
	/**
	 * This method displays the yearly salary of the Employee objects
	 * @author nimesh
	 */
	public void display(Employees emp){
		System.out.println("The yearly salary of "+emp.getFirstName()+" "+emp.getLastName()+" is: \t"+emp.getSalary()*12);
	}
	
	/**
	 * This method is used to set the raised value of salary in Employee class
	 * @author nimesh
	 */
	public void setRaise(Employees emp){
		emp.setSalary(emp.getSalary()*1.1);
	}
	public static void main(String[] args) {
		Employees employee1=new Employees("Nimesh","Mishra",1000);
		Employees employee2=new Employees("jerry","Chaudhary",1000);
		EmployeeTest emptest=new EmployeeTest();
		emptest.display(employee1);
		emptest.display(employee2);
		emptest.setRaise(employee1);
		emptest.setRaise(employee2);
		emptest.display(employee1);
		emptest.display(employee2);

	}

}
