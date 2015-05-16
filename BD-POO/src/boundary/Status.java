package boundary;

public enum Status {
	
	ACEITO("Aceito"), NAO_ACEITO("N�o Aceito");
	
	private final String STATUS;

	private Status(String status) {
		this.STATUS = status;
	}

	public String getStatus() {
		return STATUS;
	}
	
	

}
