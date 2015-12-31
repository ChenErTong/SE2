package ui.specialui.manager.HandleReceipt;

import java.awt.Color;


import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import state.ReceiptType;
import ui.myui.MyJTable;

import ui.myui.MyTranslucentPanel;
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
/**
 * 修改单据信息的面板
 * @author zsq
 * @time 2015/11/18 23:57
 */
public class ModifyReceiptInfo extends MyTranslucentPanel {
	
	MyJTable table ;
	JTextField textField;
	ValueObject currentBill;
	ReceiptType currentType;
	
	public ModifyReceiptInfo(ReceiptType  type,ValueObject receipt) {
		super(365-100,100-30,750,550);
		this.currentBill = receipt;
		this.currentType = type;
		this.setOpaque(false);
		this.initComponent();
		initTable(type,receipt);
	}
	private void initComponent() {	
	}
	
	private void initTable(ReceiptType receiptType, ValueObject receipt){
		if(receiptType.equals(ReceiptType.ORDER)){
			orderTable((OrderVO)receipt);
		}else if(receiptType.equals(ReceiptType.BRANCH_TRUCK)){
			loadingListTable((LoadingListVO)receipt);
		}else if(receiptType.equals(ReceiptType.BRANCH_ARRIVAL)){
			branchArrivalTable((BranchArrivalListVO)receipt);
		}else if(receiptType.equals(ReceiptType.DEBIT)){
			debitBillTable((DebitBillVO)receipt);
		}else if(receiptType.equals(ReceiptType.BRANCH_DELIVER)){
			deliveryList((DeliveryListVO)receipt);
		}else if(receiptType.equals(ReceiptType.TRANS_ARRIVAL)){
			transferArrivalTable((TransferArrivalListVO)receipt);
		}else if(receiptType.equals(ReceiptType.INSTOCK)){
			importTable((InventoryImportReceiptVO)receipt);
		}else if(receiptType.equals(ReceiptType.TRANS_PLANE)){
			transOrderTable((TransferOrderVO) receipt);
		}else if(receiptType.equals(ReceiptType.OUTSTOCK)){
			exportTable((InventoryExportReceiptVO)receipt);
		}else if(receiptType.equals(ReceiptType.PAY)){
			paybillTable((PaymentBillVO)receipt);
		}
		initJsp();
	}
	
	private void paybillTable(PaymentBillVO receipt) {
		String[] headers = {"付款人","付款金额","付款账号","付款条目","付款备注","付款日期"};
		table = new MyJTable(headers, true,this);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] rowData = {receipt.payerName,receipt.money,receipt.bankAccountID,receipt.items.value,receipt.remarks,receipt.date};
		tableModel.addRow(rowData);
	}
	private void exportTable(InventoryExportReceiptVO receipt) {/*ReceiptType type, String destination, String depture, ExpressType expressType,
			String transferID, String commoditiesID, int a, int b, int c, int d*/
		String [] headers = {"单据类型","转运ID","商品货物信息","区","排","架","位"};
		table = new MyJTable(headers,true,this);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] rowData = {receipt.type,receipt.transferID,receipt.commodityVO.commodityState+"|"+receipt.commodityVO.commodityType+"|"+receipt.commodityVO.weight+"|"+receipt.commodityVO.volumn,receipt.area,receipt.row,receipt.frame,receipt.position};
		tableModel.addRow(rowData);
		
	}
	private void transOrderTable(TransferOrderVO receipt) {
		// String facilityID, ReceiptType type,String departure, String destination, String courierName ArrayList<String> orders
		String [] headers = {"单据类型","中转车次编号","出发地","到达地","监装员","托运订单编号"};
		table = new MyJTable(headers,true,this);
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[] rowData = {receipt.type,receipt.facilityID,receipt.departure,receipt.destination,receipt.courierName,receipt.orders};
		tableModel.addRow(rowData);
		
	}
	private void importTable(InventoryImportReceiptVO receipt) {
		//  ReceiptType type, String depture, String destination,String commoditiesID, int a, int b, int c, int d)
		String[] headers = {"单据类型","转运ID","商品货物信息","区","排","架","位"};
		table = new MyJTable(headers,true,this);
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
	
		Object[] rowData = {receipt.type,receipt.commodityVO.commodityState+"|"+receipt.commodityVO.commodityType+"|"+receipt.commodityVO.weight+"|"+receipt.commodityVO.volumn,receipt.area,receipt.row,receipt.frame,receipt.position};
		tableModel.addRow(rowData);
	}
	private void transferArrivalTable(TransferArrivalListVO receipt) {
		// ReceiptType type,String transferCenterID, String destination, String departure,CommodityState state, ArrayList<String> orders
		String[] headers = {"单据类型","中转中心编号","出发地","目的地","货物到达状态","订单订单号"};
		table = new MyJTable(headers,true,this);
		DefaultTableModel tableModel =(DefaultTableModel)table.getModel();
		Object[] rowData = {receipt.type,receipt.transferCenterID,receipt.destination,receipt.departure,receipt.state,receipt.order};
		tableModel.addRow(rowData);
	}
	private void deliveryList(DeliveryListVO receipt) {
		//  ReceiptType type,ArrayList<String> orders, String courierName
		String[] headers = {"单据类型","订单号","装车员"};
		table = new MyJTable(headers,true,this);
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[] rowData = {receipt.type,receipt.order,receipt.courierName};
		tableModel.addRow(rowData);
		
	}
	private void debitBillTable(DebitBillVO receipt) {
		String[] headers = {"单据类型","收款日期","收款金额","收款快递员","对应订单条形码"};
		table = new MyJTable(headers,true,this);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] rowData = {receipt.type,receipt.date,receipt.money,receipt.courierID,receipt.orderNumbers};
		tableModel.addRow(rowData);
		
	}
	private void branchArrivalTable(BranchArrivalListVO receipt) {
		// ReceiptType type, String transferListID, String departure,		CommodityState state, ArrayList<String> orders
		String[] headers = {"单据类型","中转单编号","出发地","货物到达状态","订单订单号"};
		table = new MyJTable(headers,true,this);
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[]rowData = {receipt.transferListID,receipt.departure,receipt.state,receipt.orderID};
		tableModel.addRow(rowData);
	}
	private void loadingListTable(LoadingListVO receipt) {
		// ReceiptType type, String branchID, String transferNumber,	String distination, String carID, String monitorName, String courierName, ArrayList<String> orders, double money
		String[] headers = {"单据种类","营业厅编号","装运编号","目的地","车辆代号","监装员","押运员","订单序列","运费"};
		table = new MyJTable(headers,true,this);
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[]rowData = {receipt.type.value,receipt.branchID,receipt.transferNumber,receipt.distination,receipt.carID,receipt.monitorName,receipt.orders,receipt.money};
		tableModel.addRow(rowData);
	}
	private void orderTable(OrderVO receipt) {
		// String id, ReceiptType type, ArrayList<String> orders
		String[] headers = {};
		table = new MyJTable(headers,true,this);
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[] rowData = {receipt.senderName,receipt.senderAddress,receipt.senderTel,receipt.senderCo,receipt.sendTime,receipt.recipientName,
				receipt.recipientAddress,receipt.recipientTel,receipt.recipientCo,receipt.recipientTime,receipt.packType,receipt.express,receipt.midAddres,receipt.commodities};
		tableModel.addRow(rowData);
	}
	private void initJsp(){
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(10, 10, 730, 530);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
	}


	private static final long serialVersionUID = 1L;
}
