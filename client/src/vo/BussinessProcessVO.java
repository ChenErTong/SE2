package vo;
import java.util.ArrayList;

import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;
<<<<<<< HEAD
/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public class BussinessProcessVO {
=======
	/** @author lxl
	 *  @version Oct 23,2015   
	 */
	public class BussinessProcessVO {
>>>>>>> origin/master
	/**
	 * 经营历程表
	 * 查看一段时间里的所有单据，单据分为：
	 * 入款单和出款单
	 * 筛选条件为：时间区间
	 * 显示出符合条件的单据后，可以对单据进行查看操作，但是不可修改和删除。
<<<<<<< HEAD
	*/

		
		public ArrayList<DebitBillVO> incomeReceipt;
		public BussinessProcessVO(ArrayList<DebitBillVO> incomeReceipt, ArrayList<PaymentBillVO> expenReceipt) {
=======
	 */
	public ArrayList<DebitBillVO> incomeReceipt;
	
	public BussinessProcessVO(ArrayList<DebitBillVO> incomeReceipt, ArrayList<PaymentBillVO> expenReceipt) {
>>>>>>> origin/master
		super();
		this.incomeReceipt = incomeReceipt;
		this.expenReceipt = expenReceipt;
	}
<<<<<<< HEAD
		public ArrayList<PaymentBillVO> expenReceipt;
		
		
		
		
	
}
		
		
=======
	
	public ArrayList<PaymentBillVO> expenReceipt;
}
>>>>>>> origin/master
