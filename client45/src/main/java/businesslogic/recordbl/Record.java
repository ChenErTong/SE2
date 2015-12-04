package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogic.fundbl.DebitAndPayBillShowInfo;
import util.ExportExcel;
import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.BussinessProcessExportVO;
import vo.BussinessProcessVO;
import vo.receiptvo.DebitAndPayBillVO;

public class Record {
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
	
	public void exportBussinessProcessToExcel(BussinessProcessVO vo){
		String fileName="output/"+vo.beginDate+"至"+vo.endDate+"经营情况报表"+".xls";
		String head=vo.beginDate+"-"+vo.endDate+"经营情况报表";
		String[] title = {"单据编号","日期","金额","单据类型","快递员编号（收款单）","订单号（收款单）","姓名（付款单）","员工编号（付款单）","付款类型（付款单）","备注（付款单）"};
		List<Object> list = new ArrayList<>();
		for (DebitAndPayBillVO receipt : vo.receipt) {
			list.add(new BussinessProcessExportVO(receipt));
		}
		System.out.println(ExportExcel.exportExcel(fileName, head, title, list));;
		
	}
}

