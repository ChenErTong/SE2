package ui.specialui.manager;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ui.commonui.login.Frame_Login;
import ui.commonui.login.Panel_Login;
import ui.image.CommonImage;
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
	
	public FrameManager(String userID){
		super(userID);
		totalPanel = new Panel_Manager_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		this.setBackground(CommonImage.BACKGROUND);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			if(modifyReceiptInfo!=null&&subPanel!=null){
				modifyReceiptInfo.setVisible(false);
				this.remove(modifyReceiptInfo);
				modifyReceiptInfo = null;
				subPanel.setVisible(true);
				System.out.println("111");
			}else if(modifyReceiptInfo==null&&subPanel != null){
				subPanel.setVisible(false);
				this.remove(subPanel);
				subPanel = null;
				totalPanel.setVisible(true);
			}
		}else if(e.getActionCommand().equals("HandleReceipt")){
			totalPanel.setVisible(false);
			try {
				this.setBackground(CommonImage.MANAGER_BACKGROUND);
				subPanel = new HandleReceipt();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("HandleOrganization")){
			this.setBackground(CommonImage.MANAGER_BACKGROUND);
			totalPanel.setVisible(false);
			subPanel = new HandleOrganization(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			this.setBackground(CommonImage.MANAGER_BACKGROUND);
		}else if(e.getActionCommand().equals("AdjustBase")){
			totalPanel.setVisible(false);
			subPanel = new AdjustBase(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("AdjustSalaryPolicy")){
			this.setBackground(CommonImage.MANAGER_BACKGROUND);
			totalPanel.setVisible(false);
			subPanel = new AdjustSalaryPolicy(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewUser")){
			this.setBackground(CommonImage.MANAGER_BACKGROUND);
			totalPanel.setVisible(false);
			subPanel = new AccountManage();
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewIncomeStatement")){
			this.setBackground(CommonImage.MANAGER_BACKGROUND);
			totalPanel.setVisible(false);
			subPanel = new ViewIncomeStatement(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewBusinessPerformance")){
			this.setBackground(CommonImage.MANAGER_BACKGROUND);
			totalPanel.setVisible(false);
			subPanel = new ViewBusinessPerformance(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("Withdraw")){
			Frame_Login login = new Frame_Login(ID);
			subPanel = new Panel_Login(login);
			subPanel.setVisible(true);
		}else if(e.getActionCommand().equals("ViewLogMsg")){
			this.setBackground(CommonImage.MANAGER_BACKGROUND);
			totalPanel.setVisible(false);
			subPanel = new ViewLogPanel();
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
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
}
