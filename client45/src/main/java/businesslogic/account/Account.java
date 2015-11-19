package businesslogic.account;

import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import dataservice.accountdataservice.AccountDataService;
import vo.accountvo.AccountVO;

public class Account implements AccountBLService{
	private AccountDataService accountData;
	public Account() {
		try {
			accountData = (AccountDataService)Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+AccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<AccountVO> show() throws RemoteException {
		return POstoVOs(accountData.show());
	}
	
	public ArrayList<AccountVO> POstoVOs(ArrayList<po.accountpo.AccountPO> POs) {
		ArrayList<AccountVO> VOs = new ArrayList<AccountVO>();
		for(po.accountpo.AccountPO po : POs) {
			AccountVO vo = poToVO(po);
			VOs.add(vo);
		}
		return VOs;
	}
	public AccountVO poToVO(po.accountpo.AccountPO po) {
		String ID=po.getID();
		String duty=po.getDuty();
		String name =po.getName();
		String birthday=po.getBirthDay();
		String IDCard=po.getIDCard ();
		 String phone=po.getPhone() ;
		double salary=po.getSalary();
		 String workTime=po.getWorkTime();
		 int receiptNum=po.getReceiptNum() ;
		AccountVO vo = new AccountVO(ID,duty,  name,  birthday,  IDCard,  phone, salary,workTime, receiptNum);
		return vo;
	}
	


}
