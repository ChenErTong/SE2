package po;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public class InventoryPO extends PersistentObject {
	/** serialVersionUID */
	private static final long serialVersionUID = -2898348688803208513L;

	private CommodityPO[][][][] commos;
	
	private String transferID;

	public InventoryPO(String id, int area, int row, int frame, int position,String transferID) {
		super(id);
		this.commos = new CommodityPO[area][row][frame][position];
		this.transferID=transferID;
	}

	public String getTransferID() {
		return transferID;
	}

	public void setTransferID(String transferID) {
		this.transferID = transferID;
	}

	public CommodityPO[][][][] getCommos() {
		return commos;
	}
	public void setCommos(CommodityPO[][][][] commos) {
		this.commos = commos;
	}

}
