package businesslogicservice.accountblservice;

import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import businesslogicservice.accountblservice.AccountBLService_Stub;
import vo.accountvo.AccountVO;

public class AccountBLService_Driver {
	public void drive(AccountBLService accountBLService){
		
	 ArrayList<AccountVO> accountvo=accountBLService.show();
	 System.out.println("输出全部员工账户信息列表");
		
	}
	public static void main(String[] args){
		AccountBLService_Stub accountblservice_stub=new AccountBLService_Stub(null, null, null, null, null, null, 0, null, 0);
		AccountBLService_Driver accountblservice_driver=new AccountBLService_Driver();
		accountblservice_driver.drive(accountblservice_stub);
	}
}

