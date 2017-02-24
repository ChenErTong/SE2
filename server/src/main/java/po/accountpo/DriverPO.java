package po.accountpo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DriverPO extends AccountPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String carID;
	public DriverPO(String ID, String duty, String name, String birthDay, String IDCard, String phone, BigDecimal salary,
			String workTime,String carID,String organizationID) {
		super(ID, duty, name, birthDay, IDCard, phone, salary, workTime,organizationID,null,new ArrayList<>());
		this.carID = carID;
	}
	public String getCarID() {
		return carID;
	}
	public void setCarID(String carID) {
		this.carID = carID;
	}

}
