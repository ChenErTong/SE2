package vo.receiptvo;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

import po.PersistentObject;
import vo.ValueObject;
/**
 * 所有单据的父类，包括编号、创建时间
 * @author zsq
 */
public class ReceiptVO extends ValueObject{

	/**serializableUID*/
	private static final long serialVersionUID = 1L;
	
	public ReceiptVO(String id){
		super(id);
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}
}
