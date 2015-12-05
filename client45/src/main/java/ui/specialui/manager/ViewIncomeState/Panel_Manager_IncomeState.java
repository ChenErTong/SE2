package ui.specialui.manager.ViewIncomeState;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import businesslogic.ControllerFactory;
import businesslogicservice.recordblservice.RecordBLService;

import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.myui.MyTranslucentPanel;
import ui.specialui.manager.FrameManager;
import vo.BussinessConditionVO;

public class Panel_Manager_IncomeState extends  MyTranslucentPanel implements ActionListener{
	
	private MyJComboBox yearBox;
	private MyJComboBox monthBox;
	private MyJComboBox dayBox;
	private MyJButton check;
	private MyJTable	table;
	
	public Panel_Manager_IncomeState(FrameManager frame_Manager) {
		super(80, 100,1120,570+48);
		this.initComponent(frame_Manager);
		
	}

	private void initComponent(FrameManager frame_Manager) {
		MyJLabel title = new MyJLabel(475,5,170,40,"成本收益表预览",22,true);
		this.add(title);
		MyJLabel  startDate = new MyJLabel(20,75,120,30,"选择截止日期:",16,true);
		this.add(startDate);
		
		MyJLabel year = new MyJLabel(142,75,30,30,"年",16,true);
		this.add(year);
		
		MyJLabel month = new MyJLabel(265,75,30,30,"月",16,true);
		this.add(month);
		
		MyJLabel day = new MyJLabel(388,75,30,30,"日",16,true);
		this.add(day);
	
		String[] years = {"2015","2014"};
		yearBox = new MyJComboBox(172,75,90,30,years);
		this.add(yearBox);
		
		String[] months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		monthBox = new MyJComboBox(295,75,90,30,months);
		this.add(monthBox);
	
		String[] days = {"01","02","03","04","05","06","07","08","09","10",
				"11","12","13","14","15","16","17","18","19","20",
				"21","22","23","24","25","26","27","28","29","30","31"};
		dayBox = new MyJComboBox(418,75,90,30,days);
		this.add(dayBox);
	
		check = new MyJButton(608,75,90,30,"预览",16);
		check.setActionCommand("ViewIncomState");
		check.addActionListener(this);
		this.add(check);
		
		MyJButton ExportIncomeTable = new MyJButton(1040-80,573,150,40,"导出成本收益表",14);
		ExportIncomeTable.setActionCommand("ExportIncomeTable");
		ExportIncomeTable.addActionListener(this);
		this.add(ExportIncomeTable);
		ExportIncomeTable.setVisible(true);
		
		
		String[] headers = {"序号","科目分类","科目名称","金额"};
		table = new MyJTable(headers, false);
		table.setBackground(new Color(40, 42, 66));
		table.setForeground(Color.WHITE);
		table.setFont(new MyFont(14));
		table.getTableHeader().setResizingAllowed(false);
			
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(0).setMaxWidth(180);
		table.getColumnModel().getColumn(0).setMinWidth(180);
			
		table.getColumnModel().getColumn(1).setPreferredWidth(380);
		table.getColumnModel().getColumn(1).setMaxWidth(380);
		table.getColumnModel().getColumn(1).setMinWidth(380);
			
		table.getColumnModel().getColumn(2).setPreferredWidth(380);
		table.getColumnModel().getColumn(2).setMaxWidth(380);
		table.getColumnModel().getColumn(2).setMinWidth(380);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
									  	
		JScrollPane jsp=new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
		head.setFont(new MyFont(14));
		head.setForeground(Color.BLACK);
		head.setResizingAllowed(false);
								
		jsp.setBounds(20, 118, 1085, 450);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
	}
	
	/**
	 * 是否进行报表导出
	 * @return 返回0则导出。返回1则不导出
	 */
	private int isExport(){
		int rowCount = 0;
		rowCount = table.getRowCount();
		if(rowCount>0){
			return 0;
		}
		return 1;
	}
	
	private String[] getData(){
		String[] data = new String[3];
		
		data[0] =(String) yearBox.getSelectedItem();
		data[1] = (String) monthBox.getSelectedItem();
		data[2] = (String) dayBox.getSelectedItem();
		for(int i=0;i<6;i++){
			if(data[i]==""){
				return null;
			}
		}
		return data;
	}
	
	private String addZero(String str){
		if(Integer.parseInt(str) < 10){
			return "0" + str;
		}else{
			return str;
		}
	}
	
	private String yearAddZero(String str){
		if(Integer.parseInt(str) < 10){
			return "000" + str;
		}else{
			if(Integer.parseInt(str) < 100){
				return "00" + str;
			}else{
				if(Integer.parseInt(str) < 1000){
					return "0" + str;
				}else{
					return str;
				}
			}
		}
	}
	
	public  MyJTable getTable(){
		return table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ViewIncomState")){
			if(this.getData()==null){
				new MyNotification(this,"请选择截止日期！",Color.RED);
			}else{
				
				String endDate = yearAddZero((String)yearBox.getSelectedItem()) + addZero((String)monthBox.getSelectedItem()) + addZero((String)dayBox.getSelectedItem());
				RecordBLService recordController = ControllerFactory.getRecordController();
				BussinessConditionVO vo = recordController.bussinessCondition(endDate);
				
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				int rowCount = table.getRowCount();
				for(int i = 0; i < rowCount; i++){
					tableModel.removeRow(0);
				}
				if(vo!=null){
					String[] rowData = {String.valueOf(table.getRowCount() + 1), "收入类",
							"总收入", String.format("%.2f", vo.totalIncome) + "元"};
					tableModel.addRow(rowData);
					
					String[] rowData2 = {String.valueOf(table.getRowCount()+1),"支出类","总支出",String.format("%.2f", vo.totalExpen)+"元"};
					
					tableModel.addRow(rowData2);
					
					String[] rowData3 = {String.valueOf(table.getRowCount()+1),"利润类","总利润",String.format("%.2f", vo.profit)+"元"};
					
					tableModel.addRow(rowData3);
					
				}
			}
		}else if(e.getActionCommand().equals("ExportIncomeTable")){
			int rowCount = table.getRowCount();
			if(rowCount==0){
				new MyNotification(this,"导出成本收益表失败！",Color.RED);
			}else{
			String endDate = yearAddZero((String)yearBox.getSelectedItem()) + addZero((String)monthBox.getSelectedItem()) + addZero((String)dayBox.getSelectedItem());
			RecordBLService recordController = ControllerFactory.getRecordController();
			BussinessConditionVO vo = recordController.bussinessCondition(endDate);
			recordController.exportBussinessConditionToExcel(vo);
			}
		}
	}
	private static final long serialVersionUID = 1L;

}