package ui.specialui.sender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

public class Panel_Sender_Search extends MyTranslucentPanel{
	 private MyJTextField orderNumberField;
	 private MyJTextField senderNameField;
	public Panel_Sender_Search(Frame_Sender frame_Sender) {
		super(10, 105,620, 108);
		// TODO Auto-generated constructor stub
		this.initComponent(frame_Sender);
	}

	private void initComponent(Frame_Sender frame_Sender) {
		MyJLabel orderNumber = new MyJLabel(65,5,120,40,"订单号",18,true);
		this.add(orderNumber);
		orderNumber.setVisible(true);
			
		MyJLabel senderName = new MyJLabel(65,55,120,40,"寄件人姓名",18,true);
		this.add(senderName);
		senderName.setVisible(true);
		
		 orderNumberField = new MyJTextField(185, 5 ,200, 40);
		this.add(orderNumberField);
		
		senderNameField = new MyJTextField(185, 55, 200, 40);
		this.add(senderNameField);
		
		MyJButton search = new MyJButton(398,10,90,30,"查询",16);
		search.setActionCommand("SearchLogisticInfo");
		search.addActionListener(frame_Sender);
		this.add(search);
		
		MyJButton cancel = new MyJButton(398,60,90,30,"取消",16);
		cancel.setActionCommand("CancelSearch");
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//清空订单号和寄件人姓名的TextField
				orderNumberField.setText(null);
				senderNameField.setText(null);
			}
			
		});
		this.add(cancel);
		
	}
	
	public String[] getSenderInfo() {
		String[] info = new String[2];
		info[0] = orderNumberField.getText();
		info[1] = senderNameField.getText();
		
		for (String string : info) {
			if(string.equals("")) return null;
		}
		return info;
	}

	private static final long serialVersionUID = 1L;

}
