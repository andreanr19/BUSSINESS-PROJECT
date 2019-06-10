package model;

import java.util.*;

public class ServiceCompany extends Company {

	private double satisfactionClient; // to calculate

	private ArrayList<Poll> polls;

	public ServiceCompany(String name, String nit, String address, String phone, int amountOfEmployees,
			double assetValue, int constitutionDay, int constitutionMonth, int constitutionYear, String type,
			String legalRepresentative) {
		super(name, nit, address, phone, amountOfEmployees, assetValue, constitutionDay, constitutionMonth,
				constitutionYear, type, legalRepresentative);

		polls = new ArrayList<Poll>();

	}

	public void addPoll(Poll p) {
		polls.add(p);
	}

	public double getSatisfactionClient() {
		return satisfactionClient;
	}

	public void setSatisfactionClient(double satisfactionClient) {
		this.satisfactionClient = satisfactionClient;
	}

	public ArrayList<Poll> getPolls() {
		return polls;
	}

	public void setPolls(ArrayList<Poll> polls) {
		this.polls = polls;
	}
	/**
	 * This method allows to calculate the satisfaction of the clients
	 */
	public void calculateSatisfationClient() {
		double percentageA1 = 0;
		double percentageA2 = 0;
		double percentageA3 = 0;
		String ma1 = "";
		String ma2 = "";
		String ma3 = "";
		for (int i = 0; i < polls.size(); i++) {
			percentageA1 += polls.get(i).getAnswer1();
			percentageA2 += polls.get(i).getAnswer2();
			percentageA3 += polls.get(i).getAnswer3();
		}
		ma1 += "The level of satisfaction for the client with the serviced provided in a scale of 1 to 5 is "
				+ (percentageA1 / polls.size());
		ma2 += "The level of satisfaction for the client with the the response time given in a scale of 1 to 5 is "
				+ (percentageA2 / polls.size());
		ma3 += "The level of satisfaction for the client with the cost / benefit ratio of the service purchase in a scale of 1 to 5 is "
				+ (percentageA3 / polls.size());
		System.out.println(ma1);
		System.out.println(ma2);
		System.out.println(ma3);
	}

}
