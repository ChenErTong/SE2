package ui.specialui.manager.HandleReceipt;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.receiptblservice.ReceiptBLService;
import state.ReceiptType;
import state.ResultMessage;
import ui.image.CommonImage;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
import vo.ValueObject;
/**
 * 修改单据信息的面板
 * @author zsq
 * @time 2015/11/18 23:57
 */
public class Panel_Manager_ModifyReceiptInfo extends MyTranslucentPanel implements ActionListener{
	MyJTable table ;
	private static MyJButton modify;
	private MyJButton cancel;
	JTextField textField;
	ValueObject currentBill;
	ReceiptType currentType;
	public Panel_Manager_ModifyReceiptInfo(ReceiptType  type,ValueObject receipt) {
		super(365,100,550,550);
		this.currentBill = receipt;
		this.currentType = type;
		this.setOpaque(false);
		this.initComponent();
		initTable(type,receipt);
	
	}
	private void initComponent() {
		
		MyJLabel title = new MyJLabel(580, 40, 170, 50, "修改单据数据", 24, true);
		this.add(title);
		
		modify = new MyJButton(475,600,100,30,"保存修改",18);
		modify.setActionCommand("Modify");
		modify.addActionListener(this);
		this.add(modify);
		
		cancel = new MyJButton(720,600,100,30,"撤销修改",18);
		cancel.setActionCommand("Cancel");
		cancel.addActionListener(this);
		this.add(cancel);
	
		
	}
	
private void initTable(ReceiptType receiptType, ValueObject receipt){
		
		
	
		initJsp();
	}
	
	private void initJsp(){
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(25, 40, 750, 250);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
	}


	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Modify")){
			finish(currentType);
		}else if(e.getActionCommand().equals("Cancel")){
			
		}
	}
	private void finish(ReceiptType billType) {
		// TODO Auto-generated method stub
		ReceiptBLService controller = ControllerFactory.getReceiptController();
		
		ResultMessage rm = null;
		
		
		
	}

}
