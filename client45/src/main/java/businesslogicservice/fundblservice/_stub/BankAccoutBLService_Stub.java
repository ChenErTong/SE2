package businesslogicservice.fundblservice._stub;

import java.util.ArrayList;

import businesslogicservice.fundblservice.BankAccoutBLService;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

public class BankAccoutBLService_Stub  implements BankAccoutBLService{

	@Override
	public ConfirmState confirmOperation() {
		System.out.println("Please confirm your operation!");
		return ConfirmState.CONFIRM;
	}

	@Override
	public String getID() {
		System.out.println("Offer an available number for the bankAccount");
		return "123";
	}

	@Override
	public ArrayList<BankAccountVO> show() {
		System.out.println("Show all the bankAccount!");
		return new ArrayList<BankAccountVO>(){};
	}

	@Override
	public ResultMessage add(BankAccountVO vo) {
		System.out.println("Add a new BankAccount!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String ID) {
		System.out.println("Delete a BankAccount!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(BankAccountVO vo) {
		System.out.println("Modify the information of a bankAccount");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) {
		System.out.println("Find the bankAccount according to the keywords");
		return new ArrayList<BankAccountVO>(){};
	}

}
