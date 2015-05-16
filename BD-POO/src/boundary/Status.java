package boundary;

public enum Status {
	
	ACEITO("Aceito"), NAO_ACEITO("N�o Aceito");
	
	private final String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	

}
