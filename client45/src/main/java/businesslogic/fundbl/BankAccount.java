package businesslogic.fundbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.BankAccoutBLService;
import dataservice.funddataservice.BankAccountDataService;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

public class BankAccount implements BankAccoutBLService {
	private BankAccountDataService bankAccountData;
	public BankAccount() {try {
			bankAccountData = (BankAccountDataService) Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+BankAccountDataService.NAME);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (RemoteException e) {
		e.printStackTrace();
	} catch (NotBoundException e) {
		e.printStackTrace();
	}}

	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(BankAccountVO vo) {
		try {
			return bankAccountData.add(FundTrans.convertVOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(String ID) {
		try {
			return bankAccountData.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage update(BankAccountVO vo) {
		try {
			return bankAccountData.modify(FundTrans.convertVOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) {
		// TODO Auto-generated method stub
		return null;
	}

}
