package inventory;

import state.ReceiptType;
import vo.InventoryVO;

public class MockPlaceAfter extends InventoryVO{
   
	public MockPlaceAfter(String ID,ReceiptType type,int a, int b, int c, int d) {
		super(ID, type, a, b, c, d, "full");
		// TODO Auto-generated constructor stub
	}

}
