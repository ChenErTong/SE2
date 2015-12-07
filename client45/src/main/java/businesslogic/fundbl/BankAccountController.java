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
public class BankAccountController implements BankAccountBLService{
    BankAccount BankAccountBL = new BankAccount();
	@Override
	public ConfirmState confirmOperation() {
		return BankAccountBL.confirmOperation();
	}

	@Override
	public String getID() {
		try {
			if(this.isCorrectAuthority()){
				return BankAccountBL.getID();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> show() {
		try {
			if(this.isCorrectAuthority()){
				return BankAccountBL.show();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage add(BankAccountVO vo) {
		try {
			if(this.isCorrectAuthority()){
				return BankAccountBL.add(vo);
			}
			return ResultMessage.FAIL;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		try {
			if(this.isCorrectAuthority()){
				return BankAccountBL.delete(ID);
			}
			return ResultMessage.FAIL;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage update(BankAccountVO vo) {
		try {
			if(this.isCorrectAuthority()){
				return BankAccountBL.update(vo);
			}
			return ResultMessage.FAIL;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) {
		try {
			if(this.isCorrectAuthority()){
				return BankAccountBL.find(keywords, type);
			}
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
	
	private boolean isCorrectAuthority(){
		UserAuthority authority = UserInfomation.getInstance().getAuthority();
		return authority==UserAuthority.ADVANCE_FINANCE||authority==UserAuthority.MANAGER_LEVEL;
	}

}
