package vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
	
/**
 * 库存盘点盘点时，系统显示当天的库存快照
 * 包括当天各区快递的信息（快递编号、入库日期、目的地、区号、排号、架号、位号）
 * 系统自动根据当前盘点时间生成一个截止点，这个点就是批次（日期）批号（序号）
 * 在这个截点之后做的交易是不计入盘点的。
 */
public class InventoryCheckVO {

	/** 商品列表 */
	public ArrayList<InventoryPositionVO> commos;
	/** 批次 */
	public String date;
	/** 批号 */
	public String lotNum;
	
	public String transferID;
	
	public InventoryCheckVO(ArrayList<InventoryPositionVO> commos, String lotNum,String transferID) {
		super();
		this.commos = commos;
		this.lotNum = lotNum;
		/**自动生成日期*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		this.date = sdf.format(new Date());
	}
}