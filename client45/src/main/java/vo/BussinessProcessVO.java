package vo;

import java.util.ArrayList;

import vo.receiptvo.DebitAndPayBillVO;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public class BussinessProcessVO {
	/**
	 * 经营历程表 查看一段时间里的所有单据，单据分为： 入款单和出款单 筛选条件为：时间区间
	 * 显示出符合条件的单据后，可以对单据进行查看操作，但是不可修改和删除。
	 */
	public ArrayList<DebitAndPayBillVO> receipt;
	public String beginDate;
	public String endDate;
	public BussinessProcessVO(ArrayList<DebitAndPayBillVO> receipt, String beginDate, String endDate) {
		this.receipt = receipt;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	

}
