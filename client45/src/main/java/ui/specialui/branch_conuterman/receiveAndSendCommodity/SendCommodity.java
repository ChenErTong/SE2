package ui.specialui.branch_conuterman.receiveAndSendCommodity;

import java.util.ArrayList;

import ui.image.BranchImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.accountvo.AccountVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import businesslogic.ControllerFactory;
import businesslogicservice.branchblservice.BranchBLService;
import businesslogicservice.organizationblservice.OrganizationBLService;
/**
 * 派发货物界面
 * @author czw
 * @time 2015年11月22日下午2:20:58
 */
public class SendCommodity extends MyJPanel{
	private static final long serialVersionUID = 1L;
	
	private MyJComboBox courier;
	private BranchBLService branchController;
	private String orderID;
	
	public SendCommodity(Frame_Branch frame, String orderID){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
	
		branchController = ControllerFactory.getBranchController();
		this.orderID = orderID;
		
		this.add(new MyJLabel(550, 30, 210, 45, "接收派件货物", 30, true));
		this.add(new MyJLabel(620, 100, 69, 23, "到达单", 18, true));
		
		MyEmptyTextArea arrivalList = new MyEmptyTextArea(390, 100, 500, 450);
		this.add(arrivalList);
		this.add(new MyJLabel(520, 580, 115, 23, "可选快递员", 18, true));
		
		this.setCourier(frame);
		
		MyButton produceDeliveryList = new MyButton(584, 630, 111, 33,
				BranchImage.getBUTTON_PAIJIANDAN());
		produceDeliveryList.setActionCommand("produceDeliveryList");
		produceDeliveryList.addActionListener(frame);
		this.add(produceDeliveryList);
	}

	private void setCourier(Frame_Branch frame){
		//快递员
		OrganizationBLService organizationController = ControllerFactory.getOrganizationController();
		ArrayList<AccountVO> couriers = organizationController.getAccountByOrganizationID(frame.getID().substring(0, 6));
		String[] courierInfo = null;
		if(couriers.size() > 0){
			courierInfo = new String[couriers.size()];
			for(int i = 0; i < courierInfo.length; ++i){
				courierInfo[i] = couriers.get(i).ID + " " + couriers.get(i).Name;
			}
		}		
		courier = new MyJComboBox(650, 575, 141, 30, courierInfo);	
		this.add(courier);
	}
	/**
	 * 生成派件单，若未选择快递员则返回1
	 * @return
	 */
	public int produceDeliveryList() {
		String courierInfo = (String) courier.getSelectedItem();
		if(courierInfo == null){
			return 1;
		}
		String courierName = courierInfo.split(" ")[1];
		DeliveryListVO deliveryList = branchController.getDeliveryList(orderID, courierName);
		branchController.save(deliveryList);
		branchController.submit(deliveryList);
		return 0;
	}
}