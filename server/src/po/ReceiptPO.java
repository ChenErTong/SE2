package po;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

import po.PersistentObject;
/**
 * ���е��ݵĸ��࣬������š�����ʱ��
 * @author zsq
 */
public class ReceiptPO extends PersistentObject{

	/**serializableUID*/
	private static final long serialVersionUID = 1L;
	
	/**���ݱ�ţ���ͬ�ĵ��ݾ��в�ͬ�ı�Ÿ�ʽ**/
	protected String ID;
	/**����ʱ�䣬��ϵͳ�Զ�����*/
	protected String date;
	
	public ReceiptPO(String ID){
		this.ID = ID;
		/**�Զ���������*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm--dd HH:mm");
		date = sdf.format(new Date());
	}
	

}
