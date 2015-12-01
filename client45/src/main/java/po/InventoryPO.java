package po;

import vo.CommodityVO;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public class InventoryPO extends PersistentObject {
	/** serialVersionUID */
	private static final long serialVersionUID = -2898348688803208513L;

	private CommodityVO[][][][] commos;
	
	private String transferID;

	public InventoryPO(String id, int area, int row, int frame, int position,String transferID) {
		super(id);
		this.commos = new CommodityVO[area][row][frame][position];
		this.transferID=transferID;
	}

	public String getTransferID() {
		return transferID;
	}

	public void setTransferID(String transferID) {
		this.transferID = transferID;
	}

	public CommodityVO[][][][] getCommos() {
		return commos;
	}
	public void setCommos(CommodityVO[][][][] commos) {
		this.commos = commos;
	}

}
