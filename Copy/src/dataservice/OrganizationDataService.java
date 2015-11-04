package dataservice;

import java.util.ArrayList;

import po.PersistentObject;
import state.ResultMessage;

/**
 * 提供普遍的公司机构进行增删改查的操作【所以我把它直接放在dataservice的包下面了orz】
 * @author zsq
 * @version Oct 23,2015
 */
public interface OrganizationDataService<OrganizationPO extends PersistentObject>extends DataService<OrganizationPO> {
	/**
	 * 向序列化文件中添加一个OrganizationPO
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(OrganizationPO po);

	/**
	 * 根据ID删除
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);

	/**
	 * 更新po
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage update(OrganizationPO po);

	/**
	 * 显示全部po
	 * @return 返回所有po的集合
	 */
	public ArrayList<OrganizationPO> show();

}
