package model;

import java.util.*;

public class ManufacturingCompany extends Company {

	private ArrayList<Product> products;

	public ManufacturingCompany(String name, String nit, String address, String phone, int amountOfEmployees,
			double assetValue, int constitutionDay, int constitutionMonth, int constitutionYear, String type,
			String legalRepresentative) {
		super(name, nit, address, phone, amountOfEmployees, assetValue, constitutionDay, constitutionMonth,
				constitutionYear, type, legalRepresentative);

		products = new ArrayList<Product>();

	}
	/**
	 * this method allows to add a product to the company
	 * @param p the product
	 */
	public void addProducts(Product p) {
		products.add(p);
	}
	/**
	 * this method allows to get the products
	 * @return An arrayLists of products
	 */

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}



}