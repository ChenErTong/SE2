package ui.specialui.manager.HandleReceipt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.receiptbl.ReceiptController;
import businesslogic.receiptbl.ReceiptShowController;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import ui.commonui.receipt_constructor.ReceiptConductor;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import vo.ValueObject;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.PaymentBillVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import vo.receiptvo.orderreceiptvo.OrderReceiptVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;
/**
 * 处理单据的总Panel
 * @author zsq
 * @time 2015/11/18 23:58
 */
public class Panel_Manager_HandleReceipt extends MyJPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private ReceiptController receiptController;
	private Panel_Manager_SearchReceipt searchPanel;
	private Panel_Manager_ReceiptInfo receiptInfo;
	
	static ArrayList<ValueObject> listPool;
	static ArrayList<ReceiptType> typePool;
	static int index = -1;
	ArrayList<ValueObject> passList;
	ArrayList<ReceiptType> passType;
	JTable table;
	DefaultTableModel model;
	
	private MyJButton ViewReceiptInfo;
	private MyJButton PassSelectedReceipts;
	private MyJButton ModifyReceiptInfo;
	private MyJButton PassThisReceipt;
	private MyJButton DontPassThisReceipt;
	private MyJButton ExportReceipt;
	public Panel_Manager_HandleReceipt() {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
		listPool = new ArrayList<ValueObject>();
		typePool = new ArrayList<ReceiptType>();
		
		passList = new ArrayList<ValueObject>();
		passType = new ArrayList<ReceiptType>();
	}
	
	private void initComponent() {
		this.add(new MyJLabel(550, 20, 210, 90, "公司运营单据处理", 24, true));
		searchPanel = new Panel_Manager_SearchReceipt(this);
		this.add(searchPanel);
		
		receiptInfo = new Panel_Manager_ReceiptInfo();
		this.add(receiptInfo);

		this.initButton();	
		
		index = -1;
	}
	
	private void initButton(){
		ViewReceiptInfo = new MyJButton(85, 650, 150, 40,"查看当前所选单据",14);
		ViewReceiptInfo.setActionCommand("ViewReceiptInfo");
		ViewReceiptInfo.addActionListener(this);
		this.add(ViewReceiptInfo);
		ViewReceiptInfo.setVisible(true);
		
		PassSelectedReceipts = new MyJButton(255, 650, 150, 40,"通过所有选中单据",14);
		PassSelectedReceipts.setActionCommand("PassSelectedReceipts");
		PassSelectedReceipts.addActionListener(this);
		this.add(PassSelectedReceipts);
		PassSelectedReceipts.setVisible(true);
		
		ModifyReceiptInfo = new MyJButton(425, 650, 150, 40,"修改单据内容",14);
		
		ModifyReceiptInfo.setActionCommand("ModifyReceiptInfo");
		ModifyReceiptInfo.addActionListener(this);
		this.add(ModifyReceiptInfo);
		ModifyReceiptInfo.setVisible(true);
		
		PassThisReceipt = new MyJButton(705,650,150,40,"通过此单据",14);
		PassThisReceipt.setActionCommand("PassThisReceipt");
		PassThisReceipt.addActionListener(this);
		this.add(PassThisReceipt);
		PassThisReceipt.setVisible(true);
		
		DontPassThisReceipt = new MyJButton(875, 650, 150, 40,"不通过此单据",14);
		DontPassThisReceipt.setActionCommand("DontPassThisReceipt");
		DontPassThisReceipt.addActionListener(this);
		this.add(DontPassThisReceipt);
		
		ExportReceipt = new MyJButton(1045, 650, 150, 40,"导出单据",14);
		ExportReceipt.setActionCommand("ExportReceipt");
		ExportReceipt.addActionListener(this);
		this.add(ExportReceipt);
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getActionCommand().equals("DontPassThisReceipt")){
			receiptController =ControllerFactory.getReceiptController();
			ArrayList<ReceiptVO> dontPassList = new ArrayList<ReceiptVO>();
			ArrayList<ReceiptType> dontPassType =  new ArrayList<ReceiptType>();
			dontPassList.add((ReceiptVO)listPool.get(index));
			dontPassType.add(typePool.get(index));
		//	ResultMessage rm = receiptController.dontPassReceipt(dontPassList);
			
			//if(rm.equals(ResultMessage.FAIL)){
				//this.add(new MyNotification(this,"不通过单据失败！",Color.RED));
			//}else{
				
				//bt_search.doClick();
				
			//}
		}else if(events.getActionCommand().equals("PassThisReceipt")){
			table = searchPanel.getTable();
			if(index >= 0){
				if(!table.getValueAt(index, 3).equals("未审批")){
					this.add(new MyNotification(this,"状态为未审批状态的单据才能进行审批！",Color.RED));
				}else{
					receiptController= ControllerFactory.getReceiptController();
					
					passList.clear();
					passType.clear();
					
					passList.add(listPool.get(index));
					passType.add(typePool.get(index));
					
			//		ResultMessage rsg = receiptController.passReceipt(passList, receiptTypes);
							//passBill(passList, passType);
					
				//	if(rsg.equals(ResultMessage.FAIL)){
					//	this.add(new MyNotification(this,"单据审批失败！",Color.RED));
					//}//else{
						
						
						
						//index = -1;
						//ta.setText("");
						//word.setText("单据状态:    ");
						
						this.add(new MyNotification(this,"单据审批成功！",Color.GREEN));
							
					//}
				//}
			}
		}else if(events.getActionCommand().equals("PassSelectedReceipts")){
			table = searchPanel.getTable();
			int count = 0;
			boolean flag = true;
			
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				if(table.getValueAt(i, 0) != null)
					if(table.getValueAt(i, 0).equals(Boolean.TRUE)){
						count++;
					}
				
				if(table.getValueAt(i, 0) != null)
					if(table.getValueAt(i, 0).equals(Boolean.TRUE) && 
							!table.getValueAt(i, 3).equals("未审批")){
						flag = false;
					}
			}
			if(flag == true){
				if(count == 0){
					this.add(new MyNotification(this,"请先选择需要进行审批的单据！",Color.RED));
				}else{
					this.add(new MyNotification(this,"单据批量审批成功！",Color.GREEN));
				}
			}else{
				this.add(new MyNotification(this,"只可对未审批的单据进行审批!",Color.RED));
			}
		}else if(events.getActionCommand().equals("ViewReceiptInfo")){
				int count = 0;
			
				for(int i = 0; i < table.getRowCount(); i++){
				if(table.getValueAt(i, 0) != null)
					if(table.getValueAt(i, 0).equals(Boolean.TRUE)){
						count++;
						index = i;
					}
			}
			
			if(count == 0){
				this.add(new MyNotification(this,"请选择一条要查看的单据！",Color.RED));
			}else if(count > 1){
				this.add(new MyNotification(this,"请只选择一条要查看的单据！",Color.RED));
			}else{
				ReceiptConductor  writer = new ReceiptConductor();
				receiptInfo.getTa().setText(writer.writeReceipt(typePool.get(index),listPool.get(index)));
			}
		}else if(events.getActionCommand().equals("ModifyReceiptInfo")){
			table = searchPanel.getTable();
			if(index >= 0){
				if(!table.getValueAt(index, 3).equals("未审批")){
					this.add(new MyNotification(this,"状态为未审批的单据才能进行修改！",Color.RED));
				}else{
					Panel_Manager_ModifyReceiptInfo modifyUI = new Panel_Manager_ModifyReceiptInfo(typePool.get(index),listPool.get(index));
					this.setVisible(false);
					modifyUI.setVisible(true);
				}
			}
		}else if(events.getActionCommand().equals("ExportReceipt")){
			table = searchPanel.getTable();
			if(index >= 0){
				FileSystemView fsv = FileSystemView.getFileSystemView();
				String file = String.valueOf(fsv.getHomeDirectory()) + "/" + table.getValueAt(index, 2) + ".txt";		
				System.out.print(file);
				writeto(receiptInfo.getTa().getText().replaceAll("\n", "\r\n"),file);
				
				this.add(new MyNotification(this,"单据成功导出至桌面！",Color.GREEN));
			}
		}else if(events.getActionCommand().equals("SearchReceipt")){
			//清空VO储存池
			listPool.clear();
			typePool.clear();
			table = searchPanel.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			int rowCount = table.getRowCount();
			
			for(int k = 0; k < rowCount; k++)
				tableModel.removeRow(0);
			int data[] = searchPanel.getData();
			if(data[0]==1){
				try{
					getApprovalData(data[1]);
				}catch(Exception e){
					e.printStackTrace();
				}
			}else if(data[0]==2){
				try{
					getPassData(data[1]);
				}catch(Exception e){
					e.printStackTrace();
				}
			}else if(data[0]==3){
				try{
					getFailureData(data[1]);
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				try{
					getApprovalData(data[1]);
				}catch(Exception e){
					e.printStackTrace();
				}
				try{
					getPassData(data[1]);
				}catch(Exception e){
					e.printStackTrace();
				}
				try{
					getFailureData(data[1]);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(table.getRowCount() == 0){
				this.add(new MyNotification(this,"目前没有找到符合条件的单据！",Color.RED));
			}
		}
	}
	}
private void getApprovalData(int index) throws RemoteException{
		table = searchPanel.getTable();	
		ReceiptController controller = ControllerFactory.getReceiptController();
		
		/**寄件单、装车单、营业厅到达单、收款单、派件单、中转中心到达单、入库单、中转单、出库单、付款单*/
		/**
		 * @author Ann
		 */
		ArrayList<ReceiptVO> vo = controller.show(null, ReceiptState.APPROVALING);//待审批的单据
		ArrayList<OrderReceiptVO> orderReceipt = controller.show(ReceiptType.ORDER, ReceiptState.APPROVALING);
		ArrayList<LoadingListVO> loadingList = controller.show(ReceiptType.BRANCH_TRUCK, ReceiptState.APPROVALING);
		ArrayList<BranchArrivalListVO> branchArrival = controller.show(ReceiptType.BRANCH_ARRIVAL, ReceiptState.APPROVALING);
		ArrayList<DebitBillVO> debitBill = controller.show(ReceiptType.DEBIT, ReceiptState.APPROVALING);
		ArrayList<DeliveryListVO> delivery = controller.show(ReceiptType.BRANCH_DELIVER, ReceiptState.APPROVALING);
		ArrayList<TransferArrivalListVO> transferArrival = controller.show(ReceiptType.TRANS_ARRIVAL, ReceiptState.APPROVALING);
		ArrayList<InventoryImportReceiptVO> importReceipt = controller.show(ReceiptType.INSTOCK, ReceiptState.APPROVALING);
		ArrayList<TransferOrderVO> transferOrder = controller.show(ReceiptType.TRANS_PLANE, ReceiptState.APPROVALING);
		ArrayList<InventoryExportReceiptVO> exportReceipt = controller.show(ReceiptType.OUTSTOCK, ReceiptState.APPROVALING);
		ArrayList<PaymentBillVO> paymentBill = controller.show(ReceiptType.PAY, ReceiptState.APPROVALING);
		
		model = (DefaultTableModel) table.getModel();
		
		if(index == 0){
			for(int i = 1; i <= 10; i++)
				getApprovalData(i);
		}
		if(index == 1){
			for(int i = 0; i < orderReceipt.size(); i++){
				Object[] rowData = {null, "寄件单", orderReceipt.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add(orderReceipt.get(i));
				typePool.add(orderReceipt.get(i).type);
			}
		}
		if(index == 2){
			for(int i = 0; i < loadingList.size(); i++){
				Object[] rowData = {new Boolean(false), "装车单", loadingList.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add(loadingList.get(i));
				typePool.add(loadingList.get(i).type);
			}
		}
		if(index == 3){
			for(int i = 0; i < branchArrival.size(); i++){
				Object[] rowData = {new Boolean(false), "营业厅到达单", branchArrival.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add(branchArrival.get(i));
				typePool.add(branchArrival.get(i).type);
			}
		}
		if(index == 4){
			for(int i = 0; i <  debitBill.size(); i++){
				Object[] rowData = {new Boolean(false), "收款单", debitBill.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add( debitBill.get(i));
				typePool.add( debitBill.get(i).type);
			}
		}
		if(index == 5){
			for(int i = 0; i < delivery.size(); i++){
				Object[] rowData = {new Boolean(false), "派件单", delivery.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add(delivery.get(i));
				typePool.add(delivery.get(i).type);
			}
		}
		if(index == 6){
			for(int i = 0;i<transferArrival.size();i++){
				Object[] rowData = {new Boolean(false),"中转中心到达单",transferArrival.get(i).ID,"未审批"};
				model.addRow(rowData);
				listPool.add(transferArrival.get(i));
				typePool.add(transferArrival.get(i).type);
			}
		}if(index == 7){
			for(int i = 0;i<importReceipt.size();i++){
				Object[] rowData = {new Boolean(false),"入库单",importReceipt.get(i).ID,"未审批"};
				model.addRow(rowData);
				listPool.add(importReceipt.get(i));
				typePool.add(importReceipt.get(i).type);
			}
		}if(index == 8){
			for(int i = 0;i<transferOrder.size();i++){
				Object[] rowData = {new Boolean(false),"转运单",transferOrder.get(i).ID,"未审批"};
				model.addRow(rowData);
				listPool.add(transferOrder.get(i));
				typePool.add(transferOrder.get(i).type);
			}
		}if(index == 9){
			for(int i = 0;i<exportReceipt.size();i++){
				Object[] rowData = {new Boolean(false),"出库单",exportReceipt.get(i).ID,"未审批"};
				model.addRow(rowData);
				listPool.add(exportReceipt.get(i));
				typePool.add(exportReceipt.get(i).type);
			}
		}if(index == 10){
			for(int i = 0;i<paymentBill .size();i++){
				Object[] rowData = {new Boolean(false),"付款单",paymentBill .get(i).ID,"未审批"};
				model.addRow(rowData);
				listPool.add(paymentBill .get(i));
				typePool.add(paymentBill .get(i).type);
			}
		}
	}
	
	private void getPassData(int index) throws RemoteException{
		table = searchPanel.getTable();	
		ReceiptController controller = ControllerFactory.getReceiptController();
		ArrayList<ReceiptVO> vo = controller.show(null, ReceiptState.SUCCESS);//待审批的单据
		ArrayList<OrderReceiptVO> orderReceipt = controller.show(ReceiptType.ORDER, ReceiptState.SUCCESS);
		ArrayList<LoadingListVO> loadingList = controller.show(ReceiptType.BRANCH_TRUCK, ReceiptState.SUCCESS);
		ArrayList<BranchArrivalListVO> branchArrival = controller.show(ReceiptType.BRANCH_ARRIVAL, ReceiptState.SUCCESS);
		ArrayList<DebitBillVO> debitBill = controller.show(ReceiptType.DEBIT, ReceiptState.SUCCESS);
		ArrayList<DeliveryListVO> delivery = controller.show(ReceiptType.BRANCH_DELIVER, ReceiptState.SUCCESS);
		ArrayList<TransferArrivalListVO> transferArrival = controller.show(ReceiptType.TRANS_ARRIVAL, ReceiptState.SUCCESS);
		ArrayList<InventoryImportReceiptVO> importReceipt = controller.show(ReceiptType.INSTOCK,ReceiptState.SUCCESS);
		ArrayList<TransferOrderVO> transferOrder = controller.show(ReceiptType.TRANS_PLANE, ReceiptState.SUCCESS);
		ArrayList<InventoryExportReceiptVO> exportReceipt = controller.show(ReceiptType.OUTSTOCK, ReceiptState.SUCCESS);
		ArrayList<PaymentBillVO> paymentBill = controller.show(ReceiptType.PAY, ReceiptState.SUCCESS);
		
model = (DefaultTableModel) table.getModel();
		
		if(index == 0){
			for(int i = 1; i <= 10; i++)
				getPassData(i);
		}
		if(index == 1){
			for(int i = 0; i < orderReceipt.size(); i++){
				Object[] rowData = {null, "寄件单", orderReceipt.get(i).ID, "已通过"};
				model.addRow(rowData);
				listPool.add(orderReceipt.get(i));
				typePool.add(orderReceipt.get(i).type);
			}
		}
		if(index == 2){
			for(int i = 0; i < loadingList.size(); i++){
				Object[] rowData = {new Boolean(false), "装车单", loadingList.get(i).ID, "已通过"};
				model.addRow(rowData);
				listPool.add(loadingList.get(i));
				typePool.add(loadingList.get(i).type);
			}
		}
		if(index == 3){
			for(int i = 0; i < branchArrival.size(); i++){
				Object[] rowData = {new Boolean(false), "营业厅到达单", branchArrival.get(i).ID, "已通过"};
				model.addRow(rowData);
				listPool.add(branchArrival.get(i));
				typePool.add(branchArrival.get(i).type);
			}
		}
		if(index == 4){
			for(int i = 0; i <  debitBill.size(); i++){
				Object[] rowData = {new Boolean(false), "收款单", debitBill.get(i).ID, "已通过"};
				model.addRow(rowData);
				listPool.add( debitBill.get(i));
				typePool.add( debitBill.get(i).type);
			}
		}
		if(index == 5){
			for(int i = 0; i < delivery.size(); i++){
				Object[] rowData = {new Boolean(false), "派件单", delivery.get(i).ID, "已通过"};
				model.addRow(rowData);
				listPool.add(delivery.get(i));
				typePool.add(delivery.get(i).type);
			}
		}
		if(index == 6){
			for(int i = 0;i<transferArrival.size();i++){
				Object[] rowData = {new Boolean(false),"中转中心到达单",transferArrival.get(i).ID,"已通过"};
				model.addRow(rowData);
				listPool.add(transferArrival.get(i));
				typePool.add(transferArrival.get(i).type);
			}
		}if(index == 7){
			for(int i = 0;i<importReceipt.size();i++){
				Object[] rowData = {new Boolean(false),"入库单",importReceipt.get(i).ID,"已通过"};
				model.addRow(rowData);
				listPool.add(importReceipt.get(i));
				typePool.add(importReceipt.get(i).type);
			}
		}if(index == 8){
			for(int i = 0;i<transferOrder.size();i++){
				Object[] rowData = {new Boolean(false),"转运单",transferOrder.get(i).ID,"已通过"};
				model.addRow(rowData);
				listPool.add(transferOrder.get(i));
				typePool.add(transferOrder.get(i).type);
			}
		}if(index == 9){
			for(int i = 0;i<exportReceipt.size();i++){
				Object[] rowData = {new Boolean(false),"出库单",exportReceipt.get(i).ID,"已通过"};
				model.addRow(rowData);
				listPool.add(exportReceipt.get(i));
				typePool.add(exportReceipt.get(i).type);
			}
		}if(index == 10){
			for(int i = 0;i<paymentBill .size();i++){
				Object[] rowData = {new Boolean(false),"付款单",paymentBill .get(i).ID,"已通过"};
				model.addRow(rowData);
				listPool.add(paymentBill .get(i));
				typePool.add(paymentBill .get(i).type);
			}
		}
	}
	
	private void getFailureData(int index) throws RemoteException{
		table = searchPanel.getTable();	
		ReceiptController controller = ControllerFactory.getReceiptController();
		ArrayList<ReceiptVO> vo = controller.show(null, ReceiptState.SUCCESS);//待审批的单据
		ArrayList<OrderReceiptVO> orderReceipt = controller.show(ReceiptType.ORDER, ReceiptState.SUCCESS);
		ArrayList<LoadingListVO> loadingList = controller.show(ReceiptType.BRANCH_TRUCK, ReceiptState.SUCCESS);
		ArrayList<BranchArrivalListVO> branchArrival = controller.show(ReceiptType.BRANCH_ARRIVAL, ReceiptState.SUCCESS);
		ArrayList<DebitBillVO> debitBill = controller.show(ReceiptType.DEBIT, ReceiptState.SUCCESS);
		ArrayList<DeliveryListVO> delivery = controller.show(ReceiptType.BRANCH_DELIVER, ReceiptState.SUCCESS);
		ArrayList<TransferArrivalListVO> transferArrival = controller.show(ReceiptType.TRANS_ARRIVAL, ReceiptState.SUCCESS);
		ArrayList<InventoryImportReceiptVO> importReceipt = controller.show(ReceiptType.INSTOCK,ReceiptState.SUCCESS);
		ArrayList<TransferOrderVO> transferOrder = controller.show(ReceiptType.TRANS_PLANE, ReceiptState.SUCCESS);
		ArrayList<InventoryExportReceiptVO> exportReceipt = controller.show(ReceiptType.OUTSTOCK, ReceiptState.SUCCESS);
		ArrayList<PaymentBillVO> paymentBill = controller.show(ReceiptType.PAY, ReceiptState.SUCCESS);
		
		model = (DefaultTableModel) table.getModel();
		
		if(index == 0){
			for(int i = 1; i <= 10; i++)
				getFailureData(i);
		}
		if(index == 1){
			for(int i = 0; i < orderReceipt.size(); i++){
				Object[] rowData = {null, "寄件单", orderReceipt.get(i).ID, "未通过"};
				model.addRow(rowData);
				listPool.add(orderReceipt.get(i));
				typePool.add(orderReceipt.get(i).type);
			}
		}
		if(index == 2){
			for(int i = 0; i < loadingList.size(); i++){
				Object[] rowData = {new Boolean(false), "装车单", loadingList.get(i).ID, "未通过"};
				model.addRow(rowData);
				listPool.add(loadingList.get(i));
				typePool.add(loadingList.get(i).type);
			}
		}
		if(index == 3){
			for(int i = 0; i < branchArrival.size(); i++){
				Object[] rowData = {new Boolean(false), "营业厅到达单", branchArrival.get(i).ID, "未通过"};
				model.addRow(rowData);
				listPool.add(branchArrival.get(i));
				typePool.add(branchArrival.get(i).type);
			}
		}
		if(index == 4){
			for(int i = 0; i <  debitBill.size(); i++){
				Object[] rowData = {new Boolean(false), "收款单", debitBill.get(i).ID, "未通过"};
				model.addRow(rowData);
				listPool.add( debitBill.get(i));
				typePool.add( debitBill.get(i).type);
			}
		}
		if(index == 5){
			for(int i = 0; i < delivery.size(); i++){
				Object[] rowData = {new Boolean(false), "派件单", delivery.get(i).ID, "未通过"};
				model.addRow(rowData);
				listPool.add(delivery.get(i));
				typePool.add(delivery.get(i).type);
			}
		}
		if(index == 6){
			for(int i = 0;i<transferArrival.size();i++){
				Object[] rowData = {new Boolean(false),"中转中心到达单",transferArrival.get(i).ID,"未通过"};
				model.addRow(rowData);
				listPool.add(transferArrival.get(i));
				typePool.add(transferArrival.get(i).type);
			}
		}if(index == 7){
			for(int i = 0;i<importReceipt.size();i++){
				Object[] rowData = {new Boolean(false),"入库单",importReceipt.get(i).ID,"未通过"};
				model.addRow(rowData);
				listPool.add(importReceipt.get(i));
				typePool.add(importReceipt.get(i).type);
			}
		}if(index == 8){
			for(int i = 0;i<transferOrder.size();i++){
				Object[] rowData = {new Boolean(false),"转运单",transferOrder.get(i).ID,"未通过"};
				model.addRow(rowData);
				listPool.add(transferOrder.get(i));
				typePool.add(transferOrder.get(i).type);
			}
		}if(index == 9){
			for(int i = 0;i<exportReceipt.size();i++){
				Object[] rowData = {new Boolean(false),"出库单",exportReceipt.get(i).ID,"未通过"};
				model.addRow(rowData);
				listPool.add(exportReceipt.get(i));
				typePool.add(exportReceipt.get(i).type);
			}
		}if(index == 10){
			for(int i = 0;i<paymentBill .size();i++){
				Object[] rowData = {new Boolean(false),"付款单",paymentBill .get(i).ID,"未通过"};
				model.addRow(rowData);
				listPool.add(paymentBill .get(i));
				typePool.add(paymentBill .get(i).type);
			}
		}
	}
private void writeto(String a,String file){
		
		try {
			File filename=new File(file);
			
			if (!filename.exists()) { 
				filename.createNewFile();}
			
			FileWriter fw=new FileWriter(filename);
			fw.write(a);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

/*private void setCondition(String str){
	switch(str){
	case "未通过" : word.setText("单据状态:    " + "未通过");break;
	case "已通过": word.setText("单据状态:    " + "已通过");break;
	case "未审批" : word.setText("单据状态:    " + "未审批");break;
	}*/
//}
}


