package ui.specialui.sender;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.orderblservice.OrderBLService;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import vo.OrderVO;


/**
 * 物流信息显示面板
 * @author zsq
 * @time 2015/11/18 19:34
 */
public class Panel_Sender_Total extends MyJPanel implements ActionListener{
	private Panel_Sender_CommodityInfo commodityPanel ;
	private Panel_Sender_logisticInfo logisticPanel;
	private Panel_Sender_Search searchPanel;
	private MyJTable table_order,table_logistic;
	private OrderBLService orderController;
	static ArrayList<OrderVO> orderPool;
	static String orderID = " ";
	public Panel_Sender_Total() {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent();
	}

	private void initComponent() {
		
		commodityPanel = new Panel_Sender_CommodityInfo();
		logisticPanel = new Panel_Sender_logisticInfo();
		searchPanel = new Panel_Sender_Search(this);
		this.add(commodityPanel);
		this.add(logisticPanel);
		this.add(searchPanel);
		this.add(new MyJLabel(560,30,150,40,"物流信息查询",22,true));
		orderPool = new ArrayList<OrderVO>();
		
		
	}

	
	private static final long serialVersionUID = 1L;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("SearchLogisticInfo")){
			if(this.isSearch()){
				table_order = commodityPanel.getTable();
				table_logistic = logisticPanel.getTable();
				DefaultTableModel tableModel_1 = (DefaultTableModel) table_order.getModel();
				int rowCount_1 = table_order.getRowCount();
				
				DefaultTableModel tableModel_2 = (DefaultTableModel) table_logistic.getModel();
				int rowCount_2 = table_logistic.getRowCount();
				
				for(int i=1;i<rowCount_1;i++){
					tableModel_1.removeRow(0);
				}
				for(int i=1;i<rowCount_2;i++){
					tableModel_2.removeRow(0);
				}
				orderPool.clear();
				orderID = "";
				
				//根据orderID查找 {"订单号","寄件人","收件人","费用","预计到达时间"};
				orderController = ControllerFactory.getOrderController();
				OrderVO orderVO;
				String[] data = searchPanel.getSenderInfo();
				if(data!=null){
					orderVO = orderController.inquireOrder(data[0], data[1]);
					if(orderVO==null){
						new MyNotification(this,"没有相应的订单！",Color.RED);
					}else{
						Object[] rowData ={orderVO.orderIdString,orderVO.senderName,orderVO.recipientName,orderVO.money,orderVO.recipientTime};
						tableModel_1.addRow(rowData);
						for(int i=0;i<orderVO.midAddres.size();i++){
						//TODO 
						Object[] rowData2 = {orderVO.midAddres.get(i)};
						tableModel_1.addRow(rowData2);
					}
						orderPool.add(orderVO);
						System.out.println("SearchSucceed!");
						new MyNotification(this,"共有"+table_order.getRowCount()+"个订单满足查新条件！",Color.GREEN);
					}
				}else{
					new MyNotification(this,"请输入查询信息！",Color.RED);
				}
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
		// 调用bl的判断是否合法方法即可  TODO

		return false;
	}

}
