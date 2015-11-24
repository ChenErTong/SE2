package po.accountpo;

import state.ReceiptType;

public class DriverPO extends AccountPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DriverPO(String ID, ReceiptType type,String duty, String name, String birthDay, String IDCard, String phone, double salary,
			String workTime, int receiptNum) {
		super(ID, type, duty, name, birthDay, IDCard, phone, salary, workTime, receiptNum);
		// TODO Auto-generated constructor stub
	}

	

}
