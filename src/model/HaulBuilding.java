package model;

public interface HaulBuilding {

	public final static int ABAJO = 1;
	public final static int DERECHA = 2;
	public final static int ARRIBA = 3;
	public final static int IZQUIERDA = 4;
	
	public String haulEmail(String chargeEmployeed);
	public String haulExtensionL(String nameEmployeed);
	public String haulExtensionZ(String nameEmployeed);
	public String haulExtensionX(String nameEmployeed);
	public String haulExtensionO(String nameEmployeed);
	public String haulExtensionE(String nameEmployeed);

}