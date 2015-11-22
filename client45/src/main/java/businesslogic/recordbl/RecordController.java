package businesslogic.recordbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.recordblservice.RecordBLService;
import vo.BussinessConditionVO;
import vo.DebitAndPayBillVO;

public class RecordController implements RecordBLService{
    Record  RecordBL;
		
	@Override
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end)  {
		// TODO Auto-generated method stub
		try {
			return RecordBL.bussinessProcess(begin, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BussinessConditionVO bussinessCondition(String end){
		// TODO Auto-generated method stub
		try {
			return RecordBL.bussinessCondition(end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
