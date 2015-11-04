package po;

import java.io.Serializable;

/**
 *所有PO类的父类，包括创建时间、编号
 * @author zsq
 * @version Oct 22,2015
 *
 */
public class PersistentObject implements Serializable{

	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**单据编号，格式根据不同单子具有不同的格式*/
	protected String ID;
	/**时间*/
	protected String date;
	
	protected PersistentObject(String id){
		this.ID = id;
	}

	public PersistentObject(String iD, String date) {
		super();
		ID = iD;
		this.date = date;
	}
	
	
}
