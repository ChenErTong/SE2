package po.accountpo;

public class DriverPO extends AccountPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String carID;
	public DriverPO(String ID, String duty, String name, String birthDay, String IDCard, String phone, double salary,
			String workTime, int receiptNum,String carID) {
		super(ID, duty, name, birthDay, IDCard, phone, salary, workTime, receiptNum);
		this.carID = carID;
	}
	public String getCarID() {
		return carID;
	}
	public void setCarID(String carID) {
		this.carID = carID;
	}

}
