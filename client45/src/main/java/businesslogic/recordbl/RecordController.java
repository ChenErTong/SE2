package businesslogic.recordbl;

/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.recordblservice.RecordBLService;
import vo.BussinessConditionVO;
import vo.BussinessOneDayVO;
import vo.BussinessProcessVO;
import vo.receiptvo.DebitAndPayBillVO;

public class RecordController implements RecordBLService {
	Record RecordBL = new Record();

	@Override
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) {
		try {
			return RecordBL.bussinessProcess(begin, end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BussinessConditionVO bussinessCondition(String end) {
		try {
			return RecordBL.bussinessCondition(end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BussinessOneDayVO bussinessOneDay(String WorkPlace, String date) {
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
