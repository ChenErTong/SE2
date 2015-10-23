package dataservice.basedataservice;

import java.util.ArrayList;


import po.BasePO;

import state.FindTypeBase;
import state.ResultMessage;

/**
 * 提供公司基本运营数据的集体载入、保存和增删改查服务
 * @author zsq
 * @version Oct 22,2015
 */
public interface BaseDataService {
	/**
	 * 向序列化文件中增加一个BasePO
	 * @param po
	 * @return 处理结果
	 */
	public ResultMessage insert(BasePO po);
	/**
	 * 根据ID删除序列化文件中的一个BasePO
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID);
	/**
	 * 更新BasePO
	 * @param PO
	 * @return 处理结果
	 */
	public ResultMessage update(BasePO PO);
	/**
	 * type是查找的类型，另一个参数是ACCOUNT对象
	 * @param baseType
	 * @return 账户持久化对象
	 */
	public ArrayList<BasePO> find(FindTypeBase baseType);
}
