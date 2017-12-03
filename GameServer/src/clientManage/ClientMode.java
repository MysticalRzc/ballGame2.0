package clientManage;

public class ClientMode {
	private int clientId = -1;
	private String address = null;
	private int recePort = -1;
	private int value;

	public ClientMode(int clientId, String address, int recePort) {
		super();
		this.clientId = clientId;
		this.address = address;
		this.recePort = recePort;
	}

	public int getClientId() {
		return clientId;
	}

	public String getAddress() {
		return address;
	}

	public int getRecePort() {
		return recePort;
	}

	public int getValue() {
		return value;
	}

	void setClientId(int clientId) {
		this.clientId = clientId;
	}

	void setAddress(String address) {
		this.address = address;
	}

	void setRecePort(int recePort) {
		this.recePort = recePort;
	}

	void setValue(int value) {
		this.value = value;
	}
}
