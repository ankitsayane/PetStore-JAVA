package Utils;

import java.util.ArrayList;

import Com.Category.Category;
import Com.Category.Status;
import Com.Store.Pet;
import CustomException.AuthenticationException;
import CustomException.IllegalArgumentException;

public class Validation {
	
	public static Pet petValidation(int id, String name, String category, double price, int stock ) throws IllegalArgumentException{
		Category cat = validateCategory(category);
		int s =  validateStock(stock);
		double p = validatePrice(price);
		return new Pet(id, name, cat, p, s);
	}
	public static Category validateCategory(String cate) throws IllegalArgumentException{
		return Category.valueOf(cate.toUpperCase());
	}
	public static int validateStock(int quantity) throws IllegalArgumentException{
		if(quantity < 1)
			throw new CustomException.IllegalArgumentException("Invalid Quantity!!!");
		return quantity;
	}
	public static double validatePrice(double price) throws IllegalArgumentException{
		if(price < 1)
			throw new CustomException.IllegalArgumentException("Invalid Price!!!");
		return price;
	}
	
	public static String loginValidation(String username, String password) throws AuthenticationException{
		//Admin
		if(username.equals("admin") && password.equals("admin")) {
			System.out.println("Admin Loggin Successfull");
			return "admin";
		}
		
		//Customer
		if(username.equals("user") && password.equals("user")) {
			System.out.println("Customer Loggin Successfull");
			return "user";
		}
		throw new AuthenticationException("Invalid Username OR Password");
	}
	
	
	public static Pet getPet(int id, ArrayList<Pet> arrayList) throws AuthenticationException {
		for (Pet p : arrayList) {
			if (p.getPetId() == id) {
				return p;
			}
		}
		throw new AuthenticationException("Id not Found");
	}
	
	public static Status validateStatus(String cate) throws IllegalArgumentException{
		return Status.valueOf(cate.toUpperCase());
	}

}
