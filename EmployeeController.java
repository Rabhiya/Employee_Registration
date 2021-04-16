package controller;

import java.util.Scanner;

import com.models.Employee;
import com.services.EmployeeList;

public class EmployeeController {
	private Scanner sc = new Scanner(System.in);
	private EmployeeList empList = new EmployeeList();

	    public void Menu() {
		boolean back = false;
		DisplayMenu();
		System.out.print("\t\t\t Welcome to the Employee registration system\n");
		while (!back) {
			//System.out.print("\t\t\t Welcome to the Employee registration system\n");

			String choice = sc.nextLine();
			try {
				int Choice = Integer.parseInt(choice);
				switch (Choice) {
				case 0:
					System.out.println("Employee registration system closed");
					back = true;
					break;
				case 1:
					Employee_Add();
					break;
				case 2:
					empList.Employee_display();
					break;
					
				case 3:
					Employee_update();
					break;

				case 4:
					Employee_delete();
					break;

				case 5:
					Employee_search();
					break;

				case 6:
					DisplayMenu();
					break;
				
					default:
						System.out.println("Press the right key.\n OR Type 6 to display the menu");
				}

			} catch (Exception e) {
				System.out.println("Something went wrong type 6 to try again");
			}
		}

	}

	public void Employee_Add() {
		try {
			System.out.print("Enter the employee name: ");
			String name = sc.nextLine();
			System.out.print("Enter employee age: ");
			String age = sc.nextLine();
			int Age = Integer.parseInt(age);
			System.out.print("Enter employee address: ");
			String address = sc.nextLine();
			Employee newEmployee = Employee.new_create(empList.Id(), name, Age, address);
			System.out.println("Records saved successfully.");
			System.out.println("\n Your Employee id:" +newEmployee.getId());
			empList.checkadd(newEmployee);
		} catch (Exception e) {
			System.out.println("Something wrong in addition process");
		}

	}

	public void Employee_delete() {
		try {
			System.out.print("Please enter the id: ");
			String id = sc.nextLine();
			int ID = Integer.parseInt(id);
			Employee search = empList.search(ID);

			if (search == null) {
				System.out.println("Record does not exists for ID: " + ID);
			}
			if (empList.remove(search)) {
				System.out.println("Records for ID: " + search.getId() + " deleted successfully");
			} else {
				System.out.println("Deletion is not possible ");
			}
		} catch (Exception e) {
			System.out.println("Something wrong in deletion process");
		}

	}

	public void Employee_search() {
		try {
			System.out.print("Please enter the id: ");
			String id = sc.nextLine();
			int ID = Integer.parseInt(id);
			Employee recordEmployee = empList.search(ID);

			if (recordEmployee == null) {
				System.out.println("Record does not exists for ID: " + ID);
			} 
			else {
				System.out.println("Employee Id: " + recordEmployee.getId() + "\n Employee Name: "+ recordEmployee.getName() + "\n Employee age: " + recordEmployee.getAge()+ "\n Employee Address: " + recordEmployee.getAddress());

			}
		} catch (Exception e) {
			System.out.println("Something wrong in search process");

		}

	}

	public void DisplayMenu() {
		System.out.println("Type here:" + "\nType 0 to close\n" + "Type 1 to Add Employee\n"+ "Type 2 to Display Employee details\n" + "Type 3 to Update Employee details\n"+ "Type 4 to Remove Employee details\n" + "Type 5 to Search Employee details \n");
	}

	public void Employee_update() {
		try {
			System.out.print("Please enter the id: ");
			String id = sc.nextLine();
			int ID = Integer.parseInt(id);
			Employee recordEmployee = empList.search(ID);

			if (recordEmployee == null) {
				System.out.println("Record does not exists for ID: " + ID);
			} else {
				System.out.print("Enter the new employee name: ");
				String name = sc.nextLine();
				System.out.print("Enter new employee age: ");
				String age = sc.nextLine();
				int integerAge = Integer.parseInt(age);
				System.out.print("Enter new employee address: ");
				String address = sc.nextLine();
				Employee newEmployee = Employee.new_create(recordEmployee.getId(), name, integerAge, address);

				if (empList.update(recordEmployee, newEmployee)) {
					System.out.println("Successfully Updated");
				} else {
					System.out.println("Update Unsuccessful");
				}
			}

		} catch (Exception e) {
			System.out.println("Error in updating details");

		}
		sc.close(); 
	}
	
}
