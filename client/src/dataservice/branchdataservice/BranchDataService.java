package dataservice.branchdataservice;

import dataservice.DataService;
import po.PersistentObject;
import state.ResultMessage;

/**
 *提供营业厅集体载入、增改改查的服务
 *@author czw
 *@version Oct 22,2015 
 */
public interface BranchDataService <BranchPO extends PersistentObject>extends DataService<BranchPO>{
	/**
	 * 查找营业厅
	 * @param id 营业厅编号
	 * @return 营业厅持久化对象
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public BranchPO find(String id);
	
	/**
	 * 新增营业厅
	 * @param branch 营业厅持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage insert(BranchPO branch);
	
	/**
	 * 删除营业厅
	 * @param branch 营业厅持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage delete(BranchPO branch);
	
	/**
	 * 更新营业厅
	 * @param branch 营业厅持久化对象
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage update(BranchPO branch);
	
	/**
	 * 初始化
	 * @return 处理结果
	 * @author czw
	 * @version Oct 22,2015 
	 */
	public ResultMessage init();
}