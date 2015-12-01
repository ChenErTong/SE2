package vo;

import java.util.ArrayList;

/**
 * @author lxl
 * @version Oct 23,2015
 **/
public class InventoryVO extends ValueObject {
	public ArrayList<InventoryPositionVO> commodities;
	public String transferID;
	public InventoryVO(ArrayList<InventoryPositionVO> commodities,String transferID) {
		this.commodities=commodities;
		this.transferID=transferID;
	}
}
