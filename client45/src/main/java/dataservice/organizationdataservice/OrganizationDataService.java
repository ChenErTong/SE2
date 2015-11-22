package dataservice.organizationdataservice;

import dataservice.ManageDataService;
import po.OrganizationPO;

/**
 * 提供普遍的公司机构进行增删改查的操作【所以我把它直接放在dataservice的包下面了orz】
 * @author zsq
 * @version Oct 23,2015
 */
public interface OrganizationDataService extends ManageDataService<OrganizationPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "OrganizationData";
	/**
	 * 向序列化文件中添加一个OrganizationPO
	 * @param po
	 * @return 处理结果
	 */
//	public ResultMessage insert(OrganizationPO po) throws RemoteException;

	/**
	 * 根据ID删除
	 * @param ID
	 * @return 处理结果
	 */
//	public ResultMessage delete(String ID) throws RemoteException;

	/**
	 * 更新po
	 * @param po
	 * @return 处理结果
	 */
//	public ResultMessage update(OrganizationPO po) throws RemoteException;

	/**
	 * 显示全部po
	 * @return 返回所有po的集合
	 */
//	public ArrayList<OrganizationPO> show() throws RemoteException;

}
