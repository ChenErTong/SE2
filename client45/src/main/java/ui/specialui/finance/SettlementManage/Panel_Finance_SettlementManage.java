package ui.specialui.finance.SettlementManage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.finance.Frame_Finance;


public class Panel_Finance_SettlementManage extends MyJPanel{

	private static final long serialVersionUID = 1L;
	private PayReceiptInfo payReceiptInfo;
	private PayReceiptList payReceiptList;
	private MyJButton commonButton;
	public Panel_Finance_SettlementManage(Frame_Finance frame_Finance) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Finance);
	}

	private void initComponent(Frame_Finance frame_Finance) {
		this.add(new MyJLabel(530, 20, 250, 90, "公司运营成本管理", 24, true));
		payReceiptInfo = new PayReceiptInfo();
		this.add(payReceiptInfo);
		
		payReceiptList = new PayReceiptList(frame_Finance);
		this.add(payReceiptList);
		this.initButton(frame_Finance);
	}

	private void initButton(Frame_Finance frame) {
		MyJButton insertButton = new MyJButton(0, 150, 40, 130,
				"<html>添<br/>加<br/>付<br/>款<br/>单<br/></html>", 18);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_SettlementManage.this.insertPanel(frame);
				
			}
		});
		this.add(insertButton);

		MyJButton modifyButton = new MyJButton(0, 280, 40, 130,
				"<html>修<br/>改<br/>付<br/>款<br/>单<br/></html>", 18);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_SettlementManage.this.modifyPanel(frame);
				
			}
		});
		this.add(modifyButton);

		MyJButton searchButton = new MyJButton(0, 410, 40, 130,
				"<html>查<br/>看<br/>付<br/>款<br/>单<br/></html>", 18);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_SettlementManage.this.searchPanel(frame);
				
			}
		});
		this.add(searchButton);

		MyJButton deleteButton = new MyJButton(0, 540, 40, 110,
				"<html>合<br/>计<br/>付<br/>款<br/>单<br/></html>", 18);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel_Finance_SettlementManage.this.deletePanel(frame);
				
			}
		});
		this.add(deleteButton);
	}
	

	private void insertPanel(Frame_Finance frame) {
	this.removeAll();
	this.add(payReceiptList);
	this.add(new MyJLabel(530, 20, 250, 90, "公司运营成本管理", 24, true));
	this.initButton(frame);

	
	payReceiptInfo = new PayReceiptInfo();
	payReceiptInfo.add(new MyJLabel(230,5,120,30,"新增付款单",18,true));
	this.add(payReceiptInfo);
	
	
	commonButton = new MyJButton(890, 670, 120, 30, "添加付款单", 20);
	commonButton.setActionCommand("AddPayReceipt");
	commonButton.addActionListener(frame);
	this.add(commonButton);
	
	this.repaint();
}

private void modifyPanel(Frame_Finance frame) {
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司运营成本管理", 24, true));
	this.add(payReceiptList);
	this.initButton(frame);
	
	payReceiptInfo = new PayReceiptInfo();
	payReceiptInfo.add(new MyJLabel(230,5,120,30,"修改付款单",18,true));
	this.add(payReceiptInfo);
	
	commonButton = new MyJButton(890, 670, 150, 30, "修改付款单", 20);
	commonButton.setActionCommand("ModifyPayReceipt");
	commonButton.addActionListener(frame);
	this.add(commonButton);
	
	this.repaint();
}

private void searchPanel(Frame_Finance frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530, 20, 250, 90, "公司运营成本管理", 24, true));
	this.add(payReceiptList);
	this.initButton(frame);
	
	payReceiptInfo = new PayReceiptInfo();
	payReceiptInfo.setUneditable();
	payReceiptInfo.add(new MyJLabel(230,5,150,30,"查看付款单信息",18,true));
	this.add(payReceiptInfo);
	
	this.repaint();
}

private void deletePanel(Frame_Finance frame) {
	
	this.removeAll();
	this.add(new MyJLabel(530,20, 250, 90, "公司运营结算管理", 24, true));
	this.add(payReceiptList);
	this.initButton(frame);
	
	payReceiptInfo = new PayReceiptInfo();
	payReceiptInfo.setUneditable();
	payReceiptInfo.add(new MyJLabel(230,5,120,30,"合计付款单",18,true));
	this.add(payReceiptInfo);
	
	commonButton = new MyJButton(890, 670, 120, 30, "合计付款单", 20);
	commonButton.setActionCommand("CalculateAllPay");
	commonButton.addActionListener(frame);
	this.add(commonButton);
	
	this.repaint();
}
}
