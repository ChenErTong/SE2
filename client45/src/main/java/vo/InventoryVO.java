package vo;

/**
 * @author lxl
 * @version Oct 23,2015
 **/
public class InventoryVO extends ValueObject {
    //区 TODO 这个参数可能会改成枚举类
	public int area;
	//排;
	public int row;
	//架
	public int frame;
	//位
	public int position;
	public boolean isEmpty;
	public String transferID;
	public InventoryVO( int area, int row, int frame, int position,String transferID) {
		this.area = area;
		this.row = row;
		this.frame = frame;
		this.position = position;
		this.transferID=transferID;
	}

}
