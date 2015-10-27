package po;

import java.util.ArrayList;
<<<<<<< HEAD


import po.receiptpo.DebitBillPO;
import po.receiptpo.PaymentBillPO;
=======
import po.receiptpo.DebitBillPO;
import vo.receiptvo.PaymentBillVO;
>>>>>>> origin/master

public class BussinessProcessPO {
	/**
	 * 经营历程表
	 * 查看一段时间里的所有单据，单据分为：
	 * 入款单和出款单
	 * 筛选条件为：时间区间
	 * 显示出符合条件的单据后，可以对单据进行查看操作，但是不可修改和删除。
<<<<<<< HEAD
	*/
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
		
		public ArrayList<DebitBillPO> incomeReceipt;
		public ArrayList<PaymentBillPO> expenReceipt;
    
		public BussinessProcessPO(ArrayList<DebitBillPO> incomeReceipt, ArrayList<PaymentBillPO> expenReceipt) {
=======
	 */
	public ArrayList<DebitBillPO> incomeReceipt;
	
	public ArrayList<PaymentBillVO> expenReceipt;
	
	public BussinessProcessPO(ArrayList<DebitBillPO> incomeReceipt, ArrayList<PaymentBillVO> expenReceipt) {
>>>>>>> origin/master
		super();
		this.incomeReceipt = incomeReceipt;
		this.expenReceipt = expenReceipt;
	}
<<<<<<< HEAD
		
		
}
=======
}
>>>>>>> origin/master
