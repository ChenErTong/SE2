package businesslogicservice.fundblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.PayBillItem;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.DebitAndPayBillVO;

/**
 * 负责实现资金管理界面所需要的服务
 * 
 * @author zsq
 * @version Oct 22,2015
 */
public interface DebitAndPayBillBLService {
	/**
	 * 得到付款单的ID
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public String getPayID();

	/**
	 * 得到收款单的ID
	 * 
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public String getExpenseID();

	/**
	 * 根据ID精确查找账单
	 * 
	 * @param ID
	 *            账单ID
	 * @return DebitAndPayBillVO
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public DebitAndPayBillVO find(String ID);

	/**
	 * 建立新的收款单（付款单），单据类型在前面的getID方法已经得到
	 * 
	 * @param operatorID
	 *            付款人ID/收款人ID【可以下拉列表进行】
	 * @param operatorName
	 *            收款人姓名/付款人姓名 TODO 这个方法不知道要加几个参数orz
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */

	// 建立收款单
	public ResultMessage addDebitBill(double money, String courierID, ReceiptType type, ArrayList<String> orderNumbers);
	
	// 建立付款单
	public ResultMessage addPayBill(double money, String payerName, String accountID, ReceiptType type,
			PayBillItem items, String transferReceiptID,String remarks) throws RemoteException;

	/**
	 * 提交单据进行审批
	 * 
	 * @return 是否成功
	 * @throws RemoteException
	 */
	public ResultMessage submit(DebitAndPayBillVO vo);

	/**
	 * 保存成草稿状态
	 * 
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public ResultMessage save(DebitAndPayBillVO vo);

	/**
	 * 修改草稿状态
	 * 
	 * @param vo
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 * @throws RemoteException
	 */
	public ResultMessage updateDraft(DebitAndPayBillVO vo);


}
