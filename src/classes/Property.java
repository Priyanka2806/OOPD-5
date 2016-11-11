package classes;

public class Property {

	private int propertyId;
	private String propertyName;
	private String desciption;
	
	public Property(int propertyId, String propertyName, String desciption) {
		super();
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.desciption = desciption;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
	
}
