package dataservice.userdataservice;

import po.UserPO;
import state.UserAuthority;
import state.UserIdentity;

public class UserDataService_Driver {
	private UserPO po = new UserPO("username", "name", "password", UserIdentity.ADMIN, "123",UserAuthority.MANAGER_LEVEL);
	private LoginInfo loginInfo = new LoginInfo("username", "password", false);
	public void drive(UserDataService userDataService){
		userDataService.find();
		userDataService.login(loginInfo);
		userDataService.insert(po);
		userDataService.update(po);
		userDataService.delete("id");
		
	}
	
	public static void main(String args[]){
		UserDataService_Driver driver = new UserDataService_Driver();
		UserDataService stub = new UserDataService_Stub();
		driver.drive(stub);
	}
}
