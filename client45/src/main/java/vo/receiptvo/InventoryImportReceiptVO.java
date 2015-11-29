package vo.receiptvo;

import state.ReceiptType;

public class InventoryImportReceiptVO extends ReceiptVO{
	
	   //出发地
		public String depture;
	   //目的地
		public String destination;
		//货物编号
		public String CommoditiesID;
		// 区号
		public int area;
		// 排号
		public int row;
		// 架号
		public int frame;
		// 位号
		public int position;
		public InventoryImportReceiptVO(String id, ReceiptType type, String depture, String destination,
				String commoditiesID, int area, int row, int frame, int position) {
			super(id, type);
			this.depture = depture;
			this.destination = destination;
			CommoditiesID = commoditiesID;
			this.area=area;
			this.row=row;
			this.frame=frame;
			this.position=position;
		}

	
	

}