package vo;

import java.util.ArrayList;

import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

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

	/** 出库数量 **/
	public ArrayList<InventoryExportReceiptVO> exportReceipts;
	/** 入库数量） **/
	public ArrayList<InventoryImportReceiptVO> importReceipts;
	/** 库存数量 **/
	public ArrayList<InventoryPositionVO> commodityInInventory;

	public InventoryViewVO(ArrayList<InventoryExportReceiptVO> exportReceipts,
			ArrayList<InventoryImportReceiptVO> importReceipts, ArrayList<InventoryPositionVO> commodityInInventory,
			InventoryVO inventory) {
		this.exportReceipts = exportReceipts;
		this.importReceipts = importReceipts;
		this.commodityInInventory = commodityInInventory;
	}
}
