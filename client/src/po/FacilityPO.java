package po;

import java.util.ArrayList;

import po.receiptpo.LoadingListPO;
/**
 * 运输工具的PO类，
 * 包括编号、监管员编号、
 * 运输历史、购入时间，
 * 编号格式为营业厅编号+日期(20150921)+五位数字编码(00000)
 * @author Ann
 *
 */
public class FacilityPO extends PersistentObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 管理员编号
	 */
	private String managerId;
	
	/**
	 * 运输历史
	 */
	private ArrayList<LoadingListPO> deliverHistory;

	public FacilityPO(String id, String date, String managerId, ArrayList<LoadingListPO> deliverHistory) {
		super(id, date);
		this.managerId = managerId;
		this.deliverHistory = deliverHistory;
	}

	public String getManagerId() {
		return managerId;
	}

	public ArrayList<LoadingListPO> getDeliverHistory() {
		return deliverHistory;
	}
}
