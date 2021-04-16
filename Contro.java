package com.services;

import com.models.Employee;

public interface Contro {
		boolean checkadd(Employee emp);
		void Employee_display();
		boolean remove(Employee emp);
		boolean update(Employee oldemp, Employee newemp);
}
