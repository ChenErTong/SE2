package vo;

/**
 * 
 * @author Ann
 *
 */
public class InventoryPositionVO extends ValueObject {
	public int area;
	//排;
	public int row;
	//架
	public int frame;
	//位
	public int position;
	public boolean isEmpty;
	public CommodityVO commodity;
	public InventoryPositionVO( int area, int row, int frame, int position,boolean isEmpty,CommodityVO commodity) {
		this.area = area;
		this.row = row;
		this.frame = frame;
		this.position = position;
		this.commodity=commodity;
		this.isEmpty=isEmpty;
	}

}
