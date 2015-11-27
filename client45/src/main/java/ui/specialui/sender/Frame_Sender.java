package ui.specialui.sender;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.fundblservice.BankAccountBLService;
import state.FindTypeAccount;
import ui.image.CommonImage;
import ui.myui.MyJFrame;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import vo.BankAccountVO;
import vo.OrderVO;
/**
 * 订单物流信息查询界面
 * @author zsq
 * @time 2015/11/18 19:31
 */
public class Frame_Sender extends MyJFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private MyJTable table_order,table2_logistic;
	
	static ArrayList<OrderVO> commodityPool;
	static String accountID = " ";
	
	private Panel_Sender_Total totalPanel ;
	private Panel_Sender_Search searchPanel;
	private Panel_Sender_CommodityInfo order;
	private Panel_Sender_logisticInfo logistic;
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
				/*table_order = .getTable();
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rowCount = table.getRowCount();
				
				for(int i = 0; i < rowCount; i++){
					tableModel.removeRow(0);
				}
				
				accountPool.clear();
				accountID = "";
				
				//"模糊查找", "账户编号(ID)", "账户名称", "账户余额"
				BankAccountBLService controller = ControllerFactory.getBankAccountController();
				ArrayList<BankAccountVO> bankAccountVO;
				String[] data = bankAccountPanel.getData();
				if(data!=null){
					switch(Integer.parseInt(data[0])){
						case 0 : bankAccountVO = controller.find(data[1], null);break;
						case 1 : bankAccountVO = controller.find(data[1], FindTypeAccount.ID);break;
						case 2 : bankAccountVO = controller.find(data[1], FindTypeAccount.NAME);break;
						default : bankAccountVO = controller.find(data[1], FindTypeAccount.MONEY);break;
					}
				
					for(int i = 0; i < bankAccountVO.size(); i++){
					String[] rowData = {bankAccountVO.get(i).ID, 
							bankAccountVO.get(i).name, String.valueOf(bankAccountVO.get(i).money)+"元"};
					tableModel.addRow(rowData);
					accountPool.add(bankAccountVO.get(i));
					System.out.println("SearchSucceed!");
						this.add(new MyNotification(this,"共有"+table.getColumnCount()+"个账户满足条件！",Color.GREEN));
					}	
					}else {
						this.add(new MyNotification(this,"请输入查询关键字！",Color.RED));
					}*/
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
		case 3: new MyNotification(this, "订单号输入错误！", Color.RED); break;
		case 4: new MyNotification(this, "订单号与收件人姓名不匹配！", Color.RED); break;
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
		if(orderNumberInfo[0].length()!=11){
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

