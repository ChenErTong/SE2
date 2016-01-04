package businesslogic.organizationbl;

import java.rmi.RemoteException;

import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:40
 */
public interface ReceiptInfo_Branch_Transfer {
	/**
	 * 获取新单据编号
	 * 
	 * @return String型，新单据编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public String getID() throws RemoteException;

	/**
	 * 添加单据
	 * 
	 * @param vo
	 *            ReceiptVO型，单据值对象
	 * @return ResultMessage型，是否添加成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage add(ReceiptVO vo) throws RemoteException;

	/**
	 * 修改单据
	 * 
	 * @param vo
	 *            ReceiptVO型，单据值对象
	 * @return ResultMessage型，是否修改成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage modify(ReceiptVO vo) throws RemoteException;
}
