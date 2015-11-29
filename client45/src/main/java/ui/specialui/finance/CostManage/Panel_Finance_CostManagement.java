package ui.specialui.finance.CostManage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.fundbl.DebitAndPayBillShowController;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.specialui.finance.Frame_Finance;
import vo.receiptvo.DebitAndPayBillVO;
import vo.receiptvo.DebitBillVO;

public class Panel_Finance_CostManagement extends MyJPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private DebitReceiptList debitReceiptList;
	private Panel_Finance_DebitReceiptInfo debitReceiptInfo;
	private CalAllDebit calAll;
	private MyJButton calButton;
	private MyJButton viewButton;
	private MyJTable table;
	private DebitAndPayBillShowController showController;
	static ArrayList<DebitBillVO> debitbillPool;
	static String[] debitbillIDs;
	static String debitBillID = "";
	
	public Panel_Finance_CostManagement(Frame_Finance frame_Finance) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司运营结算管理", 24, true));
		debitReceiptList = new DebitReceiptList(this);
		this.add(debitReceiptList);
		
		debitReceiptInfo = new Panel_Finance_DebitReceiptInfo();
		debitReceiptInfo.setUneditable();
		this.add(debitReceiptInfo);
		
		calAll = new CalAllDebit();
		this.add(calAll);
		
		calButton = new MyJButton(150,660,180,30,"合计收款单",16);
		calButton.setActionCommand("CalDebit");
		calButton.addActionListener(this);
		this.add(calButton);
		
		viewButton = new MyJButton(350,660,180,30,"查看所选收款单",16);
		viewButton.setActionCommand("ViewDebit");
		viewButton.addActionListener(this);
		this.add(viewButton);
		debitbillPool = new ArrayList<DebitBillVO>();
		//this.showAll();

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
		
		}else if(e.getActionCommand().equals("CalDebit")){
	
		}else if(e.getActionCommand().equals("Search")){
			
		}
	}	
}