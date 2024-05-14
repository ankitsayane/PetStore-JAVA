package Functions;

import java.util.ArrayList;

import Com.Category.Category;
import Com.Store.Pet;

public class PetUtils {
	public static ArrayList<Pet> populateList(){
		ArrayList<Pet> arrList = new ArrayList<>();
		arrList.add(new Pet(12, "German Shepard", Category.DOG, 22500.0, 18));
		arrList.add(new Pet(89, "Popat", Category.PARROT, 2250.50, 2));
		arrList.add(new Pet(9, "Kitten", Category.CAT, 11880.0, 23));
		arrList.add(new Pet(10, "Tommy", Category.DOG, 19550.0, 8));
		arrList.add(new Pet(4, "Gold Fish", Category.FISH, 2500.0, 12));
		return arrList;
		
	}
}
