package vo.receiptvo;

import java.text.SimpleDateFormat;
import java.util.Date;

import state.ReceiptCondition;
import state.ReceiptState;
import state.ReceiptType;
import vo.ValueObject;
/**
 * 所有单据的父类，包括编号、创建时间
 * @author zsq
 */
public class ReceiptVO extends ValueObject{

	
	/**单据编号，不同的单据具有不同的编号格式**/
	public String ID;
	/**创建时间，由系统自动生成*/
	public String date;
	
	public ReceiptType type;
	
	public ReceiptState receiptState;
	
	public ReceiptCondition receiptCondition;
	
	public ReceiptVO(String id, ReceiptType type){
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	    type=this.type;
	}
	
	

	public ReceiptVO(String iD) {
		ID = iD;
	}

}
