package businesslogicservice.baseblservice;

import state.FindTypeBase;
import vo.BaseVO;

public class BaseBLService_Driver {
	BaseVO vo = new BaseVO();
	String ID;
	FindTypeBase baseType;
	public void drive(BaseBLService service){
		service.addBase(vo);
		service.confirmOperation();
		service.deleteBase(ID);
		service.updateBase(vo);
		service.show(baseType);
		service.getID(baseType);
		
	}
	
	public static void main(String args[]){
		BaseBLService_Driver driver = new BaseBLService_Driver();
		BaseBLService stub = new BaseBLService_Stub();
		driver.drive(stub);
		
	}
}
