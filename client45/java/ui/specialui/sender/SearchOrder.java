package ui.specialui.sender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.image.CommonImage;
import ui.image.LoginImage;
import ui.myui.MyButton;
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
	 private MyButton search;
	 private MyButton cancel;
	
	 public SearchOrder(Panel_Sender_Total handle) {
		super(10, 105,600, 108);
		this.initComponent(handle);
	 }

	private void initComponent(Panel_Sender_Total handle) {
		this.add(new MyJLabel(65,5,120,40,"订单号",18,true));
		this.add( new MyJLabel(65,55,120,40,"寄件人姓名",18,true));
		
		 orderNumberField = new MyJTextField(185, 5 ,200, 40);
		 orderNumberField.setOnlyInteger(10);
		 orderNumberField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==orderNumberField){
					senderNameField.requestFocus();
				}
				
			}
			 
		 });
		this.add(orderNumberField);
		
		senderNameField = new MyJTextField(185, 55, 200, 40);
		this.add(senderNameField);
		
		 search = new MyButton(398,10,35,35,LoginImage.getBUTTON_LOGISTIC());
		 search.setActionCommand("SearchLogisticInfo");
		 search.addActionListener(handle);
		 this.add(search);
		
		 cancel = new MyButton(398,60,35,35,CommonImage.getWITHDRAW());
		 cancel.setActionCommand("CancelSearch");
		 cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				orderNumberField.setText(null);
				senderNameField.setText(null);
			}
		});
		this.add(cancel);
		this.repaint();
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
