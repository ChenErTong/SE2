package vo;

import state.ReceiptType;

/**
 * ֵ����
 * @author zsq
 * @version Oct 22,2015
 */
public class ValueObject {
	public String ID;
	public String date;
	public ReceiptType type;
	public ValueObject(String iD,ReceiptType type) {
		super();
		ID = iD;
		this.type=type;
		
	}
	


}
