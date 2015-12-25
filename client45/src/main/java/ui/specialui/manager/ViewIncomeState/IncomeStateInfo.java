package ui.specialui.manager.ViewIncomeState;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import businesslogic.ControllerFactory;
import businesslogicservice.recordblservice.RecordBLService;
import ui.image.LoginImage;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyFileChooser;
import ui.myui.MyFont;
import ui.myui.MyJLabel;
import ui.myui.MyJTable;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.myui.MyTranslucentPanel;
import ui.specialui.manager.FrameManager;
import vo.BussinessConditionVO;

public class IncomeStateInfo extends  MyTranslucentPanel implements ActionListener{

	private MyButton check;
	private MyJTable	table;
	private MyJTextField[] input;
	private DateLabel[] dateLabel;
	private JScrollPane jsp;
	private MyButton ExportBusinessTable;

	
	public IncomeStateInfo(FrameManager frame_Manager) {
		super(80, 100-30,1120,570+48);
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
		
		check = new MyButton(172+3*123+5,75,30,30,LoginImage.getBUTTON_LOGISTIC());
		check.setActionCommand("ViewIncomeState");
		check.addActionListener(this);
		this.add(check);
		
		ExportBusinessTable = new MyButton(1040-80-5,573,150,30,FinanceImage.getBUTTON_EXPORTINCOME());
		ExportBusinessTable.setActionCommand("ExportIncomeTable");
		ExportBusinessTable.addActionListener(this);
		this.add(ExportBusinessTable);
		ExportBusinessTable.setVisible(true);
		
		this.initTable();
		this.addInput();
	}
	class DateLabel extends JLabel {
		private static final long serialVersionUID = 1L;

		public DateLabel(String Text) {
			super(Text, JLabel.LEFT);
			this.setFont(getFont());
		}
	}
	/**
	 * 添加输入日期的输入框
	 */
	private void addInput() {
		dateLabel = new DateLabel[3];
		input = new MyJTextField[3];
		SimpleDateFormat[] sdf = new SimpleDateFormat[3];
		String[] date_s = {"年", "月", "日"};
		String[] dateFormat = {"yyyy", "MM", "dd"};
		Date curDate = new Date();
		// 初始化输入框，设置标签和输入框的位置，并且添加标签和输入框
		for(int i = 0; i < dateLabel.length; i++) {
			dateLabel[i] = new DateLabel(date_s[i]);
			sdf[i] = new SimpleDateFormat(dateFormat[i]);
			input[i] = new MyJTextField(172+i*123,75,90,30);
			input[i].setText(sdf[i].format(curDate));
			input[i].setFont(getFont());
			input[i].setHorizontalAlignment(JTextField.CENTER);
			this.add(input[i]);
			this.add(dateLabel[i]);
		}
	}
	
	private void initTable(){
		//the table
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
											  	
				jsp=new JScrollPane(table);
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
	@SuppressWarnings("unused")
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
		
		for(int i=0;i<2;i++){
			data[i] = input[i].getText();
		}
		for(int i=0;i<2;i++){
			if(data[i].equals(null)){
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
	
	private boolean isLegal(){
		for(int i=0;i<input.length;i++){
			if(!this.isDigit(input[i].getText())){
				return false;
			}
		}	
		
		Date current = new Date();
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		
		int standard = Integer.parseInt(sdfYear.format(current));
		int year = Integer.parseInt(input[0].getText());
		int month = Integer.parseInt(input[1].getText());
		int day = Integer.parseInt(input[2].getText());
		if(year<0||year>standard){
			return false;
		}else if((month<0||month>12)){
			return false;
		}else if((day<0||day>31)){
			return false;
		}
		if((month==2&&day>28)){
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ViewIncomeState")){
			if(this.getData()==null){
				new MyNotification(this,"请输入截止日期！",Color.RED);
			}else{
				if(this.isLegal()){
					String endDate = yearAddZero(input[0].getText()) + addZero(input[1].getText()) + addZero(input[2].getText());
			
					try {
						
						RecordBLService recordController = ControllerFactory.getRecordController();
						BussinessConditionVO vo = recordController.bussinessCondition(endDate);
						System.out.println(vo+"ui");
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
							
							new MyNotification(this,"共有"+table.getRowCount()+"个单据满足条件！",Color.GREEN);
							
						}else{
							new MyNotification(this,"成本收益表预览失败！",Color.RED);
						}
					} catch (RemoteException | MalformedURLException | NotBoundException e1) {
						new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
						return;
					}
				}else{
					new MyNotification(this,"输入的日期参数不合法！",Color.RED);
				}
			}
		}else if(e.getActionCommand().equals("ExportIncomeTable")){
			int rowCount = table.getRowCount();
			MyFileChooser chooser = new MyFileChooser();
			String path = chooser.str;
			if(rowCount==0){
				new MyNotification(this,"导出成本收益表失败！",Color.RED);
			}else{
				String endDate = yearAddZero(input[0].getText())+"-" + addZero(input[1].getText())+"-" + addZero(input[2].getText());
				try {
					RecordBLService recordController = ControllerFactory.getRecordController();
					BussinessConditionVO vo = recordController.bussinessCondition(endDate);
					if(vo==null){
						new MyNotification(this,"空表无法导出！",Color.RED);
						return;
					}
					recordController.exportBussinessConditionToExcel(vo,path);
					new MyNotification(this,"成本收益表导出成功！",Color.GREEN);
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
					return;
				}
			}
		}
	}
	
	@SuppressWarnings("unused")
	private class WheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			JScrollBar onlineFriendsBar =  jsp.getHorizontalScrollBar();
			if (!((onlineFriendsBar.getValue() == onlineFriendsBar.getMinimum() && e.getWheelRotation() <= 0) || (onlineFriendsBar.getValue() == onlineFriendsBar.getMaximum() && e.getWheelRotation() >= 0))) {
				if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 >= onlineFriendsBar.getMaximum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMaximum());
				} else if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 <= onlineFriendsBar.getMinimum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMinimum());
				} else {
					onlineFriendsBar.setValue(onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement()
												* e.getUnitsToScroll() * 10);
				}
			}
		}
	}
	private static final long serialVersionUID = 1L;

}