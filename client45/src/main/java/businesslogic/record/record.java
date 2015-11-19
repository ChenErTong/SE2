package businesslogic.record;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.recordblservice.RecordBLService;
import dataservice.recorddataservice.RecordDataService;
import vo.BussinessConditionVO;
import vo.BussinessProcessVO;

public class record implements RecordBLService{
	private RecordDataService recordData;
	public record() {
		try {
			recordData= (RecordDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+RecordDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public BussinessProcessVO bussinessProcess(String begin, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BussinessConditionVO bussinessCondition(String end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double income(String end) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double earning(String end) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double expense(String end) {
		// TODO Auto-generated method stub
		return 0;
	}

}
