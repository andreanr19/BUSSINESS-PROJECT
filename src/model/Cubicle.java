package model;

public class Cubicle {

	private String employeeName;
	private String employeeCharge;
	private String employeeEmail;
	private String extension;
	private boolean availableCubicle;

	private Building theBuilding;

	public Cubicle(String extension, boolean availableCubicle) {

		this.extension = extension;
		this.availableCubicle = availableCubicle;

	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCharge() {
		return employeeCharge;
	}

	public void setEmployeeCharge(String employeeCharge) {
		this.employeeCharge = employeeCharge;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public boolean getAvailableCubicle() {
		return availableCubicle;
	}

	public void setAvailableCubicle(boolean availableCubicle) {
		this.availableCubicle = availableCubicle;
	}

	public Building getTheBuilding() {
		return theBuilding;
	}

	public void setTheBuilding(Building theBuilding) {
		this.theBuilding = theBuilding;
	}

	public String haulEmailEmployeed(String employeeCharge) {
		String msg = "";
		if (getAvailableCubicle() == true) {

			if (this.employeeCharge.equals(employeeCharge)) {
				msg += getEmployeeEmail();
			}

		}
		return msg;

	}

	/**
	 * This method allows to haul a extension of an employee
	 * @param employeeName the name of the employee
	 * @return an String with the extension of the employees
	 */
	public String haulExtensionEmployee(String employeeName) {
		String msg = "";
		if (getAvailableCubicle() == true) {
			if (this.employeeName.equals(employeeName)) {
				msg += getExtension();
			}
		}
		return msg;
	}

}
