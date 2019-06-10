package model;

import java.util.*;

public class Building {

	// Constantes

	public final static int NUMBER_CUBICLE = 20;

	// Atributos

	private int numberOfFloors;

	// Relaciones

	private Cubicle[][] cublicles;

	// Metodos
	/**
	 * this method allows to initialize the cublicles with an extension
	 */
	public void cubiclesInitilized() {
		for (int f = 0; f < cublicles.length; f++) {
			for (int c = 0; c < cublicles[0].length; c++) {

				cublicles[f][c] = new Cubicle("80" + f + c, false);
			}
		}
	}

	// Constructor

	public Building(int numberOfFloors) {

		this.numberOfFloors = numberOfFloors;
		cublicles = new Cubicle[numberOfFloors][NUMBER_CUBICLE];
		cubiclesInitilized();
	}

	public Cubicle[][] getCublicles() {
		return cublicles;
	}

	public void setCublicles(Cubicle[][] cublicles) {
		this.cublicles = cublicles;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	/**
	 * this method allows to haul a cubicle
	 * @param employeeCharge the charge of the employee
	 * @return an string with the charge of the employee
	 */
	public String haulEmailEmployeed(String employeeCharge) {
		String msg = "";

		for (int i = 0; i < cublicles.length; i++) {
			for (int j = 0; j < cublicles[i].length; j++) {
				if (cublicles[i][j].getAvailableCubicle() == true) {
					msg += cublicles[i][j].getEmployeeCharge() + "\n";
				}
			}
		}
		return msg;
	}
	/**
	 * This method allows to assign a cublicle to a employee
	 * @param employeeName name of the employee
	 * @param employeeCharge charge of the employee
	 * @param employeeEmail email of the employee
	 */
	public void assignCublicleEmployeeName(String employeeName,  String employeeCharge, String employeeEmail) {
		boolean t = false;
		
		for (int i = 0; i < cublicles.length && !t; i++) {
			for (int j = 0; j < cublicles[i].length && !t; j++) {
				if (cublicles[i][j].getAvailableCubicle() == false) {
					cublicles[i][j].setEmployeeName(employeeName);
					cublicles[i][j].setEmployeeCharge(employeeCharge);
					cublicles[i][j].setEmployeeEmail(employeeEmail);
					cublicles[i][j].setAvailableCubicle(true);
					t = true;
				}
			}
		}
	}
	
	
	public void employeesName() {
		String msg="";
		for(int i=0; i<cublicles.length;i++) {
			for(int j=0; j<cublicles[i].length;j++) {
				if(cublicles[i][j].getAvailableCubicle()==true) {
					msg+=cublicles[i][j].getEmployeeName() + "\n";
				}
			}
		}
		System.out.println(msg);
	}
}

