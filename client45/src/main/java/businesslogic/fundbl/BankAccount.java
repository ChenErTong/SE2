package businesslogic.fundbl;

import java.util.ArrayList;

import businesslogicservice.fundblservice.BankAccoutBLService;
import dataservice.funddataservice.BankAccountDataService;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

public class BankAccount implements BankAccoutBLService {
	private BankAccountDataService bankAccountData;
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(BankAccountVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) {
		// TODO Auto-generated method stub
		return null;
	}

}
