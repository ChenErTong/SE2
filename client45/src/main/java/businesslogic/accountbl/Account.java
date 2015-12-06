package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.branchbl.BranchInfo;
import config.RMIConfig;
import dataservice.accountdataservice.AccountDataService;
import po.accountpo.AccountPO;
import state.ResultMessage;
import vo.accountvo.AccountVO;
/**
 * 存取account信息
 * @author LIUXUANLIN
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:31:26
 */
public class Account{
	
	private AccountDataService accountData;
	private BranchInfo_Account branchInfo;
	private TransferInfo_Account transferInfo;
	public Account() {
		accountData=getData();
		branchInfo = new BranchInfo();
	}
	
	public AccountDataService getData(){
		try {
			return (AccountDataService)Naming.lookup(RMIConfig.PREFIX+AccountDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AccountVO> show() throws RemoteException {
		return AccountTrans.convertPOstoVOs(accountData.find());
	}
	public ArrayList<AccountVO> show(String duty) throws RemoteException {
		ArrayList<AccountPO> pos = accountData.find();
		return AccountTrans.convertPOstoVOsByDuty(pos, duty);
	}
	
	public String getID() throws RemoteException{
		return accountData.getID();
	}
	public ResultMessage addAccount(AccountVO vo) throws RemoteException{
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		ResultMessage message = this.addAccountInOrganization(po);
		if(message==ResultMessage.SUCCESS)
			return accountData.add(po);
		return ResultMessage.FAIL;
	}
	public ResultMessage deleteAccount(String ID) throws RemoteException{
		AccountPO po = accountData.find(ID);
		if(po==null){
			return ResultMessage.FAIL;
		}
		else{
			String organizationID = po.getOrganizationID();
			ResultMessage message = this.deleteAccountInOrganization(organizationID,ID);
			if(message==ResultMessage.SUCCESS)
				return accountData.delete(ID);
		}
		return ResultMessage.FAIL;
		
	}
	public ResultMessage updateAccount(AccountVO vo) throws RemoteException{
		AccountPO po = AccountTrans.convertVOtoPO(vo);
		ResultMessage message = this.modifyAccountInOrganization(po);
		if(message==ResultMessage.SUCCESS)
			return accountData.modify(po);
		return ResultMessage.FAIL;
	}

	public AccountVO find(String id) throws RemoteException{
		AccountPO po = accountData.find(id);
		return AccountTrans.convertPOToVO(po);
	}

	private ResultMessage deleteAccountInOrganization(String organizationID, String accountID) throws RemoteException{
		if(organizationID.length()==4){
			//The organization is transfer,use transferInfo to delete this account
			return transferInfo.deleteAccount(organizationID, accountID);
		}
		else if(organizationID.length()==6){
			//The organization is branch, use branchInfo to delete this account
			return branchInfo.deleteAccount(organizationID, accountID);
		}
		else{
			System.out.println("the length of organizationID is not 4 or 6,please check the length of organizaiont ID in account"+accountID);
			return ResultMessage.FAIL;
		}
	}

	private ResultMessage addAccountInOrganization(AccountPO account) throws RemoteException {
		String organizationID = account.getOrganizationID();
		if(organizationID.length()==4){
			//The organization is transfer,use transferInfo to delete this account
			return transferInfo.addAccount(account);
		}
		else if(organizationID.length()==6){
			//The organization is branch, use branchInfo to delete this account
			return branchInfo.addAccount(account);
		}
		else{
			System.out.println("the length of organizationID is not 4 or 6,please check the length of organizaiont ID in account"+account.getID());
			return ResultMessage.FAIL;
		}
	}

	private ResultMessage modifyAccountInOrganization(AccountPO account) throws RemoteException {
		String organizationID = account.getOrganizationID();
		if(organizationID.length()==4){
			//The organization is transfer,use transferInfo to delete this account
			return transferInfo.modifyAccount(account);
		}
		else if(organizationID.length()==6){
			//The organization is branch, use branchInfo to delete this account
			return branchInfo.modifyAccount(account);
		}
		else{
			System.out.println("the length of organizationID is not 4 or 6,please check the length of organizaiont ID in account"+account.getID());
			return ResultMessage.FAIL;
		}
	}

}
