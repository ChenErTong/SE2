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
	//最大容量 TODO 硬编码 之后可能会写到配置文件中
	public final int maxSize=200;
	public InventoryVO( int area, int row, int frame, int position) {
		this.area = area;
		this.row = row;
		this.frame = frame;
		this.position = position;
	}

}
