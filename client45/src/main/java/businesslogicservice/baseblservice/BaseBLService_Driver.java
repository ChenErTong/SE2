package businesslogicservice.baseblservice;

import java.rmi.RemoteException;

import state.FindTypeBase;
import vo.BaseVO;

public class BaseBLService_Driver {
	
	String ID;
	BaseVO vo = new BaseVO(ID, null, null, null);
	FindTypeBase baseType;
	public void drive(BaseBLService service) throws RemoteException{
		service.addBase(vo);
		service.confirmOperation();
		service.deleteBase(ID);
		service.updateBase(vo);
		try {
			service.show(baseType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.getID(baseType);
		
	}
	
	public static void main(String args[]) throws RemoteException{
		BaseBLService_Driver driver = new BaseBLService_Driver();
		BaseBLService stub = new BaseBLService_Stub();
		driver.drive(stub);
		
	}
}
