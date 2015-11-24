package businesslogic.inventorybl;

import java.util.ArrayList;

import po.InventoryPO;
import po.receiptpo.InventoryImportReceiptPO;
import vo.InventoryVO;
import vo.receiptvo.InventoryImportReceiptVO;

public class InventoryTrans {
	public static InventoryPO convertVOtoPO(InventoryVO vo){
		InventoryPO po=new InventoryPO(vo.getID(), vo.getA(), vo.getB(), vo.getC(), vo.getD(), vo.getEmptyOrFull());
		return po;
	}
	
	public  static InventoryVO convertPOtoVO(InventoryPO po){
		InventoryVO vo = new InventoryVO(po.getID(),po.getA(),po.getB(),po.getC(),po.getD(),po.getEmptyOrFull());
		return vo;
	}
	
	public static InventoryImportReceiptVO convertPOtoVO(InventoryImportReceiptPO po){
		InventoryImportReceiptVO vo = new InventoryImportReceiptVO(po.getCommoditiesID(),po.getDestination(),po.getA(),po.getB(),po.getC(),po.getD());
		return vo;
	}
	
	public static ArrayList<InventoryVO> convertInventoryPOstoVOs(ArrayList<InventoryPO> pos){
		ArrayList<InventoryVO> vos=new ArrayList<InventoryVO>();
		for(InventoryPO po : pos) {
			InventoryVO vo = InventoryTrans.convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}
	
	public static ArrayList<InventoryPO> convertInventoryVOstoPOs(ArrayList<InventoryVO> vos){
		ArrayList<InventoryPO> pos=new ArrayList<InventoryPO>();
		for(InventoryVO vo : vos) {
			InventoryPO po = InventoryTrans.convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}
	
	public static ArrayList<InventoryImportReceiptVO> convertInventoryImportReceiptPOstoVOs(ArrayList<InventoryImportReceiptPO> pos){
		ArrayList<InventoryImportReceiptVO> vos=new ArrayList<InventoryImportReceiptVO>();
		for(InventoryImportReceiptPO po : pos) {
			InventoryImportReceiptVO vo = InventoryTrans.convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}
}
