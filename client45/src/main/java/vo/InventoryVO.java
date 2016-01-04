package vo;

/**
 * @author lxl
 * @version Oct 23,2015
 **/
public class InventoryVO extends ValueObject {
	public CommodityVO[][][][] commodities;
	public String transferID;
	public InventoryVO(String id, int area, int row, int frame, int position,String transferID) {
		super(id);
		this.commodities=new CommodityVO[area][row][frame][position];
		this.transferID=transferID;
	}
	@Override
	public String toString(){
		return this.ID+"|"+commodities[0].length+"|"+commodities[0][0].length+"|"+commodities[0][0][0].length+"|"+this.transferID;
	}
}
