package businesslogic.fundbl;

import java.rmi.RemoteException;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:57
 */
public interface AccountInfo_DebitAndPayBillVOShow {
	/**
	 * 判断一个快递员是否属于特定的营业厅
	 * @author Ann
	 * @param accountID 营业员ID
	 * @param branchID 营业厅ID
	 * @return 是就返回true不是返回false
	 * @throws RemoteException 
	 */
	public boolean isAccountAMemberOfBranch(String accountID,String branchID) throws RemoteException;
}
