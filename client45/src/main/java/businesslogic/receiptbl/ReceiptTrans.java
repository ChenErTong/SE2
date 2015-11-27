package businesslogic.receiptbl;

import java.util.ArrayList;

import po.receiptpo.ReceiptPO;
import state.ReceiptType;
import vo.receiptvo.ReceiptVO;

public class ReceiptTrans {
	public static ReceiptPO convertVOtoPO(ReceiptVO vo){
		if(vo==null)
			return null;
		else {
			//TODO 之后会改造成工厂
			String ID = vo.ID;
			ReceiptType type = vo.type;
			return new ReceiptPO(ID, type);
		}
	}
	
	public static ReceiptVO convertPOtoVO(ReceiptPO po){
		if(po==null)
			return null;
		else {
			//TODO 之后会改造成工厂
			String id = po.getID();
			ReceiptType type = po.getReceiptType();
			return new ReceiptVO(id, type);
		}
	}
	
	public static ArrayList<ReceiptVO> convertPOstoVOs(ArrayList<ReceiptPO> pos){
		ArrayList<ReceiptVO> vos=new ArrayList<ReceiptVO>();
		for(ReceiptPO po:pos){
			ReceiptVO vo=convertPOtoVO(po);
			 vos.add(vo);
		}
		return vos;
	}
	
	public static ArrayList<ReceiptPO> convertVOstoPOs(ArrayList<ReceiptVO> vos){
		ArrayList<ReceiptPO> pos=new ArrayList<ReceiptPO>();
		for(ReceiptVO vo:vos){
			ReceiptPO po=convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}
}
