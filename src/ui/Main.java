package ui;

import java.util.*;
import model.*;

public class Main {

	private Holding myHolding;
	private Scanner input;

	public Main() {
		init();
		input = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}

	public void showMenu() {
		int option = 0;

		while (option != 20) {

			showOptions();
			option = input.nextInt();
			input.nextLine();
			if (option == 1) {

				System.out.println("Enter the company's name");
				String cn = input.nextLine();
				System.out.println("Enter the company's nit");
				String cnit = input.nextLine();
				System.out.println("Enter the company's address");
				String ca = input.nextLine();
				System.out.println("Enter the company's phone");
				String cp = input.nextLine();
				System.out.println("Enter the company's amount of employees");
				int ce = Integer.parseInt(input.nextLine());
				System.out.println("Enter the company's asset value");
				double cav = Double.parseDouble(input.nextLine());
				System.out.println("Enter the company's constitutation day");
				int cd = Integer.parseInt(input.nextLine());
				System.out.println("Enter the company's constitutation month");
				int cm = Integer.parseInt(input.nextLine());
				System.out.println("Enter the company's constitutation year");
				int cy = Integer.parseInt(input.nextLine());
				System.out.println("Wich one of the following is the company's type. Please enter the number");
				myHolding.showthetypesofcompanies();
				String type = input.nextLine();
				String typeF = myHolding.showTcompany(type);
				System.out.println("Enter the name of the legal representative");
				String lrc = input.nextLine();
				System.out.println("What kind of company is the company goint to be?");
				myHolding.showTypeOfCompanies();
				String option2 = input.nextLine();
				if (option2.equals("1")) {
					ManufacturingCompany m = new ManufacturingCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF,
							lrc);
					myHolding.addCompany(m);
					System.out.println(
							"How many floor do you want the building to have? Please, enter a number between 3 and 7");
					int numberOfFloors = input.nextInt();
					myHolding.addBuildingToACompany2(cn, numberOfFloors);

					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("2")) {
					System.out.println("Enter the sanitary registration");
					String sr = input.nextLine();
					System.out.println("Enter the status");
					String st = input.nextLine();
					System.out.println("Enter the expiration month");
					int em = Integer.parseInt(input.nextLine());
					System.out.println("Enter the expiration year");
					int ey = Integer.parseInt(input.nextLine());
					System.out.println("Wich of the following is the company's modality");
					myHolding.showModalityMedicineCompany();
					String opp = input.nextLine();

					String modality = myHolding.modalityMedicineCompany(opp);
					MedicineManufacturingCompany m = new MedicineManufacturingCompany(cn, cnit, ca, cp, ce, cav, cd, cm,
							cy, typeF, lrc, sr, st, em, ey, modality);
					myHolding.addCompany(m);
					System.out.println(
							"How many floor do you want the building to have? Please, enter a number between 3 and 7");
					int numberOfFloors = input.nextInt();
					myHolding.addBuildingToACompany2(cn, numberOfFloors);

				} else if (option2.equals("3")) {
					ServiceCompany m = new ServiceCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF, lrc);
					myHolding.addCompany(m);
					System.out.println(
							"How many floor do you want the building to have? Please, enter a number between 3 and 7");
					int numberOfFloors = input.nextInt();
					myHolding.addBuildingToACompany2(cn, numberOfFloors);

					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("4")) {
					System.out.println("Which of the following is the company's type of service");
					myHolding.showtypeOfServicePSC();
					String opp = input.nextLine();
					String typeOfService = myHolding.typeOfServicePSC(opp);
					System.out.println("Enter the number of the total of suscribers");
					int suscribersT = Integer.parseInt(input.nextLine());
					System.out.println("Enter the number of the suscribers stratum 1 and 2");
					int suscribers1and2 = input.nextInt();
					PublicServiceCompany m = new PublicServiceCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF, lrc,
							typeOfService, suscribersT, suscribers1and2);
					myHolding.addCompany(m);
					System.out.println(
							"How many floor do you want the building to have? Please, enter a number between 3 and 7");
					int numberOfFloors = input.nextInt();
					myHolding.addBuildingToACompany2(cn, numberOfFloors);

					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("5")) {
					System.out.println("Enter registration number");
					int rn = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's high quality identity years");
					int hgy = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's saber11 national position");
					int s11 = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's saberPro national position");
					int spro = Integer.parseInt(input.nextLine());
					System.out.println("Enter company's rector name");
					String rectorn = input.nextLine();
					System.out.println("Enter the company's education sector");
					String es = input.nextLine();
					System.out.println("Enter the company's stratum");
					int stratum = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's active students of stratum 1 and 2 ");
					int s1and2 = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's total active students");
					int st = input.nextInt();
					EducationCompany m = new EducationCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF, lrc, rn,
							hgy, s11, spro, rectorn, es, stratum, s1and2, st);

					myHolding.addCompany(m);
					System.out.println(
							"How many floor do you want the building to have? Please, enter a number between 3 and 7");
					int numberOfFloors = input.nextInt();
					myHolding.addBuildingToACompany2(cn, numberOfFloors);

					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("6")) {
					System.out.println("Enter the amount of energy used in the company");
					double amountOfEnergyUsed = input.nextDouble();
					TechnologicalCompany m = new TechnologicalCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF, lrc,
							amountOfEnergyUsed);

					System.out.println(
							"How many floor do you want the building to have? Please, enter a number between 3 and 7");
					int numberOfFloors = input.nextInt();
					myHolding.addBuildingToACompany2(cn, numberOfFloors);
					myHolding.addCompany(m);

					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("7")) {
					System.out.println("Enter the name of the importer");
					String importer = input.nextLine();
					System.out.println("Enter the name of the marker");
					String marker = input.nextLine();
					System.out.println("Which of the following is the company's type of service");
					myHolding.showTypesOfServicesFMC();
					String opp = input.nextLine();
					String typefmc = myHolding.typeOfServicesFMC(opp);
					FoodManufacturingCompany m = new FoodManufacturingCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy,
							typeF, lrc, importer, marker, typefmc);
					myHolding.addCompany(m);

					System.out.println(
							"How many floor do you want the building to have? Please, enter a number between 3 and 7");
					int numberOfFloors = input.nextInt();
					myHolding.addBuildingToACompany2(cn, numberOfFloors);
					System.out.println("Congrats. The company has been created");

				} else {
					System.out.println("Wrong option");
				}

			} else if (option == 2) {
				System.out.println("Wich one of the following companies you'd like to add a building. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println(
						"How many floor do you want the building to have? Please, enter a number between 3 and 7");
				int numberOfFloors = input.nextInt();
				myHolding.addBuildingToACompany2(nameOfCompany, numberOfFloors);
			} else if (option == 3) {
				System.out.println("Wich one of the following companies you'd like to add a product. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println("Enter the name of the product");
				String np = input.nextLine();
				System.out.println("Enter the code of the product");
				String cp = input.nextLine();
				System.out.println("Enter the amount of water used in the product");
				double wp = Double.parseDouble(input.nextLine());
				System.out.println("Enter the number of units in inventory of the product");
				int ip = input.nextInt();
				myHolding.addProductsToACompany(nameOfCompany, np, cp, wp, ip);
			} else if (option == 4) {
				System.out.println(
						"Wich one of the following companies you'd like to calculate proculture tax. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				myHolding.calculateProcultureTax(nameOfCompany);
			} else if (option == 5) {
				System.out.println(
						"Wich one of the following companies you'd like to calculate the trees it has to plant. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				myHolding.calculateNaturalResource(nameOfCompany);
			} else if (option == 6) {
				System.out
						.println("Wich one of the following companies you'd like to register its poll. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println(
						"1.On a scale of 1 to 5 where 1 is not satisfied and 5 is very satisfied how satisfied you are with the service provided");
				int a1 = Integer.parseInt(input.nextLine());
				System.out.println(
						"2.On a scale of 1 to 5 where 1 is not satisfied and 5 is very satisfied how satisfied you are with the response time given");
				int a2 = Integer.parseInt(input.nextLine());
				System.out.println(
						"3.On a scale of 1 to 5 where 1 is not satisfied and 5 is very satisfied how satisfied you are with the cost "
								+ "/ benefit ratio of the service purchased");
				int a3 = input.nextInt();

				myHolding.realizePoll(nameOfCompany, a1, a2, a3);
			} else if (option == 7) {
				System.out
						.println("Wich one of the following companies you'd like to register its poll. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				myHolding.calculateSatisfactionClients(nameOfCompany);
			} else if (option == 8) {
				System.out.println("Wich one of the following companies you'd like to add a employee to its building");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println("Enter the employee's name");
				String en = input.nextLine();
				System.out.println("Enter the employee's charge");
				String ec = input.nextLine();
				System.out.println("Enter the employee's email");
				String ee = input.nextLine();
				myHolding.addEmployeToACubicleCompany(nameOfCompany, en, ee, ec);

			} else if (option == 9) {
				System.out.println("Wich one of the following companies you'd like to haul. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println("Those are the employees of the company");
				myHolding.showemployeeOfACompany(nameOfCompany);
				System.out.println("Enter the employee's name");
				String en = input.nextLine();
				System.out.println("Enter the lyric you want to haul the building.Enter the name");
				myHolding.showLyricToTheHaul();
				String lyric = input.nextLine();
				myHolding.haulBuilding(lyric, nameOfCompany, en);
			} else if (option == 10) {
				System.out.println("Enter the employee's name");
				String en = input.nextLine();
				System.out.println("Enter the employee's charge");
				String ec = input.nextLine();
				System.out.println("Enter the employee's email");
				String ee = input.nextLine();
				myHolding.addEmployeeToACubicleHolding(en, ee, ec);
			} else if (option == 11) {
				System.out.println("Enter the employee's name");
				String en = input.nextLine();
				System.out.println("Enter the lyric you want to haul the building.Enter the name");
				myHolding.showLyricToTheHaul();
				String lyric = input.nextLine();
				myHolding.haulHolding(lyric, en);
			} else if (option == 12) {
				System.out.println("Wich one of the following companies you'd like to haul. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println("Enter the name of the charge");
				String chargeName = input.nextLine();
				myHolding.haulEmailCompanyMethod(nameOfCompany, chargeName);
			} else if (option == 13) {
				System.out.println("Enter the name of the charge");
				String chargeName = input.nextLine();
				myHolding.haulEmail(chargeName);
			} else if (option == 14) {
				System.out.println("Wich one of the following companies you'd like to add a product. Enter the name.");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println("What type of service you want to add?.Enter the number");
				myHolding.showTypeOfServicesTC();
				String opp = input.nextLine();
				String type = myHolding.typeOfServicesTC(opp);
				myHolding.addServiceToTechnologicalCompany(nameOfCompany, type);
			} else if (option == 15) {
				System.out.println("Wich one of the following companies you'd like to haul. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println("Enter the name of the employee");
				String nameEmployee = input.nextLine();
				System.out.println("Enter the lyric for the haul.");
				myHolding.showLyricToTheHaul();
				String lyric = input.nextLine();
				myHolding.haulBuilding(lyric, nameOfCompany, nameEmployee);
			}
		}

	}

	public void showOptions() {
		System.out.println("WELCOME TO THE HOLDING. WHAT WOULD YOU LIKE TO DO?");
		System.out.println("1.To register a company");
		System.out.println("2.To add a building to a company");
		System.out.println("3.To add products to a company");
		System.out.println("4.To calculate the proculture tax of a company");
		System.out.println(
				"5.To calculate how many trees a company has to plant based on the amount of the natural resource used");
		System.out.println("6.To register a poll for a company");
		System.out.println("7.To calculate the satisfaction of the clients for a company");
		System.out.println("8.To add an employee to a cubicle in a company's building");
		System.out.println("9.To haul a building of the company for searching the extension of an employee");
		System.out.println("10.To add an employee to a cubicle in the holding");
		System.out.println(
				"11.To haul the building of the holding for searching the extension of an employee given an specific name");
		System.out.println(
				"12.To haul a building of the company for searching the email of the employee given an specific charge");
		System.out.println("13.To haul the holding for searching the email of the employee given an specific charge");
		System.out.println("14.To add a service to a technological company.");
		System.out.println(
				"15.To haul the building of a company of the holding for searching the extension of an employee given an specific name");

	}

	public void init() {
		myHolding = new Holding("Holding S.A");

		ServiceCompany sc1 = new ServiceCompany("PINIVA SERVICES", "1010138801", "Kra9 Av 9", "2670039", 2, 5000000, 3,
				6, 2019, Company.TSC, "Andrea Nunez");
		myHolding.addEmployeToACubicleCompany("PINIVA SERVICES", "Luke Hemmings", "@luke5sos", "singer");
		
		TechnologicalCompany tc1 = new TechnologicalCompany("Fever Technological SAS", "1010138803", "kra3", "333", 2,
				2000000, 3, 6, 2019, Company.CS, "Armin", 20);
		myHolding.addEmployeToACubicleCompany("Fever Technological SAS", "Calum Hood", "@Calum5SOS", "Bassist");
		myHolding.addServiceToTechnologicalCompany("Fever Technological SAS", Service.CONSULTANCY );
		
		EducationCompany edc1 = new EducationCompany("Tio Conejo", "1010138804", "kra3", "444", 2, 50000000, 3, 6, 2019,
				Company.FS, "Eren", 0001, 5, 4, 2, "Levi", "UpLevel", 5, 200, 400);
		myHolding.addEmployeToACubicleCompany("Tio Conejo", "Michael Clifford", "@Michael5SOS", "Singer");
		
		PublicServiceCompany psc1 = new PublicServiceCompany("Acuavalle SA", "1010138805", "Kra5", "555", 2, 7000000, 3,
				3, 2019, Company.EGS, "Erwin", PublicServiceCompany.AQUEDUCT, 1000, 500);
		myHolding.addEmployeToACubicleCompany("Acuavalle SA", "Ashton Irwin", "@Ashton5S0S", "Drummer");
		
		ManufacturingCompany mn1 = new ManufacturingCompany("The Middle SAS", "1010138802", "Kra2", "2222", 2, 10000000,
				3, 6, 2019, Company.MI, "Beck");
		myHolding.addEmployeToACubicleCompany("The Middle SAS", "Ruben Doblas","@RubiosOMG"	,"Youtuber");
		
		MedicineManufacturingCompany mc1 = new MedicineManufacturingCompany("San Roque", "1010138806", "Kra6", "6666",
				2, 3000000, 3, 6, 2019, Company.FS, "Mikasa", "222", "Uplevel", 6, 2019,
				MedicineManufacturingCompany.MANUFACTURE_AND_EXPORT);
		myHolding.addEmployeToACubicleCompany("San Roque", "Doctor Negrete", "@DoctorNegrete", "Doctor");
		
		FoodManufacturingCompany fmc1 = new FoodManufacturingCompany("LAS VACAS SAS", "10101355", "KRA 44", "3223", 7,
				50000000, 7, 6, 2019, Company.MI, "Santiago Valencia", "Levi Ackerman", "Kenny Ackerman",
				FoodManufacturingCompany.F);
		myHolding.addEmployeToACubicleCompany("LAS VACAS SAS", "German Garmendia", "@gERman", "Youtuber");

		myHolding.addCompany(sc1);
		myHolding.addCompany(tc1);
		myHolding.addCompany(edc1);
		myHolding.addCompany(psc1);
		myHolding.addCompany(mn1);
		myHolding.addCompany(mc1);
		myHolding.addCompany(fmc1);

		Building buildingHolding = new Building(4);
		myHolding.setBuilding(buildingHolding);

		Building buildingService = new Building(4);
		sc1.setBuilding(buildingService);

		Building buildingTechnology = new Building(4);
		tc1.setBuilding(buildingTechnology);

		Building buildingEducation = new Building(4);
		edc1.setBuilding(buildingEducation);

		Building buildingPservice = new Building(4);
		psc1.setBuilding(buildingPservice);

		Building buildingMCompany = new Building(4);
		mn1.setBuilding(buildingMCompany);

		Building buildingMedicineC = new Building(4);
		mc1.setBuilding(buildingMedicineC);

		Building buildingFoodC = new Building(4);
		fmc1.setBuilding(buildingFoodC);
		
		Product mc = new Product("Televisor", "000", 50, 10);
		mn1.addProducts(mc);
		
		
		Product md =new Product("Acetaminofen", "001", 500, 500);
		mc1.addProducts(md);
		

		Product fp= new Product("Pollo", "0099", 5, 23);
		fmc1.addProducts(fp);
		
		Poll sp=new Poll(3, 4, 4);
		sc1.addPoll(sp);
		
		Poll spc=new Poll(5, 5, 5);
		psc1.addPoll(spc);
		
		

	}

}
