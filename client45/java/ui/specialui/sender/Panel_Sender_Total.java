package ui.specialui.sender;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogicservice.orderblservice.OrderBLService;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.myui.MyTitle;
import vo.OrderVO;


/**
 * 物流信息显示面板
 * @author zsq
 * @time 2015/11/18 19:34
 */
public class Panel_Sender_Total extends MyJPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private CommodifyInfo commodityPanel ;
	private LogisticInfo logisticPanel;
	private SearchOrder searchPanel;
	private MyJTable table_order,table_logistic;
	private OrderBLService orderController;
	
	static ArrayList<OrderVO> orderPool;
	static String orderID = " ";

	public Panel_Sender_Total() {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		MyTitle.setTitle(this, "物流查询界面", 480, 0, 306, 142);
		this.initComponent();
	}

	private void initComponent() {
		commodityPanel = new CommodifyInfo();
		logisticPanel = new LogisticInfo();
		searchPanel = new SearchOrder(this);
		this.add(commodityPanel);
		this.add(logisticPanel);
		this.add(searchPanel);
	//	this.add(new MyJLabel(560,30,150,40,"物流信息查询",22,true));
		orderPool = new ArrayList<OrderVO>();
	}
	
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
				
				OrderVO orderVO;
				String[] data = searchPanel.getSenderInfo();
				if(data!=null){
					try {
						orderController = ControllerFactory.getOrderController();
						orderVO = orderController.inquireOrder(data[0], data[1]);
						if(orderVO==null){
							new MyNotification(this,"没有相应的订单！",Color.RED);
						}else{
							Object[] rowData ={orderVO.ID,orderVO.senderName,orderVO.recipientName,orderVO.money,orderVO.recipientTime};
							tableModel_1.addRow(rowData);
							System.out.println(orderVO.midAddres.size());
							for(int i=0;i<orderVO.midAddres.size();i++){
								
								Object[] rowData2 = {orderVO.midAddres.get(i)};
								tableModel_2.addRow(rowData2);
							}
							orderPool.add(orderVO);
						}
					} catch (RemoteException | MalformedURLException | NotBoundException e1) {
						new MyNotification(this,"网络连接异常，请检查网络设置！",Color.RED);ControllerFactory.init();
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
	 */
	public  boolean isSearch(){
		switch((search())){
		case 0: new MyNotification(this, "正在进行查询", Color.GREEN); return true;
		case 1: new MyNotification(this, "请填写订单号", Color.RED); break;
		case 2: new MyNotification(this, "请填写寄件人姓名", Color.RED); break;
		case 3: new MyNotification(this, "订单号输入错误！", Color.RED); break;
		case 4: new MyNotification(this,"请输入查询信息！",Color.RED);break;
		}	
		return false ;
	}
		
	/**
	 * 进行查询
	 * @return 
	 */
	public int search() {
		String[] string = searchPanel.getSenderInfo();
		if(string==null){
			return 4;
		}
		if(string[0] == ""){
			return 1;
		}
		if(string[1] == ""){
			return 2;
		}
		if(string[0].length()!=10){
			return 3;
		}
		return 0;
		
	}
}
