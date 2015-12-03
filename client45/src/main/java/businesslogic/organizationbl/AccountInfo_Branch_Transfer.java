package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.accountvo.AccountVO;

public interface AccountInfo_Branch_Transfer {
	public ArrayList<AccountVO> getAccountByOrganizationID(String organizationID) throws RemoteException;
}
