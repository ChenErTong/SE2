package ui.specialui.finance.OpenningStock;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businesslogic.openingstockbl.OpeningStockController;
import businesslogicservice.openingstockblservice.OpeningStockBLService;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.specialui.finance.Frame_Finance;
import vo.OpeningStockVO;
@SuppressWarnings("unused")

public class Panel_Finance_OpenningStock extends MyJPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	//private Panel_Finance_OpenningStockInfo openningStockInfo;
	//private MyJButton commonButton;
	private MyJButton insertButton;
	private MyJButton searchButton;
	
	private MyJTable transferTable,branchTable,employTable,facilityTable,inventoryTable,bankAccountTable;
	public Panel_Finance_OpenningStock(Frame_Finance frame_Finance) {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司期初建账管理", 24, true));
		this.initButton(frame_Finance);
		String[] headers = {"机构编号", "日期","机构类型","机构地址","机构人数"};
		transferTable= new MyJTable(headers,true);
		transferTable.setBackground(new Color(40, 42, 66));
		transferTable.setForeground(Color.WHITE);
		transferTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		transferTable.setDefaultRenderer(Object.class, tcr);

		
		String[] headers2 = {"人员编号", "日期","姓名","职务权限","工作时间"};
		employTable = new MyJTable(headers2,true);
		employTable.setBackground(new Color(40, 42, 66));
		employTable.setForeground(Color.WHITE);
		employTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();// 设置table内容居中
		tcr1.setHorizontalAlignment(JLabel.CENTER);
		employTable.setDefaultRenderer(Object.class, tcr1);
		
		String[] headers3 = {"车辆编号", "日期","车辆购入日期","车牌号","运输历史"};
		facilityTable = new MyJTable(headers3,true);
		facilityTable.setBackground(new Color(40, 42, 66));
		facilityTable.setForeground(Color.WHITE);
		facilityTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();// 设置table内容居中
		tcr2.setHorizontalAlignment(JLabel.CENTER);
		facilityTable.setDefaultRenderer(Object.class, tcr2);
		
		String[] headers4 = {"库存编号", "日期"};
		inventoryTable = new MyJTable(headers4,true);
		inventoryTable.setBackground(new Color(40, 42, 66));
		inventoryTable.setForeground(Color.WHITE);
		inventoryTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr3 = new DefaultTableCellRenderer();// 设置table内容居中
		tcr3.setHorizontalAlignment(JLabel.CENTER);
		inventoryTable.setDefaultRenderer(Object.class, tcr3);
		
		String[] headers5 = {"账户编号","日期", "账户名称", "账户金额"};
		bankAccountTable = new MyJTable(headers5,false);
		bankAccountTable.setBackground(new Color(40, 42, 66));
		bankAccountTable.setForeground(Color.WHITE);
		bankAccountTable.setFont(new MyFont(14));
		
		DefaultTableCellRenderer tcr4 = new DefaultTableCellRenderer();// 设置table内容居中
		tcr4.setHorizontalAlignment(JLabel.CENTER);
		bankAccountTable.setDefaultRenderer(Object.class, tcr4);
		
		JScrollPane jsp = new JScrollPane(transferTable);
		jsp.setBounds(80, 90, 1085,  512/5);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		JScrollPane jsp2 = new JScrollPane(employTable);
		jsp2.setBounds(80, 90+ (512/5)*1 + 10, 1085, 512/5 );
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		JScrollPane jsp3 = new JScrollPane(facilityTable);
		jsp3.setBounds(80, 90 + (512/5)*2 + 20, 1085, 512/5 );
		jsp3.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp3.setOpaque(false);
		jsp3.setVisible(true);
		this.add(jsp3);
		
		JScrollPane jsp4 = new JScrollPane(inventoryTable);
		jsp4.setBounds(80, 90 + (512/5)*3 + 30 ,1085, 512/5);
		jsp4.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp4.setOpaque(false);
		jsp4.setVisible(true);
		this.add(jsp4);
		
		JScrollPane jsp5 = new JScrollPane(bankAccountTable);
		jsp5.setBounds(80, 90+(512/5)*4+40, 1085, 512/5);
		jsp5.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp5.setOpaque(false);
		jsp5.setVisible(true);
		this.add(jsp5);
	
		this.showAll();
		
	}
	private void initButton(Frame_Finance frame) {
		insertButton = new MyJButton(0, 150, 40, 130,
				"<html>添<br/>加<br/>期<br/>初<br/>账<br/>目<br/></html>", 18);
		insertButton.addActionListener(this);
		/*insertButton.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
				Panel_Finance_OpenningStock.this.insertPanel(frame);
				
			}
		});*/
		this.add(insertButton);

	

		searchButton = new MyJButton(0, 280, 40, 130,
				"<html>查<br/>看<br/>期<br/>初<br/>账<br/>目<br/></html>", 18);
		searchButton.addActionListener(this);
		/*searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_OpenningStock.this.searchPanel(frame);
				
			}
		});*/
		this.add(searchButton);
	}
	
	

	/* void insertPanel(Frame_Finance frame) {
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司期初建账管理", 24, true));
	this.initButton(frame);

	
//	openningStockInfo = new Panel_Finance_OpenningStockInfo();
	//openningStockInfo.add(new MyJLabel(230,5,120,30,"新增期初账目",18,true));
//	this.add(openningStockInfo);
	
	
	commonButton = new MyJButton(890, 670, 150, 30, "新增期初账目", 20);
	commonButton.setActionCommand("AddNewStock");
	commonButton.addActionListener(frame);
	this.add(commonButton);
	
	this.repaint();
}


private void searchPanel(Frame_Finance frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司期初建账管理", 24, true));
	this.initButton(frame);
	
	//openningStockInfo = new Panel_Finance_OpenningStockInfo();
	//openningStockInfo.setUneditable();
	//openningStockInfo.add(new MyJLabel(230,5,150,30,"查看期初账目",18,true));
	//this.add(openningStockInfo);
	
	this.repaint();
}*/
public void showAll(){
	OpeningStockBLService controller = new OpeningStockController();
	ArrayList<OpeningStockVO> openingStockVO = controller.show();
	
	DefaultTableModel tableModel = (DefaultTableModel)transferTable.getModel();
	DefaultTableModel tableModel2 = (DefaultTableModel)employTable.getModel();
	DefaultTableModel tableModel3 = (DefaultTableModel) facilityTable.getModel();
	DefaultTableModel tableModel4 = (DefaultTableModel) inventoryTable.getModel();
	DefaultTableModel tableModel5 = (DefaultTableModel) bankAccountTable.getModel();
	
	int rowCount = transferTable.getRowCount();
	int rowCount2 = employTable.getRowCount();
	int rowCount3 = facilityTable.getRowCount();
	int rowCount4 = inventoryTable.getRowCount();
	int rowCount5 = bankAccountTable.getRowCount();
	for(int i = 0; i < rowCount; i++){
		tableModel.removeRow(0);
	}
	for(int i = 0; i < rowCount2; i++){
		tableModel2.removeRow(0);
	}
	for(int i = 0; i < rowCount3; i++){
		tableModel3.removeRow(0);
	}
	for(int i = 0; i < rowCount4; i++){
		tableModel4.removeRow(0);
	}
	for(int i = 0;i < rowCount5; i++){
		
	}
	if(openingStockVO  != null){
		for(int i = 0; i < openingStockVO.size(); i++){
			OpeningStockVO avo = openingStockVO.get(i);
			
			for(int j = 0; j < avo.transfers.size(); j++){
				Object[] rowData = {avo.transfers.get(j).getOrganizationID(), avo.date
						, avo.transfers.get(j).getOrganizationType(),avo.transfers.get(j).getNumberOfPerson(),avo.transfers.get(j).getAddress()};
				tableModel.addRow(rowData);
			}
			
			for(int j = 0; j < avo.accounts.size(); j++){
				Object[] rowData = {avo.accounts.get(j).getID(), avo.date, avo.accounts.get(j).getName(),
						avo.accounts.get(j).getDuty(), avo.accounts.get(j).getWorkTime()};
				tableModel2.addRow(rowData);
			}
			
			for(int j = 0; j < avo.facilities.size(); j++){
				Object[] rowData = {avo.facilities.get(j).getID(), avo.date, avo.facilities.get(j).getDate(), avo.facilities.get(j).getVehicleIdentificationNumber(), 
					avo.facilities.get(j).getDeliverHistory()};
				tableModel3.addRow(rowData);
			}
			
			for(int j = 0; j < avo.inventories.size(); j++){
				Object[] rowData = {avo.inventories.get(j).getID(), avo.date, avo.inventories.isEmpty()};
				tableModel4.addRow(rowData);
			}
			
			for(int j = 0;j<avo.bankAccounts.size();j++){
				Object[] rowData = {avo.bankAccounts.get(j).getID(),avo.date,avo.bankAccounts.get(j).getName(),
						avo.bankAccounts.get(j).getMoney()};
				tableModel5.addRow(rowData);
			}
			
		}
	}
 }



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==searchButton){
		this.showAll();
	}else if(e.getSource()==insertButton){
		OpeningStockBLService controller = new OpeningStockController();
		controller.add();
	}
	
}
}



