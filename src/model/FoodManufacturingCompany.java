package model;

public class FoodManufacturingCompany extends ManufacturingCompany {
	
	public static final String RT="Room Temperature";
	public static final String R="Refrigeration";
	public static final String F="Freezer";
	
	private String importer;
	private String maker;
	private String conservationType;
	
	

	
	public FoodManufacturingCompany(String name, String nit, String address, String phone, int amountOfEmployees,
			double assetValue, int constitutionDay, int constitutionMonth, int constitutionYear, String type,
			String legalRepresentative, String importer, String maker, String conservationType) {
		super(name, nit, address, phone, amountOfEmployees, assetValue, constitutionDay, constitutionMonth,
				constitutionYear, type, legalRepresentative);
		this.importer = importer;
		this.maker = maker;
		this.conservationType = conservationType;
	}
	public String getImporter() {
		return importer;
	}
	public void setImporter(String importer) {
		this.importer = importer;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getConservationType() {
		return conservationType;
	}
	public void setConservationType(String conservationType) {
		this.conservationType = conservationType;
	}

}
