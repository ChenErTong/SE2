package dataservice.funddataservice;

import java.util.ArrayList;


import po.DebitAndPayBillPO;
import state.ReceiptType;
import state.ResultMessage;

/**
 * 收款单、付款单的集体载入、保存、查看和修改操作
 * @author zsq
 * @version Oct 22,2015
 */
public interface DebitAndPayBillDataService {
	/**
	 * 向序列化文件中增加一个DebitAndPayBillPO
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(DebitAndPayBillPO po);
	/**
	 * 根据ID删除序列化文件中的一个DebitAndPayBillPO
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);
	/**
	 * 更新DebitAndPayBillPO
	 * @param PO
	 * @return 处理结果
	 */
	public ResultMessage update(DebitAndPayBillPO PO);
	/**
	 * 根据单据类型生成编号
	 * @param type 收款单或者付款单
	 * @return 可用的单据编号 ；若为null则传入类型错误
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getID(ReceiptType type) ;

	/**
	 * @return 获得新的收款单ID
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getExpenseID() ;

	/**
	 * @return 获得新的付款单ID
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getPayID() ;

	/**
	 * 按照单据类型返回单据【收款单或者付款单】
	 * @param type
	 * @return
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ArrayList<DebitAndPayBillPO> show(ReceiptType type);

}
