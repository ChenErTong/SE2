package ui.specialui.manager.ViewBusinessPerformance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import businesslogic.ControllerFactory;
import businesslogicservice.recordblservice.RecordBLService;
import ui.myui.MyComboBox;
import ui.myui.MyFont;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import ui.specialui.manager.FrameManager;
import vo.receiptvo.DebitAndPayBillVO;

public class Panel_Manager_BusinessPerformance extends  MyTranslucentPanel implements ActionListener{
	private MyComboBox yearBox;
	private MyComboBox yearBox_2;
	private MyComboBox monthBox;
	private MyComboBox monthBox_2;
	private MyComboBox dayBox;
	private MyComboBox dayBox_2;
	private MyJButton check;
	private MyJTable	table;
	public Panel_Manager_BusinessPerformance(FrameManager frame_Manager) {
		super(80, 100,1120,570);
		this.initComponent(frame_Manager);
		
	}

	private void initComponent(FrameManager frame_Manager) {
		MyJLabel title = new MyJLabel(475,5,170,40,"经营情况表预览",22,true);
		this.add(title);
		MyJLabel  startDate = new MyJLabel(20,40,120,30,"选择开始日期:",16,true);
		this.add(startDate);
		
		MyJLabel endDate = new MyJLabel(20,75,120,30,"选择截止日期:",16,true);
		this.add(endDate);
		
		MyJLabel year = new MyJLabel(142,40,30,30,"年",16,true);
		this.add(year);
		
		MyJLabel year_2 =new MyJLabel(142,75,30,30,"年",16,true);
		this.add(year_2);
		
		MyJLabel month = new MyJLabel(265,40,30,30,"月",16,true);
		this.add(month);
		
		MyJLabel month_2 = new MyJLabel(265,75,30,30,"月",16,true);
		this.add(month_2);
		
		MyJLabel day = new MyJLabel(388,40,30,30,"日",16,true);
		this.add(day);
		MyJLabel day_2 = new MyJLabel(388,75,30,30,"日",16,true);
		this.add(day_2);
		
		String[] years = {"2015","2014"};
		yearBox = new MyComboBox(172,40,90,30,16,years);
		this.add(yearBox);
		yearBox_2 = new MyComboBox(172,75,90,30,16,years);
		this.add(yearBox_2);
		
		String[] months = {"一月","二月"};
		monthBox = new MyComboBox(295,40,90,30,16,months);
		this.add(monthBox);
		monthBox_2 = new MyComboBox(295,75,90,30,16,months);
		this.add(monthBox_2);
		
		String[] days = {"01","02"};
		dayBox = new MyComboBox(418,40,90,30,16,days);
		this.add(dayBox);
		dayBox_2 = new MyComboBox(418,75,90,30,16,days);
		this.add(dayBox_2);
	
		check = new MyJButton(608,75,90,30,"预览",16);
		check.setActionCommand("ViewBusinessTable");
		check.addActionListener(frame_Manager);
		this.add(check);
		
		//the table
			String[] headers = {"单据编号","单据种类","单据内容","单据金额"};
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
		String[] data = new String[6];
		
		data[0] =(String) yearBox.getSelectedItem();
		data[1] = (String) monthBox.getSelectedItem();
		data[2] = (String) dayBox.getSelectedItem();
		data[3] = (String)yearBox_2.getSelectedItem();
		data[4] = (String)monthBox_2.getSelectedItem();
		data[5] = (String)dayBox_2.getSelectedItem();
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

	
	private static final long serialVersionUID = 1L;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==check){
			if(this.getData()==null){
				//this.add(new MyNotification());
			}else{
				String beginDate = yearAddZero((String) yearBox.getSelectedItem()) + addZero((String) monthBox.getSelectedItem()) + addZero((String) dayBox.getSelectedItem());
				String endDate = yearAddZero((String)yearBox_2.getSelectedItem()) + addZero((String)monthBox_2.getSelectedItem()) + addZero((String)dayBox_2.getSelectedItem());
				RecordBLService recordController = ControllerFactory.getRecordController();
				ArrayList<DebitAndPayBillVO> vo = recordController.bussinessProcess(beginDate, endDate);
				
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				int rowCount = table.getRowCount();
				for(int i = 0; i < rowCount; i++){
					tableModel.removeRow(0);
				}
				
				if (vo!=null){
					for(int i=0;i<vo.size();i++){
						
						DebitAndPayBillVO dpo = vo.get(i);
//						Object rowData[] = { dpo.ID, dpo.type, dpo.money, dpo.payerName, dpo.bankAccouts, dpo.items,
//								dpo.rentYear, dpo.salaryMonth, dpo.orderNumbers, dpo.transListNumber };
//						tableModel.addRow(rowData);	
						}
					}
				}

	
			}
		}
}