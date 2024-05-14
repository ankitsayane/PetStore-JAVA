package Com.Store;
import Com.Category.Category;

public class Pet {
	private int petId;
	private String petName;
	private Category petCategory;
	private double unitPrice;
	private int petStock;
	
	public Pet(int petId, String petName, Category petCategory, double unitPrice, int petStock) {
		this.petId = petId;
		this.petName = petName;
		this.petCategory = petCategory;
		this.unitPrice = unitPrice;
		this.petStock = petStock;
	}
	
	public Pet(String petName, Category petCategory, double unitPrice, int petStock) {
		super();
		this.petName = petName;
		this.petCategory = petCategory;
		this.unitPrice = unitPrice;
		this.petStock = petStock;
	}


	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Category getPetCategory() {
		return petCategory;
	}

	public void setPetCategory(Category petCategory) {
		this.petCategory = petCategory;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getPetStock() {
		return petStock;
	}

	public void setPetStock(int petStock) {
		this.petStock = petStock;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", petCategory=" + petCategory + ", unitPrice="
				+ unitPrice + ", petStock=" + petStock + "]";
	}
	
	
	
}
