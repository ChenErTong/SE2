package vo.accountvo;

import java.math.BigDecimal;

public class DriverVO extends AccountVO{
	//车辆编号
	public String carID;
	
	public DriverVO(String ID, String duty, String name, String birthDay, String IDCard, String phone, BigDecimal salary,
			String workTime, String carID,String branchID) {
		super(ID, duty, name, birthDay, IDCard, phone, salary, workTime,branchID,null);
		this.carID = carID;
	}
}
