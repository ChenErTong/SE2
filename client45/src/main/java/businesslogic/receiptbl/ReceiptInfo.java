package businesslogic.receiptbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.fundbl.ReceiptInfo_DebitAndPayBill;
import businesslogic.inventorybl.ReceiptInfo_Inventory;
import businesslogic.organizationbl.ReceiptInfo_Branch_Transfer;
import businesslogic.organizationbl.branchbl.ReceiptInfo_Branch;
import businesslogic.organizationbl.transferbl.ReceiptInfo_Transfer;
import config.RMIConfig;
import dataservice.receiptdataservice.ReceiptDataService;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import state.ReceiptType;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.ReceiptVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:58
 */
public class ReceiptInfo implements ReceiptInfo_Inventory, ReceiptInfo_Branch_Transfer, ReceiptInfo_Transfer,
		ReceiptInfo_Branch, ReceiptInfo_DebitAndPayBill {
	ReceiptDataService receiptData;

	public ReceiptInfo() throws MalformedURLException, RemoteException, NotBoundException {
		receiptData = (ReceiptDataService) Naming.lookup(RMIConfig.PREFIX + ReceiptDataService.NAME);
	}

	/**
	 * @see ReceiptInfo_Branch_Transfer#getID()
	 */
	public String getID() throws RemoteException {
		return receiptData.getID();
	}

	/**
	 * @see ReceiptInfo_Inventory#getImportID()
	 */
	public String getImportID() throws RemoteException {
		return receiptData.getImportID();
	}

	/**
	 * @see ReceiptInfo_Inventory#getExportID()
	 */
	public String getExportID() throws RemoteException {
		return receiptData.getExportID();
	}

	/**
	 * @see ReceiptInfo_Inventory#getAdjustID()
	 */
	public String getAdjustID() throws RemoteException {
		return receiptData.getAdjustID();
	}

	/**
	 * @see ReceiptInfo_Inventory#getTransferID()
	 */
	public String getTransferID() throws RemoteException {
		return receiptData.getTransferArrialID();
	}

	/**
	 * @see ReceiptInfo_Transfer#getTransferDeliverID()
	 */
	public String getTransferDeliverID() throws RemoteException {
		return receiptData.getTransferDeliverID();
	}

	/**
	 * @see ReceiptInfo_Transfer#getTransferArrialID()
	 */
	public String getTransferArrialID() throws RemoteException {
		return receiptData.getTransferArrialID();
	}

	/**
	 * @see ReceiptInfo_Branch#getBranchTruckID()
	 */
	public String getBranchTruckID() throws RemoteException {
		return receiptData.getBranchTruckID();
	}

	/**
	 * @see ReceiptInfo_Inventory#getImportNumber(String, String)
	 */
	public int getImportNumber(String begin, String end) throws RemoteException {
		return this.getReceiptNum(ReceiptType.INSTOCK);
	}

	/**
	 * @see ReceiptInfo_Inventory#getExportNumber(String, String)
	 */
	public int getExportNumber(String begin, String end) throws RemoteException {
		return this.getReceiptNum(ReceiptType.OUTSTOCK);
	}

	/**
	 * @see ReceiptInfo_Inventory#add(ReceiptVO)
	 * @see ReceiptInfo_Branch_Transfer#add(ReceiptVO)
	 * @see ReceiptInfo_DebitAndPayBill#add(ReceiptVO)
	 */
	public ResultMessage add(ReceiptVO vo) throws RemoteException {
		ReceiptPO po = ReceiptTrans.convertVOtoPO(vo);
		return receiptData.add(po);
	}
	/*
	 * @Override public ResultMessage add(DebitAndPayBillPO po) throws
	 * RemoteException { return receiptData.add(po); }
	 */

	/**
	 * @see ReceiptInfo_Inventory
	 */
	public InventoryImportReceiptVO addImportReceipt(CommodityVO vo, int area, int row, int frame, int position,String transferID)
			throws RemoteException {
		String id = this.getImportID();
		InventoryImportReceiptVO importReceiptVO = new InventoryImportReceiptVO(id, ReceiptType.INSTOCK, vo, area, row,
				frame, position,transferID);
		this.add(importReceiptVO);
		return importReceiptVO;
	}

	/**
	 * @see ReceiptInfo_Inventory#modify(ReceiptVO)
	 * @see ReceiptInfo_Branch_Transfer#modify(ReceiptVO)
	 * @see ReceiptInfo_DebitAndPayBill#modify(ReceiptVO)
	 */
	public ResultMessage modify(ReceiptVO vo) throws RemoteException {
		ReceiptPO po = ReceiptTrans.convertVOtoPO(vo);
		return receiptData.add(po);
	}

	/**
	 * @see ReceiptInfo_Inventory#findTransferArrivalList(String)
	 */
	public TransferArrivalListPO findTransferArrivalList(String id) throws RemoteException {
		return receiptData.findTransferArrivalList(id);
	}

	/**
	 * @see ReceiptInfo_Inventory#findImport(String)
	 */
	public InventoryImportReceiptPO findImport(String importID) throws RemoteException {
		return receiptData.findImport(importID);
	}

	/**
	 * @see ReceiptInfo_Inventory#showInDateByType(String, String, ReceiptType)
	 */
	public <T extends ReceiptVO> ArrayList<T> showInDateByType(String begin, String end, ReceiptType type)
			throws RemoteException {
		ArrayList<ReceiptPO> pos = receiptData.find();
		ArrayList<T> vos = new ArrayList<>();
		for (ReceiptPO receiptPO : pos) {
			if (receiptPO.getReceiptType().equals(type) && inDate(receiptPO, begin, end)) {
				@SuppressWarnings("unchecked")
				T vo = (T) ReceiptTrans.convertPOtoVO(receiptPO);
				vos.add(vo);
			}
		}
		return vos;
	}

	/**
	 * @see ReceiptInfo_Inventory#hasChecked()
	 */
	public boolean hasChecked() throws RemoteException {
		ArrayList<ReceiptPO> receipts = receiptData.find();
		for (ReceiptPO receiptPO : receipts) {
			String ID = receiptPO.getID();
			if (ID.startsWith("CHECK")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String date = sdf.format(new Date());
				if (ID.substring(5).startsWith(date)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断单据是否在指定日期内
	 * 
	 * @param po
	 *            ReceiptPO型，单据持久化对象
	 * @param beginDate
	 *            String型，开始日期
	 * @param endDate
	 *            String型，结束日期
	 * @return boolean型，判断结果
	 */
	private boolean inDate(ReceiptPO po, String beginDate, String endDate) {
		String date=po.getDate().split(" ")[0];
		if (date.compareTo(beginDate) >= 0 && date.compareTo(endDate) <= 0)
			return true;
		return false;
	}

	/**
	 * 获得某类型单据的数量
	 * 
	 * @param type
	 *            ReceiptType型，单据类型
	 * @return int型，单据数量
	 * @throws RemoteException
	 *             远程异常
	 */
	private int getReceiptNum(ReceiptType type) throws RemoteException {
		int sum = 0;
		ArrayList<ReceiptPO> pos = receiptData.find();
		for (ReceiptPO receiptPO : pos) {
			if (receiptPO.getReceiptType() == type)
				++sum;
		}
		return sum;
	}
}
