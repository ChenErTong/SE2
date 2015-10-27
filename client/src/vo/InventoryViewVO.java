package vo;

import java.util.ArrayList;

public class InventoryViewVO {

	  /** @author lxl
		 *  @version Oct 23,2015
		 *      **/
		
	/** 出库数量 **/
	public int exportNumber;
	/** 入库数量）**/
	public int importNumber;

	
	public ArrayList<InventoryVO> InventoryCondition;
	
	public InventoryViewVO(int exportNumber, int importNumber, ArrayList<InventoryVO> InventoryCondition) {
		super();
		this.exportNumber = exportNumber;
		this.importNumber = importNumber;
		this.InventoryCondition=InventoryCondition;
	}
	
	
	
	
}
