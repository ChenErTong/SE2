package businesslogicservice.receiptblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

/**
 * 实现审批单据界面所需要的服务
 * 
 * @author zsq
 * @author Ann
 * @version Oct 22,2015
 */
public interface ReceiptBLService {

	/**
	 * 修改单据内容
	 * 
	 * @param receiptVO
	 * @param receiptType，单据类型
	 * @author zsq
	 * @version Oct 22,2015
	 * @return 处理信息
	 */
	public ResultMessage updateReceipt(ReceiptVO receiptVO) throws RemoteException;

	/**
	 * 通过单据审批
	 * 
	 * @author zsq
	 * @version Oct 22,2015
	 * @param VOs
	 * @param receiptTypes，单据类型
	 * @return 处理信息
	 */
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException;

	/**
	 * 不通过单据审批
	 * 
	 * @author zsq
	 * @version Oct 22,2015
	 * @param VOs
	 * @param receiptTypes，单据类型
	 * @return
	 */
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException;

	/**
	 * 查看单据内容，根据单据的状态进行区分：等待审核的单据、通过审核的单据、未通过审核的单据
	 * 
	 * @author zsq
	 * @version Oct 22,2015
	 * @param receiptStates，单据状态
	 * @return 处理信息
	 */
	public <T extends ReceiptVO> ArrayList<T> show(ReceiptType type, ReceiptState state) throws RemoteException;
}
