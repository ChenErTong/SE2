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
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import ui.commonui.receipt_constructor.ReceiptConductor;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import vo.ValueObject;
import vo.receiptvo.ReceiptVO;
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
			//receiptController =ControllerFactory.getReceiptController();
			//ArrayList<ReceiptVO> dontPassList = new ArrayList<ReceiptVO>();
		//	ArrayList<ReceiptType> dontPassType =  new ArrayList<ReceiptType>();
			//dontPassList.add((ReceiptVO)listPool.get(index));
		//	dontPassType.add(typePool.get(index));
			//ResultMessage rm = receiptController.dontPassReceipt(dontPassList,ReceiptType.BRANCH_ARRIVAL);
			
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
		/**
		 * @author Ann
		 */
		//TODO 我的锅，一会给你加方法
		//ArrayList<ReceiptVO> vo = controller.showReceipt(ReceiptState.APPROVALING);//待审批的单据
	//	ApprovalShow controller = new ApprovalShow();
		//ApprovalVO vo = controller.ShowApproving();
	//	ArrayList<PurchaseVO> approval_pur = vo.purchaseVOs;
	//	ArrayList<SalesVO> approval_sale = vo.salesVOs;
		//ArrayList<AccountBillVO> approval_account = vo.accountBillVOs;
		//ArrayList<InventoryBillVO> approval_inventory = vo.inventoryBillVOs;
		//ArrayList<CashBillVO> approval_cashBill = vo.cashBillVOs;
		
		model = (DefaultTableModel) table.getModel();
		
		if(index == 0)
			for(int i = 1; i <= 5; i++)
				getApprovalData(i);
		
		if(index == 1){
			/*for(int i = 0; i < approval_pur.size(); i++){
				Object[] rowData = {null, "进货类单据", approval_pur.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add(approval_pur.get(i));
				typePool.add(approval_pur.get(i).type);*/
		}
		
		if(index == 2){
			/*for(int i = 0; i < approval_sale.size(); i++){
				Object[] rowData = {new Boolean(false), "销售类单据", approval_sale.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add(approval_sale.get(i));
				typePool.add(approval_sale.get(i).type);*/
		}
		
		if(index == 3){
			/*for(int i = 0; i < approval_account.size(); i++){
				Object[] rowData = {new Boolean(false), "财务类单据", approval_account.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add(approval_account.get(i));
				typePool.add(approval_account.get(i).type);*/
		}
		
		if(index == 4){
			/*for(int i = 0; i < approval_inventory.size(); i++){
				Object[] rowData = {new Boolean(false), "库存类单据", approval_inventory.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add(approval_inventory.get(i));
				typePool.add(approval_inventory.get(i).billType);*/
		}
		
		if(index == 5){
			/*for(int i = 0; i < approval_cashBill.size(); i++){
				Object[] rowData = {new Boolean(false), "现金类单据", approval_cashBill.get(i).ID, "未审批"};
				model.addRow(rowData);
				listPool.add(approval_cashBill.get(i));
				typePool.add(BillType.CASH);
			}*/
		}
	}
	
	private void getPassData(int index) throws RemoteException{
	
	}
	
	private void getFailureData(int index) throws RemoteException{
		
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


