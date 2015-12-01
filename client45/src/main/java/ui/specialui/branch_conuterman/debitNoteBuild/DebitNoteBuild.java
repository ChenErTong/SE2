package ui.specialui.branch_conuterman.debitNoteBuild;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import state.ReceiptType;
import ui.myui.MyEmptyTextArea;
import ui.myui.MyJButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTextField;
import ui.myui.MyNotification;
import ui.specialui.branch_conuterman.Frame_Branch;
import vo.OrderVO;
import vo.accountvo.AccountVO;
import vo.receiptvo.DebitBillVO;
import businesslogic.ControllerFactory;
import businesslogicservice.accountblservice.AccountBLService;
import businesslogicservice.fundblservice.DebitAndPayBillBLService;
import businesslogicservice.orderblservice.OrderBLService;
/**
 * 收款单建立界面
 * @author czw
 * @time 2015年11月22日下午2:20:29
 */
public class DebitNoteBuild extends MyJPanel{
	private static final long serialVersionUID = 1L;

	private MyJTextField courierId;
	private MyJButton searchCourier;
	private MyEmptyTextArea courierBill;
	
	public DebitNoteBuild(Frame_Branch frame){
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		
		this.add(new MyJLabel(550, 30, 210, 45, "收款单建立", 30, true));
		this.add(new MyJLabel(385, 119, 105, 21, "快递员编号", 20, true));
		
		courierId = new MyJTextField(500, 115, 250, 30);
		courierId.setOnlyInteger(9);
		this.add(courierId);
		searchCourier = new MyJButton(760, 115, 60, 30, "查询", 20);
		searchCourier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!DebitNoteBuild.this.searchCourier(courierId.getText())){
					new MyNotification(frame, "不存在该快递员", Color.RED);
				}				
			}
		});
		this.add(searchCourier);
		
		this.add(new MyJLabel(545, 190, 189, 21, "快递员当日收款信息", 18, true));
		courierBill = new MyEmptyTextArea(410, 190, 440, 405);
		this.add(courierBill);
		
		MyJButton produceDebitNote = new MyJButton(575, 630, 115, 23,
				"生成收款单", 18);
		produceDebitNote.setActionCommand("produceDebitNote");
		produceDebitNote.addActionListener(frame);
		this.add(produceDebitNote);
	}
	
	/**
	 * 清空界面上所有数据
	 */
	public void refresh(){
		courierId.setText(null);
		courierBill.setText(null);
	}
	
	/**
	 * 查询快递员
	 * @param courierId 
	 * @return
	 */
	private boolean searchCourier(String courierId) {
		AccountBLService acountController = ControllerFactory.getAccountController();
		AccountVO account = acountController.find(courierId);
		if(account == null) return false;
		courierBill.setText("快递员编号：" + courierId);
		if(account.ordersID.size() == 0){
			courierBill.setText("该快递员当日未收款");
		}else{
			OrderBLService orderController = ControllerFactory.getOrderController();
			OrderVO order;
			for(int i = 0; i < account.ordersID.size(); ++i){
				order = orderController.inquireOrder(account.ordersID.get(i));
				courierBill.append("\n订单编号：" + order.ID + "\t费用：" + order.money + "\t收款日期：" + order.recipientTime);
			}
		}
		return true;
	}
	
	/**
	 * 建立收款单
	 * @return
	 */
	public int produceDebitNote() {
		String text = courierBill.getText();
		if(text.equals("")){
			return 1;
		}
		String[] lines = text.split("\n");
		String[] infos;
		ArrayList<String> orderID = new ArrayList<String>();
		double money = 0.0;
		String date = null;
		String courierID = lines[0].substring(6);
		for (int i = 1; i < lines.length; ++i) {
			infos = lines[i].split("\t");
			orderID.add(infos[0].substring(5));
			money += Double.parseDouble(infos[1].substring(3));
			date = infos[2].substring(5);
		}
		DebitAndPayBillBLService controller = ControllerFactory.getDebitAndPayBillController();
		DebitBillVO debitBillVO = new DebitBillVO(controller.getExpenseID(), ReceiptType.DEBIT, courierID, money, orderID, date);
		controller.addDebitBill(debitBillVO);
		controller.save(debitBillVO);
		controller.submit(debitBillVO);
		return 0;
	}
}