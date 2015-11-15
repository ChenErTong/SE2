package po;

import java.io.Serializable;

/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public class InventoryPO extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	OrderPO order;
	String comLocation;
	
	
	
	public InventoryPO(String id, OrderPO order, String comLocation) {
		super(id);
		this.order = order;
		this.comLocation = comLocation;
	}

	public OrderPO getOrder(){
		return order;
	}
	
	public String getComLocation(){
		return comLocation;
	}
	
	public void modifyComLocation(String newComLocation){
		comLocation = newComLocation;
	}
}