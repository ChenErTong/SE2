package vo.accountvo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DriverVO extends AccountVO{
	//车辆编号
	public String carID;
	
	public DriverVO(String ID, String duty, String name, String birthDay, String IDCard, String phone, BigDecimal salary,
			String workTime, String carID,String branchID) {
		super(ID, duty, name, birthDay, IDCard, phone, salary, workTime,branchID,null,new ArrayList<>());
		this.carID = carID;
	}
}
