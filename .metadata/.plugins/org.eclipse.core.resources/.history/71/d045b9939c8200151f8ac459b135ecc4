package businesslogicservice.receiptblservice;

import java.util.ArrayList;

import state.ReceiptState;
import state.ReceiptType;
import vo.receiptpvo.ReceiptVO;


public class ReceiptBLService_Driver {
	
	ReceiptState receiptStates = ReceiptState.APPROVALING;
	ReceiptType receiptTypes = ReceiptType.INSTOCK;
	ReceiptVO receiptVO = new ReceiptVO(null);
	
	
	public void drive(ReceiptBLService service){
		service.showReceipt(receiptStates);
		
		service.dontPassReceipt(new ArrayList<ReceiptVO>(), receiptTypes);
		
		service.passReceipt(new ArrayList<ReceiptVO>(), receiptTypes);
		
		service.updateReceipt(receiptVO, receiptTypes);
		
	}
	
	public static void main(String args[]){
		ReceiptBLService_Driver driver = new ReceiptBLService_Driver();
		ReceiptBLService stub = new ReceiptBLService_Stub();
		driver.drive(stub);
		
	}
}
