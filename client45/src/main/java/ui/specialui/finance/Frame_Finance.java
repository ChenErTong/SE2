package ui.specialui.finance;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.fundbl.DebitAndPayBillShowController;
import ui.commonui.login.Frame_Login;
import ui.image.CommonImage;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.finance.BankAccountManage.BankAccountManage;
import ui.specialui.finance.CostManage.CostManagement;
import ui.specialui.finance.OpenningStock.OpenningStockManage;
import ui.specialui.finance.SettlementManage.SettlementManage;
import ui.specialui.finance.ViewBusinessPerformance.BusinessPerformanceInfo;
import ui.specialui.finance.ViewBusinessPerformance.ViewBusinessPerformance;
import ui.specialui.finance.ViewIncomeState.ViewIncomeState;
import ui.specialui.finance.ViewLogMsg.ViewLogPanel;


/**
 * 实现财务人员财务管理界面的主Frame，负责到具体功能的界面跳转
 * @version 2015/12/4 16:44
 * @author zsq
 *
 */
public class Frame_Finance  extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	static JTable outputTable;

	private MyJTable output;

	@SuppressWarnings("unused")
	private Frame_Login login;
	private Panel_Finance_Total totalPanel;
	private MyJPanel subPanel ;
	private BusinessPerformanceInfo businessPerformance;
	//导航栏
	private MyButton CostManage;
	private MyButton SettlementManage;
	private MyButton BankAccountManage;
	private MyButton OpenningStock;
	private MyButton ViewBusinessPerformance;
	private MyButton ViewIncomeStatement;
	private MyButton viewLog;
	
	@SuppressWarnings("unused")
	private DebitAndPayBillShowController showController;
	
	public Frame_Finance(String userID){
		super(userID);
		totalPanel = new Panel_Finance_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		
		CostManage = new MyButton(300, 690, 95, 20,FinanceImage.getBUTTON_JIESUAN_());
		CostManage.setActionCommand("CostManage");
		CostManage.addActionListener(this);
		this.add(CostManage);
		
		SettlementManage = new MyButton(395+10,690,95,20,FinanceImage.getBUTTON_COST_());
		SettlementManage.setActionCommand("SettlementManage");
		SettlementManage.addActionListener(this);
		this.add(SettlementManage);
		
		BankAccountManage = new MyButton(395+10+105,690,120,20,FinanceImage.getBUTTON_BANK_());
		BankAccountManage.setActionCommand("BankAccountManage");
		BankAccountManage.addActionListener(this);
		this.add(BankAccountManage);
		
		OpenningStock = new MyButton(405+105+120+10,690,120,20,FinanceImage.getBUTTON_QICHU_());
		OpenningStock.setActionCommand("OpenningStock");
		OpenningStock.addActionListener(this);
		this.add(OpenningStock);
		
		ViewBusinessPerformance = new MyButton(510+130+120+10+5,690,120,20,FinanceImage.getButton_JINGYING_());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(this);
		this.add(ViewBusinessPerformance);
		
		ViewIncomeStatement = new MyButton(770+130+10,690,120,20,FinanceImage.getButton_CHENGBEN_());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(this);
		this.add(ViewIncomeStatement);
		
		viewLog = new MyButton(770+130+130+15,690,120,20,FinanceImage.getButton_LOG_());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(this);
		this.add(viewLog);
		
		this.setNavigation(false);
		
		this.repaint();
		
		this.setBackground(CommonImage.BACKGROUND);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			if(subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
				this.setNavigation(false);
			}else{
				this.logout();
			}
		}else if(e.getActionCommand().equals("CostManage")){
			try {
					showController = ControllerFactory.getDebitAndPayBillShowController();
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					return;
				}
			if(subPanel !=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new CostManagement(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		
		}else if(e.getActionCommand().equals("SettlementManage")){
			 try {
					showController = ControllerFactory.getDebitAndPayBillShowController();
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
					return;
				}
			if(subPanel !=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new SettlementManage(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
			
		}else if(e.getActionCommand().equals("OpenningStock")){
			try {
				showController = ControllerFactory.getDebitAndPayBillShowController();
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new OpenningStockManage(this);
			totalPanel.setVisible(false);
			subPanel = new OpenningStockManage(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("BankAccountManage")){
			try {
				showController = ControllerFactory.getDebitAndPayBillShowController();
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new BankAccountManage(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));	
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("ViewBusinessPerformance")){
			try {
				showController = ControllerFactory.getDebitAndPayBillShowController();
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new ViewBusinessPerformance(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("ViewIncomeStatement")){
			try {
				showController = ControllerFactory.getDebitAndPayBillShowController();
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new ViewIncomeState(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("ViewLogMsg")){
			try {
				showController = ControllerFactory.getDebitAndPayBillShowController();
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new ViewLogPanel(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("ExportBusinessTable")){
			if(this.isExport()){
				output = businessPerformance.getTable();
				int rowCount = output.getRowCount();
				for(int i=0;i<rowCount;i++){
					//recordController.exportBussinessProcessToExcel(new BusinessProcessVO(output.ro));
				}
				//	recordController.
				//	setTable(((Panel_Finance_BusinessPerformance)subPanel).getTable());
				//this.outputExcel();
			}
		}else if(e.getActionCommand().equals("ExportIncomeTable")){
			if(this.isExport_2()){
			//	setTable(((Panel_Finance_IncomeState)subPanel).getTable());
				//this.outputExcel();
			}
		}
	}
	
	/**
	 * 是否导出经营情况表
	 * @return 是否导出成功
	 * 与bl层连接
	 */
	private boolean isExport(){
		switch(((ViewBusinessPerformance)subPanel).isExport()){
		case 0:new MyNotification(this,"正在导出经营情况表！",Color.GREEN);return true;
		case 1:new MyNotification(this,"导出经营情况表失败！",Color.RED);break;
		}
		return false;
	}
	
	private boolean isExport_2(){
		switch(((ViewIncomeState)subPanel).isExport()){
		case 0:new MyNotification(this,"正在导出成本收益表！",Color.GREEN);return true;
		case 1:new MyNotification(this,"导出成本收益表失败！",Color.RED);break;
		}
		return false;
	}
	/**
	 * 导出Excel表格的方法
	 * @author zsq
	 * @version 2015/11/28 14:20
	 */
	public  void outputExcel(){
    	
		FileDialog fd = new FileDialog(this, "导出至Excel", FileDialog.SAVE);
	    fd.setLocation(this.getX(), this.getY());
	    fd.setVisible(true);  
	    String stringfile = fd.getDirectory()+fd.getFile()+".xls";  
	    try {   	
	    	exportTable(outputTable, new File(stringfile));
	    } catch (IOException ex) {
	    	System.out.println(ex.getMessage());
	    	ex.printStackTrace();
	    }
	}
	/**
	 * 执行导出表格操作
	 * @param table 要导出的表格
	 * @param file  存放导出表格的文件
	 * @throws IOException
	 * @author zsq 
	 */
	public void exportTable(JTable table, File file) throws IOException {
	       DefaultTableModel model = (DefaultTableModel) table.getModel();
	       
	       //"ANSI");
	       OutputStreamWriter bWriter=new OutputStreamWriter((new FileOutputStream(file)),"GB2312");
	       //BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));  
	       for(int i=0; i < model.getColumnCount(); i++) {
	           bWriter.write(model.getColumnName(i));
	           bWriter.write("\t");
	       	}
	       	bWriter.write("\n");
	       	for(int i = 0; i< model.getRowCount(); i++) {
	    	   	for(int j = 0; j < model.getColumnCount(); j++) {
	    	   		
	    	   		String str;
	    	   		
	    	   		if(table.getValueAt(i, j) == null){
	    	   			str = " ";
	    	   		}else{
	    	   			str = table.getValueAt(i, j).toString();
	    	   		}
	    	   		
	        	   	bWriter.write(str);
	        	   	
	               	bWriter.write("\t");
	           	}
	    		bWriter.write("\n");
	       	}
	       	bWriter.close();
	       	this.add(new MyNotification(this,"已成功导出！",Color.GREEN));
	     
	   }
	
	public static void setTable(JTable _table){
		outputTable = _table;
		
	}
	
	// 设置导航栏是否隐藏
		private void setNavigation(boolean isVisible) {
			CostManage.setVisible(isVisible);
			SettlementManage.setVisible(isVisible);
			BankAccountManage.setVisible(isVisible);
			OpenningStock.setVisible(isVisible);
			ViewBusinessPerformance.setVisible(isVisible);
			ViewIncomeStatement.setVisible(isVisible);
			viewLog.setVisible(isVisible);
			subscript.setVisible(isVisible);
		}
}