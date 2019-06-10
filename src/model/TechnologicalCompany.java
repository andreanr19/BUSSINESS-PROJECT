package model;
import java.util.*;

public class TechnologicalCompany extends ServiceCompany implements naturalResource{

	private double amountOfEnergyUsed;
	private ArrayList<Service> theServices;

	public TechnologicalCompany(String name, String nit, String address, String phone, int amountOfEmployees,
			double assetValue, int constitutionDay, int constitutionMonth, int constitutionYear, String type,
			String legalRepresentative, double amountOfEnergyUsed) {
		super(name, nit, address, phone, amountOfEmployees, assetValue, constitutionDay, constitutionMonth,
				constitutionYear, type, legalRepresentative);
		
		theServices=new ArrayList<Service>();
		this.amountOfEnergyUsed=amountOfEnergyUsed;
	}
	public void addService(Service s) {
		theServices.add(s);
	}

	public ArrayList<Service> getTheServices() {
		return theServices;
	}

	public void setTheServices(ArrayList<Service> theServices) {
		this.theServices = theServices;
	}
	public double getAmountOfEnergyUsed() {
		return amountOfEnergyUsed;
	}
	public void setAmountOfEnergyUser(double amountOfEnergyUsed) {
		this.amountOfEnergyUsed=amountOfEnergyUsed;
	}
	/**
	 * This method allows to calculates the amount of trees the company has to plant
	 */
	public String naturalResourceXTree() {
		String msg="The amount of trees to be planted in the year by the compant " + getName() + " are: ";
		
		if(amountOfEnergyUsed>=1 && amountOfEnergyUsed <=1000) {
			msg+="8";
		}else if(amountOfEnergyUsed>=1001 && amountOfEnergyUsed <=3000) {
			msg+="35";
		}else {
			msg+="500";
		}
		
		return msg;
		
	}
	
	
}