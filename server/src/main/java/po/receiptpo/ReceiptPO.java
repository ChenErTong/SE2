package po.receiptpo;

import po.PersistentObject;
import state.ReceiptCondition;
import state.ReceiptState;
import state.ReceiptType;
/**
 * 所有单据的父类，包括编号、创建时间
 * @author zsq
 */
public class ReceiptPO extends PersistentObject{

	/**serializableUID*/
	private static final long serialVersionUID = 1L;
	/**单据状态*/
	protected ReceiptState receiptState;
	
	protected ReceiptCondition receiptCondition;
	
	protected ReceiptType receiptType;
	
	public ReceiptPO(String ID,ReceiptType type){
		super(ID);
		this.receiptType=type;
		this.receiptState=ReceiptState.DRAFT;
		this.receiptCondition=ReceiptCondition.DRAFT;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ReceiptState getReceiptState() {
		return receiptState;
	}

	public void setReceiptState(ReceiptState receiptState) {
		this.receiptState = receiptState;
	}

	public ReceiptCondition getReceiptCondition() {
		return receiptCondition;
	}

	public void setReceiptCondition(ReceiptCondition receiptCondition) {
		this.receiptCondition = receiptCondition;
	}

	public ReceiptType getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(ReceiptType receiptType) {
		this.receiptType = receiptType;
	}

}
