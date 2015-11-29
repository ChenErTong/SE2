package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.fundbl.DebitAndPayBillShowInfo;
import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.receiptvo.DebitAndPayBillVO;

public class Record {
	//TODO 依赖倒置
	private DebitAndPayBillShowInfo_Record showInfo;
	
	public Record() {
		 showInfo = new DebitAndPayBillShowInfo();
	}
	
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException {
		return showInfo.getBusinessProcess(begin, end);
	}

	public BussinessConditionVO bussinessCondition(String end) throws RemoteException {
		return showInfo.getBussinessCondition(end);
	}
	/**
	 * 返回某一个营业厅一天的收款单
	 * @param WorkPlace
	 * @param date
	 * @return
	 * @throws RemoteException
	 */
	public BussinessOneDayVO bussinessOneDay(String WorkPlace,String date) throws RemoteException {
		return showInfo.getBussinessOneDayIncome(WorkPlace, date);
	}
}

