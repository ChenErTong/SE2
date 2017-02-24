package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

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
   
	protected PersistentObject(String id){
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.date = sdf.format(new Date());
		this.ID = id;
	}

	public PersistentObject(String iD, String date) {
		this.ID = iD;
		this.date = date;
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

	public PersistentObject() {
	}

	
	
	
	
	
	
	
}
