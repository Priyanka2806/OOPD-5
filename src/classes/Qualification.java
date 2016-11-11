package classes;

public class Qualification {

	private int qualificationId;
	private String description;
	
	
	public Qualification() {
		super();
	}


	public Qualification(int qualificationId, String description) {
		super();
		this.qualificationId = qualificationId;
		this.description = description;
	}


	public int getQualificationId() {
		return qualificationId;
	}


	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
