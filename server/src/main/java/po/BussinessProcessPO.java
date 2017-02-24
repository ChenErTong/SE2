package po;

import java.util.ArrayList;

import po.receiptpo.DebitAndPayBillPO;

public class BussinessProcessPO extends PersistentObject {
	/**
	 * 经营历程表 查看一段时间里的所有单据，单据分为： 入款单和出款单 筛选条件为：时间区间
	 * 显示出符合条件的单据后，可以对单据进行查看操作，但是不可修改和删除。
	 */
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private ArrayList<DebitAndPayBillPO> receipt;
	private String beginDate;
	private String endDate;

	public BussinessProcessPO(String id, ArrayList<DebitAndPayBillPO> receipt, String beginDate, String endDate) {
		super(id);
		this.receipt = receipt;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public ArrayList<DebitAndPayBillPO> getReceipt() {
		return receipt;
	}

	public void setReceipt(ArrayList<DebitAndPayBillPO> receipt) {
		this.receipt = receipt;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
