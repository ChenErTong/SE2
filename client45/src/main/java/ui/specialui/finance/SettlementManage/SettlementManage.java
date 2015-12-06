package ui.specialui.finance.SettlementManage;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.fundbl.DebitAndPayBillController;
import businesslogic.fundbl.DebitAndPayBillShowController;
import state.PayBillItem;
import state.ReceiptType;
import state.ResultMessage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.finance.Frame_Finance;
import vo.receiptvo.DebitAndPayBillVO;
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
	
	public SettlementManage(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		paybillPool = new ArrayList<PaymentBillVO>();
		this.initComponent(frame_Finance);
		this.showAll();
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司运营成本管理", 24, true));

		payReceiptList = new SearchPayReceipt(this);
		this.add(payReceiptList);
		
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
		add.setActionCommand("AddPayReceipt");
		add.addActionListener(this);
		this.add(add);
		
		modify= new MyJButton(868,640,120,30,"确认修改",16);	
		modify.setActionCommand("ConfirmModify");
		modify.addActionListener(this);
		this.add(modify);
	}

	/**
	 * 判断一个字符串是否为数字
	 * @param num
	 * @return 是否是数字
	 */
	private boolean isDigit(String num) {
		if (num.length() == 0) {
			return false;
		}
		for(int i = 0; i < num.length(); i++) {
			if (!Character.isDigit(num.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean isLegal(String num){
		if(!this.isDigit(num)){
			return false;
		}else{
			if(Double.parseDouble(num)<0){
				return false;
			}
		}
		
		return true;
	}
	/**
	 * 显示所有的收款单
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
			
			controller = ControllerFactory.getDebitAndPayBillController();
			ArrayList<PaymentBillVO> paybillVO = new ArrayList<PaymentBillVO>();
			String data = payReceiptList.getData();
			if(data!=null){
				showController.showList(data);
				for(int i = 0; i < paybillVO.size(); i++){
					Object[] rowData = {paybillVO.get(i).ID,paybillVO.get(i).type,paybillVO.get(i).payerName,paybillVO.get(i).accountID,paybillVO.get(i).items,paybillVO.get(i).remarks};
					tableModel.addRow(rowData);
					paybillPool.add(paybillVO.get(i));
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
			}else if(this.isLegal(data[1])){
				new MyNotification(this,"输入的付款金额不合法！",Color.RED);
			}else{
				ResultMessage rsg  = controller.addPayBill(new PaymentBillVO(controller.getPayID(),data[5],ReceiptType.
						PAY,Double.parseDouble(data[1]),data[0],data[2],this.payItem(data[4]),data[3]));
				if(rsg.equals(ResultMessage.SUCCESS)){
					this.showAll();
					addPaybill.refresh();
					new MyNotification(this,"付款单添加成功！",Color.GREEN);
				}else{
					new MyNotification(this,"付款单添加失败！",Color.RED);
				}
				/*switch(i){//String iD, String date, ReceiptType type, double money, String payerName, String accountID,	PayBillItem items, String remarks
				case 0:ResultMessage rsg = controller.addPayBill(new PaymentBillVO(controller.getPayID(),data[5],ReceiptType.
						PAY,Double.parseDouble(data[1]),data[0],data[2],PayBillItem.RentMoney,data[3]));
						if(rsg.equals(ResultMessage.SUCCESS)){
							this.showAll();
							addPaybill.refresh();
							new MyNotification(this,"付款单添加成功！",Color.GREEN);
						}else{
							new MyNotification(this,"付款单添加失败！",Color.RED);
						}
				case 1:ResultMessage rsg1 = controller.addPayBill(new PaymentBillVO(controller.getPayID(),data[5],ReceiptType.
						PAY,Double.parseDouble(data[1]),data[0],data[2],PayBillItem.CARRIGE,data[3]));
						if(rsg1.equals(ResultMessage.SUCCESS)){
							this.showAll();
							addPaybill.refresh();
							new MyNotification(this,"付款单添加成功！",Color.GREEN);
						}else{
							new MyNotification(this,"付款单添加失败！",Color.RED);
						}
				case 2:ResultMessage rsg2 = controller.addPayBill(new PaymentBillVO(controller.getPayID(),data[5],ReceiptType.
						PAY,Double.parseDouble(data[1]),data[0],data[2],PayBillItem.SALARY,data[3]));
						if(rsg2.equals(ResultMessage.SUCCESS)){
							this.showAll();
							addPaybill.refresh();
							new MyNotification(this,"付款单添加成功！",Color.GREEN);
						}else{
							new MyNotification(this,"付款单添加失败！",Color.RED);
						}
				case 3:	ResultMessage rsg3 = controller.addPayBill(new PaymentBillVO(controller.getPayID(),data[5],ReceiptType.
						PAY,Double.parseDouble(data[4]),data[0],data[2],PayBillItem.BONUS,data[3]));
						if(rsg3.equals(ResultMessage.SUCCESS)){
							this.showAll();
							addPaybill.refresh();
							new MyNotification(this,"付款单添加成功！",Color.GREEN);
						}else{
							new MyNotification(this,"付款单添加失败！",Color.RED);
						}*/
				//}
			}
		}else if(e.getActionCommand().equals("ModifyPayReceipt")){
			table = payReceiptList.getTable();
			
			if(table.getSelectedRowCount() == 0){
				new MyNotification(this,"请先选择要修改的付款单！",Color.RED);
			}else{
				paybillID = paybillPool.get(table.getSelectedRow()).ID;
				Object[] data = this.setPayBill();
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
		data[2] = paybillPool.get(table.getSelectedRow()).accountID;
		data[3] = paybillPool.get(table.getSelectedRow()).items;
		data[4] = paybillPool.get(table.getSelectedRow()).remarks;
		data[5] = paybillPool.get(table.getSelectedRow()).date;
		return data;
	}
	
	private void modifyPaybill() {
		table = payReceiptList.getTable();
		controller = ControllerFactory.getDebitAndPayBillController();
		
		String[] data = modifyPaybill.getData();
		if(data==null){
			new MyNotification(this,"请检查付款单信息填写是否完整！",Color.RED);
		}else if(this.isLegal(data[1])){
			new MyNotification(this,"付款金额输入不合法！",Color.RED);
		}else{
			ResultMessage rsg  = controller.updateDraft(new PaymentBillVO(paybillPool.get(table.getSelectedRow()).ID,data[5],ReceiptType.
					PAY,Double.parseDouble(data[1]),data[0],data[2],this.payItem(data[4]),data[3]));
			if(rsg.equals(ResultMessage.SUCCESS)){
				this.showAll();
				addPaybill.refresh();
				new MyNotification(this,"付款单修改成功！",Color.GREEN);
			}else{
				new MyNotification(this,"付款单修改失败！",Color.RED);
			}
		/*	int i = Integer.parseInt(data[4]);
			switch(i){
			case 0:ResultMessage rsg = controller.updateDraft(new PaymentBillVO(paybillPool.get(table.getSelectedRow()).ID,data[5],ReceiptType.
					PAY,Double.parseDouble(data[1]),data[0],data[2],PayBillItem.RentMoney,data[3]));
					if(rsg.equals(ResultMessage.SUCCESS)){
						this.showAll();
						modifyPaybill.refresh();
						new MyNotification(this,"付款单修改成功！",Color.GREEN);
					}else{
						new MyNotification(this,"付款单修改失败！",Color.RED);
					}
			case 1:ResultMessage rsg1 = controller.updateDraft(new PaymentBillVO(paybillPool.get(table.getSelectedRow()).ID,data[5],ReceiptType.
					PAY,Double.parseDouble(data[1]),data[0],data[2],PayBillItem.CARRIGE,data[3]));
					if(rsg1.equals(ResultMessage.SUCCESS)){
						this.showAll();
						modifyPaybill.refresh();
						new MyNotification(this,"付款单修改成功！",Color.GREEN);
					}else{
						new MyNotification(this,"付款单修改失败！",Color.RED);
					}
			case 2:ResultMessage rsg2 = controller.updateDraft(new PaymentBillVO(paybillPool.get(table.getSelectedRow()).ID,data[5],ReceiptType.
					PAY,Double.parseDouble(data[1]),data[0],data[2],PayBillItem.SALARY,data[3]));
					if(rsg2.equals(ResultMessage.SUCCESS)){
						this.showAll();
						modifyPaybill.refresh();
						new MyNotification(this,"付款单修改成功！",Color.GREEN);
					}else{
						new MyNotification(this,"付款单修改失败！",Color.RED);
					}
			case 3:	ResultMessage rsg3 = controller.updateDraft(new PaymentBillVO(paybillPool.get(table.getSelectedRow()).ID,data[5],ReceiptType.
					PAY,Double.parseDouble(data[1]),data[0],data[2],PayBillItem.BONUS,data[3]));
					if(rsg3.equals(ResultMessage.SUCCESS)){
						this.showAll();
						modifyPaybill.refresh();
						new MyNotification(this,"付款单修改成功！",Color.GREEN);
					}else{
						new MyNotification(this,"付款单修改失败！",Color.RED);
					}
			}*/
		}
	}
}
