package po;

import java.util.ArrayList;


import po.receiptpo.DebitBillPO;
import po.receiptpo.PaymentBillPO;

public class BussinessProcessPO extends PersistentObject{
	/**
	 * 经营历程表
	 * 查看一段时间里的所有单据，单据分为：
	 * 入款单和出款单
	 * 筛选条件为：时间区间
	 * 显示出符合条件的单据后，可以对单据进行查看操作，但是不可修改和删除。
	*/
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
		
		public ArrayList<DebitBillPO> incomeReceipt;
		public ArrayList<PaymentBillPO> expenReceipt;
    
		public BussinessProcessPO(String id,ArrayList<DebitBillPO> incomeReceipt, ArrayList<PaymentBillPO> expenReceipt) {
		super(id);
		this.incomeReceipt = incomeReceipt;
		this.expenReceipt = expenReceipt;
	}
		
		
}
