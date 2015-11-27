package ui.specialui.finance.SettlementManage;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.fundbl.DebitAndPayBillController;
import businesslogic.fundbl.DebitAndPayBillShowController;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.finance.Frame_Finance;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.PaymentBillVO;


public class Panel_Finance_SettlementManage extends MyJPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private PayReceiptInfo payReceiptInfo;
	private PayReceiptList payReceiptList;
	private MyJButton commonButton;
	private MyJTable table;
	
	DebitAndPayBillController controller = ControllerFactory.getDebitAndPayBillController();
	DebitAndPayBillShowController showController = ControllerFactory.getDebitAndPayBillShowController();
	static ArrayList<PaymentBillVO> paybillPool;
	static String[] paybillIDs;
	static String paybillID = "";
	
	public Panel_Finance_SettlementManage(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		paybillPool = new ArrayList<PaymentBillVO>();
		this.initComponent(frame_Finance);
		this.showAll();
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司运营成本管理", 24, true));
		payReceiptInfo = new PayReceiptInfo();
		this.add(payReceiptInfo);
		payReceiptList = new PayReceiptList(this);
		this.add(payReceiptList);
		this.initButton(frame_Finance);
	}

	private void initButton(Frame_Finance frame) {
		MyJButton insertButton = new MyJButton(0, 150, 40, 130,
				"<html>添<br/>加<br/>付<br/>款<br/>单<br/></html>", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_SettlementManage.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

		MyJButton modifyButton = new MyJButton(0, 280, 40, 130,
				"<html>修<br/>改<br/>付<br/>款<br/>单<br/></html>", 18);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_SettlementManage.this.modifyPanel(frame);
				
			}
		});
		modifyButton.setActionCommand("ModifyPayReceipt");
		modifyButton.addActionListener(this);
		this.add(modifyButton);

		MyJButton searchButton = new MyJButton(0, 410, 40, 130,
				"<html>查<br/>看<br/>付<br/>款<br/>单<br/></html>", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_SettlementManage.this.searchPanel(frame);
				
			}
		});
		this.add(searchButton);

		MyJButton calButton = new MyJButton(0, 540, 40, 110,
				"<html>合<br/>计<br/>付<br/>款<br/>单<br/></html>", 18);
		calButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_SettlementManage.this.deletePanel(frame);
				
			}
		});
		calButton.setActionCommand("CalPayReceipt");
		calButton.addActionListener(this);
		this.add(calButton);
	}
	

	private void insertPanel(Frame_Finance frame) {
	this.removeAll();
	this.add(payReceiptList);
	this.add(new MyJLabel(530, 20, 250, 90, "公司运营成本管理", 24, true));
	this.initButton(frame);

	
	payReceiptInfo = new PayReceiptInfo();
	payReceiptInfo.add(new MyJLabel(230,5,120,30,"新增付款单",18,true));
	this.add(payReceiptInfo);
	
	
	commonButton = new MyJButton(890, 670, 120, 30, "添加付款单", 20);
	commonButton.setActionCommand("AddPayReceipt");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}

private void modifyPanel(Frame_Finance frame) {
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司运营成本管理", 24, true));
	this.add(payReceiptList);
	this.initButton(frame);
	
	payReceiptInfo = new PayReceiptInfo();
	payReceiptInfo.add(new MyJLabel(230,5,120,30,"修改付款单",18,true));
	this.add(payReceiptInfo);
	
	commonButton = new MyJButton(890, 670, 150, 30, "修改付款单", 20);
	commonButton.setActionCommand("checkModify");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}

private void searchPanel(Frame_Finance frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司运营成本管理", 24, true));
	this.add(payReceiptList);
	this.initButton(frame);
	
	payReceiptInfo = new PayReceiptInfo();
	payReceiptInfo.setUneditable();
	payReceiptInfo.add(new MyJLabel(230,5,150,30,"查看付款单信息",18,true));
	this.add(payReceiptInfo);
	
	this.repaint();
}

private void deletePanel(Frame_Finance frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530,20, 250, 90, "公司运营结算管理", 24, true));
	this.add(payReceiptList);
	this.initButton(frame);
	
	payReceiptInfo = new PayReceiptInfo();
	payReceiptInfo.setUneditable();
	payReceiptInfo.add(new MyJLabel(230,5,120,30,"合计付款单",18,true));
	this.add(payReceiptInfo);
	
	commonButton = new MyJButton(890, 670, 120, 30, "合计付款单", 20);
	commonButton.setActionCommand("CalculateAllPay");
	commonButton.addActionListener(this);
	this.add(commonButton);
	
	this.repaint();
}
	/**
	 * 显示所有的收款单 pb.ID,pb.type," 付款人： "+pb.payerName+" 付款账号： "+pb.accountID+" 付款条目： "+pb.items+" 备注   "+pb.remarks,pb.date
	 */
	public void showAll(){
		table = payReceiptList.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		paybillPool.clear();
		paybillID = "";
		
//		 showController = ControllerFactory.getDebitAndPayBillShowController();
		 ArrayList<DebitAndPayBillVO> paybillVO = showController.showPay();
		 PaymentBillVO payVO;
		for(int i = 0; i < paybillVO.size(); i++){
			payVO = (PaymentBillVO) paybillVO.get(i);
			Object[] rowData = {payVO.ID,payVO.type,payVO.payerName,payVO.accountID,payVO.items,payVO.remarks};
			tableModel.addRow(rowData);
			paybillPool.add((PaymentBillVO) paybillVO.get(i));
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("SearchPayReceipt")){
			table = payReceiptList.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			paybillPool.clear();
			paybillID = "";
			
			//"模糊查找", "账户编号(ID)", "账户名称", "账户余额"
			controller = ControllerFactory.getDebitAndPayBillController();
			ArrayList<PaymentBillVO> paybillVO = new ArrayList<PaymentBillVO>();
			String data = payReceiptList.getData();
			if(data!=null){//TODO - 与时间有关
				switch(Integer.parseInt(data)){
					//case 0 : bankAccountVO = controller.find(data[1], null);break;
					//case 1 : bankAccountVO = controller.find(data[1], FindTypeAccount.ID);break;
					//case 2 : bankAccountVO = controller.find(data[1], FindTypeAccount.NAME);break;
					//default : bankAccountVO = controller.find(data[1], FindTypeAccount.MONEY);break;
			}
			
				for(int i = 0; i < paybillVO.size(); i++){
					Object[] rowData = {paybillVO.get(i).ID,paybillVO.get(i).type,paybillVO.get(i).payerName,paybillVO.get(i).accountID,paybillVO.get(i).items,paybillVO.get(i).remarks};
					tableModel.addRow(rowData);
				
					paybillPool.add(paybillVO.get(i));
				System.out.println("SearchSucceed!");
					this.add(new MyNotification(this,"共有"+table.getColumnCount()+"个付款单满足条件！",Color.GREEN));
				}	
			}else{
					this.add(new MyNotification(this,"请选择查询日期！",Color.RED));
			}
	
		}else if(e.getActionCommand().equals("AddPayReceipt")){
			String[] data = payReceiptInfo.getData();
			if(data==null){
				this.add(new MyNotification(this,"请检查付款单信息填写是否完整！",Color.RED));
			}else{
			/*	ResultMessage rsg = controller.addPayBill(Double.parseDouble(data[1]), data[0], data[2], data[3], data[4], null);
				if(rsg.equals(ResultMessage.SUCCESS)){
					//System.out.println("AddSucceed!");
					this.showAll();
					this.add(new MyNotification(this,"付款单添加成功！",Color.GREEN));
				}else{
					this.add(new MyNotification(this,"付款单添加失败！",Color.RED));
				}*/
			}
		}else if(e.getActionCommand().equals("ModifyPayReceipt")){
			table = payReceiptList.getTable();
			if(table.getSelectedRowCount() == 0){
				this.add(new MyNotification(this,"请先选择要修改的付款单！",Color.RED));
			}else{
				
				paybillID = paybillPool.get(table.getSelectedRow()).ID;
				//System.out.println(accountID);
				String[] data = new String[6];
				//data[0] = paybillPool.get(table.getSelectedRow())
			
				payReceiptInfo.setData(data);
			}
		}else if(e.getActionCommand().endsWith("CheckModify")){
			table = payReceiptList.getTable();
			paybillID = paybillPool.get(table.getSelectedRow()).ID;
			if(table.getSelectedRow()==0){
				this.add(new MyNotification(this,"请先选择需要修改的付款单！",Color.RED));
			}else{
				if(payReceiptInfo.getData()==null){
					this.add(new MyNotification(this,"请检查付款单信息填写是否完整！",Color.RED));
				}else{
					this.add(new MyNotification(this,"正在修改付款单信息！",Color.GREEN));
					this.modifyPaybill();
				}
			}
		}
		else if(e.getActionCommand().equals("CalPayReceipt")){
			table = payReceiptList.getTable();
			if(table.getSelectedRowCount() == 0){
				this.add(new MyNotification(this,"请先选择要合计的付款单！",Color.RED));
			}else{
				for(int i=0;i<table.getSelectedRowCount();i++){
					paybillIDs[i] = paybillPool.get(table.getSelectedRow()).ID;
				}
			}
		}else if(e.getActionCommand().equals("CalculateAllPay")){
			table = payReceiptList.getTable();
			//paybillID = paybillPool.get(table.getSelectedRow()).ID;
			if(table.getSelectedRow()==0){
				this.add(new MyNotification(this,"请先选择需要修改的付款单！",Color.RED));
			}else{
				this.calAllPayBill();
			}
		}
	
	}

	private void modifyPaybill() {
		table = payReceiptList.getTable();
		controller = ControllerFactory.getDebitAndPayBillController();
		
		String[] data = payReceiptInfo.getData();
		//ResultMessage rsg = controller.updateDraft(po) TODO --为啥参数是POorz
		//if(rsg.equals(ResultMessage.SUCCESS)){
			//System.out.println("ModifySucceed!");
			//this.showAll();
			//this.add(new MyNotification(this,"账户修改成功！",Color.GREEN));		
		//}else{
			//this.add(new MyNotification(this,"账户修改失败！",Color.RED));
		//}
	
	}
	
	private void calAllPayBill(){
		
	}
}
