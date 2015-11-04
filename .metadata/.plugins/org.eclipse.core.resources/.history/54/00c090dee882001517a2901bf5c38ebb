package po.receiptpo;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

import po.PersistentObject;
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
	
	public ReceiptPO(String ID){
		super(ID);
		this.ID = ID;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}
	

}
