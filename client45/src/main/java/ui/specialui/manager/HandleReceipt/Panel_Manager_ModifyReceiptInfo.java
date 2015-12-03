package ui.specialui.manager.HandleReceipt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.receiptblservice.ReceiptBLService;
import state.ReceiptType;
import state.ResultMessage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
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
import vo.receiptvo.orderreceiptvo.OrderReceiptVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;
/**
 * 修改单据信息的面板
 * @author zsq
 * @time 2015/11/18 23:57
 */
public class Panel_Manager_ModifyReceiptInfo extends MyTranslucentPanel implements ActionListener{
	MyJTable table ;
	private static MyJButton modify;
	private MyJButton cancel;
	JTextField textField;
	ValueObject currentBill;
	ReceiptType currentType;
	public Panel_Manager_ModifyReceiptInfo(ReceiptType  type,ValueObject receipt) {
		super(365,100,550,550);
		this.currentBill = receipt;
		this.currentType = type;
		this.setOpaque(false);
		this.initComponent();
		initTable(type,receipt);
	
	}
	private void initComponent() {
		
		MyJLabel title = new MyJLabel(580, 40, 170, 50, "修改单据数据", 24, true);
		this.add(title);
		
		modify = new MyJButton(475,600,100,30,"保存修改",18);
		modify.setActionCommand("Modify");
		modify.addActionListener(this);
		this.add(modify);
		
		cancel = new MyJButton(720,600,100,30,"撤销修改",18);
		cancel.setActionCommand("Cancel");
		cancel.addActionListener(this);
		this.add(cancel);
	
		
	}
	/**寄件单、装车单、营业厅到达单、收款单、派件单、中转中心到达单、入库单、中转单、出库单、付款单*/
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
		table = new MyJTable(headers, true);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] rowData = {receipt.payerName,receipt.money,receipt.accountID,receipt.items,receipt.remarks,receipt.date};
		tableModel.addRow(rowData);
	}
	private void exportTable(InventoryExportReceiptVO receipt) {/*ReceiptType type, String destination, String depture, ExpressType expressType,
			String transferID, String commoditiesID, int a, int b, int c, int d*/
		String [] headers = {};
		table = new MyJTable(headers,true);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] rowData = {receipt.type,receipt.transferID,receipt.commodityVO,receipt.area,receipt.row,receipt.frame,receipt.position};
		tableModel.addRow(rowData);
		
	}
	private void transOrderTable(TransferOrderVO receipt) {
		// String facilityID, ReceiptType type,String departure, String destination, String courierName ArrayList<String> orders
		String [] headers = {};
		table = new MyJTable(headers,true);
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[] rowData = {receipt.type,receipt.facilityID,receipt.departure,receipt.destination,receipt.courierName,receipt.orders};
		tableModel.addRow(rowData);
		
	}
	private void importTable(InventoryImportReceiptVO receipt) {
		//  ReceiptType type, String depture, String destination,String commoditiesID, int a, int b, int c, int d)
		String[] headers = {};
		table = new MyJTable(headers,true);
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
	
		Object[] rowData = {receipt.type,receipt.area,receipt.row,receipt.frame,receipt.position,receipt.commodityVO.commodityType,receipt.commodityVO.commodityState,receipt.commodityVO.weight,receipt.commodityVO.volumn};
		tableModel.addRow(rowData);
	}
	private void transferArrivalTable(TransferArrivalListVO receipt) {
		// ReceiptType type,String transferCenterID, String destination, String departure,CommodityState state, ArrayList<String> orders
		String[] headers = {};
		table = new MyJTable(headers,true);
		DefaultTableModel tableModel =(DefaultTableModel)table.getModel();
		Object[] rowData = {receipt.type,receipt.transferCenterID,receipt.destination,receipt.departure,receipt.state,receipt.order};
		tableModel.addRow(rowData);
	}
	private void deliveryList(DeliveryListVO receipt) {
		//  ReceiptType type,ArrayList<String> orders, String courierName
		String[] headers = {};
		table = new MyJTable(headers,true);
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[] rowData = {receipt.type,receipt.order,receipt.courierName};
		tableModel.addRow(rowData);
		
	}
	private void debitBillTable(DebitBillVO receipt) {
		String[] headers = {"收款日期","收款金额","收款快递员","对应订单条形码"};
		table = new MyJTable(headers,true);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] rowData = {receipt.date,receipt.money,receipt.courierID,receipt.orderNumbers};
		tableModel.addRow(rowData);
		
	}
	private void branchArrivalTable(BranchArrivalListVO receipt) {
		// ReceiptType type, String transferListID, String departure,		CommodityState state, ArrayList<String> orders
		String[] headers = {};
		table = new MyJTable(headers,true);
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[]rowData = {receipt.transferListID,receipt.departure,receipt.state,receipt.order};
		tableModel.addRow(rowData);
	}
	private void loadingListTable(LoadingListVO receipt) {
		// ReceiptType type, String branchID, String transferNumber,	String distination, String carID, String monitorName, String courierName, ArrayList<String> orders, double money
		String[] headers = {};
		table = new MyJTable(headers,true);
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[]rowData = {receipt.type,receipt.branchID,receipt.transferNumber,receipt.distination,receipt.carID,receipt.monitorName,receipt.courierName,receipt.orders,receipt.money};
		tableModel.addRow(rowData);
	}
	private void orderTable(OrderVO receipt) {
		// String id, ReceiptType type, ArrayList<String> orders
		String[] headers = {};
		table = new MyJTable(headers,true);
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		Object[] rowData = {receipt.senderName,receipt.senderAddress,receipt.senderTel,receipt.senderCo,receipt.sendTime,receipt.recipientName,
				receipt.recipientAddress,receipt.recipientTel,receipt.recipientCo,receipt.recipientTime,receipt.packType,receipt.express,receipt.midAddres,receipt.commodities};
		tableModel.addRow(rowData);
	}
	private void initJsp(){
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(25, 40, 750, 250);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
	}


	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Modify")){
			if(table.isEditing()){
				table.getCellEditor().stopCellEditing();
				new MyNotification(this,"正在修改单据！",Color.RED);
			}
			finish(currentType);
		}else if(e.getActionCommand().equals("Cancel")){
			
		}
	}
	
	/**寄件单、装车单、营业厅到达单、收款单、派件单、中转中心到达单、入库单、中转单、出库单、付款单*/
	private void finish(ReceiptType billType) {
		ReceiptBLService controller = ControllerFactory.getReceiptController();
		ResultMessage rm = null;
		if(billType.equals(ReceiptType.ORDER)){
			OrderReceiptVO vo = (OrderReceiptVO) currentBill;
		//	ArrayList<String> orders = new ArrayList<String>();
			rm = controller.updateReceipt(new OrderReceiptVO(vo.ID,vo.type,vo.orders));
		}else if(billType.equals(ReceiptType.BRANCH_TRUCK)){
			LoadingListVO vo = (LoadingListVO)currentBill;	
			rm = controller.updateReceipt(new LoadingListVO(vo.ID,vo.type,vo.branchID,vo.transferNumber,vo.distination,
					vo.carID,vo.monitorName,vo.courierName,vo.orders,vo.money));
		}else if(billType.equals(ReceiptType.BRANCH_ARRIVAL)){
			BranchArrivalListVO vo = (BranchArrivalListVO) currentBill;
			rm = controller.updateReceipt(new BranchArrivalListVO(vo.ID,vo.type,vo.transferListID,vo.departure,vo.state,vo.order));
		}else if(billType.equals(ReceiptType.PAY)){
			PaymentBillVO vo = (PaymentBillVO) currentBill;
			double sum = 0;
			
			for(int i = 0; i < table.getRowCount(); i++){
				double price = Double.parseDouble((String)table.getValueAt(i, 1));
				sum = sum + price;
			}
			rm = controller.updateReceipt(new PaymentBillVO(vo.ID,vo.date,vo.type,vo.money,vo.payerName,vo.accountID,vo.items,vo.remarks));
		}else if(billType.equals(ReceiptType.BRANCH_DELIVER)){
			DeliveryListVO vo = (DeliveryListVO) currentBill;
			rm = controller.updateReceipt(new DeliveryListVO(vo.ID,vo.type,vo.order,vo.courierName));
		}else if(billType.equals(ReceiptType.TRANS_ARRIVAL)){
			TransferArrivalListVO vo = (TransferArrivalListVO) currentBill;
			rm = controller.updateReceipt(new TransferArrivalListVO(vo.ID,vo.type,vo.transferCenterID,vo.destination,vo.departure,vo.state,vo.order));
		}else if(billType.equals(ReceiptType.INSTOCK)){
			InventoryImportReceiptVO vo = (InventoryImportReceiptVO) currentBill;
			rm = controller.updateReceipt(new InventoryImportReceiptVO(vo.ID,vo.type,vo.commodityVO,vo.area,vo.row,vo.frame,vo.position));
		}else if(billType.equals(ReceiptType.OUTSTOCK)){
			InventoryExportReceiptVO vo = (InventoryExportReceiptVO) currentBill;
			rm = controller.updateReceipt(new InventoryExportReceiptVO(vo.ID,vo.type,vo.transferID,vo.commodityVO,vo.area,vo.row,vo.frame,vo.position));
		}else if(billType.equals(ReceiptType.TRANS_PLANE)){
			TransferOrderVO vo = (TransferOrderVO) currentBill;
			rm = controller.updateReceipt(new TransferOrderVO(vo.ID,vo.facilityID,vo.type,vo.departure,vo.destination,vo.courierName,vo.orders));
		}else if(billType.equals(ReceiptType.DEBIT)){
			DebitBillVO  vo = (DebitBillVO) currentBill;
			rm = controller.updateReceipt(new DebitBillVO(vo.ID,vo.type,vo.courierID,vo.money,vo.orderNumbers, vo.date));
		}
		if(rm.equals(ResultMessage.SUCCESS)){
			new MyNotification(this,"单据修改成功",Color.GREEN);
		}else{
			new MyNotification(this,"单据修改失败",Color.RED);
		}
		
		
	}

}
