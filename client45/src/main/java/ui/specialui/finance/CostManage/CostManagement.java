package ui.specialui.finance.CostManage;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司运营结算管理", 24, true));
		debitReceiptList = new SearchDebitReceipt(this);
		this.add(debitReceiptList);
		
		debitReceiptInfo = new DebitReceiptInfo();
		debitReceiptInfo.setUneditable();
		this.add(debitReceiptInfo);
		
		calAll = new CalAllDebit();
		this.add(calAll);
		
		calButton = new MyButton(150,660,180,30,FinanceImage.getButton_HEJISHOUKUAN());
		calButton.setActionCommand("CalDebit");
		calButton.addActionListener(this);
		this.add(calButton);
		
		viewButton = new MyButton(350,660,180,30,FinanceImage.getBUTTON_VIEWDEBIT());
		viewButton.setActionCommand("ViewDebit");
		viewButton.addActionListener(this);
		this.add(viewButton);
		debitbillPool = new ArrayList<DebitBillVO>();
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
		
		showController = ControllerFactory.getDebitAndPayBillShowController();
		
		 ArrayList<DebitAndPayBillVO> debitbillVO = showController.showExpense();
		 DebitBillVO debitVO;
		for(int i = 0; i < debitbillVO.size(); i++){
			debitVO = ( DebitBillVO) debitbillVO.get(i);
			Object[] rowData = {debitVO.ID,debitVO.date,debitVO.courierID,debitVO.money,debitVO.orderNumbers};
			tableModel.addRow(rowData);
			debitbillPool.add((DebitBillVO) debitbillVO.get(i));
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
				showController_2 = ControllerFactory.getRecordController();
				String[] data = debitReceiptList.getData();
				BussinessOneDayVO debitbillVO ;
				if(data!=null){
					debitbillVO =  showController_2.bussinessOneDay(data[0],data[1]);
					earnings = debitbillVO.earnings;
					calAll.init(earnings+"");
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
			showController_2 = ControllerFactory.getRecordController();
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
				
				debitbillVO=showController_2.bussinessOneDay(data[0], date);
					Object[] rowData = {debitbillVO.DebitBills};
					tableModel.addRow(rowData);
					System.out.println("SearchSucceed!");
					new MyNotification(this,"共有"+table.getRowCount()+"个付款单满足条件！",Color.GREEN);
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