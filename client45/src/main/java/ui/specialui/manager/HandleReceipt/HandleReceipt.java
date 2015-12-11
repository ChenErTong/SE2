package ui.specialui.manager.HandleReceipt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.receiptbl.ReceiptController;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import ui.commonui.receipt_constructor.ReceiptConductor;
import ui.image.ManagerImage;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;
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
public class HandleReceipt extends MyJPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private ReceiptController receiptController;
	private SearchReceipt searchPanel;
	private ReceiptInfo receiptInfo;
	
	static ArrayList<ValueObject> listPool;
	static ArrayList<ReceiptType> typePool;
	static int index = -1;
	
	ArrayList<ValueObject> passList;
	ArrayList<ReceiptType> passType;
	JTable table;
	DefaultTableModel model;
	
	private MyButton ViewReceiptInfo;
	private MyButton PassSelectedReceipts;
	private MyButton ModifyReceiptInfo;
	private MyButton PassThisReceipt;
	private MyButton DontPassThisReceipt;
	private MyButton ExportReceipt;
	private MyButton search;
	
	public HandleReceipt(FrameManager frameManager) throws RemoteException {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
		this.leadline(frameManager);
		listPool = new ArrayList<ValueObject>();
		typePool = new ArrayList<ReceiptType>();
		
		passList = new ArrayList<ValueObject>();
		passType = new ArrayList<ReceiptType>();
		search  = searchPanel.getSearch();
	}
	
	private void initComponent() throws RemoteException {
		this.add(new MyJLabel(530, 20, 300, 40, "公司运营单据处理", 30, true));
		searchPanel = new SearchReceipt(this);
		this.add(searchPanel);
		
		receiptInfo = new ReceiptInfo();
		this.add(receiptInfo);

		this.initButton();	
		
		index = -1;
		
		this.showAll();
	}
	
	private void initButton(){
		ViewReceiptInfo = new MyButton(85, 650-30, 150, 40,ManagerImage.getBUTTON_VIEWBILL());
		ViewReceiptInfo.setActionCommand("ViewReceiptInfo");
		ViewReceiptInfo.addActionListener(this);
		this.add(ViewReceiptInfo);
		ViewReceiptInfo.setVisible(true);
		
		PassSelectedReceipts = new MyButton(255, 650-30, 150, 40,ManagerImage.getBUTTON_APPROVEALL());
		PassSelectedReceipts.setActionCommand("PassSelectedReceipts");
		PassSelectedReceipts.addActionListener(this);
		this.add(PassSelectedReceipts);
		PassSelectedReceipts.setVisible(true);
		
		ModifyReceiptInfo = new MyButton(425, 650-30, 150, 40,ManagerImage.getBUTTON_MODIFYBILL());
		
		ModifyReceiptInfo.setActionCommand("ModifyReceiptInfo");
		ModifyReceiptInfo.addActionListener(this);
		this.add(ModifyReceiptInfo);
		ModifyReceiptInfo.setVisible(true);
		
		PassThisReceipt = new MyButton(705,650-30,150,40,ManagerImage.getBUTTON_PASSBILL());
		PassThisReceipt.setActionCommand("PassThisReceipt");
		PassThisReceipt.addActionListener(this);
		this.add(PassThisReceipt);
		PassThisReceipt.setVisible(true);
		
		DontPassThisReceipt = new MyButton(875, 650-30, 150, 40,ManagerImage.getBUTTON_DONTPASS());
		DontPassThisReceipt.setActionCommand("DontPassThisReceipt");
		DontPassThisReceipt.addActionListener(this);
		this.add(DontPassThisReceipt);
		
		ExportReceipt = new MyButton(1045, 650-30, 150, 40,ManagerImage.getBUTTON_EXPORTBILL());
		ExportReceipt.setActionCommand("ExportReceipt");
		ExportReceipt.addActionListener(this);
		this.add(ExportReceipt);
	}
	
public void leadline(FrameManager frameManager){
		
		MyButton HandleReceipt = new MyButton(300-105, 690,95,20,ManagerImage.getBUTTON_APPROVE_());
		HandleReceipt.setActionCommand("HandleReceipt");
		HandleReceipt.addActionListener(frameManager);
		this.add(HandleReceipt);
		HandleReceipt.setVisible(true);
		
		MyButton HandleOrganization = new MyButton(300, 690,120,20,ManagerImage.getBUTTON_ORGANIZATION_());
		HandleOrganization.setActionCommand("HandleOrganization");
		HandleOrganization.addActionListener(frameManager);
		this.add(HandleOrganization);
		HandleOrganization.setVisible(true);
		
		MyButton AdjustBase = new MyButton(300+120+10, 690,120,20,ManagerImage.getBUTTON_BASE_());
		AdjustBase.setActionCommand("AdjustBase");
		AdjustBase.addActionListener(frameManager);
		this.add(AdjustBase);
		AdjustBase.setVisible(true);
		
		MyButton AdjustSalaryPolicy = new MyButton(300+120+10+130,690,120,20,ManagerImage.getBUTTON_POLICY_());
		AdjustSalaryPolicy.setActionCommand("AdjustSalaryPolicy");
		AdjustSalaryPolicy.addActionListener(frameManager);
		this.add(AdjustSalaryPolicy);
		AdjustSalaryPolicy.setVisible(true);
		
		MyButton ViewUser = new MyButton(300+120+10+130+130,  690,120,20,ManagerImage.getBUTTON_ACCOUNT_());
		ViewUser.setActionCommand("ViewUser");
		ViewUser.addActionListener(frameManager);
		this.add(ViewUser);
		ViewUser.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(300+120+10+130+130+130,690,120,20,FinanceImage.getButton_JINGYING_());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frameManager);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(300+130*5,690,120,20,FinanceImage.getButton_CHENGBEN_());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frameManager);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(300+130*6,690,120,20,FinanceImage.getButton_LOG_());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frameManager);
		this.add(viewLog);
	}
	public void actionPerformed(ActionEvent events){
		if(events.getActionCommand().equals("DontPassThisReceipt")){
			if(!table.getValueAt(table.getSelectedRow(), 3).equals("未审批")){
				new MyNotification(this,"状态为未审批状态的单据才能进行审批！",Color.RED);
			}else{
				try {
					receiptController =ControllerFactory.getReceiptController();
					ArrayList<ReceiptVO> dontPassList = new ArrayList<ReceiptVO>();
					ArrayList<ReceiptType> dontPassType =  new ArrayList<ReceiptType>();
					dontPassList.add((ReceiptVO)listPool.get(table.getSelectedRow()));
					dontPassType.add(typePool.get(table.getSelectedRow()));
					ResultMessage rm = receiptController.dontPassReceipt(dontPassList);
					if(rm.equals(ResultMessage.FAIL)){
						new MyNotification(this,"不通过单据失败！",Color.RED);
					}else{
						search.doClick();
					}
				} catch (RemoteException | MalformedURLException | NotBoundException e) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					e.printStackTrace();
				}
			}
		}else if(events.getActionCommand().equals("PassThisReceipt")){
			table = searchPanel.getTable();
			ArrayList<ReceiptVO> PassList = new ArrayList<ReceiptVO>();
			if(index >= 0){
				if(!table.getValueAt(table.getSelectedRow(), 3).equals("未审批")){
					new MyNotification(this,"状态为未审批状态的单据才能进行审批！",Color.RED);
				}else{
					
					try {
						receiptController= ControllerFactory.getReceiptController();
						
						passList.clear();
						passType.clear();
						
						passList.add(listPool.get(table.getSelectedRow()));
						passType.add(typePool.get(table.getSelectedRow()));
						PassList.add((ReceiptVO)listPool.get(table.getSelectedRow()));
						ResultMessage rsg = receiptController.passReceipt(PassList);
						if(rsg.equals(ResultMessage.FAIL)){
							new MyNotification(this,"单据审批失败！",Color.RED);
						}else{
							search.doClick();
							index = -1;
							//ta.setText("");
							//word.setText("单据状态:    ");
							new MyNotification(this,"单据审批成功！",Color.GREEN);
								
						}
					} catch (RemoteException | MalformedURLException | NotBoundException e) {
						new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
						e.printStackTrace();
					}
				}
			}
		}else if(events.getActionCommand().equals("PassSelectedReceipts")){
			table = searchPanel.getTable();
			int count = 0;
			boolean flag = true;
			ArrayList<ReceiptVO> PassList = new ArrayList<ReceiptVO>();
			int rowCount = table.getRowCount();
			
			passList.clear();
			passType.clear();
			
			for(int i = 0; i < rowCount; i++){
				if(table.getValueAt(i, 0) != null)
					if(table.getValueAt(i, 0).equals(Boolean.TRUE)){
						passList.add(listPool.get(i));
						passType.add(typePool.get(i));
						PassList.add((ReceiptVO)listPool.get(index));
					}
			}
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
					new MyNotification(this,"请先选择需要进行审批的单据！",Color.RED);
				}else{
					try {
						receiptController= ControllerFactory.getReceiptController();
						ResultMessage rm = receiptController.passReceipt(PassList);
						
						if(rm.equals(ResultMessage.FAIL)){
							new MyNotification(this,"单据批量审批失败",Color.RED);
						}else{
							new MyNotification(this,"单据批量审批成功！",Color.GREEN);
						}
					} catch (RemoteException | MalformedURLException | NotBoundException e) {
						new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
						e.printStackTrace();
					}
				}
			}else{
				new MyNotification(this,"只可对未审批的单据进行审批!",Color.RED);
			}
		}else if(events.getActionCommand().equals("ViewReceiptInfo")){
				table = searchPanel.getTable();
				int count = 0;
			
				for(int i = 0; i < table.getRowCount(); i++){
				if(table.getValueAt(i, 0) != null)
					if(table.getValueAt(i, 0).equals(Boolean.TRUE)){
						count++;
						index = i;
					}
			}
			if(count == 0){
				new MyNotification(this,"请选择一条要查看的单据！",Color.RED);
			}else if(count > 1){
				new MyNotification(this,"请只选择一条要查看的单据！",Color.RED);
			}else{
				ReceiptConductor  writer = new ReceiptConductor();
				receiptInfo.getTa().setText(writer.writeReceipt(typePool.get(index),listPool.get(index)));
			}
		}else if(events.getActionCommand().equals("ModifyReceiptInfo")){
				//System.out.println("111");
				table = searchPanel.getTable();
			//	System.out.println(index);
				if(index >= 0){
					if(!table.getValueAt(index, 3).equals("未审批")){
						new MyNotification(this,"状态为未审批的单据才能进行修改！",Color.RED);
					}else{
						ModifyReceiptInfo modifyUI = new ModifyReceiptInfo(typePool.get(index),listPool.get(index));
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
				new MyNotification(this,"单据成功导出至桌面！",Color.GREEN);
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
				new MyNotification(this,"目前没有找到符合条件的单据！",Color.RED);
			}
		}
	}
	
@SuppressWarnings("unused")
private void getApprovalData(int index) throws RemoteException, MalformedURLException, NotBoundException{
		table = searchPanel.getTable();	
		ReceiptController controller = ControllerFactory.getReceiptController();
		
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
	
	@SuppressWarnings("unused")
	private void getPassData(int index) throws RemoteException, MalformedURLException, NotBoundException{
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
	
	@SuppressWarnings("unused")
	private void getFailureData(int index) throws RemoteException, MalformedURLException, NotBoundException{
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
	
	private void showAll() throws RemoteException{
		try {
			this.getApprovalData(0);
			this.getPassData(0);
			this.getFailureData(0);
		} catch (MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			e.printStackTrace();
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
}


