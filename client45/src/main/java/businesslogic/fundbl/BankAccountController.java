package businesslogic.fundbl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.userbl.UserInfomation;
import businesslogicservice.fundblservice.BankAccountBLService;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import state.UserAuthority;
import vo.BankAccountVO;

/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:06
 */
public class BankAccountController implements BankAccountBLService {
	BankAccount BankAccountBL = new BankAccount();

	@Override
	public ConfirmState confirmOperation() {
		return BankAccountBL.confirmOperation();
	}

	@Override
	public String getID() throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.getID();
		}
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> show() throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.show();
		}
		return null;
	}

	@Override
	public ResultMessage add(BankAccountVO vo) throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.add(vo);
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.delete(ID);
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage update(BankAccountVO vo) throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.update(vo);
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.find(keywords, type);
		}
		return null;
	}

	@Override
	public ResultMessage subtractMoneyInBankAccount(String accountID, BigDecimal money) throws RemoteException {
		return BankAccountBL.subtractMoneyInBankAccount(accountID, money);
	}

	@Override
	public ResultMessage addMoneyInBankAccount(String accountID, BigDecimal money) throws RemoteException {
		return BankAccountBL.addMoneyInBankAccount(accountID, money);
	}

	private boolean isCorrectAuthority() {
		UserAuthority authority = UserInfomation.getInstance().getAuthority();
		return authority == UserAuthority.ADVANCE_FINANCE || authority == UserAuthority.MANAGER_LEVEL;
	}

}
