package model;

public class PublicServiceCompany extends ServiceCompany implements ProcultureTax {
	
	public final static String SEWERAGE="Sewerage";
	public final static String ENERGY="Energy";
	public final static String AQUEDUCT="Aqueduct";

	private String typeOfService;
	private int totalNumberOfSuscribers;
	private int suscribers1and2;
	private int totalSuscribers;
	public PublicServiceCompany(String name, String nit, String address, String phone, int amountOfEmployees,
			double assetValue, int constitutionDay, int constitutionMonth, int constitutionYear, String type,
			String legalRepresentative, String typeOfService, int totalNumberOfSuscribers, int suscribers1and2) {
		super(name, nit, address, phone, amountOfEmployees, assetValue, constitutionDay, constitutionMonth,
				constitutionYear, type, legalRepresentative);
		this.typeOfService = typeOfService;
		this.totalNumberOfSuscribers = totalNumberOfSuscribers;
		this.suscribers1and2 = suscribers1and2;
	}
	public String getTypeOfService() {
		return typeOfService;
	}
	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}
	public int getTotalNumberOfSuscribers() {
		return totalNumberOfSuscribers;
	}
	public void setTotalNumberOfSuscribers(int totalNumberOfSuscribers) {
		this.totalNumberOfSuscribers = totalNumberOfSuscribers;
	}
	public int getSuscribers1and2() {
		return suscribers1and2;
	}
	public void setSuscribers1and2(int suscribers1and2) {
		this.suscribers1and2 = suscribers1and2;
	}
	/**
	 * this method allow to calculate the proculture tax of the company
	 */
	public String procultureTax() {
		String msg="";
		double procultureTax=0;
		
		
		procultureTax= 40 - ((totalNumberOfSuscribers-suscribers1and2)/100);
		if(procultureTax<0) {
			msg+="The company shouldn't pay proculture tax";
			
		}else {
			msg+="The percentage of tax payable of the company " + getName() + " is : "+ procultureTax +"%";
		}return msg;
		
	}
	
	
}
