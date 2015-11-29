package vo;

import vo.receiptvo.ReceiptVO;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public class InventoryVO extends ReceiptVO {
    //区
	public int area;
	//排;
	public int row;
	//架
	public int frame;
	//位
	public int position;
	//空或满
	public String EmptyOrFull;
	public InventoryVO(String id, int area, int row, int frame, int position, String emptyOrFull) {
		super(id);
		this.area = area;
		this.row = row;
		this.frame = frame;
		this.position = position;
		EmptyOrFull = emptyOrFull;
	}

	


}
