package businesslogic;

import java.util.ArrayList;

import vo.BussinessProcessVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.PaymentBillVO;


/**
 *  * 经营历程表
 * 查看一段时间里的所有单据，单据分为：
 
 *付款单，收款单
 * 筛选条件为：时间区间
 * 显示出符合条件的单据后，可以对单据进行查看操作，但是不可修改和删除。
 * @author lxl
 * @version 
 */
public class BusinessProcessList {
	
	ArrayList<BussinessProcessVO> VO;
	public String begin;
	public String end;
	public ArrayList<DebitBillVO> incomeReceipt;
	public ArrayList<PaymentBillVO> expenReceipt;
	
	
	public BusinessProcessList(String beginDate,String endDate) {
		this.begin=beginDate;
		this.end =endDate;
		this.VO = new ArrayList<BussinessProcessVO>();
	}
    
	public BussinessProcessVO BussinessProcess(String beginDate,String endDate) {
		BussinessProcessVO vo = new BussinessProcessVO(incomeReceipt,expenReceipt); 
		return vo;
	}

	
	
}
