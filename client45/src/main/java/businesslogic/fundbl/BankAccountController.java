package businesslogic.fundbl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.userbl.UserInfomation;
import businesslogicservice.fundblservice.BankAccountBLService;
import command.BankAccountCommandController;
import command.CommandDelete;
import po.BankAccountPO;
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
	BankAccount BankAccountBL;
	private BankAccountCommandController commandController;
	public BankAccountController() throws MalformedURLException, RemoteException, NotBoundException {
		BankAccountBL = new BankAccount();
		commandController = new BankAccountCommandController("bankAccount");
	}

	@Override
	public ConfirmState confirmOperation() {
		return BankAccountBL.confirmOperation();
	}

	/**
	 * @see BankAccountBLService#getID()
	 */
	public String getID() throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.getID();
		}
		return null;
	}

	/**
	 * @see BankAccountBLService#show()
	 */
	public ArrayList<BankAccountVO> show() throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.show();
		}
		return null;
	}

	/**
	 * @see BankAccountBLService#add(BankAccountVO)
	 */
	public ResultMessage add(BankAccountVO vo) throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.add(FundTrans.convertVOtoPO(vo));
		}
		return ResultMessage.FAIL;
	}

	/**
	 * @see BankAccountBLService#delete(String)
	 */
	public ResultMessage delete(String ID) throws RemoteException {
		if (this.isCorrectAuthority()) {
			BankAccountPO po =  BankAccountBL.delete(ID);
			if(po==null){
				return ResultMessage.FAIL;
			}else{
				commandController.addCommand(new CommandDelete<BankAccountPO>("delete", po));
				return ResultMessage.SUCCESS;
			}
		}
		return ResultMessage.FAIL;
	}

	/**
	 * @see BankAccountBLService#update(BankAccountVO)
	 */
	public ResultMessage update(BankAccountVO vo) throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.modify(FundTrans.convertVOtoPO(vo));
		}
		return ResultMessage.FAIL;
	}

	/**
	 * @see BankAccountBLService#find(String, FindTypeAccount)
	 */
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) throws RemoteException {
		if (this.isCorrectAuthority()) {
			return BankAccountBL.find(keywords, type);
		}
		return null;
	}

	/**
	 * @see BankAccountBLService#subtractMoneyInBankAccount(String, BigDecimal)
	 */
	public ResultMessage subtractMoneyInBankAccount(String accountID, BigDecimal money) throws RemoteException {
		return BankAccountBL.subtractMoneyInBankAccount(accountID, money);
	}

	/**
	 * @see BankAccountBLService#addMoneyInBankAccount(String, BigDecimal)
	 */
	public ResultMessage addMoneyInBankAccount(String accountID, BigDecimal money) throws RemoteException {
		return BankAccountBL.addMoneyInBankAccount(accountID, money);
	}

	/**
	 * 判断当前用户的权限是否可以进行高级操作
	 * 
	 * @return boolean型，判断结构
	 */
	private boolean isCorrectAuthority() {
		UserAuthority authority = UserInfomation.getInstance().getAuthority();
		return authority == UserAuthority.ADVANCE_FINANCE || authority == UserAuthority.MANAGER_LEVEL;
	}

}
