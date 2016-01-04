package businesslogic.recordbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logbl.LogController;
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
	Record RecordBL;

	public RecordController() throws MalformedURLException, RemoteException, NotBoundException {
		RecordBL = new Record();
	}

	/**
	 * @see RecordBLService#bussinessProcess(String, String)
	 */
	public ArrayList<DebitAndPayBillVO> bussinessProcess(String begin, String end) throws RemoteException {
		LogController.getInstance().addLog("查询公司经营情况");
		return RecordBL.bussinessProcess(begin, end);
	}

	/**
	 * @see RecordBLService#bussinessCondition(String)
	 */
	public BussinessConditionVO bussinessCondition(String end) throws RemoteException {
		LogController.getInstance().addLog("查询公司成本收益");
		return RecordBL.bussinessCondition(end);
	}

	/**
	 * @see RecordBLService#bussinessOneDay(String, String)
	 */
	public BussinessOneDayVO bussinessOneDay(String WorkPlace, String date) throws RemoteException {
		LogController.getInstance().addLog("查询"+WorkPlace+"在"+date+"单日收益");
		return RecordBL.bussinessOneDay(WorkPlace, date);
	}
	

	/**
	 * @see RecordBLService#exportBussinessProcessToExcel(BussinessProcessVO)
	 */
	public void exportBussinessProcessToExcel(BussinessProcessVO vo,String fileDirectoryPath) {
		RecordBL.exportBussinessProcessToExcel(vo,fileDirectoryPath);
	}

	/**
	 * @see RecordBLService#exportBussinessConditionToExcel(BussinessConditionVO)
	 */
	public void exportBussinessConditionToExcel(BussinessConditionVO vo,String fileDirectoryPath) {
		RecordBL.exportBussinessConditionToExcel(vo,fileDirectoryPath);
	}

}
