package dataservice.transferdataservice;

import po.PersistentObject;
import state.ResultMessage;
import dataservice.DataService;

/**
 *提供中转中心集体载入、增改改查的服务
 *@author czw
 *@version Oct 22,2015 
 */
public interface TransferDataService <TransferPO extends PersistentObject> extends DataService<TransferPO>{
	/**
	 * 查找中转中心
	 * @param id 中转中心编号
	 * @return 中转中心持久化对象
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public TransferPO find(String id);
	
	/**
	 * 新增中转中心
	 * @param transfer 中转中心持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage insert(TransferPO transfer);
	
	/**
	 * 删除中转中心
	 * @param transfer 中转中心持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage delete(TransferPO transfer);
	
	/**
	 * 更新中转中心
	 * @param transfer 中转中心持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage update(TransferPO transfer);
	
	/**
	 * 初始化
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage init();
}
