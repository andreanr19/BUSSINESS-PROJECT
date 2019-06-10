package model;

import java.util.*;

public class Holding implements HaulBuilding {

	private String name;
	// Relaciones

	private ArrayList<Company> companies;
	private Building building;

	// Constructor

	public Holding(String name) {

		companies = new ArrayList<Company>();
		this.name = name;
	}
	/**
	 * This method allows to get the name of the holding
	 * @return A string with the name of the holding
	 */
	public String getName() {
		return name;
	}
	/**
	 * this method allows to set the name of the holding
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method allows to add a new company
	 * @param newCompany
	 */
	public void addCompany(Company newCompany) {
		companies.add(newCompany);
	}
	
	/**
	 * this method allows to get the companies
	 * @return an ArrayList of companies
	 */
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	
	/**
	 * This method allows to set the companies
	 * @param companies
	 */
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
	/**
	 * This method allows to get the Building
	 * @return a Building
	 */
	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	// Metodos
	
	/**
	 * This method allows to haul the building in spiral
	 * @param chargeEmployeed It's the employee's charge
	 */
	public String haulEmail(String chargeEmployeed) {

		int filas = 0;
		int columnas = 0;
		int numCeldas = 0;
		int totalCeldas = (building.getCublicles().length * building.getCublicles()[0].length);
		int minY = 0;
		int minX = 0;
		int maxY = building.getCublicles().length - 1;
		int maxX = building.getCublicles()[0].length - 1;
		int direccion = HaulBuilding.ABAJO;
		String msg = "";

		while (numCeldas < totalCeldas) {

			switch (direccion) {

			case ABAJO:

				filas++;
				if (filas == maxY) {
					direccion = HaulBuilding.DERECHA;
					minX++;
				}

				msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

			case DERECHA:

				columnas++;
				if (columnas == maxX) {
					direccion = HaulBuilding.ARRIBA;
					maxY--;
				}

				msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

			case ARRIBA:
				filas--;
				if (filas == minY) {
					direccion = HaulBuilding.IZQUIERDA;
					maxX--;
				}

				msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

			case IZQUIERDA:
				columnas--;
				if (columnas == minX) {
					direccion = HaulBuilding.ABAJO;
					minY++;
				}

				msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

			}
		}

		return msg;

	}

	/**
	 * This method allows to haul the building in X
	 * @param nameEmployeed It's the employee's name
	 * @return A string with the extension of the employees
	 * 
	 */
	// RECORRIDO EN X
	public String haulExtensionX(String nameEmployeed) {
		String msg = "";

		for (int i = 0; i < building.getCublicles().length; i++) {
			msg += building.getCublicles()[i][i].haulExtensionEmployee(nameEmployeed) + "\n";
		}
		for (int k = 0; k < building.getCublicles().length; k++) {
			if ((building.getCublicles().length % 2 == 0)
					|| (building.getCublicles().length % 2 != 0 && k != building.getCublicles().length / 2)) {
				msg += building.getCublicles()[k][building.getCublicles().length - 1 - k]
						.haulExtensionEmployee(nameEmployeed);
			}
		}
		return msg;
	}
	/**
	 * This method allows to haul the building in Z
	 * @param nameEmployeed It's the employee's name
	 * @return A string with the extension of the employees
	 * 
	 */
	// RECORRIDO EN Z
	public String haulExtensionZ(String nameEmployeed) {

		String msg = "";
		for (int i = 0; i < building.getCublicles().length; i++) {
			msg += building.getCublicles()[0][i].haulExtensionEmployee(nameEmployeed) + "\n";
		}
		for (int k = 1; k < building.getCublicles().length; k++) {
			msg += building.getCublicles()[k][building.getCublicles().length - k];
		}
		for (int j = 1; j < building.getCublicles().length; j++) {
			msg += building.getCublicles()[building.getCublicles().length][j];
		}
		return msg;
	}
	
	/**
	 * This method allows to haul the building in L
	 * @param nameEmployeed It's the employee's name
	 * @return A string with the extension of the employees
	 * 
	 */
	// RECORRIDO EN L
	public String haulExtensionL(String nameEmployeed) {
		String msg = "";
		int k = 0;
		boolean abajoL = false;

		for (int i = 0; i < building.getCublicles().length; i++) {
			msg += building.getCublicles()[i][k];
			abajoL = true;
		}
		if (abajoL == true) {
			for (int m = 1; m < building.getCublicles().length; m++) {
				msg += building.getCublicles()[k][m].haulExtensionEmployee(nameEmployeed);
			}
		}
		return msg;
	}
	/**
	 * This method allows to haul the building in E
	 * @param nameEmployeed It's the employee's name
	 * @return A string with the extension of the employees
	 * 
	 */

	// RECORRIDO EN ESPIRAL E
	public String haulExtensionE(String nameEmployeed) {
		String msg = "";
		int m = 0;
		for (int i = 0; i < building.getCublicles().length; i += 2) {
			for (int j = 0; j < building.getCublicles().length; j++) {
				if (m % 2 == 0) {
					msg += building.getCublicles()[i][j].haulExtensionEmployee(nameEmployeed);
				} else if (m % 2 != 0) {
					msg += building.getCublicles()[i][building.getCublicles().length - j - 1]
							.haulExtensionEmployee(nameEmployeed);
				}
			}
			if (m % 2 == 0 && i < building.getCublicles().length - 1) {
				msg += building.getCublicles()[i + 1][building.getCublicles().length - 1]
						.haulExtensionEmployee(nameEmployeed);
			} else {
				msg += building.getCublicles()[i + 1][0].haulExtensionEmployee(nameEmployeed);
			}
			m++;
		}
		return msg;
	}
	/**
	 * This method allows to haul the building in O
	 * @param nameEmployeed It's the employee's name
	 * @return A string with the extension of the employees
	 * 
	 */

	// RECORRIDO EN O
	public String haulExtensionO(String nameEmployeed) {
		String msg = "";
		for (int i = 0; i < building.getCublicles().length; i++) {
			msg += building.getCublicles()[0][i].haulExtensionEmployee(nameEmployeed);
		}
		for (int k = building.getCublicles()[0].length - 1; k > 0; k--) {
			msg += building.getCublicles()[building.getCublicles().length - 1][k].haulExtensionEmployee(nameEmployeed);
		}

		for (int o = 0; o < building.getCublicles().length; o++) {
			msg += building.getCublicles()[o][0].haulExtensionEmployee(nameEmployeed);
			msg += building.getCublicles()[o][building.getCublicles().length].haulExtensionEmployee(nameEmployeed);
		}
		return msg;
	}

	/**
	 * This method allows to show the type of companies
	 */
	public void showTypeOfCompanies() {
		System.out.println("1.Manufacturing Company \n" + "2.Medicine Manufacturing Company \n" + "3.Service Company \n"
				+ "4.Public Service Company \n" + "5.Education Company \n" + "6.Technological Company\n"
				+ "7.Food Manufacturing Company");
	}

	/**
	 * This method allows to choose the type of company
	 * @param option of the type of company
	 * @return the type of company
	 */
	public String showTcompany(String option) {
		String typeCompany = "";
		String AGFF = "1";
		String EMQ = "2";
		String MI = "3";
		String EGS = "4";
		String B = "5";
		String WR = "6";
		String TSC = "7";
		String FS = "8";
		String CS = "9";

		if (option.equals(AGFF)) {
			typeCompany = Company.AHFF;
		} else if (option.equals(EMQ)) {
			typeCompany = Company.EMQ;
		} else if (option.equals(MI)) {
			typeCompany = Company.MI;
		} else if (option.equals(EGS)) {
			typeCompany = Company.EGS;
		} else if (option.equals(B)) {
			typeCompany = Company.B;
		} else if (option.equals(WR)) {
			typeCompany = Company.WR;
		} else if (option.equals(TSC)) {
			typeCompany = Company.TSC;
		} else if (option.equals(FS)) {
			typeCompany = Company.FS;
		} else {
			typeCompany = Company.CS;
		}
		return typeCompany;
	}
	
	public void showthetypesofcompanies() {
		System.out.println("1.AGRICULTURE, HUNTING, FORESTRY AND FISHING\n" + "2.EXPLOTATION, MINES AND QUARRIES\n"
				+ "3.MANUFACTURING INDUSTRY\n" + "4.ELECTRICITY, GAS AND STEAM\n" + "5.BUILDING\n"
				+ "6.WHOLESALE AND RETAIL\n" + "7.TRANSPORTATION STORAGE COMMUNICATIONS\n" + "8.FINANCIAL STATEMENT\n"
				+ "9.COMUNAL AND SOCIAL");

	}

	/**
	 * This method allows to create a company
	 * @param option to create a company
	 * @param name of the company
	 * @param nit of the company
	 * @param address that the company will have
	 * @param phone of the company
	 * @param amountOfEmployees that the company has
	 * @param assetValue that the company has
	 * @param constitutionDay of the creation of the company
	 * @param constitutionMonth of the creation of the company
	 * @param constitutionYear of the creation of the company
	 * @param type of company
	 * @param legalRepresentative name of the legal representative
	 */
	public void showOptionsCreateCompany(String option, String name, String nit, String address, String phone,
			int amountOfEmployees, double assetValue, int constitutionDay, int constitutionMonth, int constitutionYear,
			String type, String legalRepresentative) {
		String ManufacturingCompany = "1";
		String MedicineManufacturingCompany = "2";
		String ServiceCompany = "3";
		String PublicServiceCompany = "4";
		String EducationCompany = "5";
		String TechnologicalCompany = "6";

		if (option.equals(ManufacturingCompany) || option.equals(MedicineManufacturingCompany)) {
			Company m = new ManufacturingCompany(name, nit, address, phone, amountOfEmployees, assetValue,
					constitutionDay, constitutionMonth, constitutionYear, type, legalRepresentative);
			addCompany(m);
			getCompanies().add(m);
			System.out.println("Your company has been sucessfully created");

		} else if (option.equals(ServiceCompany) || option.equals(PublicServiceCompany)
				|| option.equals(EducationCompany) || option.equals(TechnologicalCompany)) {
			Company m = new ServiceCompany(name, nit, address, phone, amountOfEmployees, assetValue, constitutionDay,
					constitutionMonth, constitutionYear, type, legalRepresentative);
			addCompany(m);
			getCompanies().add(m);
			System.out.println("Your company has been sucessfully created");

		}
	}

	public void verifyInstanceOfACompany(Company c, String sanitaryRegistration, String status, int expirationMonth,
			int expirationYear, String modality) {
		if (c instanceof ManufacturingCompany) {
			MedicineManufacturingCompany med = (MedicineManufacturingCompany) c;
			med.setSanitaryRegistration(sanitaryRegistration);
			med.setStatus(status);
			med.setExpirationMonth(expirationMonth);
			med.setExpirationYear(expirationYear);
			med.setModality(modality);
		}
	}

	public void showModalityMedicineCompany() {
		System.out.println("1.Manufacture and export\n" + "2.Manufacture and sell\n" + "3.Import and sell");
	}

	public String modalityMedicineCompany(String option) {
		String modalityCompany = "";
		String MAE = "1";
		String MAS = "2";
		String IAS = "3";
		if (option.equals(MAE)) {
			modalityCompany = MedicineManufacturingCompany.MANUFACTURE_AND_EXPORT;
		} else if (option.equals(MAS)) {
			modalityCompany = MedicineManufacturingCompany.MANUFACTURE_AND_SELL;
		} else {
			modalityCompany = MedicineManufacturingCompany.IMPORT_AND_SELL;
		}
		return modalityCompany;
	}

	public void showtypeOfServicePSC() {
		System.out.println("1.Sewerage\n" + "2.Energy\n" + "3.Aqueduct");
	}

	public String typeOfServicePSC(String option) {
		String type = "";
		String S = "1";
		String E = "2";
		String A = "3";
		if (option.equals(S)) {
			type = PublicServiceCompany.SEWERAGE;
		} else if (option.equals(E)) {
			type = PublicServiceCompany.ENERGY;
		} else {
			type = PublicServiceCompany.AQUEDUCT;
		}
		return type;
	}

	public void showTypeOfServicesTC() {
		System.out.println("1.Consultancy\n" + "2.Training\n" + "3.Development\n" + "4.Infrastructure\n"
				+ "5.Software\n" + "6.Platform");
	}
	public String typeOfServicesTC(String option) {
		String type="";
		String C="1";
		String T="2";
		String D="3";
		String I="4";
		String S="5";
		String P="6";
		if(option.equalsIgnoreCase(C)) {
			type=Service.CONSULTANCY;
		}else if(option.equalsIgnoreCase(T)) {
			type=Service.TRAINING;
		}else if(option.equalsIgnoreCase(D)) {
			type=Service.DEVELOPMENT_OF_CUSTOM_SOFTWARE;
		}else if(option.equalsIgnoreCase(I)) {
			type=Service.INFRAESTRUCTURE;
		}else if(option.equalsIgnoreCase(S)) {
			type=Service.SOFTWARE;
		}else if(option.equalsIgnoreCase(P)) {
			type=Service.PLATFORM;
		}return type;
		
	}
	
	/**
	 * This method allows to add a service to a technological company
	 * @param nameOfCompany name of the technological company
	 * @param type of the company
	 */
	public void addServiceToTechnologicalCompany(String nameOfCompany, String type) {
		for(int i=0;i<companies.size();i++) {
			if(companies.get(i).getName().equals(nameOfCompany)) {
				if(companies.get(i) instanceof TechnologicalCompany) {
					TechnologicalCompany m=(TechnologicalCompany) companies.get(i);
					Service s = new Service(type);
					m.addService(s);
					System.out.println("The service has been added to the company " + companies.get(i).getName());
					
				}
			}
		}
	}

	public void showTypesOfServicesFMC() {
		System.out.println("1.Room Temperature\n" + "2.Refrigeration\n" + "3.Freezer");
	}

	public String typeOfServicesFMC(String option) {
		String type = "";
		String RT = "1";
		String R = "2";
		String F = "3";
		if (option.equals(RT)) {
			type = FoodManufacturingCompany.RT;
		} else if (option.equals(R)) {
			type = FoodManufacturingCompany.R;
		} else {
			type = FoodManufacturingCompany.F;
		}
		return type;
	}

	public String showActualCompanies() {
		String companiesNames = "";
		if (companies.size() != 0) {

			for (int i = 0; i < companies.size(); i++) {
				companiesNames += i + 1 + "." + companies.get(i).getName() + "\n";
			}

		} else {
			companiesNames += "There's no companies in the holding yet.";
		}

		return companiesNames;
	}
	
	/**
	 * This method allows to add a building to a company
	 * @param nameOfCompany name of company to add a building
	 * @param numberOfFloors number of floor the company will have
	 */

	public void addBuildingtoACompany(String nameOfCompany, int numberOfFloors) {

		boolean stop = false;
		for (int i = 0; i < companies.size() && !stop; i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (numberOfFloors >= 3 && numberOfFloors <= 7) {

					Building b = new Building(numberOfFloors);
					companies.get(i).setBuilding(b);
					System.out.println("The building has been added to the company " + companies.get(i).getName());
					stop = true;
					break;
				} else if (numberOfFloors > 7) {
					System.out.println("A company can't have a building of more than 7 floors");
				} else {
					System.out.println("A company can't have a building of less than 3 floors");
				}
				break;

			} else {
				System.out.println("The company " + nameOfCompany + " doesn't exist");

			}
		}
	}

	/**
	 * This method allows to add a building to a company
	 * @param nameOfCompany name of company to add a building
	 * @param numberOfFloors number of floor the company will have
	 */
	public void addBuildingToACompany2(String nameOfCompany, int numberOfFloors) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i).getBuilding() == null) {
					if (numberOfFloors >= 3 && numberOfFloors <= 7) {
						Building b = new Building(numberOfFloors);
						companies.get(i).setBuilding(b);
						System.out.println("The building has been added to the company " + companies.get(i).getName());
					} else if (numberOfFloors > 7) {
						System.out.println("A company can't have a building of more than 7 floors");
					} else {
						System.out.println("A company can't have a building of less than 3 floors");
					}
				} else {
					System.out.println("The company " + companies.get(i).getName() + " has a building already");
				}
			}
		}
	}

	/**
	 * This method allows to add products to a company
	 * @param nameOfCompany name of company to add products
	 * @param nameOfProduct name of the product
	 * @param codeOfProduct code of the product
	 * @param amountOfWater amount of water the product needs
	 * @param unitsInInventory units in inventory of the product
	 */
	public void addProductsToACompany(String nameOfCompany, String nameOfProduct, String codeOfProduct,
			double amountOfWater, int unitsInInventory) {

		boolean stop = false;
		for (int i = 0; i < companies.size() && !stop; i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i) instanceof ManufacturingCompany
						&& companies.get(i) instanceof MedicineManufacturingCompany) {

					MedicineManufacturingCompany m = (MedicineManufacturingCompany) companies.get(i);
					Product p = new Product(nameOfProduct, codeOfProduct, amountOfWater, unitsInInventory);
					m.addProducts(p);
					stop = true;
					System.out
							.println("The product " + nameOfProduct + " has been added to the company " + m.getName());
				}else if(companies.get(i) instanceof ManufacturingCompany && companies.get(i) instanceof FoodManufacturingCompany) {
					FoodManufacturingCompany m= (FoodManufacturingCompany) companies.get(i);
					Product p= new Product(nameOfProduct, codeOfProduct, amountOfWater, unitsInInventory);
					m.addProducts(p);
					stop=true;
					System.out.println("The product " + nameOfProduct + " has been added to the company " + m.getName());
			}else {
					System.out.println(
							"The company " + companies.get(i).getName() + " doesn't need products to be added");
					break;
				}

			}
		}
	}

	/**
	 * This method allows to calculate the proculture tax a company has to pay
	 * @param nameOfCompany company that has to pay the tax
	 */
	public void calculateProcultureTax(String nameOfCompany) {

		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {

				if (companies.get(i) instanceof EducationCompany) {

					EducationCompany m = (EducationCompany) companies.get(i);
					System.out.println(m.procultureTax());
				} else if (companies.get(i) instanceof PublicServiceCompany) {
					PublicServiceCompany m = (PublicServiceCompany) companies.get(i);
					System.out.println(m.procultureTax());
				} else {
					System.out.println("The company " + companies.get(i).getName() + " doesn't pay the proculture tax");
					break;
				}

			}
		}
	}
	/**
	 * This method allows to calculate the amount of trees a company has to plant
	 * @param nameOfCompany that has to plant trees
	 */
	public void calculateNaturalResource(String nameOfCompany) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i) instanceof MedicineManufacturingCompany) {
					MedicineManufacturingCompany m = (MedicineManufacturingCompany) companies.get(i);
					System.out.println(m.naturalResourceXTree());
				} else if (companies.get(i) instanceof TechnologicalCompany) {
					TechnologicalCompany m = (TechnologicalCompany) companies.get(i);
					System.out.println(m.naturalResourceXTree());
				} else {
					System.out.println("The company " + companies.get(i).getName()
							+ " doesn't have to plant trees because it doesn't implement the method");
				}
			}
		}
	}
	/**
	 * This method allows to realize polls to clients of a company
	 * @param nameOfCompany name of the company that has to realize the poll
	 * @param a1 answer one
	 * @param a2 answer two
	 * @param a3 anwer three
	 */
	public void realizePoll(String nameOfCompany, int a1, int a2, int a3) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i) instanceof ServiceCompany) {
					if (a1 >= 1 && a1 <= 5 && a2 >= 1 && a2 <= 5 && a3 >= 1 && a3 <= 5) {
						ServiceCompany m = (ServiceCompany) companies.get(i);

						Poll p = new Poll(a1, a2, a3);
						m.addPoll(p);
						p.setAnswer1(a1);
						p.setAnswer2(a2);
						p.setAnswer3(a3);
						System.out.println("The poll has been registered to the company " + companies.get(i).getName());
					} else {
						System.out.println("The scale is between 1 and 5. Register the poll again");
					}
				} else {
					System.out.println("The company " + companies.get(i) + " doesn't have to make polls");
				}
			}
		}
	}
	
	/**
	 * This method allows to calculate the satisfaction of clients
	 * @param nameOfCompany name of the company
	 */
	public void calculateSatisfactionClients(String nameOfCompany) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i) instanceof ServiceCompany) {
					ServiceCompany m = (ServiceCompany) companies.get(i);
					if (m.getPolls().size() > 10 && m.getPolls().size() < 50) {
						m.calculateSatisfationClient();
					} else if (m.getPolls().size() < 10) {
						System.out.println("It's necessary that the company has at least 10 polls");
					} else {
						System.out.println("It's necessary that the company only have 50 polls");
					}
				} else {
					System.out.println("The company " + companies.get(i).getName() + " doesn't realize polls");
				}
			}
		}
	}

	/**
	 * This method allows to add an employee to a cubicle
	 * @param nameOfCompany name of the company
	 * @param employeeName name of the employee
	 * @param employeeEmail email of the employee
	 * @param employeeCharge charge of the employee
	 */
	public void addEmployeToACubicleCompany(String nameOfCompany, String employeeName, String employeeEmail,
			String employeeCharge) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i).getBuilding() != null) {
					companies.get(i).getBuilding().assignCublicleEmployeeName(employeeName, employeeCharge,
							employeeEmail);
					// companies.get(i).getBuilding().assignCublicleEmployeeCharge(employeeCharge);
					// companies.get(i).getBuilding().assignCublicleEmployeeEmail(employeeEmail);
					System.out.println("The employee " + employeeName
							+ " has been assigned to the building of the company " + companies.get(i).getName());
					break;
				} else {
					System.out.println("The company " + companies.get(i).getName() + " doesn't have a building yet.");
					break;
				}

			}
		}
	}
	/**
	 * This method allows to add an employee to a cublicle of the holding
	 * @param employeeName name of the employee
	 * @param employeeEmail email of the employee
	 * @param employeeCharge charge of the employee
	 */
	public void addEmployeeToACubicleHolding(String employeeName, String employeeEmail, String employeeCharge) {
		getBuilding().assignCublicleEmployeeName(employeeName, employeeCharge, employeeEmail);
		System.out.println("The employee " + employeeName + " has been assigned to the building of the holding.");
	}

	public void showLyricToTheHaul() {
		System.out.println("1.X\n" + "2.Z\n" + "3.L\n" + "4.E\n" + "5.O\n");
	}
	
	/**
	 * this method allows to haul the building given an specific lyric
	 * @param lyric of the hauling
	 * @param nameOfCompany name of the company to haul
	 * @param employeeName name of the employee
	 */
	public void haulBuilding(String lyric, String nameOfCompany, String employeeName) {

		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (lyric.equalsIgnoreCase("x")) {
					System.out.println(companies.get(i).haulExtensionX(employeeName));
				} else if (lyric.equalsIgnoreCase("z")) {
					System.out.println(companies.get(i).haulExtensionZ(employeeName));
				} else if (lyric.equalsIgnoreCase("l")) {
					System.out.println(companies.get(i).haulExtensionL(employeeName));
				} else if (lyric.equalsIgnoreCase("e")) {
					System.out.println(companies.get(i).haulExtensionE(employeeName));
				} else if (lyric.equalsIgnoreCase("o")) {
					System.out.println(companies.get(i).haulExtensionO(employeeName));
				}
			} else {
				System.out.println("Wrong option.");
				break;
			}
		}
	}

	public void haulBuildingCompanyEmail(String nameOfCompany, String employeeCharge) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				System.out.println(companies.get(i).haulEmail(employeeCharge));
			}
		}
	}

	public void haulHolding(String lyric, String employeeName) {
		if (lyric.equalsIgnoreCase("x")) {
			System.out.println(haulExtensionX(employeeName));
		} else if (lyric.equalsIgnoreCase("z")) {
			System.out.println(haulExtensionE(employeeName));
		} else if (lyric.equalsIgnoreCase("l")) {
			System.out.println(haulExtensionL(employeeName));
		} else if (lyric.equalsIgnoreCase("e")) {
			System.out.println(haulExtensionE(employeeName));
		} else if (lyric.equalsIgnoreCase("o")) {
			System.out.println(haulExtensionO(employeeName));
		} else {
			System.out.println("Wrong option.");
		}
	}

	public void showemployeeOfACompany(String companyName) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(companyName)) {
				companies.get(i).showEmployee();
			}
		}
	}

	public void haulEmailCompanyMethod(String companyName, String chargeName) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(companyName)) {
				System.out.println(companies.get(i).haulEmail(chargeName));
			}
		}
	}

} // cierra la clase