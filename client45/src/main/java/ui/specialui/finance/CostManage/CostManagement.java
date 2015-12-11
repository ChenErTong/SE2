package ui.specialui.finance.CostManage;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.fundbl.DebitAndPayBillShowController;
import businesslogic.recordbl.RecordController;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.finance.Frame_Finance;
import vo.BussinessOneDayVO;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;

/**
 * 实现财务人员查看收款单和进行收款单合计功能的总Panel
 * @author zsq
 * @version 2015/11/30 23:45
 */

public class CostManagement extends MyJPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private SearchDebitReceipt debitReceiptList;
	private DebitReceiptInfo debitReceiptInfo;
	private CalAllDebit calAll;

	private MyButton calButton;
	private MyButton viewButton;
	private MyJTable table;
	
	private DebitAndPayBillShowController showController;
	private RecordController showController_2;

	static ArrayList<DebitBillVO> debitbillPool;
	static String[] debitbillIDs;
	static String debitBillID = "";
	
	public CostManagement(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
		this.showAll();
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(515, 20, 300, 40, "公司运营结算管理", 30, true));
		debitReceiptList = new SearchDebitReceipt(this);
		this.add(debitReceiptList);
		
		debitReceiptInfo = new DebitReceiptInfo();
		debitReceiptInfo.setUneditable();
		this.add(debitReceiptInfo);
		
		calAll = new CalAllDebit();
		this.add(calAll);
		
		calButton = new MyButton(150,660-30,180,30,FinanceImage.getButton_HEJISHOUKUAN());
		calButton.setActionCommand("CalDebit");
		calButton.addActionListener(this);
		this.add(calButton);
		
		viewButton = new MyButton(350,660-30,180,30,FinanceImage.getBUTTON_VIEWDEBIT());
		viewButton.setActionCommand("ViewDebit");
		viewButton.addActionListener(this);
		this.add(viewButton);
		
		this.leadline(frame_Finance);
		debitbillPool = new ArrayList<DebitBillVO>();
	}
	
	public void leadline(Frame_Finance frame_Finance){
		MyButton CostManage = new MyButton(300, 690, 95, 20,FinanceImage.getBUTTON_JIESUAN_());
		CostManage.setActionCommand("CostManage");
		CostManage.addActionListener(frame_Finance);
		this.add(CostManage);
		CostManage.setVisible(true);
		
		MyButton SettlementManage = new MyButton(395+10,690,95,20,FinanceImage.getBUTTON_COST_());
		SettlementManage.setActionCommand("SettlementManage");
		SettlementManage.addActionListener(frame_Finance);
		this.add(SettlementManage);
		SettlementManage.setVisible(true);
		
		MyButton BankAccountManage = new MyButton(395+10+105,690,120,20,FinanceImage.getBUTTON_BANK_());
		BankAccountManage.setActionCommand("BankAccountManage");
		BankAccountManage.addActionListener(frame_Finance);
		this.add(BankAccountManage);
		BankAccountManage.setVisible(true);
		
		MyButton OpenningStock = new MyButton(405+105+120+10,690,120,20,FinanceImage.getBUTTON_QICHU_());
		OpenningStock.setActionCommand("OpenningStock");
		OpenningStock.addActionListener(frame_Finance);
		this.add(OpenningStock);
		OpenningStock.setVisible(true);
		
		MyButton ViewBusinessPerformance = new MyButton(510+130+120+10+5,690,120,20,FinanceImage.getButton_JINGYING_());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(frame_Finance);
		this.add(ViewBusinessPerformance);
		ViewBusinessPerformance.setVisible(true);
		
		MyButton ViewIncomeStatement = new MyButton(770+130+10,690,120,20,FinanceImage.getButton_CHENGBEN_());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(frame_Finance);
		this.add(ViewIncomeStatement);
		ViewIncomeStatement.setVisible(true);
		
		MyButton viewLog = new MyButton(770+130+130+15,690,120,20,FinanceImage.getButton_LOG_());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(frame_Finance);
		this.add(viewLog);
	}
	
	/**
	 * 显示所有的收款单 
	 */
	public void showAll(){
		
		table = debitReceiptList.getTable();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		debitbillPool.clear();
		debitBillID = "";
		
		 try {
			 showController = ControllerFactory.getDebitAndPayBillShowController();
			ArrayList<DebitAndPayBillVO> debitbillVO = showController.showExpense();
			if(debitbillVO== null){
				return ;
			}
			 DebitBillVO debitVO;
			for(int i = 0; i < debitbillVO.size(); i++){
				debitVO = ( DebitBillVO) debitbillVO.get(i);
				Object[] rowData = {debitVO.ID,debitVO.date,debitVO.courierID,debitVO.money,debitVO.orderNumbers};
				tableModel.addRow(rowData);
				debitbillPool.add((DebitBillVO) debitbillVO.get(i));
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ViewDebit")){
			table = debitReceiptList.getTable();
			if(table.getSelectedRowCount()==0){
				new MyNotification(this,"请先选择要查看的收款单！",Color.RED);
			}else{
				debitBillID = debitbillPool.get(table.getSelectedRow()).ID;
				Object[] data = new String[4];
				data[0] = debitbillPool.get(table.getSelectedRow()).date;
				data[1] = debitbillPool.get(table.getSelectedRow()).money+"";
				data[2] = debitbillPool.get(table.getSelectedRow()).courierID;
				data[3] = debitbillPool.get(table.getSelectedRow()).orderNumbers;
				debitReceiptInfo.setData(data);
				MyJTable table = debitReceiptInfo.getTable();
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				
				int rowCount = table.getRowCount();
				for(int i = 0; i < rowCount; i++){
					tableModel.removeRow(0);
				}
				ArrayList<String> orderlists  = debitbillPool.get(table.getSelectedRow()).orderNumbers;
				for(int i = 0; i < orderlists.size();i++){
					String orderNumber = orderlists.get(i);
					Object[] rowData = {orderNumber,""};
					tableModel.addRow(rowData);
				}
				
			}
		}else if(e.getActionCommand().equals("CalDebit")){
			table = debitReceiptList.getTable();
			BigDecimal earnings=new BigDecimal(0);
			if(table.getSelectedRowCount()==0){
				new MyNotification(this,"请先选择要合计的收款单！",Color.RED);
			}else{
				try {
					showController_2 = ControllerFactory.getRecordController();
					String[] data = debitReceiptList.getData();
					BussinessOneDayVO debitbillVO ;
					if(data!=null){
						debitbillVO =  showController_2.bussinessOneDay(data[0],data[1]);
						earnings = debitbillVO.earnings;
						calAll.init(earnings+"");
					}
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					e1.printStackTrace();
				}
			}
		}else if(e.getActionCommand().equals("SearchDebitReceipt")){
			table = debitReceiptList.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			debitbillPool.clear();
			debitBillID = "";
			
			BussinessOneDayVO debitbillVO ;
			String[] data = debitReceiptList.getData();
			if(data!=null){
				Date current = new Date();
				String year = data[1];
				SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
				year = (isDigit(year))?year:sdfYear.format(current);//默认为当年
				String month = data[2];
				month = (isDigit(month)) ? ("-" + month) : "";
				String day = data[3];
				day = (isDigit(day) && month.length() != 0) ? ("-" + day) : "";
				String date = year + month + day;
				
				try {
					showController_2 = ControllerFactory.getRecordController();
					debitbillVO=showController_2.bussinessOneDay(data[0], date);
						Object[] rowData = {debitbillVO.DebitBills};
						tableModel.addRow(rowData);
						System.out.println("SearchSucceed!");
						new MyNotification(this,"共有"+table.getRowCount()+"个付款单满足条件！",Color.GREEN);
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络连接！",Color.RED);
					e1.printStackTrace();
				}
			}else{
					new MyNotification(this,"请选择查询日期！",Color.RED);
			}
		}
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
}