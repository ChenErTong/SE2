package ui.specialui.finance.SettlementManage;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.fundbl.DebitAndPayBillController;
import businesslogic.fundbl.DebitAndPayBillShowController;
import state.ResultMessage;
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
	private PayReceiptList payReceiptList;
	private AddPayBill addPaybill;
	private ModifyPayBill modifyPaybill;
	private ViewPayBill viewPaybill;
	private MyJButton viewButton;
	private MyJButton modifyButton;
	private MyJButton add;
	private MyJButton modify;
	private MyJTable table;
	DebitAndPayBillShowController showController;
	
	DebitAndPayBillController controller ;

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
	//	payReceiptInfo = new PayReceiptInfo();
		//this.add(payReceiptInfo);
		payReceiptList = new PayReceiptList(this);
		this.add(payReceiptList);
	//	this.initButton(frame_Finance);
		addPaybill = new AddPayBill();
		this.add(addPaybill);
		modifyPaybill = new ModifyPayBill();
		this.add(modifyPaybill);
		viewPaybill = new ViewPayBill();
		this.add(viewPaybill);
		viewButton = new MyJButton(150,346,150,30,"查看所选收款单",16);
		viewButton.setActionCommand("ViewPayBill");
		viewButton.addActionListener(this);
		this.add(viewButton);
		
		modifyButton = new MyJButton(350,346,150,30,"修改所选收款单",16);
		modifyButton.setActionCommand("ModifyPayReceipt");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
		
		add = new MyJButton(868,346,120,30,"确认添加",16);	
		add.setActionCommand("AddPayReceieptt");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyJButton(868,640,120,30,"确认修改",16);	
		modify.setActionCommand("ConfirmModify");
		modify.addActionListener(this);
		this.add(modify);
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
		
		showController = ControllerFactory.getDebitAndPayBillShowController();
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
				showController.showList(data);
				for(int i = 0; i < paybillVO.size(); i++){
					Object[] rowData = {paybillVO.get(i).ID,paybillVO.get(i).type,paybillVO.get(i).payerName,paybillVO.get(i).accountID,paybillVO.get(i).items,paybillVO.get(i).remarks};
					tableModel.addRow(rowData);
				
					paybillPool.add(paybillVO.get(i));
				System.out.println("SearchSucceed!");
					new MyNotification(this,"共有"+table.getColumnCount()+"个付款单满足条件！",Color.GREEN);
				}	
			}else{
					new MyNotification(this,"请选择查询日期！",Color.RED);
			}
	
		}else if(e.getActionCommand().equals("AddPayReceipt")){
			controller = ControllerFactory.getDebitAndPayBillController();
			String[] data = addPaybill.getData();
			if(data==null){
					new MyNotification(this,"请检查付款单信息填写是否完整！",Color.RED);
			}else{
				int i = Integer.parseInt(data[4]);
				switch(i){
				case 0:
				case 1:
				case 2:
				case 3:	
				}
			//	ResultMessage rsg = controller.addPayBill(Double.parseDouble(data[1]), data[0], data[2], ReceiptType.PAY, PayBillItem.BONUS, "", data[4]);
				/*ResultMessage rsg = controller.addPayBill(data[0], data[1], null, getAlignmentX(), data[2], data[3], null, data[5]);
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
				new MyNotification(this,"请先选择要修改的付款单！",Color.RED);
			}else{
				
				paybillID = paybillPool.get(table.getSelectedRow()).ID;/*"付款人","付款金额","付款账号","付款条目","付款备注","付款日期"};*/
				//System.out.println(accountID);
				Object[] data = new String[6];
				data[0] = paybillPool.get(table.getSelectedRow()).payerName;
				data[1] = paybillPool.get(table.getSelectedRow()).money+"";
				data[2] = paybillPool.get(table.getSelectedRow()).accountID;
				data[3] = paybillPool.get(table.getSelectedRow()).remarks;
				data[4] = paybillPool.get(table.getSelectedRow()).items;
				data[5] = paybillPool.get(table.getSelectedRow()).date;
			
				modifyPaybill.setData(data);
			}
		}else if(e.getActionCommand().endsWith("CheckModify")){
			table = payReceiptList.getTable();
			paybillID = paybillPool.get(table.getSelectedRow()).ID;
			if(table.getSelectedRow()==0){
				new MyNotification(this,"请先选择需要修改的付款单！",Color.RED);
			}else{
				if(modifyPaybill.getData()==null){
					new MyNotification(this,"请检查付款单信息填写是否完整！",Color.RED);
				}else{
					new MyNotification(this,"正在修改付款单信息！",Color.GREEN);
					this.modifyPaybill();
				}
			}
		}else if(e.getActionCommand().equals("ViewPayBill")){
			table = payReceiptList.getTable();
			if(table.getSelectedRowCount()==0){
				new MyNotification(this,"请先选择要查看的付款单！",Color.RED);
			}else{
				paybillID = paybillPool.get(table.getSelectedRow()).ID;
				Object[] data = new String[6];
				data[0] = paybillPool.get(table.getSelectedRow()).payerName;
				data[1] = paybillPool.get(table.getSelectedRow()).money+"";
				data[2] = paybillPool.get(table.getSelectedRow()).accountID;
				data[3] = paybillPool.get(table.getSelectedRow()).items;
				data[4] = paybillPool.get(table.getSelectedRow()).remarks;
				data[5] = paybillPool.get(table.getSelectedRow()).date;
				
				viewPaybill.setData(data);
			}
		}
	}

	private void modifyPaybill() {
		table = payReceiptList.getTable();
		controller = ControllerFactory.getDebitAndPayBillController();
		
		String[] data = modifyPaybill.getData();
		ResultMessage rsg=  controller.updateDraft(new PaymentBillVO(data[0], data[1], null, getAlignmentX(), data[2], data[3], null, data[5]));
		
		if(rsg.equals(ResultMessage.SUCCESS)){
			System.out.println("ModifySucceed!");
			this.showAll();
			new MyNotification(this,"付款单修改成功！",Color.GREEN);		
		}else{
			new MyNotification(this,"付款单修改失败！",Color.RED);
		}
	
	}
}
