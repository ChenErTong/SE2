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
			orderTable((OrderReceiptVO)receipt);
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
	private void exportTable(InventoryExportReceiptVO receipt) {
		// TODO Auto-generated method stub
		
	}
	private void transOrderTable(TransferOrderVO receipt) {
		// TODO Auto-generated method stub
		
	}
	private void importTable(InventoryImportReceiptVO receipt) {
		// TODO Auto-generated method stub
		
	}
	private void transferArrivalTable(TransferArrivalListVO receipt) {
		// TODO Auto-generated method stub
		
	}
	private void deliveryList(DeliveryListVO receipt) {
		// TODO Auto-generated method stub
		
	}
	private void debitBillTable(DebitBillVO receipt) {
		String[] headers = {"收款日期","收款金额","收款快递员","对应订单条形码"};
		table = new MyJTable(headers,true);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] rowData = {receipt.date,receipt.money,receipt.courierID,receipt.orderNumbers};
		tableModel.addRow(rowData);
		
	}
	private void branchArrivalTable(BranchArrivalListVO receipt) {
		// TODO Auto-generated method stub
		
	}
	private void loadingListTable(LoadingListVO receipt) {
		// TODO Auto-generated method stub
		
	}
	private void orderTable(OrderReceiptVO receipt) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		ReceiptBLService controller = ControllerFactory.getReceiptController();
		
		ResultMessage rm = null;
	//	ApprovalBLService controller = new ApprovalController();
		
		//ResultMessage rm = null;
		
		if(billType.equals(ReceiptType.ORDER)){
			OrderReceiptVO vo = (OrderReceiptVO) currentBill;
		//	PurchaseVO vo = (PurchaseVO)currentBill;
		//	ArrayList<CommodityItemVO> commodities = new ArrayList<CommodityItemVO>();
			
			double sum = 0;
			double price = 0;
			int num = 0;
			
			for(int i = 0; i < table.getRowCount(); i++){
				
				num = Integer.parseInt((String)table.getValueAt(i, 3).toString());
			
				price = Double.parseDouble((String)table.getValueAt(i, 4).toString());
				
				//String ID, int number, double price, String remark, String name, String type
			//	commodities.add(new CommodityItemVO((String)table.getValueAt(i, 0), num, price, (String)table.getValueAt(i, 5)
				//		, (String)table.getValueAt(i, 1), (String)table.getValueAt(i, 2)));
				sum = sum + num * price;
			}
			
			//BillType type, String ID, String clientID, String client,
			//String user, Storage storage, ArrayList<CommodityItemVO> commodities, double beforePrice, BillState state
		//	rm = controller.updateBill(new PurchaseVO(billType, vo.ID, vo.clientID,
			//		vo.client, vo.user, vo.storage,commodities,sum,vo.state), billType);
			
		}else if(billType.equals(ReceiptType.BRANCH_TRUCK)){
			//SalesVO vo = (SalesVO)currentBill;
			//ArrayList<CommodityItemVO> commodities = new ArrayList<CommodityItemVO>();
			LoadingListVO vo = (LoadingListVO)currentBill;
			double sum = 0;
			double price = 0;
			int num = 0;
			
			for(int i = 0; i < table.getRowCount(); i++){
				num = Integer.parseInt((String)table.getValueAt(i, 3).toString());
				
				price = Double.parseDouble((String)table.getValueAt(i, 4).toString());
				
				sum = sum + num * price;
				
				//String ID, int number, double price, String remark, String name, String type
			//	commodities.add(new CommodityItemVO((String)table.getValueAt(i, 0), num, price, (String)table.getValueAt(i, 5)
					//	, (String)table.getValueAt(i, 1), (String)table.getValueAt(i, 2)));
			}
			//String ID, String clientID, String client, Storage storage, String user,
			//String salesman, ArrayList<CommodityItemVO> commodities, String remark, 
			//double beforePrice, double allowance, double voucher, double afterPrice, BillType type, BillState state
		//	double afterSum = sum - vo.afterPrice - vo.voucher;
			//rm = controller.updateBill(new SalesVO(vo.ID, vo.clientID, vo.client, vo.storage
				//	, vo.user, vo.salesman, commodities, textField.getText()
					//, sum, vo.allowance, vo.voucher, afterSum, vo.type, vo.state ), billType);
		}else if(billType.equals(ReceiptType.BRANCH_ARRIVAL)){
			BranchArrivalListVO vo = (BranchArrivalListVO) currentBill;
			//InventoryBillVO vo = (InventoryBillVO)currentBill;
			
		//	ArrayList<CommodityItemVO> commodities = new ArrayList<CommodityItemVO>();
			
			double price = 0;
			int num = 0;
			
			for(int i = 0; i < table.getRowCount(); i++){
				num = Integer.parseInt((String)table.getValueAt(i, 3).toString());
				
				price = 0;
				
				//String ID, int number, double price, String remark, String name, String type
			//	commodities.add(new CommodityItemVO((String)table.getValueAt(i, 0), num, price, null
				//		, (String)table.getValueAt(i, 1), (String)table.getValueAt(i, 2)));
			}
			
			//String ID, BillType billType, ArrayList<CommodityItemVO> commodities, String remark, BillState state
			//rm = controller.updateBill(new InventoryBillVO(vo.ID, billType, commodities,vo.remark, vo.state), billType);
		}else if(billType.equals(ReceiptType.PAY)){
			PaymentBillVO vo = (PaymentBillVO) currentBill;
			//CashBillVO vo = (CashBillVO)currentBill;
			//ArrayList<CashItemVO> bills = new ArrayList<CashItemVO>();
			double sum = 0;
			
			for(int i = 0; i < table.getRowCount(); i++){
				//String name, double money, String remark
				
				double price = Double.parseDouble((String)table.getValueAt(i, 3));
				sum = sum + price;
				//bills.add(new CashItemVO((String)table.getValueAt(i, 1), price, (String)table.getValueAt(i, 2)));
			}
			
			//String ID, String user, String account, ArrayList<CashItemVO> bills, double total, BillState state
			//rm = controller.updateBill(new CashBillVO(vo.ID, vo.user, vo.account, bills, sum, vo.state), billType);
		}else if(billType.equals(ReceiptType.BRANCH_DELIVER)){
			DeliveryListVO vo = (DeliveryListVO) currentBill;
			
		}else if(billType.equals(ReceiptType.TRANS_ARRIVAL)){
			TransferArrivalListVO vo = (TransferArrivalListVO) currentBill;
		}else if(billType.equals(ReceiptType.INSTOCK)){
			InventoryImportReceiptVO vo = (InventoryImportReceiptVO) currentBill;
		}else if(billType.equals(ReceiptType.OUTSTOCK)){
			InventoryExportReceiptVO vo = (InventoryExportReceiptVO) currentBill;

		}else if(billType.equals(ReceiptType.TRANS_PLANE)){
			TransferOrderVO vo = (TransferOrderVO) currentBill;
		}else if(billType.equals(ReceiptType.DEBIT)){
			DebitBillVO  vo = (DebitBillVO) currentBill;
		}
		
		//bt_return.doClick();
		
		if(rm.equals(ResultMessage.SUCCESS)){
			new MyNotification(this,"单据修改成功",Color.GREEN);
		}else{
			new MyNotification(this,"单据修改失败",Color.RED);
		}
		
		
	}

}
