package po;

import java.util.ArrayList;

import po.receiptpo.LoadingListPO;

public class FacilityPO extends PersistentObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3096881770967373957L;

	/**
	 * 管理员编号
	 */
	private String managerId;
	
	private String date;
	
	/**
	 * 运输历史
	 */
	private ArrayList<LoadingListPO> deliverHistory;
	/**
	 * 底盘号
	 */
	private String bottomCode;
	/**
	 * 发动机号
	 */
	private String engineCode;

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

	public String getDate() {
		return date;
	}

	public FacilityPO(String id, String managerId, String date, ArrayList<LoadingListPO> deliverHistory,
			String bottomCode, String engineCode) {
		super(id);
		this.managerId = managerId;
		this.date = date;
		this.deliverHistory = deliverHistory;
		this.bottomCode = bottomCode;
		this.engineCode = engineCode;
	}

	public String getBottomCode() {
		return bottomCode;
	}

	public String getEngineCode() {
		return engineCode;
	}
	
	


}
