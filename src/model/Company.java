package model;

public abstract class Company implements HaulBuilding {
	
	public final static String AHFF= "AGRICULTURE, HUNTING, FORESTRY AND FISHING";
	public final static String EMQ="EXPLOTATION, MINES AND QUARRIES";
	public final static String MI="MANUFACTURING INDUSTRY";
	public final static String EGS="ELECTRICITY, GAS AND STEAM";
	public final static String B="BUILDING";
	public final static String WR="WHOLESALE AND RETAIL";
	public final static String TSC="TRANSPORTATION STORAGE COMMUNICATIONS";
	public final static String FS="FINANCIAL STATEMENT";
	public final static String CS="COMUNAL AND SOCIAL";
	
	//ATRIBUTTES
	private String name;
	private String nit;
	private String address;
	private String phone;
	private int amountOfEmployees;
	private double assetValue;
	private int constitutionDay;
	private int constitutionMonth;
	private int constitutionYear;
	private String type;
	private String legalRepresentative;
	
	private Building building;
	
	public Company(String name, String nit, String address, String phone, int amountOfEmployees, double assetValue,
			int constitutionDay, int constitutionMonth, int constitutionYear, String type, String legalRepresentative) {
		this.name = name;
		this.nit = nit;
		this.address = address;
		this.phone = phone;
		this.amountOfEmployees = amountOfEmployees;
		this.assetValue = assetValue;
		this.constitutionDay = constitutionDay;
		this.constitutionMonth = constitutionMonth;
		this.constitutionYear = constitutionYear;
		this.type = type;
		this.legalRepresentative = legalRepresentative;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAmountOfEmployees() {
		return amountOfEmployees;
	}
	public void setAmountOfEmployees(int amountOfEmployees) {
		this.amountOfEmployees = amountOfEmployees;
	}
	public double getAssetValue() {
		return assetValue;
	}
	public void setAssetValue(double assetValue) {
		this.assetValue = assetValue;
	}
	public int getConstitutionDay() {
		return constitutionDay;
	}
	public void setConstitutionDay(int constitutionDay) {
		this.constitutionDay = constitutionDay;
	}
	public int getConstitutionMonth() {
		return constitutionMonth;
	}
	public void setConstitutionMonth(int constitutionMonth) {
		this.constitutionMonth = constitutionMonth;
	}
	public int getConstitutionYear() {
		return constitutionYear;
	}
	public void setConstitutionYear(int constitutionYear) {
		this.constitutionYear = constitutionYear;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	
	
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	
	/**
	 * This method allows to haul the building in spiral
	 * @param chargeEmployeed It's the employee's charge
	 */
	public String haulEmail(String chargeEmployeed){

		int filas = 0;
		int columnas = 0;
		int numCeldas = 0;
		int totalCeldas = (building.getCublicles().length * building.getCublicles()[0].length);
		int minY = 0;
		int minX = 0;
		int maxY = building.getCublicles().length-1;
		int maxX = building.getCublicles()[0].length-1;
		int direccion = HaulBuilding.ABAJO;
		String msg = "";

		while (numCeldas < totalCeldas){

			switch (direccion){

				case ABAJO:

					filas++;
					if(filas == maxY){
						direccion = HaulBuilding.DERECHA;
						minX++;
					}

					msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

				case DERECHA:

					columnas++;
					if (columnas == maxX){
						direccion = HaulBuilding.ARRIBA;
						maxY--;
					}

					msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

				case ARRIBA:
					filas--;
					if (filas == minY){
						direccion = HaulBuilding.IZQUIERDA;
						maxX--;
					}

					msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

				case IZQUIERDA:
					columnas--;
					if (columnas == minX){
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

	//RECORRIDO EN Z
	public String haulExtensionZ(String nameEmployeed) {
		
		String msg="";
		for(int i=0; i<building.getCublicles().length;i++) {
			msg+= building.getCublicles()[0][i].haulExtensionEmployee(nameEmployeed)+ "\n";
		}
		for(int k=1;k<building.getCublicles().length;k++) {
			msg+=building.getCublicles()[k][building.getCublicles().length-k];
		}
		for(int j=1; j<building.getCublicles().length;j++) {
			msg+= building.getCublicles()[building.getCublicles().length][j];
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

		public void showTypeOfCompanies() {
			System.out.println("1.Manufacturing Company \n" + "2.Medicine Manufacturing Company \n" + "3.Service Company \n"
					+ "4.Public Service Company \n" + "5.Education Company \n" + "6.Technological Company");
		}
		
		public void showEmployee() {
		getBuilding().employeesName();
		}
}
