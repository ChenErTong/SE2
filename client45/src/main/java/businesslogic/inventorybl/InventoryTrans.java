package businesslogic.inventorybl;

import java.util.ArrayList;

import po.InventoryPO;
import vo.InventoryVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:35:38
 */
public class InventoryTrans {
	public static InventoryPO convertVOtoPO(InventoryVO vo) {
		if(vo==null)
			return null;
		else{
			String id = vo.ID;
			int area = vo.commodities.length;
			int row = vo.commodities[0].length;
			int frame = vo.commodities[0][0].length;
			int position = vo.commodities[0][0][0].length;
			String transferID = vo.transferID;
			return new InventoryPO(id, area, row, frame, position, transferID);
		}
	}

	public static InventoryVO convertPOtoVO(InventoryPO po) {
		if(po==null)
			return null;
		else{
			String id = po.getID();
			int area = po.getCommos().length;
			int row = po.getCommos()[0].length;
			int frame = po.getCommos()[0][0].length;
			int position = po.getCommos()[0][0][0].length;
			String transferID = po.getTransferID();
			return new InventoryVO(id, area, row, frame, position, transferID);
		}
	}

	/*public static InventoryImportReceiptVO convertPOtoVO(InventoryImportReceiptPO po) {
		if(po==null)
			return null;
		else {
			String id = po.getID();
			ReceiptType type = po.getReceiptType();
			CommodityVO commodityVO = OrderTrans.convertPOtoVO(po.getCommodityPO());
			int area = po.getArea();
			int row = po.getRow();
			int frame = po.getFrame();
			int position = po.getPosition();
			return new InventoryImportReceiptVO(id, type, commodityVO, area, row, frame, position);
		}
	}
	
	public static InventoryImportReceiptPO convertVOtoPO(InventoryImportReceiptVO vo) {
		if(vo==null)
			return null;
		else {
			String ID = vo.ID;
			ReceiptType type = vo.type;
			CommodityPO commodityPO = OrderTrans.convertVOtoPO(vo.commodityVO);
			int area = vo.area;
			int row = vo.row;
			int frame = vo.frame;
			int position = vo.position;
			return new InventoryImportReceiptPO(ID, type, commodityPO, area, row, frame, position);
		}
	}
	
	
	public static InventoryExportReceiptPO convertVOtoPO(InventoryExportReceiptVO vo){
		InventoryExportReceiptPO po = new InventoryExportReceiptPO(vo.ID, ReceiptType.OUTSTOCK,vo.destination, vo.depture, vo.expressType,vo. TransferID,
				vo.CommoditiesID,vo.area, vo.row ,vo.frame, vo.position);
				return po;
	}
	public static InventoryExportReceiptVO convertPOtoVO(InventoryExportReceiptPO po){
		InventoryExportReceiptVO vo = new InventoryExportReceiptVO(po.getID(), ReceiptType.OUTSTOCK,po.getDestination(), po.getDepture(), po.getExpressType(),po.getTransferID(),
				po.getCommoditiyID(), po.getArea(), po.getRow() ,po.getFrame(), po.getPosition());
				return vo;
	}*/
	
	public static ArrayList<InventoryVO> convertInventoryPOstoVOs(ArrayList<InventoryPO> pos) {
		ArrayList<InventoryVO> vos = new ArrayList<InventoryVO>();
		for (InventoryPO po : pos) {
			InventoryVO vo = InventoryTrans.convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	public static ArrayList<InventoryPO> convertInventoryVOstoPOs(ArrayList<InventoryVO> vos) {
		ArrayList<InventoryPO> pos = new ArrayList<InventoryPO>();
		for (InventoryVO vo : vos) {
			InventoryPO po = InventoryTrans.convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}

	/*public static ArrayList<InventoryImportReceiptVO> convertInventoryImportReceiptPOstoVOs(
			ArrayList<InventoryImportReceiptPO> pos) {
		ArrayList<InventoryImportReceiptVO> vos = new ArrayList<InventoryImportReceiptVO>();
		for (InventoryImportReceiptPO po : pos) {
			InventoryImportReceiptVO vo = InventoryTrans.convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}*/
}
