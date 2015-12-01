package ui.commonui.receipt_constructor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.filechooser.FileSystemView;

import businesslogic.ControllerFactory;
import businesslogicservice.inventoryblservice.InventoryBLService;
import state.ReceiptType;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJButton;
import ui.myui.MyJComboBox;
import ui.myui.MyJFrame;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyNotification;
import vo.ValueObject;

public class SaveDraftPanel extends MyJPanel implements ActionListener{
	MyJButton check,export;
	MyEmptyTextArea ta;
	MyJComboBox cbb;
	ArrayList<ReceiptType> typePool;
	ArrayList<ValueObject> billPool;
	
	static ReceiptType billType;
	static ValueObject bill;
	
	public SaveDraftPanel() {
		super(0,0,1280,720);
		this.initCompoment();
	}

	private void initCompoment() {
		typePool = new ArrayList<ReceiptType>();
		billPool = new ArrayList<ValueObject>();
		this.add(new MyJLabel(500,100,200,40,"单据查看",24,true));
		
		ta = new MyEmptyTextArea(50,150,1180,550);
		ta.setEditable(false);
		
		JScrollPane jsp2 = new JScrollPane(ta);
		jsp2.setBounds(25, 40 + 50, 650, 465);
		this.add(jsp2);
		
		check = new MyJButton(0,300,40,130,"<html><br>查<br>看<br>单<br>据</br>",18);
		check.setActionCommand("CheckReceipt");
		check.addActionListener(this);
		
		export = new MyJButton(0,430,40,130,"<html><br>导<br>出<br>单<br>据</br>",18);
		export.setActionCommand("ExportReceipt");
		export.addActionListener(this);
		
		this.add(new MyJLabel(0,0,0,0,"请选择要查看的草稿单据！",18,true));
		
		cbb = new MyJComboBox(0,0,0,0,getSaveDraft());
		this.add(cbb);
	}

	private static final long serialVersionUID = 1L;

	private String[] getSaveDraft(){
		String str = "";
		typePool.clear();
		billPool.clear();
		if(MyJFrame.frameName.equals("Frame_Branch")){
			
		}else if(MyJFrame.frameName.equals("Frame_Courier")){
			
		}else if(MyJFrame.frameName.equals("Frame_Finance")){
			
		}else if(MyJFrame.frameName.equals("Frame_Inventory")){
			InventoryBLService inventoryController = ControllerFactory.getInventoryController();
			//ArrayList<InventoryExportVO> list = inventoryController.
		}else if(MyJFrame.frameName.equals("Frame_Transfer")){
			
		}
		return null;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("CheckReceipt")){
			if(cbb.getSelectedItem().toString().equals("无")){
				new MyNotification(this,"目前无单据可以查看！",Color.RED);
			}else{
				billType = typePool.get(cbb.getSelectedIndex());
				bill = billPool.get(cbb.getSelectedIndex());
				ReceiptConductor rc = new ReceiptConductor();
				ta.setText(rc.writeReceipt(billType, bill));
			}
			
		}else if(e.getActionCommand().equals("ExportReceipt")){
			if(cbb.getSelectedItem().toString().equals("无")){
				new MyNotification(this,"目前没有单据可以导出！",Color.RED);
			}else{
				FileSystemView fsv = FileSystemView.getFileSystemView();
				String file=String.valueOf(fsv.getHomeDirectory())+"/草稿单" + bill.ID + ".txt";		
				writeto(ta.getText().replaceAll("\n", "\r\n"),file);
				new MyNotification(this,"单据成功导出至桌面！",Color.GREEN);
				
			}
		}
			
		
	}

	private void writeto(String a, String file) {
		try {
			File filename=new File(file);
			
			if (!filename.exists()) { 
				filename.createNewFile();}
			
			FileWriter fw=new FileWriter(filename);
			fw.write(a);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
