package businesslogic.receiptbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.branchbl.ReceiptInfo_Branch_Transfer;
import businesslogic.inventorybl.ReceiptInfo_Inventory;
import dataservice.receiptdataservice.ReceiptDataService;
import po.receiptpo.ReceiptPO;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class ReceiptInfo implements ReceiptInfo_Inventory,ReceiptInfo_Branch_Transfer {
	Receipt receipt;
	ReceiptDataService receiptData;
	public ReceiptInfo() {
		receipt = new Receipt();
		receiptData = receipt.getData();
	}
	@Deprecated
	@Override
	public <T extends ReceiptVO> ArrayList<T> showInDateByType(String begin, String end, ReceiptType type) throws RemoteException {
		ArrayList<ReceiptPO> pos = receiptData.find();
		ArrayList<T> vos = new ArrayList<>();
		for (ReceiptPO receiptPO : pos) {
			if(receiptPO.getReceiptType().equals(type)&&inDate(receiptPO, begin, end)){
				@SuppressWarnings("unchecked")
				T vo = (T) ReceiptTrans.convertPOtoVO(receiptPO);
				vos.add(vo);
			}
		}
		return vos;
	}
	
	private boolean inDate(ReceiptPO po, String beginDate, String endDate) {
		if (po.getDate().compareTo(beginDate) >= 0 && po.getDate().compareTo(endDate) <= 0)
			return true;
		return false;
	}
	@Override
	public int getImportNumber(String begin, String end) throws RemoteException {
		return this.getReceiptNum(ReceiptType.INSTOCK);
	}
	@Override
	public int getExportNumber(String begin, String end) throws RemoteException {
		return this.getReceiptNum(ReceiptType.OUTSTOCK);
	}
	private int getReceiptNum(ReceiptType type) throws RemoteException{
		int sum=0;
		ArrayList<ReceiptPO> pos = receiptData.find();
		for (ReceiptPO receiptPO : pos) {
			if(receiptPO.getReceiptType()==type)
				++sum;
		}
		return sum;
	}
	@Override
	public ResultMessage add(ReceiptVO vo) throws RemoteException {
		ReceiptPO po = ReceiptTrans.convertVOtoPO(vo);
		return receiptData.add(po);
	}
	@Override
	public ResultMessage modify(ReceiptVO vo) throws RemoteException {
		ReceiptPO po = ReceiptTrans.convertVOtoPO(vo);
		return receiptData.add(po);
	}
	@Override
	public String getID() throws RemoteException {
		return receiptData.getID();
	}
}
