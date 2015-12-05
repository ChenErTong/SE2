package ui.specialui.sender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyTranslucentPanel;

/**
 * 负责输入查询订单的信息的panel
 * @author zsq
 *
 */
public class SearchOrder extends MyTranslucentPanel{
	 private MyJTextField orderNumberField;
	 private MyJTextField senderNameField;
	 private MyJButton search;
	 private MyJButton cancel;
	
	 public SearchOrder(Panel_Sender_Total handle) {
		super(10, 105,620, 108);
		this.initComponent(handle);
	 }

	private void initComponent(Panel_Sender_Total handle) {
		this.add(new MyJLabel(65,5,120,40,"订单号",18,true));
		this.add( new MyJLabel(65,55,120,40,"寄件人姓名",18,true));
		
		 orderNumberField = new MyJTextField(185, 5 ,200, 40);
		 orderNumberField.setOnlyInteger(9);
		this.add(orderNumberField);
		
		senderNameField = new MyJTextField(185, 55, 200, 40);
		this.add(senderNameField);
		
		 search = new MyJButton(398,10,90,30,"查询",16);
		 search.setActionCommand("SearchLogisticInfo");
		 search.addActionListener(handle);
		 this.add(search);
		
		 cancel = new MyJButton(398,60,90,30,"取消",16);
		 cancel.setActionCommand("CancelSearch");
		 cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
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
