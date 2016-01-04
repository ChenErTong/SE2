package ui.specialui.branch_conuterman.debitNoteBuild;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ReceiptType;
import ui.image.BranchImage;
import ui.image.LoginImage;
import ui.myui.MyButton;
import ui.myui.MyEmptyTextArea;
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
 * 
 * @author czw
 * @time 2015年11月22日下午2:20:29
 */
public class DebitNoteBuild extends MyJPanel {
	private static final long serialVersionUID = 1L;

	private MyJTextField courierId;
	private MyJTextField bankAccont;
	private MyButton searchCourier;
	private MyEmptyTextArea courierBill;

	public DebitNoteBuild(Frame_Branch frame) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);

		this.add(new MyJLabel(550, 30, 210, 45, "收款单建立", 30, true));
		this.add(new MyJLabel(415, 109, 105, 21, "快递员编号", 20, true));

		courierId = new MyJTextField(530, 105, 250, 30);
		courierId.setOnlyInteger(9);
		this.add(courierId);
		searchCourier = new MyButton(790, 100, 35, 35,
				LoginImage.getBUTTON_LOGISTIC());
		searchCourier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!DebitNoteBuild.this.searchCourier(courierId.getText())) {
					new MyNotification(frame, "不存在该快递员", Color.RED);
				}
				DebitNoteBuild.this.repaint();
			}
		});
		this.add(searchCourier);

		this.add(new MyJLabel(545, 160, 189, 21, "快递员当日收款信息", 18, true));
		courierBill = new MyEmptyTextArea(410, 160, 440, 405);
		this.add(courierBill);

		this.add(new MyJLabel(490, 587, 76, 19, "银行卡号", 18, true));
		bankAccont = new MyJTextField(580, 580, 180, 33);
		bankAccont.setOnlyInteger(19);
		this.add(bankAccont);
		
		MyButton produceDebitNote = new MyButton(575, 630, 111, 33,
				BranchImage.getBUTTON_SKD());
		produceDebitNote.setActionCommand("produceDebitNote");
		produceDebitNote.addActionListener(frame);
		this.add(produceDebitNote);
	}

	/**
	 * 清空界面上所有数据
	 */
	public void refresh() {
		courierId.setText(null);
		courierBill.setText(null);
	}

	/**
	 * 查询快递员
	 * @param courierId
	 * @return
	 */
	private boolean searchCourier(String courierId) {
		AccountBLService acountController;
			try {
				acountController = ControllerFactory
						.getAccountController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e1) {
				new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
				return true;
			}
		AccountVO account = null;
		try {
			account = acountController.find(courierId);
		} catch (RemoteException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return true;
		}
		if (account == null)
			return false;
		courierBill.setText("\n\n");
		courierBill.append("快递员编号：" + courierId + "\n");
		if (account.ordersID.size() == 0) {
			courierBill.append("该快递员当日未收款   ");
		} else {
			OrderBLService orderController;
			try {
				orderController = ControllerFactory
						.getOrderController();
			} catch (MalformedURLException | RemoteException
					| NotBoundException e1) {
				new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
				return true;
			}

			try {
				OrderVO order;
				for (int i = 0; i < account.ordersID.size(); ++i) {
					order = orderController.inquireOrder(account.ordersID
							.get(i));
					courierBill.append("\n订单编号：" + order.ID + "\t费用："
							+ order.money + "\t收款日期：" + order.recipientTime.substring(0, 10));
				}
			} catch (RemoteException e) {
				new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
				return true;
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
		if (text.equals("")) {
			return 1;
		}
		String bankId = bankAccont.getText();
		if(bankId.equals("")){
			return 2;
		}
		String[] lines = text.split("\n");
		String[] infos;
		ArrayList<String> orderID = new ArrayList<String>();
		BigDecimal money = new BigDecimal(0);
		String date = null;
		String courierID = lines[0].substring(6);
		for (int i = 1; i < lines.length; ++i) {
			infos = lines[i].split("\t");
			orderID.add(infos[0].substring(5));
			money = money.add(new BigDecimal(infos[1].substring(3)));
			date = infos[2].substring(5);
		}
		DebitAndPayBillBLService controller;
		try {
			controller = ControllerFactory
					.getDebitAndPayBillController();
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return 2;
		}
		DebitBillVO debitBillVO;
		try {
			debitBillVO = new DebitBillVO(controller.getExpenseID(),
				ReceiptType.DEBIT, courierID, money, orderID, date, bankId);
			controller.addDebitBill(debitBillVO);
			return 0;
		} catch (RemoteException e) {
			new MyNotification(this, "网络已断开，请连接后重试", Color.RED);ControllerFactory.init();
			return 2;
		}
	}
}