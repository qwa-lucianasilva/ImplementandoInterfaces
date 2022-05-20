package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employees;

public class Program {
	
	public static void main(String[] args) {
		
		List<Employees> list = new ArrayList<>();
		String path = "C:\\temp\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String employeesCsv = br.readLine();
			while (employeesCsv != null) {
				String[] fields = employeesCsv.split(",");				
				list.add(new Employees(fields[0], Double.parseDouble(fields[1])));
				employeesCsv = br.readLine();
			}
			Collections.sort(list);
			for (Employees emp : list) {
				System.out.println(emp.getName() + ", " + emp.getSalary());
			}
			
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
