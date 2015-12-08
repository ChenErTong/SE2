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
	/**
	 * 根据机构的编号获取该机构的所有员工
	 * 
	 * @param organizationID
	 *            String型，机构编号
	 * @return ArrayList<AccountVO>型，该机构的所有员工
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<AccountVO> getAccountByOrganizationID(String organizationID) throws RemoteException;
}
