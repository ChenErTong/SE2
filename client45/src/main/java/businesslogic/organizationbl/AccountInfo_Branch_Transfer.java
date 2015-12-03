package businesslogic.organizationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.accountvo.AccountVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:36:52
 */
public interface AccountInfo_Branch_Transfer {
	public ArrayList<AccountVO> getAccountByOrganizationID(String organizationID) throws RemoteException;
}
