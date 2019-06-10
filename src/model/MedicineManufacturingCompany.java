package model;

public class MedicineManufacturingCompany extends ManufacturingCompany implements naturalResource {

	public final static String MANUFACTURE_AND_EXPORT = "Manufacture and export";
	public final static String MANUFACTURE_AND_SELL = "Manufacture and sell";
	public final static String IMPORT_AND_SELL = "Import and sell";

	private String sanitaryRegistration;
	private String status;
	private int expirationMonth;
	private int expirationYear;
	private String modality;

	public MedicineManufacturingCompany(String name, String nit, String address, String phone, int amountOfEmployees,
			double assetValue, int constitutionDay, int constitutionMonth, int constitutionYear, String type,
			String legalRepresentative, String sanitaryRegistration, String status, int expirationMonth,
			int expirationYear, String modality) {
		super(name, nit, address, phone, amountOfEmployees, assetValue, constitutionDay, constitutionMonth,
				constitutionYear, type, legalRepresentative);

		this.sanitaryRegistration = sanitaryRegistration;
		this.status = status;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.modality = modality;
	}

	public String getSanitaryRegistration() {
		return sanitaryRegistration;
	}

	public void setSanitaryRegistration(String sanitaryRegistration) {
		this.sanitaryRegistration = sanitaryRegistration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public int getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}
	
	public double totalWaterWasted() {
		double total=0;
		for (int i=0; i<getProducts().size();i++) {
			total+=getProducts().get(i).getAmountOfWater();
		}
		return total;
	}
	/**
	 * This method allows to calculate the amount of trees the company has to plant
	 */
	public String naturalResourceXTree() {

		String msg = "The amount of trees to be planted in the year by the company " + getName() + " are: ";
		double totalWaterWasted= totalWaterWasted();
		
		
		
		//for (int i = 0; i < getProducts().size(); i++) {
			if (totalWaterWasted >= 1.0 && totalWaterWasted <= 140) {

				msg += "6";
			} else if (totalWaterWasted >= 41
					&& totalWaterWasted <= 800) {
				msg += "25";
			} else {
				msg += "200";

			
		}
		return msg;
	}
}
