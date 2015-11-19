package ui.specialui.sender;


import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;

/**
 * 物流信息显示面板
 * @author zsq
 * @time 2015/11/18 19:34
 */
public class Panel_Sender_Total extends MyJPanel{
	public Panel_Sender_Total() {
		// TODO Auto-generated constructor stub
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		
			MyJLabel orderNumber = new MyJLabel(120,120,120,40,"订单号",18,true);
			this.add(orderNumber);
			orderNumber.setVisible(true);
				
			MyJLabel senderName = new MyJLabel(120,170,120,40,"寄件人姓名",18,true);
			this.add(senderName);
			senderName.setVisible(true);
			
			MyJTextField orderNumberField = new MyJTextField(220, 120, 200, 40);
			this.add(orderNumberField);
			
			MyJTextField senderNameField = new MyJTextField(220, 170, 200, 40);
			this.add(senderNameField);
			
			MyJButton search = new MyJButton(450,125,90,30,"查询",16);
			this.add(search);
			
			MyJButton cancel = new MyJButton(450,175,90,30,"取消",16);
			this.add(cancel);
		
	}


	private static final long serialVersionUID = 1L;

}
