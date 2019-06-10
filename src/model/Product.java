package model;

public class Product {
	
	public String name;
	public String code;
	public double amountOfWater;
	public int unitsInInventory;
	public Product(String name, String code, double amountOfWater, int unitsInInventory) {

		this.name = name;
		this.code = code;
		this.amountOfWater = amountOfWater;
		this.unitsInInventory = unitsInInventory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getAmountOfWater() {
		return amountOfWater;
	}
	public void setAmountOfWater(double amountOfWater) {
		this.amountOfWater = amountOfWater;
	}
	public int getUnitsInInventory() {
		return unitsInInventory;
	}
	public void setUnitsInInventory(int unitsInInventory) {
		this.unitsInInventory = unitsInInventory;
	}
	
	
}
