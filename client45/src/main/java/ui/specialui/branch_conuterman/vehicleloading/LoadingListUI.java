package ui.specialui.branch_conuterman.vehicleloading;

import ui.myui.MyEmptyTextArea;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
/**
 * 装车单界面
 * @author czw
 * @time 2015年11月28日下午9:23:50
 */
public class LoadingListUI extends MyJPanel {
	private static final long serialVersionUID = 1L;
	
	public LoadingListUI(LoadingListVO loadingList) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(573, 60, 133, 19, "装车单详细信息", 18, true));
		MyEmptyTextArea infoArea = new MyEmptyTextArea(370, 100, 540, 540);
		this.add(infoArea);
		//给装车单面板添加信息
		infoArea.setText("营业厅编号：" + loadingList.branchID + "\n");
		infoArea.append("目的地：" + loadingList.distination + "\n");
		infoArea.append("车辆编号：" + loadingList.carID + "\n");
		infoArea.append("押运员：" + loadingList.monitorName + "\n");
		infoArea.append("订单编号：\n");
		for(String orderID: loadingList.orders){
			infoArea.append(orderID + "\n");
		}
		infoArea.append("运费：" + loadingList.money);
	}
}