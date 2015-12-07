package businesslogic.fundbl;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.BankAccountBLService;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;
/**
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:34:06
 */
public class BankAccountController implements BankAccountBLService{
    BankAccount BankAccountBL = new BankAccount();
	@Override
	public ConfirmState confirmOperation() {
		return BankAccountBL.confirmOperation();
	}

	@Override
	public String getID() {
		try {
			return BankAccountBL.getID();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> show() {
		try {
			return BankAccountBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage add(BankAccountVO vo) {
		try {
			return BankAccountBL.add(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		try {
			return BankAccountBL.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage update(BankAccountVO vo) {
		try {
			return BankAccountBL.update(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) {
		try {
			return BankAccountBL.find(keywords, type);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage subtractMoneyInBankAccount(String accountID, BigDecimal money) {
		try {
			return BankAccountBL.subtractMoneyInBankAccount(accountID, money);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage addMoneyInBankAccount(String accountID, BigDecimal money) {
		try {
			return BankAccountBL.addMoneyInBankAccount(accountID, money);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
