package po;

import java.io.Serializable;

import state.ReceiptType;

/**
 *所有PO类的父类，包括创建时间、编号
 * @author zsq
 * @version Oct 22,2015
 *
 */

public class PersistentObject implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**单据编号，格式根据不同单子具有不同的格式*/
	protected String ID;
	/**时间*/
	protected String date;
   
	protected ReceiptType type;
	protected PersistentObject(String id,ReceiptType type){
		this.ID = id;
		this.type=type;
	}

	public PersistentObject(String iD, String date,ReceiptType type) {
		super();
		ID = iD;
		this.date = date;
		this.type=type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ReceiptType getType() {
		return type;
	}

	public void setType(ReceiptType type) {
		this.type = type;
	}
	
	
	
	
	
	
	
}
