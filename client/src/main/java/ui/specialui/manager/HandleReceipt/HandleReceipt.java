package ui.specialui.manager.HandleReceipt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import businesslogic.ControllerFactory;
import businesslogic.receiptbl.ReceiptController;
import businesslogicservice.receiptblservice.ReceiptBLService;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import ui.commonui.receipt_constructor.ReceiptConductor;
import ui.image.ManagerImage;
import ui.image.FinanceImage.BankAccountImage;
import ui.myui.MyButton;
import ui.myui.MyJLabel;
import ui.myui.MyJPanel;
import ui.myui.MyJTable;
import ui.myui.MyNotification;
import ui.specialui.manager.FrameManager;

import vo.ValueObject;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.PaymentBillVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import vo.receiptvo.orderreceiptvo.OrderReceiptVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

/**
 * 处理单据的总Panel
 * @author zsq
 * @time 2015/11/18 23:58
 */
/**
 * 
 * @author zsq
 * @time 2015年12月16日下午9:34:40
 */
public class HandleReceipt extends MyJPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private ReceiptController receiptController;
	private SearchReceipt searchPanel;
	private ReceiptInfo receiptInfo;
	ModifyReceiptInfo modifyUI;

	static ArrayList<ValueObject> listPool;
	static ArrayList<ReceiptType> typePool;
	static int index = -1;

	ArrayList<ValueObject> passList;
	ArrayList<ReceiptType> passType;
	JTable table;
	MyJTable modifyTable;
	DefaultTableModel model;

	ValueObject currentBill;
	ReceiptType currentType;

	private MyButton ViewReceiptInfo;
	private MyButton PassSelectedReceipts;
	private MyButton ModifyReceiptInfo;
	private MyButton PassThisReceipt;
	private MyButton DontPassThisReceipt;
	private MyButton ExportReceipt;
	private MyButton search;
	private MyButton modify;
	private MyButton cancel;

	public HandleReceipt(FrameManager frameManager) throws RemoteException {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		listPool = new ArrayList<ValueObject>();
		typePool = new ArrayList<ReceiptType>();
		passList = new ArrayList<ValueObject>();
		passType = new ArrayList<ReceiptType>();
		this.initComponent();
		search = searchPanel.getSearch();

	}

	private void initComponent() throws RemoteException {
		this.add(new MyJLabel(530, 20, 300, 40, "公司运营单据处理", 30, true));
		searchPanel = new SearchReceipt(this);
		this.add(searchPanel);

		receiptInfo = new ReceiptInfo();
		this.add(receiptInfo);

		this.initButton();

		index = -1;

		this.showAll();
	}

	private void initButton() {
		ViewReceiptInfo = new MyButton(85, 650 - 30, 150, 40,
				ManagerImage.getBUTTON_VIEWBILL());
		ViewReceiptInfo.setActionCommand("ViewReceiptInfo");
		ViewReceiptInfo.addActionListener(this);
		this.add(ViewReceiptInfo);
		ViewReceiptInfo.setVisible(true);

		PassSelectedReceipts = new MyButton(255, 650 - 30, 150, 40,
				ManagerImage.getBUTTON_APPROVEALL());
		PassSelectedReceipts.setActionCommand("PassSelectedReceipts");
		PassSelectedReceipts.addActionListener(this);
		this.add(PassSelectedReceipts);
		PassSelectedReceipts.setVisible(true);

		ModifyReceiptInfo = new MyButton(425, 650 - 30, 150, 40,
				ManagerImage.getBUTTON_MODIFYBILL());

		ModifyReceiptInfo.setActionCommand("ModifyReceiptInfo");
		ModifyReceiptInfo.addActionListener(this);
		this.add(ModifyReceiptInfo);
		ModifyReceiptInfo.setVisible(true);

		PassThisReceipt = new MyButton(705, 650 - 30, 150, 40,
				ManagerImage.getBUTTON_PASSBILL());
		PassThisReceipt.setActionCommand("PassThisReceipt");
		PassThisReceipt.addActionListener(this);
		this.add(PassThisReceipt);
		PassThisReceipt.setVisible(true);

		DontPassThisReceipt = new MyButton(875, 650 - 30, 150, 40,
				ManagerImage.getBUTTON_DONTPASS());
		DontPassThisReceipt.setActionCommand("DontPassThisReceipt");
		DontPassThisReceipt.addActionListener(this);
		this.add(DontPassThisReceipt);

		ExportReceipt = new MyButton(1045, 650 - 30, 150, 40,
				ManagerImage.getBUTTON_EXPORTBILL());
		ExportReceipt.setActionCommand("ExportReceipt");
		ExportReceipt.addActionListener(this);
		this.add(ExportReceipt);
	}

	public void actionPerformed(ActionEvent events) {
		if (events.getActionCommand().equals("DontPassThisReceipt")) {
			if (!table.getValueAt(table.getSelectedRow(), 3).equals("未审批")) {
				new MyNotification(this, "状态为未审批状态的单据才能进行审批！", Color.RED);
			} else {
				try {
					receiptController = ControllerFactory
							.getReceiptController();
					ArrayList<ReceiptVO> dontPassList = new ArrayList<ReceiptVO>();
					ArrayList<ReceiptType> dontPassType = new ArrayList<ReceiptType>();
					dontPassList.add((ReceiptVO) listPool.get(table
							.getSelectedRow()));
					dontPassType.add(typePool.get(table.getSelectedRow()));
					ResultMessage rm = receiptController
							.dontPassReceipt(dontPassList);
					if (rm.equals(ResultMessage.FAIL)) {
						new MyNotification(this, "不通过单据失败！", Color.RED);
					} else {
						search.doClick();
						new MyNotification(this, "不通过单据成功！", Color.GREEN);
					}
				} catch (RemoteException | MalformedURLException
						| NotBoundException e) {
					new MyNotification(this, "网络连接异常，请检查网络设置！", Color.RED);
					ControllerFactory.init();
					ControllerFactory.init();
					return;
				}
			}
		} else if (events.getActionCommand().equals("PassThisReceipt")) {
			table = searchPanel.getTable();
			ArrayList<ReceiptVO> PassList = new ArrayList<ReceiptVO>();
			if (!table.getValueAt(table.getSelectedRow(), 3).equals("未审批")) {
				new MyNotification(this, "状态为未审批状态的单据才能进行审批！", Color.RED);
			} else {

				try {
					receiptController = ControllerFactory
							.getReceiptController();

					passList.clear();
					passType.clear();

					passList.add(listPool.get(table.getSelectedRow()));
					passType.add(typePool.get(table.getSelectedRow()));

					PassList.add((ReceiptVO) listPool.get(table
							.getSelectedRow()));

					ResultMessage rsg = receiptController.passReceipt(PassList);
					if (rsg.equals(ResultMessage.FAIL)) {
						new MyNotification(this, "通过单据失败！", Color.RED);
					} else {
						search.doClick();
						index = -1;
						new MyNotification(this, "通过单据成功！", Color.GREEN);

					}
				} catch (RemoteException | MalformedURLException
						| NotBoundException e) {
					new MyNotification(this, "网络连接异常，请检查网络设置！", Color.RED);
					ControllerFactory.init();
					ControllerFactory.init();
					return;
				}
			}

		} else if (events.getActionCommand().equals("PassSelectedReceipts")) {
			table = searchPanel.getTable();
			int count = 0;
			boolean flag = true;
			ArrayList<ReceiptVO> PassList = new ArrayList<ReceiptVO>();
			int rowCount = table.getRowCount();

			passList.clear();
			passType.clear();

			for (int i = 0; i < rowCount; i++) {
				if (table.getValueAt(i, 0) != null)
					if (table.getValueAt(i, 0).equals(Boolean.TRUE)) {
						passList.add(listPool.get(i));
						passType.add(typePool.get(i));
						PassList.add((ReceiptVO) listPool.get(i));
					}
			}
			for (int i = 0; i < rowCount; i++) {
				if (table.getValueAt(i, 0) != null)
					if (table.getValueAt(i, 0).equals(Boolean.TRUE)) {
						count++;
					}

				if (table.getValueAt(i, 0) != null)
					if (table.getValueAt(i, 0).equals(Boolean.TRUE)
							&& !table.getValueAt(i, 3).equals("未审批")) {
						flag = false;
					}
			}
			if (flag == true) {
				if (count == 0) {
					new MyNotification(this, "请先选择需要进行审批的单据！", Color.RED);
				} else {
					try {
						receiptController = ControllerFactory
								.getReceiptController();
						ResultMessage rm = receiptController
								.passReceipt(PassList);

						if (rm.equals(ResultMessage.FAIL)) {
							new MyNotification(this, "单据批量审批失败", Color.RED);
						} else {

							search.doClick();
							new MyNotification(this, "单据批量审批成功！", Color.GREEN);
						}
					} catch (RemoteException | MalformedURLException
							| NotBoundException e) {
						new MyNotification(this, "网络连接异常，请检查网络设置！", Color.RED);
						ControllerFactory.init();
						return;
					}
				}
			} else {
				new MyNotification(this, "只可对未审批的单据进行审批!", Color.RED);
			}
		} else if (events.getActionCommand().equals("ViewReceiptInfo")) {
			table = searchPanel.getTable();
			int count = 0;

			for (int i = 0; i < table.getRowCount(); i++) {
				if (table.getValueAt(i, 0) != null)
					if (table.getValueAt(i, 0).equals(Boolean.TRUE)) {
						count++;
						index = i;
					}
			}
			if (count == 0) {
				new MyNotification(this, "请选择一条要查看的单据！", Color.RED);
			} else if (count > 1) {
				new MyNotification(this, "请只选择一条要查看的单据！", Color.RED);
			} else {
				ReceiptConductor writer = new ReceiptConductor();
				receiptInfo.getTa().setText(
						writer.writeReceipt(typePool.get(index),
								listPool.get(index)));
				this.repaint();
			}
		} else if (events.getActionCommand().equals("ModifyReceiptInfo")) {
			table = searchPanel.getTable();
			int count = 0;

			for (int i = 0; i < table.getRowCount(); i++) {
				if (table.getValueAt(i, 0) != null)
					if (table.getValueAt(i, 0).equals(Boolean.TRUE)) {
						count++;
						index = i;
					}
			}
			if (count == 0) {
				new MyNotification(this, "请选择一条要修改的单据！", Color.RED);
				return;
			} else if (count > 1) {
				new MyNotification(this, "请只选择一条要修改的单据！", Color.RED);
				return;
			}
			if (!table.getValueAt(index, 3).equals("未审批")) {
				new MyNotification(this, "状态为未审批的单据才能进行修改！", Color.RED);
			} else {
				modifyUI = new ModifyReceiptInfo(typePool.get(index),
						listPool.get(index));
				currentType = typePool.get(index);
				currentBill = listPool.get(index);

				this.removeAll();
				this.add(new MyJLabel(550, 20, 200, 40, "单据信息修改", 24, true));
				modify = new MyButton(395, 633, 100, 30,
						BankAccountImage.getBUTTON_CONFIRM());
				modify.setActionCommand("Modify");
				modify.addActionListener(this);
				this.add(modify);
				cancel = new MyButton(766, 633, 100, 30,
						ManagerImage.getBUTTON_RETURN());
				cancel.setActionCommand("Cancel");
				cancel.addActionListener(this);
				this.add(cancel);
				this.repaint();
				this.add(modifyUI);
			}

		} else if (events.getActionCommand().equals("ExportReceipt")) {
			table = searchPanel.getTable();
			if (index >= 0) {
				FileSystemView fsv = FileSystemView.getFileSystemView();
				String file = String.valueOf(fsv.getHomeDirectory()) + "/"
						+ table.getValueAt(index, 2) + ".txt";
				System.out.print(file);
				writeto(receiptInfo.getTa().getText().replaceAll("\n", "\r\n"),
						file);
				new MyNotification(this, "单据成功导出至桌面！", Color.GREEN);
			}
		} else if (events.getActionCommand().equals("SearchReceipt")) {
			// 清空VO储存池
			listPool.clear();
			typePool.clear();

			// System.out.println(listPool);

			table = searchPanel.getTable();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

			int rowCount = table.getRowCount();

			for (int k = 0; k < rowCount; k++)
				tableModel.removeRow(0);
			int data[] = searchPanel.getData();
			if (data[0] == 1) {
				try {
					getApprovalData(data[1]);
				} catch (Exception e) {
					return;
				}
			} else if (data[0] == 2) {
				try {
					getPassData(data[1]);
				} catch (Exception e) {
					return;
				}
			} else if (data[0] == 3) {
				try {
					getFailureData(data[1]);
				} catch (Exception e) {
					return;
				}
			} else {
				try {
					getApprovalData(data[1]);
				} catch (Exception e) {
					return;
				}
				try {
					getPassData(data[1]);
				} catch (Exception e) {
					return;
				}
				try {
					getFailureData(data[1]);
				} catch (Exception e) {
					return;
				}
			}
			if (table.getRowCount() == 0) {
				new MyNotification(this, "目前没有找到符合条件的单据！", Color.RED);
			}
		} else if (events.getSource() == cancel) {
			MyJTable table = modifyUI.table;
			if (table.isEditing()) {
				table.getCellEditor().stopCellEditing();
			}
			try {
				this.removeAll();
				this.initComponent();
				this.repaint();
			} catch (RemoteException e) {
				new MyNotification(this, "网络连接异常，请检查网络设置！", Color.RED);
				ControllerFactory.init();
				ControllerFactory.init();
				return;
			}
		} else if (events.getSource() == modify) {
			modifyTable = modifyUI.table;
			if (modifyTable.isEditing()) {
				modifyTable.getCellEditor().stopCellEditing();
				new MyNotification(this, "正在修改单据！", Color.GREEN);
			}
			try {
				finish(currentType);
				this.removeAll();

				this.initComponent();
				this.repaint();
			} catch (RemoteException | MalformedURLException
					| NotBoundException e1) {
				new MyNotification(this, "网络连接异常，请检查网络设置！", Color.RED);
				ControllerFactory.init();
				ControllerFactory.init();
				return;
			}
		}
	}

	private void getApprovalData(int index) throws RemoteException,
			MalformedURLException, NotBoundException {
		table = searchPanel.getTable();
		ReceiptController controller = ControllerFactory.getReceiptController();

		@SuppressWarnings("unused")
		ArrayList<ReceiptVO> vo = controller.show(null,
				ReceiptState.APPROVALING);// 待审批的单据
		ArrayList<OrderReceiptVO> orderReceipt = controller.show(
				ReceiptType.ORDER, ReceiptState.APPROVALING);
		ArrayList<LoadingListVO> loadingList = controller.show(
				ReceiptType.BRANCH_TRUCK, ReceiptState.APPROVALING);
		ArrayList<BranchArrivalListVO> branchArrival = controller.show(
				ReceiptType.BRANCH_ARRIVAL, ReceiptState.APPROVALING);
		ArrayList<DebitBillVO> debitBill = controller.show(ReceiptType.DEBIT,
				ReceiptState.APPROVALING);
		ArrayList<DeliveryListVO> delivery = controller.show(
				ReceiptType.BRANCH_DELIVER, ReceiptState.APPROVALING);
		ArrayList<TransferArrivalListVO> transferArrival = controller.show(
				ReceiptType.TRANS_ARRIVAL, ReceiptState.APPROVALING);
		ArrayList<InventoryImportReceiptVO> importReceipt = controller.show(
				ReceiptType.INSTOCK, ReceiptState.APPROVALING);
		ArrayList<TransferOrderVO> transferOrder = controller.show(
				ReceiptType.TRANS_PLANE, ReceiptState.APPROVALING);
		ArrayList<InventoryExportReceiptVO> exportReceipt = controller.show(
				ReceiptType.OUTSTOCK, ReceiptState.APPROVALING);
		ArrayList<PaymentBillVO> paymentBill = controller.show(ReceiptType.PAY,
				ReceiptState.APPROVALING);

		model = (DefaultTableModel) table.getModel();

		if (index == 0) {
			for (int i = 1; i <= 10; i++)
				getApprovalData(i);
		}
		if (index == 1) {
			for (int i = 0; i < orderReceipt.size(); i++) {
				Object[] rowData = { null, "寄件单", orderReceipt.get(i).ID, "未审批" };
				model.addRow(rowData);
				listPool.add(orderReceipt.get(i));
				typePool.add(orderReceipt.get(i).type);
			}
		}
		if (index == 2) {
			for (int i = 0; i < loadingList.size(); i++) {
				System.out.println(loadingList + "!");
				Object[] rowData = { new Boolean(false), "装车单",
						loadingList.get(i).ID, "未审批" };
				model.addRow(rowData);
				System.out.println(loadingList + "!");
				System.out.println(listPool);
				listPool.add(loadingList.get(i));

				typePool.add(loadingList.get(i).type);
			}
		}
		if (index == 3) {

			for (int i = 0; i < branchArrival.size(); i++) {
				Object[] rowData = { new Boolean(false), "营业厅到达单",
						branchArrival.get(i).ID, "未审批" };
				model.addRow(rowData);
				listPool.add(branchArrival.get(i));
				typePool.add(branchArrival.get(i).type);
			}
		}
		if (index == 4) {
			if (debitBill == null) {
				return;
			}
			for (int i = 0; i < debitBill.size(); i++) {
				Object[] rowData = { new Boolean(false), "收款单",
						debitBill.get(i).ID, "未审批" };
				model.addRow(rowData);
				listPool.add(debitBill.get(i));
				typePool.add(debitBill.get(i).type);
			}
		}
		if (index == 5) {
			for (int i = 0; i < delivery.size(); i++) {
				Object[] rowData = { new Boolean(false), "派件单",
						delivery.get(i).ID, "未审批" };
				model.addRow(rowData);
				listPool.add(delivery.get(i));
				typePool.add(delivery.get(i).type);
			}
		}
		if (index == 6) {
			for (int i = 0; i < transferArrival.size(); i++) {
				Object[] rowData = { new Boolean(false), "中转中心到达单",
						transferArrival.get(i).ID, "未审批" };
				model.addRow(rowData);
				listPool.add(transferArrival.get(i));
				typePool.add(transferArrival.get(i).type);
			}
		}
		if (index == 7) {
			for (int i = 0; i < importReceipt.size(); i++) {
				Object[] rowData = { new Boolean(false), "入库单",
						importReceipt.get(i).ID, "未审批" };
				model.addRow(rowData);
				listPool.add(importReceipt.get(i));
				typePool.add(importReceipt.get(i).type);
			}
		}
		if (index == 8) {
			for (int i = 0; i < transferOrder.size(); i++) {
				Object[] rowData = { new Boolean(false), "转运单",
						transferOrder.get(i).ID, "未审批" };
				model.addRow(rowData);
				listPool.add(transferOrder.get(i));
				typePool.add(transferOrder.get(i).type);
			}
		}
		if (index == 9) {
			for (int i = 0; i < exportReceipt.size(); i++) {
				Object[] rowData = { new Boolean(false), "出库单",
						exportReceipt.get(i).ID, "未审批" };
				model.addRow(rowData);
				listPool.add(exportReceipt.get(i));
				typePool.add(exportReceipt.get(i).type);
			}
		}
		if (index == 10) {
			for (int i = 0; i < paymentBill.size(); i++) {
				Object[] rowData = { new Boolean(false), "付款单",
						paymentBill.get(i).ID, "未审批" };
				model.addRow(rowData);
				listPool.add(paymentBill.get(i));
				typePool.add(paymentBill.get(i).type);
			}
		}
	}

	@SuppressWarnings("unused")
	private void getPassData(int index) throws RemoteException,
			MalformedURLException, NotBoundException {
		table = searchPanel.getTable();
		ReceiptController controller = ControllerFactory.getReceiptController();
		ArrayList<ReceiptVO> vo = controller.show(null, ReceiptState.SUCCESS);// 待审批的单据
		ArrayList<OrderReceiptVO> orderReceipt = controller.show(
				ReceiptType.ORDER, ReceiptState.SUCCESS);
		ArrayList<LoadingListVO> loadingList = controller.show(
				ReceiptType.BRANCH_TRUCK, ReceiptState.SUCCESS);
		ArrayList<BranchArrivalListVO> branchArrival = controller.show(
				ReceiptType.BRANCH_ARRIVAL, ReceiptState.SUCCESS);
		ArrayList<DebitBillVO> debitBill = controller.show(ReceiptType.DEBIT,
				ReceiptState.SUCCESS);
		ArrayList<DeliveryListVO> delivery = controller.show(
				ReceiptType.BRANCH_DELIVER, ReceiptState.SUCCESS);
		ArrayList<TransferArrivalListVO> transferArrival = controller.show(
				ReceiptType.TRANS_ARRIVAL, ReceiptState.SUCCESS);
		ArrayList<InventoryImportReceiptVO> importReceipt = controller.show(
				ReceiptType.INSTOCK, ReceiptState.SUCCESS);
		ArrayList<TransferOrderVO> transferOrder = controller.show(
				ReceiptType.TRANS_PLANE, ReceiptState.SUCCESS);
		ArrayList<InventoryExportReceiptVO> exportReceipt = controller.show(
				ReceiptType.OUTSTOCK, ReceiptState.SUCCESS);
		ArrayList<PaymentBillVO> paymentBill = controller.show(ReceiptType.PAY,
				ReceiptState.SUCCESS);

		model = (DefaultTableModel) table.getModel();

		if (index == 0) {
			for (int i = 1; i <= 10; i++)
				getPassData(i);
		}
		if (index == 1) {
			for (int i = 0; i < orderReceipt.size(); i++) {
				Object[] rowData = { null, "寄件单", orderReceipt.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(orderReceipt.get(i));
				typePool.add(orderReceipt.get(i).type);
			}
		}
		if (index == 2) {
			for (int i = 0; i < loadingList.size(); i++) {
				Object[] rowData = { new Boolean(false), "装车单",
						loadingList.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(loadingList.get(i));
				typePool.add(loadingList.get(i).type);
			}
		}
		if (index == 3) {
			for (int i = 0; i < branchArrival.size(); i++) {
				Object[] rowData = { new Boolean(false), "营业厅到达单",
						branchArrival.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(branchArrival.get(i));
				typePool.add(branchArrival.get(i).type);
			}
		}
		if (index == 4) {
			for (int i = 0; i < debitBill.size(); i++) {
				Object[] rowData = { new Boolean(false), "收款单",
						debitBill.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(debitBill.get(i));
				typePool.add(debitBill.get(i).type);
			}
		}
		if (index == 5) {
			for (int i = 0; i < delivery.size(); i++) {
				Object[] rowData = { new Boolean(false), "派件单",
						delivery.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(delivery.get(i));
				typePool.add(delivery.get(i).type);
			}
		}
		if (index == 6) {
			for (int i = 0; i < transferArrival.size(); i++) {
				Object[] rowData = { new Boolean(false), "中转中心到达单",
						transferArrival.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(transferArrival.get(i));
				typePool.add(transferArrival.get(i).type);
			}
		}
		if (index == 7) {
			for (int i = 0; i < importReceipt.size(); i++) {
				Object[] rowData = { new Boolean(false), "入库单",
						importReceipt.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(importReceipt.get(i));
				typePool.add(importReceipt.get(i).type);
			}
		}
		if (index == 8) {
			for (int i = 0; i < transferOrder.size(); i++) {
				Object[] rowData = { new Boolean(false), "转运单",
						transferOrder.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(transferOrder.get(i));
				typePool.add(transferOrder.get(i).type);
			}
		}
		if (index == 9) {
			for (int i = 0; i < exportReceipt.size(); i++) {
				Object[] rowData = { new Boolean(false), "出库单",
						exportReceipt.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(exportReceipt.get(i));
				typePool.add(exportReceipt.get(i).type);
			}
		}
		if (index == 10) {
			for (int i = 0; i < paymentBill.size(); i++) {
				Object[] rowData = { new Boolean(false), "付款单",
						paymentBill.get(i).ID, "已通过" };
				model.addRow(rowData);
				listPool.add(paymentBill.get(i));
				typePool.add(paymentBill.get(i).type);
			}
		}
	}

	@SuppressWarnings("unused")
	private void getFailureData(int index) throws RemoteException,
			MalformedURLException, NotBoundException {
		table = searchPanel.getTable();
		ReceiptController controller = ControllerFactory.getReceiptController();
		ArrayList<ReceiptVO> vo = controller.show(null, ReceiptState.FAILURE);// 待审批的单据
		ArrayList<OrderReceiptVO> orderReceipt = controller.show(
				ReceiptType.ORDER, ReceiptState.FAILURE);
		ArrayList<LoadingListVO> loadingList = controller.show(
				ReceiptType.BRANCH_TRUCK, ReceiptState.FAILURE);
		ArrayList<BranchArrivalListVO> branchArrival = controller.show(
				ReceiptType.BRANCH_ARRIVAL, ReceiptState.FAILURE);
		ArrayList<DebitBillVO> debitBill = controller.show(ReceiptType.DEBIT,
				ReceiptState.FAILURE);
		ArrayList<DeliveryListVO> delivery = controller.show(
				ReceiptType.BRANCH_DELIVER, ReceiptState.FAILURE);
		ArrayList<TransferArrivalListVO> transferArrival = controller.show(
				ReceiptType.TRANS_ARRIVAL, ReceiptState.FAILURE);
		ArrayList<InventoryImportReceiptVO> importReceipt = controller.show(
				ReceiptType.INSTOCK, ReceiptState.FAILURE);
		ArrayList<TransferOrderVO> transferOrder = controller.show(
				ReceiptType.TRANS_PLANE, ReceiptState.FAILURE);
		ArrayList<InventoryExportReceiptVO> exportReceipt = controller.show(
				ReceiptType.OUTSTOCK, ReceiptState.FAILURE);
		ArrayList<PaymentBillVO> paymentBill = controller.show(ReceiptType.PAY,
				ReceiptState.FAILURE);

		model = (DefaultTableModel) table.getModel();

		if (index == 0) {
			for (int i = 1; i <= 10; i++)
				getFailureData(i);
		}
		if (index == 1) {
			for (int i = 0; i < orderReceipt.size(); i++) {
				Object[] rowData = { null, "寄件单", orderReceipt.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(orderReceipt.get(i));
				typePool.add(orderReceipt.get(i).type);
			}
		}
		if (index == 2) {
			for (int i = 0; i < loadingList.size(); i++) {
				Object[] rowData = { new Boolean(false), "装车单",
						loadingList.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(loadingList.get(i));
				typePool.add(loadingList.get(i).type);
			}
		}
		if (index == 3) {
			for (int i = 0; i < branchArrival.size(); i++) {
				Object[] rowData = { new Boolean(false), "营业厅到达单",
						branchArrival.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(branchArrival.get(i));
				typePool.add(branchArrival.get(i).type);
			}
		}
		if (index == 4) {
			for (int i = 0; i < debitBill.size(); i++) {
				Object[] rowData = { new Boolean(false), "收款单",
						debitBill.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(debitBill.get(i));
				typePool.add(debitBill.get(i).type);
			}
		}
		if (index == 5) {
			for (int i = 0; i < delivery.size(); i++) {
				Object[] rowData = { new Boolean(false), "派件单",
						delivery.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(delivery.get(i));
				typePool.add(delivery.get(i).type);
			}
		}
		if (index == 6) {
			for (int i = 0; i < transferArrival.size(); i++) {
				Object[] rowData = { new Boolean(false), "中转中心到达单",
						transferArrival.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(transferArrival.get(i));
				typePool.add(transferArrival.get(i).type);
			}
		}
		if (index == 7) {
			for (int i = 0; i < importReceipt.size(); i++) {
				Object[] rowData = { new Boolean(false), "入库单",
						importReceipt.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(importReceipt.get(i));
				typePool.add(importReceipt.get(i).type);
			}
		}
		if (index == 8) {
			for (int i = 0; i < transferOrder.size(); i++) {
				Object[] rowData = { new Boolean(false), "转运单",
						transferOrder.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(transferOrder.get(i));
				typePool.add(transferOrder.get(i).type);
			}
		}
		if (index == 9) {
			for (int i = 0; i < exportReceipt.size(); i++) {
				Object[] rowData = { new Boolean(false), "出库单",
						exportReceipt.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(exportReceipt.get(i));
				typePool.add(exportReceipt.get(i).type);
			}
		}
		if (index == 10) {
			for (int i = 0; i < paymentBill.size(); i++) {
				Object[] rowData = { new Boolean(false), "付款单",
						paymentBill.get(i).ID, "未通过" };
				model.addRow(rowData);
				listPool.add(paymentBill.get(i));
				typePool.add(paymentBill.get(i).type);
			}
		}
	}

	private void showAll() throws RemoteException {
		try {
			this.getApprovalData(0);
			this.getPassData(0);
			this.getFailureData(0);
		} catch (MalformedURLException | NotBoundException e) {
			new MyNotification(this, "网络连接异常，请检查网络设置！", Color.RED);
			ControllerFactory.init();
			return;
		}
	}

	private void writeto(String a, String file) {
		try {
			File filename = new File(file);

			if (!filename.exists()) {
				filename.createNewFile();
			}

			FileWriter fw = new FileWriter(filename);
			fw.write(a);
			fw.close();
		} catch (IOException e) {
			return;
		}
	}

	/**
	 * 寄件单、装车单、营业厅到达单、收款单、派件单、中转中心到达单、入库单、中转单、出库单、付款单
	 * 
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @throws MalformedURLException
	 */
	@SuppressWarnings("unchecked")
	private void finish(ReceiptType billType) throws RemoteException,
			MalformedURLException, NotBoundException {
		ReceiptBLService controller = ControllerFactory.getReceiptController();
		ResultMessage rm = null;
		if (billType.equals(ReceiptType.ORDER)) {
			OrderReceiptVO vo = (OrderReceiptVO) currentBill;
			vo.orders = (ArrayList<String>) table.getValueAt(0, 2);
			rm = controller.updateReceipt(new OrderReceiptVO(vo.ID, vo.type,
					vo.orders));
		} else if (billType.equals(ReceiptType.BRANCH_TRUCK)) {
			LoadingListVO vo = (LoadingListVO) currentBill;
			// String[] headers =
			// {"单据种类","营业厅编号","装运编号","目的地","车辆代号","监装员","订单序列","运费"};
			vo.branchID = (String) modifyTable.getValueAt(0, 1);
			vo.transferNumber = (String) modifyTable.getValueAt(0, 2);
			vo.distination = (String) modifyTable.getValueAt(0, 3);
			vo.carID = (String) modifyTable.getValueAt(0, 4);
			vo.monitorName = (String) modifyTable.getValueAt(0, 5);
			vo.orders = new ArrayList<String>();
			vo.orders.add((String) modifyTable.getValueAt(0, 7));
			vo.money = new BigDecimal((String) modifyTable.getValueAt(0, 8));

			rm = controller.updateReceipt(new LoadingListVO(vo.ID, vo.type,
					vo.branchID, vo.transferNumber, vo.distination, vo.carID,
					vo.monitorName, vo.orders, vo.money));
		} else if (billType.equals(ReceiptType.BRANCH_ARRIVAL)) {
			BranchArrivalListVO vo = (BranchArrivalListVO) currentBill;
			// String[] headers = {"单据类型","中转单编号","出发地","货物到达状态","订单订单号"};
			vo.transferListID = (String) modifyTable.getValueAt(0, 1);
			vo.departure = (String) modifyTable.getValueAt(0, 2);
			vo.orderID = (String) modifyTable.getValueAt(0, 3);
			rm = controller.updateReceipt(new BranchArrivalListVO(vo.ID,
					vo.type, vo.transferListID, vo.departure, vo.state,
					vo.orderID));
		} else if (billType.equals(ReceiptType.PAY)) {
			PaymentBillVO vo = (PaymentBillVO) currentBill;

			vo.date = (String) modifyTable.getValueAt(0, 5);
			vo.money = new BigDecimal((String) modifyTable.getValueAt(0, 1));
			vo.payerName = (String) modifyTable.getValueAt(0, 0);
			vo.bankAccountID = (String) modifyTable.getValueAt(0, 2);
			vo.remarks = (String) modifyTable.getValueAt(0, 4);

			rm = controller.updateReceipt(new PaymentBillVO(vo.ID, vo.date,
					vo.type, vo.money, vo.payerName, vo.bankAccountID,
					vo.items, vo.remarks));

		} else if (billType.equals(ReceiptType.BRANCH_DELIVER)) {
			DeliveryListVO vo = (DeliveryListVO) currentBill;
			vo.order = (String) table.getValueAt(0, 1);
			vo.courierName = (String) table.getValueAt(0, 2);
			rm = controller.updateReceipt(new DeliveryListVO(vo.ID, vo.type,
					vo.order, vo.courierName));
		} else if (billType.equals(ReceiptType.TRANS_ARRIVAL)) {
			// String[] headers =
			// {"单据类型","中转中心编号","出发地","目的地","货物到达状态","订单订单号"};
			TransferArrivalListVO vo = (TransferArrivalListVO) currentBill;
			vo.transferCenterID = (String) modifyTable.getValueAt(0, 1);
			vo.departure = (String) modifyTable.getValueAt(0, 2);
			vo.destination = (String) modifyTable.getValueAt(0, 3);
			vo.order = (String) modifyTable.getValueAt(0, 5);
			rm = controller.updateReceipt(new TransferArrivalListVO(vo.ID,
					vo.type, vo.transferCenterID, vo.destination, vo.departure,
					vo.state, vo.order));
		} else if (billType.equals(ReceiptType.INSTOCK)) {
			InventoryImportReceiptVO vo = (InventoryImportReceiptVO) currentBill;
			vo.transferID = (String) modifyTable.getValueAt(0, 1);
			// vo.commodityVO = (CommodityVO) modifyTable.getValueAt(0, 2);
			vo.area = Integer.parseInt((String) modifyTable.getValueAt(0, 3));
			vo.position = Integer.parseInt((String) modifyTable
					.getValueAt(0, 4));
			vo.row = Integer.parseInt((String) modifyTable.getValueAt(0, 5));
			vo.position = Integer.parseInt((String) modifyTable
					.getValueAt(0, 6));
			rm = controller.updateReceipt(new InventoryImportReceiptVO(vo.ID,
					vo.type, vo.commodityVO, vo.area, vo.row, vo.frame,
					vo.position, vo.transferID));
		} else if (billType.equals(ReceiptType.OUTSTOCK)) {
			// String [] headers = {"单据类型","转运ID","商品货物信息","区","排","架","位"};
			InventoryExportReceiptVO vo = (InventoryExportReceiptVO) currentBill;
			vo.transferID = (String) modifyTable.getValueAt(0, 1);
			vo.area = Integer.parseInt((String) modifyTable.getValueAt(0, 3));
			vo.position = Integer.parseInt((String) modifyTable
					.getValueAt(0, 4));
			vo.row = Integer.parseInt((String) modifyTable.getValueAt(0, 5));
			vo.position = Integer.parseInt((String) modifyTable
					.getValueAt(0, 6));

			rm = controller.updateReceipt(new InventoryExportReceiptVO(vo.ID,
					vo.type, vo.transferID, vo.commodityVO, vo.area, vo.row,
					vo.frame, vo.position));
		} else if (billType.equals(ReceiptType.TRANS_PLANE)) {
			// String [] headers = {"单据类型","中转车次编号","出发地","到达地","监装员","托运订单编号"};
			TransferOrderVO vo = (TransferOrderVO) currentBill;
			vo.facilityID = (String) modifyTable.getValueAt(0, 1);
			vo.departure = (String) modifyTable.getValueAt(0, 2);
			vo.destination = (String) modifyTable.getValueAt(0, 3);
			vo.courierName = (String) modifyTable.getValueAt(0, 4);
			vo.orders = new ArrayList<String>();
			vo.orders.add((String) modifyTable.getValueAt(0, 5));
			rm = controller.updateReceipt(new TransferOrderVO(vo.ID,
					vo.facilityID, vo.type, vo.departure, vo.destination,
					vo.courierName, vo.orders));
		} else if (billType.equals(ReceiptType.DEBIT)) {
			DebitBillVO vo = (DebitBillVO) currentBill;
			// String[] headers = {"单据类型","收款日期","收款金额","收款快递员","对应订单条形码"};
			vo.date = (String) modifyTable.getValueAt(0, 1);
			vo.money = new BigDecimal((String) modifyTable.getValueAt(0, 2));
			vo.courierID = (String) modifyTable.getValueAt(0, 3);
			vo.orderNumbers = new ArrayList<String>();
			vo.orderNumbers.add((String) modifyTable.getValueAt(0, 4));

			rm = controller.updateReceipt(new DebitBillVO(vo.ID, vo.type,
					vo.courierID, vo.money, vo.orderNumbers, vo.date,
					vo.bankAccountID));
		}
		if (rm.equals(ResultMessage.SUCCESS)) {
			new MyNotification(this, "单据修改成功", Color.GREEN);
		} else {
			new MyNotification(this, "单据修改失败", Color.RED);
		}
	}

}
