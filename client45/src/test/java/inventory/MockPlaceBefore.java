package inventory;

import state.ReceiptType;
import vo.InventoryVO;

public class MockPlaceBefore extends InventoryVO{
       
	public MockPlaceBefore(String ID,ReceiptType type,int a, int b, int c, int d) {
		super(ID,type, a, b, c, d,"empty");
		
	}
       
}
