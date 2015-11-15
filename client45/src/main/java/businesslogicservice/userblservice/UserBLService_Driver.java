package businesslogicservice.userblservice;

import dataservice.userdataservice.LoginInfo;
import state.UserIdentity;
import vo.UserVO;

public class UserBLService_Driver {
		UserVO vo = new UserVO("123", "123", "123", UserIdentity.ADMIN);
		LoginInfo loginInfo = new LoginInfo("123","123",false);
	public void drive(UserBLService service){
		service.getID();
		service.addUser(vo);
		service.deleteUser(vo.getUsername());
		service.show();
		service.updateUser(vo);
		service.confirmOperation();
		service.login(loginInfo);
		

	}
	public static void main(String args[]){
		UserBLService_Driver driver = new UserBLService_Driver();
		UserBLService stub = new UserBLService_Stub();
		driver.drive(stub);
	}
}
