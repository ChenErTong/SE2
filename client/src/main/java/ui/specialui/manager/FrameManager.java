package ui.specialui.manager;

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
import businesslogicservice.accountblservice.AccountBLService;
import ui.image.CommonImage;
import ui.image.ManagerImage;
import ui.image.FinanceImage.FinanceImage;
import ui.myui.MyButton;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import ui.specialui.manager.AccountManage.AccountManage;
import ui.specialui.manager.AdjustBase.AdjustBase;
import ui.specialui.manager.AdjustSalaryPolicy.AdjustSalaryPolicy;
import ui.specialui.manager.HandleOrganization.HandleOrganization;
import ui.specialui.manager.HandleReceipt.HandleReceipt;
import ui.specialui.manager.HandleReceipt.ModifyReceiptInfo;
import ui.specialui.manager.ViewBusinessPerformance.BusinessPerformanceInfo;
import ui.specialui.manager.ViewBusinessPerformance.ViewBusinessPerformance;
import ui.specialui.manager.ViewIncomeState.IncomeStateInfo;
import ui.specialui.manager.ViewIncomeState.ViewIncomeStatement;
import ui.specialui.manager.ViewLogMsg.ViewLogPanel;
/**
 * 总经理主界面Frame，负责进入各个功能
 * @author zsq
 * @version 2015/12/05 16:10
 */
public class FrameManager extends MyJFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private Panel_Manager_Total totalPanel;
	private ModifyReceiptInfo modifyReceiptInfo;
	private MyJPanel subPanel;
	
	static JTable outputTable;
	//导航栏
	private MyButton HandleReceipt;
	private MyButton HandleOrganization;
	private MyButton AdjustBase;
	private MyButton AdjustSalaryPolicy;
	private MyButton ViewUser;
	private MyButton ViewBusinessPerformance;
	private MyButton ViewIncomeStatement;
	private MyButton viewLog;
	
	@SuppressWarnings("unused")
	private AccountBLService controller ;
	
	public FrameManager(String userID){
		super(userID);
		totalPanel = new Panel_Manager_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		
		HandleReceipt = new MyButton(300-105, 690,95,20,ManagerImage.getBUTTON_APPROVE_());
		HandleReceipt.setActionCommand("HandleReceipt");
		HandleReceipt.addActionListener(this);
		this.add(HandleReceipt);
		
		HandleOrganization = new MyButton(300, 690,120,20,ManagerImage.getBUTTON_ORGANIZATION_());
		HandleOrganization.setActionCommand("HandleOrganization");
		HandleOrganization.addActionListener(this);
		this.add(HandleOrganization);
		
		AdjustBase = new MyButton(300+120+10, 690,120,20,ManagerImage.getBUTTON_BASE_());
		AdjustBase.setActionCommand("AdjustBase");
		AdjustBase.addActionListener(this);
		this.add(AdjustBase);
		
		AdjustSalaryPolicy = new MyButton(300+120+10+130,690,120,20,ManagerImage.getBUTTON_POLICY_());
		AdjustSalaryPolicy.setActionCommand("AdjustSalaryPolicy");
		AdjustSalaryPolicy.addActionListener(this);
		this.add(AdjustSalaryPolicy);
		
		ViewUser = new MyButton(300+120+10+130+130,  690,120,20,ManagerImage.getBUTTON_ACCOUNT_());
		ViewUser.setActionCommand("ViewUser");
		ViewUser.addActionListener(this);
		this.add(ViewUser);
		
		ViewBusinessPerformance = new MyButton(300+120+10+130+130+130,690,120,20,FinanceImage.getButton_JINGYING_());
		ViewBusinessPerformance.setActionCommand("ViewBusinessPerformance");
		ViewBusinessPerformance.addActionListener(this);
		this.add(ViewBusinessPerformance);
		
		ViewIncomeStatement = new MyButton(300+130*5,690,120,20,FinanceImage.getButton_CHENGBEN_());
		ViewIncomeStatement.setActionCommand("ViewIncomeStatement");
		ViewIncomeStatement.addActionListener(this);
		this.add(ViewIncomeStatement);
		
		viewLog = new MyButton(300+130*6,690,120,20,FinanceImage.getButton_LOG_());
		viewLog.setActionCommand("ViewLogMsg");
		viewLog.addActionListener(this);
		this.setNavigation(false);
		
		this.repaint();
		this.setBackground(CommonImage.BACKGROUND);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			if(modifyReceiptInfo!=null&&subPanel!=null){
				modifyReceiptInfo.setVisible(false);
				this.remove(modifyReceiptInfo);
				modifyReceiptInfo = null;
				try {
					subPanel = new HandleReceipt(this);
					subPanel.setVisible(true);
				} catch (RemoteException e1) {
					return;
				}
				this.setNavigation(false);
				
			}else if(modifyReceiptInfo==null&&subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
				this.setNavigation(false);
			}else{
				this.logout();
			}
		}else if(e.getActionCommand().equals("HandleReceipt")){
			try {
				controller = ControllerFactory.getAccountController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e2) {
				new MyNotification(this,"网络连接异常,请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			try {
				subPanel = new HandleReceipt(this);
			} catch (RemoteException e1) {
				return;
			}
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("HandleOrganization")){
			try {
				controller = ControllerFactory.getAccountController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e2) {
				new MyNotification(this,"网络连接异常,请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new HandleOrganization(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("AdjustBase")){
			try {
				controller = ControllerFactory.getAccountController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e2) {
				new MyNotification(this,"网络连接异常,请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new AdjustBase(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("AdjustSalaryPolicy")){
			try {
				controller = ControllerFactory.getAccountController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e2) {
				new MyNotification(this,"网络连接异常,请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new AdjustSalaryPolicy(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("ViewUser")){
			try {
				controller = ControllerFactory.getAccountController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e2) {
				new MyNotification(this,"网络连接异常,请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new AccountManage(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("ViewIncomeStatement")){
			try {
				controller = ControllerFactory.getAccountController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e2) {
				new MyNotification(this,"网络连接异常,请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}
			subPanel = new ViewIncomeStatement(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("ViewBusinessPerformance")){
			try {
				controller = ControllerFactory.getAccountController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e2) {
				new MyNotification(this,"网络连接异常,请检查网络设置！",Color.RED);
				return;
			}
			if(subPanel!=null){
				subPanel.setVisible(false);
			}else{
				totalPanel.setVisible(false);
			}			subPanel = new ViewBusinessPerformance(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setNavigation(true);
		}else if(e.getActionCommand().equals("ViewLogMsg")){
			try {
				controller = ControllerFactory.getAccountController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e2) {
				new MyNotification(this,"网络连接异常,请检查网络设置！",Color.RED);
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
				setTable(((BusinessPerformanceInfo)subPanel).getTable());
				this.outputExcel();
			}
		}else if(e.getActionCommand().equals("ExportIncomeTable")){
			if(this.isExport_2()){
				setTable(((IncomeStateInfo)subPanel).getTable());
				this.outputExcel();
			}
		}
	}
	
	/**
	 * 是否经营情况表
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
		switch(((ViewIncomeStatement)subPanel).isExport()){
		case 0:new MyNotification(this,"正在导出成本收益表！",Color.GREEN);return true;
		case 1:new MyNotification(this,"导出成本收益表失败！",Color.RED);break;
		}
		return false;
	}
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
				HandleReceipt.setVisible(isVisible);
				HandleOrganization.setVisible(isVisible);
				AdjustBase.setVisible(isVisible);
				AdjustSalaryPolicy.setVisible(isVisible);
				ViewUser.setVisible(isVisible);
				ViewBusinessPerformance.setVisible(isVisible);
				ViewIncomeStatement.setVisible(isVisible);
				viewLog.setVisible(isVisible);
				subscript.setVisible(isVisible);
			}
}
