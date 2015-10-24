package businesslogicservice.receiptblservice;

import java.util.ArrayList;

import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.ValueObject;
import vo.receiptvo.ReceiptVO;
import businesslogicservice.BLService;

/**
 * 实现审批单据界面所需要的服务
 * @author zsq
 * @version Oct 22,2015
 */
public interface ReceiptBLService {
	
	/**
	 * 修改单据内容
	 * @param vo
	 * @param receiptType，单据类型
	 * @author zsq
	 * @version Oct 22,2015
	 * @return 处理信息
	 */
	public ResultMessage updateReceipt(ValueObject vo,ReceiptType receiptType);
	
	/**
	 * 通过单据审批
	 * @author zsq
	 * @version Oct 22,2015
	 * @param VOs
	 * @param receiptTypes，单据类型
	 * @return 处理信息
	 */
	public ResultMessage passReceipt(ArrayList<ValueObject>VOs,ArrayList<ReceiptType>receiptTypes);
	
	/**
	 * 不通过单据审批
	 * @author zsq
	 * @version Oct 22,2015
	 * @param VOs
	 * @param receiptTypes，单据类型
	 * @return
	 */
	public ResultMessage dontPassReceipt(ArrayList<ValueObject>VOs,ArrayList<ReceiptType>receiptTypes);
	
	/**
	 * 查看单据内容，根据单据的状态进行区分：等待审核的单据、通过审核的单据、未通过审核的单据
	 * @author zsq
	 * @version Oct 22,2015
	 * @param receiptStates，单据状态
	 * @return 处理信息
	 */
	public  ReceiptVO showReceipt(ArrayList<ReceiptState>receiptStates);
}
