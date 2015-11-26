package businesslogic.recordbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.recordblservice.RecordBLService;
import vo.BussinessConditionVO;
import vo.receiptvo.DebitAndPayBillVO;

public class RecordController implements RecordBLService{
    Record  RecordBL = new Record();
		
	@Override
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end)  {
		try {
			return RecordBL.bussinessProcess(begin, end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BussinessConditionVO bussinessCondition(String end){
		try {
			return RecordBL.bussinessCondition(end);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
