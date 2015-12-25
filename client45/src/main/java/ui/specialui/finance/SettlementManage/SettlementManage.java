package ui.specialui.finance.SettlementManage;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.fundbl.DebitAndPayBillController;
import businesslogic.fundbl.DebitAndPayBillShowController;
import state.PayBillItem;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import ui.image.FinanceImage.BankAccountImage;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.finance.Frame_Finance;
import vo.receiptvo.PaymentBillVO;

/**
 * 财务人员实现付款单增删改查Panel
 * @author zsq
 * @version 2015/12/5 10：20
 */
public class SettlementManage extends MyJPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private SearchPayReceipt payReceiptList;
	private AddPayBill addPaybill;
	private ModifyPayBill modifyPaybill;
	private ViewPayBill viewPaybill;
	private MyButton viewButton;
	private MyButton modifyButton;
	private MyButton add;
	private MyButton modify;
	private MyJTable table;
	
	DebitAndPayBillShowController showController;
	DebitAndPayBillController controller ;

	static ArrayList<PaymentBillVO> paybillPool;
	static String[] paybillIDs;
	static String paybillID = "";
	
	public SettlementManage(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		paybillPool = new ArrayList<PaymentBillVO>();
		this.initComponent(frame_Finance);
		this.showAll();
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 300, 40, "公司运营成本管理", 30, true));

		payReceiptList = new SearchPayReceipt(this);
		this.add(payReceiptList);
		
		addPaybill = new AddPayBill();
		this.add(addPaybill);
		
		modifyPaybill = new ModifyPayBill();
		this.add(modifyPaybill);
		
		viewPaybill = new ViewPayBill();
		this.add(viewPaybill);
		
		viewButton = new MyButton(150,346-30,180,30,FinanceImage.getBUTTON_VIEWPAY());
		viewButton.setActionCommand("ViewPayBill");
		viewButton.addActionListener(this);
		this.add(viewButton);
		
		modifyButton = new MyButton(350,346-30,180,30,FinanceImage.getBUTTON_MODIFYPAY());
		modifyButton.setActionCommand("ModifyPayReceipt");
		modifyButton.addActionListener(this);
		this.add(modifyButton);
		
		add = new MyButton(868+10,346-30,120,30,BankAccountImage.getBUTTON_ADD());	
		add.setActionCommand("AddPayReceipt");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyButton(868+10,640-30,120,30,BankAccountImage.getBUTTON_CONFIRM());	
		modify.setActionCommand("ConfirmModify");
		modify.addActionListener(this);
		this.add(modify);
	}
	

	/**
	 * 判断输入的付款金额是否合法
	 * @param num
	 * @return true为合法，false为不合法
	 */
	private boolean isLegal (String num){
		
		try{
			if(BigDecimal.valueOf(Double.parseDouble(num)).compareTo(BigDecimal.ZERO)<0){
				return false;
			}
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	/**
	 * 显示所有的付款单
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
		
		try {
			showController = ControllerFactory.getDebitAndPayBillShowController();
			ArrayList<PaymentBillVO> paybillVO = showController.show(ReceiptType.PAY, ReceiptState.APPROVALING);
			ArrayList<PaymentBillVO> paybillVO_1 = showController.show(ReceiptType.PAY, ReceiptState.SUCCESS);
			ArrayList<PaymentBillVO> paybillVO_2 = showController.show(ReceiptType.PAY, ReceiptState.FAILURE);
			if(paybillVO==null&&paybillVO_2==null&&paybillVO_1==null){
				return;
			}
			PaymentBillVO payVO;
			for(int i = 0; i < paybillVO.size(); i++){
				payVO = (PaymentBillVO) paybillVO.get(i);
				Object[] rowData = {payVO.ID,payVO.payerName,payVO.money,payVO.bankAccountID,payVO.items.value,payVO.remarks,payVO.date};
				tableModel.addRow(rowData);
				paybillPool.add((PaymentBillVO) paybillVO.get(i));
			}
			for(int i = 0; i <  paybillVO_1.size(); i++){
				payVO = (PaymentBillVO)  paybillVO_1.get(i);
				Object[] rowData = {payVO.ID,payVO.payerName,payVO.money,payVO.bankAccountID,payVO.items.value,payVO.remarks,payVO.date};
				tableModel.addRow(rowData);
				paybillPool.add((PaymentBillVO) paybillVO_1.get(i));
			}
			for(int i = 0; i <  paybillVO_2.size(); i++){
				payVO = (PaymentBillVO)  paybillVO_2.get(i);
				Object[] rowData = {payVO.ID,payVO.payerName,payVO.money,payVO.bankAccountID,payVO.items.value,payVO.remarks,payVO.date};
				tableModel.addRow(rowData);
				paybillPool.add((PaymentBillVO) paybillVO_2.get(i));
			}
		
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
			return;
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
			
			ArrayList<PaymentBillVO> paybillVO = new ArrayList<PaymentBillVO>();
			int data = payReceiptList.getData();
			if(data!=3){
			
				try {
					controller = ControllerFactory.getDebitAndPayBillController();
					switch (data){
					case 0:paybillVO = showController.show(ReceiptType.PAY, ReceiptState.APPROVALING);
							for(int i = 0; i < paybillVO.size(); i++){
								Object[] rowData = {paybillVO.get(i).ID,paybillVO.get(i).type,paybillVO.get(i).payerName,paybillVO.get(i).bankAccountID,paybillVO.get(i).items.value,paybillVO.get(i).remarks};
								tableModel.addRow(rowData);
								paybillPool.add(paybillVO.get(i));
							}	new MyNotification(this,"共有"+table.getRowCount()+"个付款单满足条件！",Color.GREEN);break;
					case 1:paybillVO = showController.show(ReceiptType.PAY, ReceiptState.SUCCESS);
							for(int i = 0; i < paybillVO.size(); i++){
								Object[] rowData = {paybillVO.get(i).ID,paybillVO.get(i).type,paybillVO.get(i).payerName,paybillVO.get(i).bankAccountID,paybillVO.get(i).items.value,paybillVO.get(i).remarks};
								tableModel.addRow(rowData);
								paybillPool.add(paybillVO.get(i));
								
							}	new MyNotification(this,"共有"+table.getRowCount()+"个付款单满足条件！",Color.GREEN);break;
					case 2:paybillVO = showController.show(ReceiptType.PAY, ReceiptState.FAILURE);
							for(int i = 0; i < paybillVO.size(); i++){
								Object[] rowData = {paybillVO.get(i).ID,paybillVO.get(i).type,paybillVO.get(i).payerName,paybillVO.get(i).bankAccountID,paybillVO.get(i).items.value,paybillVO.get(i).remarks};
								tableModel.addRow(rowData);
								paybillPool.add(paybillVO.get(i));
								
							}	new MyNotification(this,"共有"+table.getRowCount()+"个付款单满足条件！",Color.GREEN);break;
					default:break;
					}
					
		
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
					return;
				}	
			}else{
					new MyNotification(this,"请选择受收款单状态！",Color.RED);
			}
			
		}else if(e.getActionCommand().equals("AddPayReceipt")){
			String[] data = addPaybill.getData();
			if(data==null){
					new MyNotification(this,"请检查付款单信息填写是否完整！",Color.RED);
			}else if(!this.isLegal(data[1])){
				new MyNotification(this,"输入的付款金额不合法！",Color.RED);
			}else{
				try {
					controller = ControllerFactory.getDebitAndPayBillController();
					ResultMessage rsg  = controller.addPayBill(new PaymentBillVO(controller.getPayID(),data[5],ReceiptType.
							PAY,new BigDecimal(data[1]),data[0],data[2],this.payItem(data[4]),data[3]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						this.showAll();
						new MyNotification(this,"付款单添加成功！",Color.GREEN);
						addPaybill.refresh();
					}else{
						new MyNotification(this,"付款单添加失败！",Color.RED);
					}
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
					return;
				}
			}
		}else if(e.getActionCommand().equals("ModifyPayReceipt")){
			table = payReceiptList.getTable();
			if(table.getSelectedRowCount()==0){
				new MyNotification(this,"请先选择需要修改的付款单！",Color.RED);
			}else{
				Object[] data = this.setPayBill();
				modifyPaybill.setData(data);
			}
			
		}else if(e.getActionCommand().endsWith("ConfirmModify")){
			table = payReceiptList.getTable();
		
			if(modifyPaybill.getData()==null){
				new MyNotification(this,"请检查付款单信息填写是否完整！",Color.RED);
			}else{
				new MyNotification(this,"正在修改付款单信息！",Color.GREEN);
				this.modifyPaybill();
			}
			
		}else if(e.getActionCommand().equals("ViewPayBill")){
			table = payReceiptList.getTable();
			if(table.getSelectedRowCount()==0){
				new MyNotification(this,"请先选择要查看的付款单！",Color.RED);
			}else{
				paybillID = paybillPool.get(table.getSelectedRow()).ID;
				Object[] data = this.setPayBill();
				viewPaybill.setData(data);
			}
		}
	}
	
	/**
	 * 判断此时添加/修改哪种类型的付款单
	 * @param num
	 * @return PayBillItem
	 */
	private PayBillItem  payItem(String num){
		int i = Integer.parseInt(num);
		switch(i){
		case 0: return PayBillItem.RentMoney;
		case 1: return PayBillItem.CARRIGE;
		case 2: return PayBillItem.SALARY;
		case 3:return PayBillItem.BONUS;
		default: break;
		}
		return null;
	}
	
	/**
	 * 获取要填入修改、查看面板的数据
	 * @return
	 */
	private Object[] setPayBill(){
		Object[] data = new String[6];
		data[0] = paybillPool.get(table.getSelectedRow()).payerName;
		data[1] = paybillPool.get(table.getSelectedRow()).money+"";
		data[2] = paybillPool.get(table.getSelectedRow()).bankAccountID;
		data[3] = paybillPool.get(table.getSelectedRow()).remarks;
		data[4] = paybillPool.get(table.getSelectedRow()).items.value;
		data[5] = paybillPool.get(table.getSelectedRow()).date;
		return data;
	}
	

	/**
	 * 修改付款单
	 */
	private void modifyPaybill() {
		table = payReceiptList.getTable();
		
		String[] data = modifyPaybill.getData();
		if(data==null){
			new MyNotification(this,"请检查付款单信息填写是否完整！",Color.RED);
		}else if(!this.isLegal(data[1])){
			new MyNotification(this,"付款金额输入不合法！",Color.RED);
		}else{
			try {
				controller = ControllerFactory.getDebitAndPayBillController();
				
				ResultMessage rsg  = controller.updateDraft(new PaymentBillVO(paybillPool.get(table.getSelectedRow()).ID,data[5],ReceiptType.
						PAY,new BigDecimal(data[1]),data[0],data[2],this.payItem(data[4]),data[3]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					
						this.showAll();
						modifyPaybill.refresh();
						new MyNotification(this,"付款单修改成功！",Color.GREEN);
					
				}else{
					new MyNotification(this,"付款单修改失败！",Color.RED);
				}
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
				return;
			}
		}
	}
}
