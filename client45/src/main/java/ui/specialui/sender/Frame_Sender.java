package ui.specialui.sender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.commonui.login.Frame_Login;
import ui.image.CommonImage;
import ui.myui.MyJFrame;
import vo.OrderVO;
/**
 * 订单物流信息查询界面
 * @author zsq
 * @time 2015/11/18 19:31
 */
public class Frame_Sender extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	static ArrayList<OrderVO> orderPool;
	static String orderID = " ";
	
	private Panel_Sender_Total totalPanel ;
	
	public Frame_Sender(String userID){
		super(userID);
		totalPanel = new Panel_Sender_Total();
		this.add(totalPanel);
		totalPanel.setVisible(true);
				
		this.returnButton.addActionListener(this);
		this.setBackground(CommonImage.BACKGROUND);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("return")){
			new Frame_Login(ID);
			this.dispose();
		}
	}
}

