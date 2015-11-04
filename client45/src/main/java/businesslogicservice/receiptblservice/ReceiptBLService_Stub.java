package businesslogicservice.receiptblservice;

import java.util.ArrayList;

import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;

import vo.receiptpvo.ReceiptVO;

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
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs,
			ReceiptType receiptTypes) {
		
		System.out.println("This receipt has not been passed!");
		
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptVO> showReceipt(ReceiptState receiptStates) {
		
		System.out.println("show"+ receiptStates +"receipts!");
		return new ArrayList<ReceiptVO>();
	}


	@Override
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs,
			ReceiptType receiptTypes) {
		System.out.println("This receipt has been passed!");
		return ResultMessage.SUCCESS;
	}

	

}
