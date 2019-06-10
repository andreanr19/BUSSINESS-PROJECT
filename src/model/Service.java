package model;

public class Service {

	public final static String CONSULTANCY="Consultancy";
	public final static String TRAINING="Training";
	public final static String DEVELOPMENT_OF_CUSTOM_SOFTWARE="Development of custom software";
	public final static String INFRAESTRUCTURE="InsfrastructureService";
	public final static String SOFTWARE="Software Service";
	public final static String PLATFORM="Platform Service";
	
	private String type;

	public Service(String type) {
		
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
