package model;

public class EducationCompany extends ServiceCompany implements ProcultureTax {

	private int registrationNumber;
	private int highQualityIdentityYears;
	private int saber11NationalPosition;
	private int saberProNationalPosition;
	private String rectorName;
	private String educationSector;
	private int stratum;
	private int activeStudents1and2;
	private int totalActiveStudents;

	public EducationCompany(String name, String nit, String address, String phone, int amountOfEmployees,
			double assetValue, int constitutionDay, int constitutionMonth, int constitutionYear, String type,
			String legalRepresentative, int registrationNumber, int highQualityIdentityYears,
			int saber11NationalPosition, int saberProNationalPosition, String rectorName, String educationSector,
			int stratum, int activeStudents1and2, int totalActiveStudents) {
		super(name, nit, address, phone, amountOfEmployees, assetValue, constitutionDay, constitutionMonth,
				constitutionYear, type, legalRepresentative);
		this.registrationNumber = registrationNumber;
		this.highQualityIdentityYears = highQualityIdentityYears;
		this.saber11NationalPosition = saber11NationalPosition;
		this.saberProNationalPosition = saberProNationalPosition;
		this.rectorName = rectorName;
		this.educationSector = educationSector;
		this.stratum = stratum;
		this.activeStudents1and2 = activeStudents1and2;
		this.totalActiveStudents = totalActiveStudents;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getHighQualityIdentityYears() {
		return highQualityIdentityYears;
	}

	public void setHighQualityIdentityYears(int highQualityIdentityYears) {
		this.highQualityIdentityYears = highQualityIdentityYears;
	}

	public int getSaber11NationalPosition() {
		return saber11NationalPosition;
	}

	public void setSaber11NationalPosition(int saber11NationalPosition) {
		this.saber11NationalPosition = saber11NationalPosition;
	}

	public int getSaberProNationalPosition() {
		return saberProNationalPosition;
	}

	public void setSaberProNationalPosition(int saberProNationalPosition) {
		this.saberProNationalPosition = saberProNationalPosition;
	}

	public String getRectorName() {
		return rectorName;
	}

	public void setRectorName(String rectorName) {
		this.rectorName = rectorName;
	}

	public String getEducationSector() {
		return educationSector;
	}

	public void setEducationSector(String educationSector) {
		this.educationSector = educationSector;
	}

	public int getStratum() {
		return stratum;
	}

	public void setStratum(int stratum) {
		this.stratum = stratum;
	}

	public int getActiveStudents1and2() {
		return activeStudents1and2;
	}

	public void setActiveStudents1and2(int activeStudents1and2) {
		this.activeStudents1and2 = activeStudents1and2;
	}

	public int getTotalActiveStudents() {
		return totalActiveStudents;
	}

	public void setTotalActiveStudents(int totalActiveStudents) {
		this.totalActiveStudents = totalActiveStudents;
	}

	/**
	 * This method calculates proculture tax <br>
	 * 
	 * <b>pre:</b> activeStudents1and2 is initilized, activeStudents1and2 != null
	 * <br>
	 * 
	 * <b>post:</b> Proculture tax has been calculated <br>
	 * 
	 * @return String The method returns a message with the information of the tax
	 *         <br>
	 */

	public String procultureTax() {

		double procultureTax = 0;
		String msg = "";

		procultureTax = 20 - (activeStudents1and2 / 100);

		if (procultureTax < 0) {

			msg = "The company shouldn't pay the proculture tax";
		}

		else {

			msg = "The percentage of tax payable of the company " + getName() + " is " + procultureTax +"%";
		}

		return msg;
	}
}
