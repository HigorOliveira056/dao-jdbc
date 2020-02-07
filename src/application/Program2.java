package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao derpatmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===Test 1 : department insert===");
		Department dep = new Department(null, "Music");
		derpatmentDao.insert(dep);
		System.out.println("Inserted! New id: " + dep.getId());
		
		System.out.println("\n===Test 2 : department findById===");
		Department depById = derpatmentDao.findById(2);
		System.out.println(depById);
		
		System.out.println("\n===Test 3 : department update===");
		depById = derpatmentDao.findById(7);
		depById.setName("Assistencia");
		derpatmentDao.update(depById);
		System.out.println(depById);
		
		System.out.println("\n===Test 4 : department findAll===");
		List<Department> list = derpatmentDao.findAll();
		for(Department d: list) {
			System.out.println(d);
		}
		
		System.out.println("\n===Test 5 : department delete===");
		System.out.println("Enter id for delete department");
		int id = sc.nextInt();
		derpatmentDao.deleteById(id);
		System.out.println("Delete Completed! id: " + id);
		
		sc.close();
	}
}
