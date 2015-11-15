package dataservice.funddataservice;

import java.util.ArrayList;


import po.ExpensePO;
import state.ResultMessage;

/**
 * 提供收款信息数据的集体载入、保存和增删改查操作
 * @author zsq
 * @version Oct 23,2015
 */
public interface ExpenseDataService {
	/**
	 * 向序列化文件中增加一个ExpensePO
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(ExpensePO po);
	/**
	 * 根据ID删除序列化文件中的一个ExpensePO
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);
	/**
	 * 更新ExpensePO
	 * @param PO
	 * @return 处理结果
	 */
	public ResultMessage update(ExpensePO PO);
	/**
	 * 查看ExpensePO
	 * @param ID
	 * return 要进行查看的PO
	 */
	public ArrayList<ExpensePO> show(String ID);
}
