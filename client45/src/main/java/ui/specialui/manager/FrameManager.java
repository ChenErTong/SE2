package ui.specialui.manager;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;

import ui.specialui.manager.AdjustBase.Panel_Manager_AdjustBase;
import ui.specialui.manager.AdjustSalaryPolicy.Panel_Manager_AdjustSalaryPolicy;
import ui.specialui.manager.HandleOrganization.Panel_Manager_HandleOrganization;
import ui.specialui.manager.HandleReceipt.Panel_Manager_HandleReceipt;
import ui.specialui.manager.HandleReceipt.Panel_Manager_ModifyReceiptInfo;
import ui.specialui.manager.ViewBusinessPerformance.Panel_Manager_BusinessPerformance;
import ui.specialui.manager.ViewBusinessPerformance.Panel_Manager_ViewBusinessPerformance;
import ui.specialui.manager.ViewIncomeState.Panel_Manager_IncomeState;
import ui.specialui.manager.ViewIncomeState.Panel_Manager_ViewIncomeStatement;
import ui.specialui.manager.ViewUserInfo.Panel_Manager_ViewUser;

public class FrameManager extends MyJFrame implements ActionListener{
private static final long serialVersionUID = 1L;
	
	private Panel_Manager_Total totalPanel;
	private Panel_Manager_HandleReceipt handleReceipt;
	private Panel_Manager_HandleOrganization handleOrganization;
	private Panel_Manager_AdjustBase adjustBase;
	private Panel_Manager_AdjustSalaryPolicy adjustSalaryPolicy;
	private Panel_Manager_ViewUser viewUser;
	private Panel_Manager_ViewIncomeStatement viewIncomeStatement;
	private Panel_Manager_ViewBusinessPerformance viewBusinessPerformance;
	private Panel_Manager_ModifyReceiptInfo modifyReceiptInfo;
	private MyJPanel subPanel;
	static JTable outputTable;
	public FrameManager(){
		totalPanel = new Panel_Manager_Total(this);
		this.add(totalPanel);
		this.returnButton.addActionListener(this);
		this.setBackground(CommonImage.TEST_BACKGROUND);
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
			subPanel = new Panel_Manager_HandleReceipt(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("HandleOrganization")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_HandleOrganization(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("AdjustBase")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_AdjustBase(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("AdjustSalaryPolicy")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_AdjustSalaryPolicy(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewUser")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_ViewUser(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("ViewIncomeStatement")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_ViewIncomeStatement(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
			
		}else if(e.getActionCommand().equals("ViewBusinessPerformance")){
			//TODO
			totalPanel.setVisible(false);
			subPanel = new Panel_Manager_ViewBusinessPerformance(this);
			this.add(subPanel);
			this.getLayeredPane().add(subPanel,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("Withdraw")){
			//TODO
		}else if(e.getActionCommand().equals("AddOrganization")){
			if(this.addOrganization()){
				((Panel_Manager_HandleOrganization)subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("ModifyOrganizationInfomation")){
			if(this.modifyOrganizationInfo()){
				((Panel_Manager_HandleOrganization)subPanel).refresh();
			}
		}else if(e.getActionCommand().equals("DeleteOrganization")){
			if(this.deleteOrganization()){
				((Panel_Manager_HandleOrganization)subPanel).refresh();
			}
		}
		else if(e.getActionCommand().equals("ModifyReceiptInfo")){
	
			((Panel_Manager_HandleReceipt)(subPanel)).setVisible(false);
			modifyReceiptInfo = new Panel_Manager_ModifyReceiptInfo();
			this.add(modifyReceiptInfo);
			this.getLayeredPane().add(modifyReceiptInfo,new Integer(Integer.MAX_VALUE));
		}else if(e.getActionCommand().equals("AddNewPolicy")){
			
		}else if(e.getActionCommand().equals("ModifyPolicy")){
	
		
		}else if(e.getActionCommand().equals("DeletePolicy")){
			
		}else if(e.getActionCommand().equals("AddNewBase")){
			
		}else if(e.getActionCommand().equals("ModifyBase")){
			
		}else if(e.getActionCommand().equals("DeleteBase")){
			
		}else if(e.getActionCommand().equals("ExportBusinessTable")){
			if(this.isExport()){
				setTable(((Panel_Manager_BusinessPerformance)subPanel).getTable());
				this.outputExcel();
			}
		}else if(e.getActionCommand().equals("ExportIncomeTable")){
			if(this.isExport_2()){
				setTable(((Panel_Manager_IncomeState)subPanel).getTable());
				this.outputExcel();
		}
		}
	}
	
	/**
	 * 添加新用户
	 * @return 是否成功添加
	 * 与bl层连接
 	 */
	private boolean addOrganization(){
		switch(((Panel_Manager_HandleOrganization)subPanel).addOrganization()){
		case 0: new MyNotification(this, "成功添加新机构", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成新机构信息填写", Color.RED); break;
		}
		return false;
	}

	/**
	 * 修改用户信息
	 * @return 是否修改成功
	 * 与bl层连接
	 */
	private boolean modifyOrganizationInfo(){
		switch(((Panel_Manager_HandleOrganization)subPanel).modifyOrganization()){
		case 0: new MyNotification(this, "成功修改机构信息", Color.GREEN); return true;
		case 1: new MyNotification(this, "请完成机构信息修改", Color.RED); break;
		}
		return false;
	}
	
	private boolean deleteOrganization(){
		switch(((Panel_Manager_HandleOrganization)subPanel).deleteOrganization()){
		case 0: new MyNotification(this, "删除成功", Color.GREEN); return true;
		}
		return false;
	}
	
	/**
	 * 是否经营情况表
	 * @return 是否导出成功
	 * 与bl层连接
	 */
	private boolean isExport(){
		switch(((Panel_Manager_ViewBusinessPerformance)subPanel).isExport()){
		case 0:new MyNotification(this,"正在导出经营情况表！",Color.GREEN);return true;
		case 1:new MyNotification(this,"导出经营情况表失败！",Color.RED);break;
		}
		return false;
	}
	private boolean isExport_2(){
		switch(((Panel_Manager_ViewIncomeStatement)subPanel).isExport()){
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
