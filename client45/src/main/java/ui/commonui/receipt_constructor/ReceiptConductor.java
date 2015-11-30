package ui.commonui.receipt_constructor;


import state.ReceiptType;
import vo.OrderVO;
import vo.ValueObject;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.PaymentBillVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

public class ReceiptConductor {
	public String writeReceipt(ReceiptType receiptType,ValueObject receipt){
		
		if(receiptType.equals(ReceiptType.ORDER)){
			return writeCommodity((OrderVO)receipt);
		}else if(receiptType.equals(ReceiptType.BRANCH_TRUCK)){
			return writeBranch_Truck((LoadingListVO)receipt);
		}else if(receiptType.equals(ReceiptType.BRANCH_ARRIVAL)){
			return writeBranch_Arrival((BranchArrivalListVO)receipt);
		}else if(receiptType.equals(ReceiptType.BRANCH_DELIVER)){
			return writeBranch_Deliver((DeliveryListVO)(receipt));
		}else if(receiptType.equals(ReceiptType.TRANS_ARRIVAL)){
			return writeTrans_Arrival((TransferArrivalListVO)receipt);
		}else if(receiptType.equals(ReceiptType.TRANS_PLANE)){
			return writeTrans_Plane((TransferOrderVO)receipt);
		}else if(receiptType.equals(ReceiptType.TRANS_TRAIN)){
			return writeTrans_Train((TransferOrderVO)receipt);
		}else if(receiptType.equals(ReceiptType.TRANS_TRUCK)){
			return writeTrans_Truck((TransferOrderVO)receipt);
		}else if(receiptType.equals(ReceiptType.INSTOCK)){
			return writeInstock((InventoryImportReceiptVO)receipt);
		}else if(receiptType.equals(ReceiptType.OUTSTOCK)){
			return writeOutStock((InventoryExportReceiptVO)receipt);
		}else if(receiptType.equals(ReceiptType.PAY)){
			return writePay((PaymentBillVO)receipt);
		}else if(receiptType.equals(ReceiptType.DEBIT)){
			return writeDebit((DebitBillVO)receipt);
		}
		return null;
		
	}

	private String writeDebit(DebitBillVO receipt) {
		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"收款单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"收款人ID： "+receipt.courierID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"付款日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "账目信息：" + "\n";
		
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"收款金额: "+receipt.money+"元\n";
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"订单条形码号: "+"\n";
		for(int i=0;i<receipt.orderNumbers.size();i++){
			text = text+": "+receipt.orderNumbers.get(i)+"\n";
		}
		
		return text;
	}

	private String writePay(PaymentBillVO receipt) {//{"付款人","付款金额","付款账号","付款条目","付款备注","付款日期"};
		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"付款单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"付款人： "+receipt.payerName+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"付款日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "账目信息：" + "\n";
		
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"付款账户： "+receipt.accountID+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"转账金额： "+receipt.money+"元\n";
		
		for(int i = 0; i < 5; i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
			
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "单据备注:" +receipt.remarks+ "\n";
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text+receipt.items+"\n";
		return text;
	}

	private String writeOutStock(InventoryExportReceiptVO receipt) {
		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"出库单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"出库日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "出库信息：" + "\n";
		
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		
		text = text +"出发地： "+receipt.depture+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"到达地： "+receipt.destination+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"出库区号： "+receipt.a+"区\n";
			
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "出库排号:" +receipt.b+ "排\n";
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text+"出库架号："+receipt.c+"架\n";
		for(int i = 0;i < 9;i++){
			text = text+blank4;
		}
		text = text+"出库位号："+receipt.d+"位\n";
		for(int i = 0;i<9;i++){
			text = text + blank4;
		}
		text = text+"货物编号"+receipt.CommoditiesID+"\n";
		for(int i = 0;i<9;i++){
			text = text + blank4;
		}
		text = text + "装运编号" + receipt.TransferID+"\n";
		return text;
	}

	private String writeInstock(InventoryImportReceiptVO receipt) {
String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"入库单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"入库日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "入库信息：" + "\n";
		
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		
		text = text +"出发地： "+receipt.depture+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"到达地： "+receipt.destination+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"出库区号： "+receipt.a+"区\n";
			
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "出库排号:" +receipt.b+ "排\n";
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text+"出库架号："+receipt.c+"架\n";
		for(int i = 0;i < 9;i++){
			text = text+blank4;
		}
		text = text+"出库位号："+receipt.d+"位\n";
		for(int i = 0;i<9;i++){
			text = text + blank4;
		}
		text = text+"货物编号"+receipt.CommoditiesID+"\n";
		return text;
	}

	private String writeTrans_Truck(TransferOrderVO receipt) {
		// String ID,String facilityID,String departure, String destination, String courierName,
		//ArrayList<String> orders
		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"转运单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"转运日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "单据信息：" + "\n";
		
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"转运工具编号："+receipt.facilityID+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"出发城市： "+receipt.departure+"\n";

		for(int i = 0; i < 5; i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
			
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "到达城市:" +receipt.destination+ "\n";
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text+"押运人: "+receipt.courierName+"\n";
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"订单条形码号： "+"\n";
		for(int i=0;i<receipt.orders.size();i++){
			text = text+": "+receipt.orders.get(i)+"\n";
		}
		return text;
	}

	private String writeTrans_Train(TransferOrderVO receipt) {
String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"转运单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"转运日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "单据信息：" + "\n";
		
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"转运工具编号："+receipt.facilityID+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"出发城市： "+receipt.departure+"\n";

		for(int i = 0; i < 5; i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
			
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "到达城市:" +receipt.destination+ "\n";
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text+"押运人: "+receipt.courierName+"\n";
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"订单条形码号： "+"\n";
		for(int i=0;i<receipt.orders.size();i++){
			text = text+": "+receipt.orders.get(i)+"\n";
		}
		return text;
	}

	private String writeTrans_Plane(TransferOrderVO receipt) {
		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"转运单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"转运日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "单据信息：" + "\n";
		
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"转运工具编号："+receipt.facilityID+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"出发城市： "+receipt.departure+"\n";

		for(int i = 0; i < 5; i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
			
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "到达城市:" +receipt.destination+ "\n";
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text+"押运人: "+receipt.courierName+"\n";
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"订单条形码号： "+"\n";
		for(int i=0;i<receipt.orders.size();i++){
			text = text+": "+receipt.orders.get(i)+"\n";
		}
		return text;
	}

	private String writeTrans_Arrival(TransferArrivalListVO receipt) {
		// String id,String transferCenterID, String destination, String departure,CommodityState state, ArrayList<String> orders
		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"中转中心到达单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"到达日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "单据信息：" + "\n";
		
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"中转中心编号："+receipt.transferCenterID+"\n";
		
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"出发城市： "+receipt.departure+"\n";

		for(int i = 0; i < 5; i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
			
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "到达城市:" +receipt.destination+ "\n";
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text+"货物状态: "+receipt.state+"\n";
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"订单条形码号： "+"\n";
		for(int i=0;i<receipt.orders.size();i++){
			text = text+": "+receipt.orders.get(i)+"\n";
		}
		return text;
	}

	private String writeBranch_Deliver(DeliveryListVO receipt) {
		// ReceiptType type,ArrayList<String> orders, String courierName
		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"派件单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"派送日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "单据信息：" + "\n";
		
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"派送快递员： "+receipt.courierName+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"订单条形码号： "+"\n";
		for(int i=0;i<receipt.orders.size();i++){
			text = text+": "+receipt.orders.get(i)+"\n";
		}
		return null;
	}

	private String writeBranch_Arrival(BranchArrivalListVO receipt) {
		// ReceiptType type, String transferListID, String departure CommodityState state, ArrayList<String> orders
		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"营业厅到达单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"到达日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "单据信息：" + "\n";
		
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"出发城市： "+receipt.departure+"\n";

		for(int i = 0; i < 5; i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
			
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "转运单编号:" +receipt.transferListID+ "\n";
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text+"货物状态: "+receipt.state+"\n";
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"订单条形码号： "+"\n";
		for(int i=0;i<receipt.orders.size();i++){
			text = text+": "+receipt.orders.get(i)+"\n";
		}
		return text;
	}

	private String writeBranch_Truck(LoadingListVO receipt) {
		// ReceiptType type, String branchID, String transferNumber,
		//String distination, String carID, String monitorName, String courierName, ArrayList<String> orders, double money
		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"营业厅装车单"+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"装车日期： "+receipt.date+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "单据信息：" + "\n";
		
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"营业厅ID： "+receipt.branchID+"\n";

		/*for(int i = 0; i < 5; i++){
			text = text + blank4;
		}
		for(int i = 0; i < 32; i++){
			text = text + line;
		}
		text = text + "\n";*/
			
		for(int i = 0; i < 7; i++){
			text = text + blank4;
		}
		text = text + "汽运编号： " +receipt.transferNumber+ "\n";
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text+"到达地: "+receipt.distination+"\n";
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text+"车辆代号: "+receipt.carID+"\n";
		for(int i=0;i<9;i++){
			text = text+blank4;
		}
		text = text+"监装员: "+receipt.monitorName+"\n";
		for(int i=0;i<9;i++){
			text = text+blank4;
		}
		text = text+"押运员: "+receipt.courierName+"\n";
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"订单条形码号： "+"\n";
		for(int i=0;i<receipt.orders.size();i++){
			text = text+": "+receipt.orders.get(i)+"\n";
		}
		for(int i=0;i<9;i++){
			text = text+blank4;
		}
		text = text +"运费： "+receipt.money+"\n";
		
		return text;
	}


	private String writeCommodity(OrderVO receipt) {

		String ID = receipt.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = " ";
		String line ="----";
		
		for(int i=0;i<25;i++){
			blank = blank+blank4;
		}
		text = text+blank+"寄件单："+"\n";
		for(int i=0;i<5;i++){
			text = text + blank4;
		}
		for(int i=0;i<32;i++){
			text = text+line;
		}
		text = text + "\n";
		text = text +"单据编号： "+ID+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"寄件人姓名： "+receipt.senderName+"\n";
		for(int i=0;i<35;i++){
			text = text + blank4;
		}
		text = text +"寄件人电话：： "+receipt.senderTel+"\n";
		
		for(int i=0;i<9;i++){
			text = text + blank4;
		}
		text = text +"寄件人住址： "+receipt.senderAddress+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"寄件人单位： "+receipt.senderCo+"元\n";
			
		for(int i = 0; i < 9; i++){
			text = text + blank4;
		}
		text = text +"收件人姓名： "+receipt.recipientName+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"收件人电话： "+receipt.recipientTel+"元\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"收件人住址： "+receipt.recipientAddress+"元\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"收件人单位： "+receipt.recipientCo+"元\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"派件时间： "+receipt.sendTime+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"收件时间： "+receipt.recipientTime+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"包装类型： "+receipt.packType+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"快递类型： "+receipt.express+"\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"费用： "+receipt.money+"元\n";
		for(int i=0;i<9;i++){
			text = text +blank4;
		}
		text = text +"运送轨迹： "+receipt.senderCo+"元\n";
		for(int i=0;i<receipt.midAddres.size();i++){
			text = text+": "+receipt.midAddres.get(i)+"\n";
		}
		
	
		return text;
	}
}
