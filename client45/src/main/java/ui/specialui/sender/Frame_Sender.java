package ui.specialui.sender;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyNotification;
/**
 * 订单物流信息查询界面
 * @author zsq
 * @time 2015/11/18 19:31
 */
public class Frame_Sender extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	
	
	private Panel_Sender_Total totalPanel ;
	private Panel_Sender_Search searchPanel;
	public Frame_Sender(){

		totalPanel = new Panel_Sender_Total(this);
		searchPanel = new Panel_Sender_Search(this);
		this.add(totalPanel);
		this.add(searchPanel);
		this.returnButton.addActionListener(this);
		this.setBackground(CommonImage.TEST_BACKGROUND);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("SearchLogisticInfo")){
			if(this.isSearch()){
				// 
			}
		}
	}
	/**
	 * 进行查询
	 * @return 是否进行查询
	 * TODO 调用bl层
	 */
	public  boolean isSearch(){
		switch((search())){
		case 0: new MyNotification(this, "正在进行查询", Color.GREEN); return true;
		case 1: new MyNotification(this, "请填写订单号", Color.RED); break;
		case 2: new MyNotification(this, "请填写寄件人姓名", Color.RED); break;
		case 3: new MyNotification(this, "订单号与寄件人姓名不匹配！", Color.RED); break;
		case 4: new MyNotification(this, "", Color.RED); break;
		}	
		return false ;
	}
		
	/**
	 * 进行查询
	 * @return 
	 */
	public int search() {
		String[] orderNumberInfo = searchPanel.getSenderInfo();
		String[] senderNameInfo =  searchPanel.getSenderInfo();
		boolean isLegal = false;
		if(orderNumberInfo == null){
			return 1;
		}
		if(senderNameInfo == null){
			return 2;
		}
		if(orderNumberInfo.length!=11){
			return 3;
		}
		if(!(isLegal ==isLegal(orderNumberInfo,senderNameInfo))){
			return 4;
		}
		return 0;
		
	}
	/**
	 * 判断寄件人姓名和订单号是否匹配
	 * @param orderNumberInfo
	 * @param senderNameInfo
	 * @return 是否匹配
	 * TODO 调用BL层
	 * 
	 */
	private boolean isLegal(String[] orderNumberInfo, String[] senderNameInfo) {
		// TODO Auto-generated method stub
	
		return false;
	}
}

