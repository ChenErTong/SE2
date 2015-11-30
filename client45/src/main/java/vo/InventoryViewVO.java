package vo;

import java.util.ArrayList;
/**
 * 库存查看
 * （设定一个时间段，
 * 查看此时间段内的出/入库数量/金额，
 * 存储位置，库存数量要有合计，
 * 这一点统一于普适需求。）
 * @author Ann
 *
 */
public class InventoryViewVO {

	/**
	 * @author lxl
	 * @version Oct 23,2015
	 **/

	/** 出库数量 **/
	public int exportNumber;
	/** 入库数量） **/
	public int importNumber;
	/** 库存数量 **/
	public int num;
	public ArrayList<InventoryVO> Location;

	public InventoryViewVO(int exportNumber, int importNumber, int num, ArrayList<InventoryVO> location) {
		super();
		this.exportNumber = exportNumber;
		this.importNumber = importNumber;
		this.num = num;
		Location = location;
	}

}
