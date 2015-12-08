package businesslogic.recordbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.recordblservice.RecordBLService;
import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.BussinessProcessVO;
import vo.receiptvo.DebitAndPayBillVO;

/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:28
 */
public class RecordController implements RecordBLService {
	Record RecordBL = new Record();

	@Override
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException {
		try {
			return RecordBL.bussinessProcess(begin, end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BussinessConditionVO bussinessCondition(String end) throws RemoteException {
		try {
			return RecordBL.bussinessCondition(end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BussinessOneDayVO bussinessOneDay(String WorkPlace, String date) throws RemoteException {
		try {
			return RecordBL.bussinessOneDay(WorkPlace, date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void exportBussinessProcessToExcel(BussinessProcessVO vo) {
		RecordBL.exportBussinessProcessToExcel(vo);
	}

	@Override
	public void exportBussinessConditionToExcel(BussinessConditionVO vo) {
		RecordBL.exportBussinessConditionToExcel(vo);
	}

}
