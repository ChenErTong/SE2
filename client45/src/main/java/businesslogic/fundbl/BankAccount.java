package businesslogic.fundbl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.funddataservice.BankAccountDataService;
import po.BankAccountPO;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

public class BankAccount {
	private BankAccountDataService bankAccountData;

	public BankAccount() {
		try {
			bankAccountData = (BankAccountDataService) Naming.lookup(RMIConfig.PREFIX + BankAccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public String getID() throws RemoteException {
		return bankAccountData.getID();

	}

	public ArrayList<BankAccountVO> show() throws RemoteException {
		ArrayList<BankAccountPO> bankaccounts = bankAccountData.find();
		return FundTrans.convertBankAccountPOstoVOs(bankaccounts);
	}

	public ResultMessage add(BankAccountVO vo) throws RemoteException {
		return bankAccountData.add(FundTrans.convertVOtoPO(vo));
	}

	public ResultMessage delete(String ID) throws RemoteException {
		return bankAccountData.delete(ID);
	}

	public ResultMessage update(BankAccountVO vo) throws RemoteException {
		return bankAccountData.modify(FundTrans.convertVOtoPO(vo));
	}

	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) throws RemoteException {
		ArrayList<BankAccountPO> pos = bankAccountData.find(keywords, type);
		ArrayList<BankAccountVO> vos = FundTrans.convertBankAccountPOstoVOs(pos);
		return vos;
	}

}
