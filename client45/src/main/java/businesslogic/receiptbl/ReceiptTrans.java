package businesslogic.receiptbl;

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
}
