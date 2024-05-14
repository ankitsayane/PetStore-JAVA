package Tester;
import static Utils.Validation.getPet;
import static Utils.Validation.loginValidation;
import static Utils.Validation.petValidation;
import static Utils.Validation.validateCategory;
import static Utils.Validation.validatePrice;
import static Utils.Validation.validateStatus;
import static Utils.Validation.validateStock;

import java.util.ArrayList;
import java.util.Scanner;

import Com.Store.Order;
import Com.Store.Pet;
import CustomException.AuthenticationException;
import CustomException.AuthorizationException;
import CustomException.IllegalArgumentException;
import CustomException.OutofStockException;
import static Functions.PetUtils.populateList;
public class PetStore {
	public static void main(String[] args) throws AuthenticationException, IllegalArgumentException, AuthorizationException, OutofStockException {
		try (Scanner sc = new Scanner(System.in)) {
			ArrayList<Pet> petList = populateList();
			ArrayList<Order> orderList = new ArrayList<>();
			int choice;
			boolean adminAccess = false;
			boolean userAccess = false;
			do {
				System.out.println("1. Login\n"
						+ "2. Add New Pet (Admin Only)\n"
						+ "3. Update Pet Details (Admin Only)\n"
						+ "4. Display All Pets\n"
						+ "5. Order a Pet\n"
						+ "6. Check Order Status by Order Id\n"
						+ "7. Update Order Status (Admin Only)\n"
						+ "8. Display All Orders\n"
						+ "9. Exit");
				System.out.print("Enter your choice : ");
				choice = sc.nextInt();
				switch(choice) {
				case 1: //Login
					System.out.println("Enter Login Id and Password : ");
					String log = loginValidation(sc.next(), sc.next());
					if(log == "admin") {
						adminAccess = true;
						userAccess = true;
					}
					else {
						adminAccess = false;
						userAccess = true;
					}
					break;
					
				case 2: //Add new Pet
					if (userAccess) {
						if (adminAccess) {
							System.out.println("Enter Id, Name, Category, Price, Quantity");
							petList.add(petValidation(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.nextInt()));
						}
						else {
							throw new AuthenticationException("Admin Only Functionality..");
						}
					}
					else {
						throw new AuthorizationException("Login First..");
					}
					break;
					
				case 3: //Update Pet Details
					if(adminAccess) {
						System.out.print("Enter Id : ");
						int i = sc.nextInt();
						for(Pet p : petList) {
							if(p.getPetId() == i ) {
								System.out.println("Enter Name, Category, Price, Quantity");
								p.setPetName(sc.next());
								p.setPetCategory(validateCategory(sc.next()));
								p.setUnitPrice(validatePrice(sc.nextDouble()));
								p.setPetStock(validateStock(sc.nextInt()));
							}
							else {
								throw new AuthenticationException("Id not Found");
							}
						}
					}
					else {
						throw new AuthenticationException("Admin Only Functionality..");
					}
					
					break;
					
				case 4: //Display All Pets
					if(adminAccess || userAccess) {
						for(Pet p : petList) {
							System.out.println(p);
						}
					}
					else {
						throw new AuthorizationException("Login First.. ");
					}
					break;
					
				case 5: //Order Pet
					if(userAccess || adminAccess) {
						System.out.print("Enter PetId : ");
						int id = sc.nextInt();
						Pet p = getPet(id, petList);
						if(p.getPetId() != 0) {
							System.out.print("Enter Quantity : ");
							int q = sc.nextInt();
							if(p.getPetStock() < q)
								throw new OutofStockException("Quantity is more Than Pet Quantity!!!");
							Order o = new Order(p.getPetId(), q);
							orderList.add(o);
							
							p.setPetStock(p.getPetStock() - q);
							System.out.println("Order Placed with PetId-"+p.getPetId());
						}
					}
					break;
					
				case 6: //Check Order Status
					if(adminAccess || userAccess) {
						System.out.print("Enter Order Id : ");
						int id = sc.nextInt();
						for(Order o : orderList) {
							if(o.getOrderId() == id) {
								System.out.println(o.getStatus());
								System.out.println(o);
							}
						}
					}
					else {
						throw new AuthenticationException("Login First");
					}
					break;
					
				case 7: //Update order Status
					if(adminAccess) {
						System.out.print("Enter Id to Update Status : ");
						int i = sc.nextInt();
						for(Order o : orderList) {
							if(o.getOrderId() == i) {
								System.out.print("Enter Order Status : ");
								o.setStatus(validateStatus(sc.next()));
								System.out.println(o);
							}
						}
						
					}
					break;
					
				case 8: //Display All orders
					if(!adminAccess) {
						throw new AuthenticationException("Login as Admin First..");	
					}
					for(Order o : orderList) {
						System.out.println(o);
					}
					break;
					
				case 9: //Exit
					choice = 9;
					break;
				}
				
			}while(choice!=9);
			
		}

	}

}
