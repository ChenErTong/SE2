package businesslogicservice.receiptblservice;

import java.util.ArrayList;

import po.receiptpo.ReceiptPO;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

/**
 * 审批单据服务逻辑接口的Stub
 * @author zsq
 * @version Oct 24,2015
 */
public class ReceiptBLService_Stub implements ReceiptBLService{

	@Override
	public ResultMessage updateReceipt(ReceiptVO vo, ReceiptType receiptType) {
		
		System.out.println("This receipt has been modified!");
		
		return ResultMessage.SUCCESS;
	}


	@Override
	public ArrayList<ReceiptPO> dontPassReceipt(ArrayList<ReceiptVO> VOs,
			ReceiptType receiptTypes) {
		
		System.out.println("This receipt has not been passed!");
		
		return null;
	}

	@Override
	public ArrayList<ReceiptVO> showReceipt(ReceiptState receiptStates) {
		
		System.out.println("show"+ receiptStates +"receipts!");
		return new ArrayList<ReceiptVO>();
	}


	@Override
	public ArrayList<ReceiptPO> passReceipt(ArrayList<ReceiptVO> VOs,
			ReceiptType receiptTypes) {
		System.out.println("This receipt has been passed!");
		return null;
	}

	

}
