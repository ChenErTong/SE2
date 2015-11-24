package po.receiptpo;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	/**单据编号，不同的单据具有不同的编号格式**/
	protected String ID;
	/**创建时间，由系统自动生成*/
	protected String date;
	
	protected ReceiptState receiptState;
	
	protected ReceiptCondition receiptCondition;
	
	protected ReceiptType receiptType;
	
	public ReceiptPO(String ID){
		super(ID);
		this.ID = ID;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}

	public ReceiptPO(String iD, String date) {
		super(iD, date);
	}
	
	
	
	

}
