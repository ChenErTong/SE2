package dataservice.organizationdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataService;
import po.BranchPO;
import po.OrganizationPO;
import po.TransferPO;
import state.ResultMessage;

/**
 * 提供普遍的公司机构进行增删改查的操作【所以我把它直接放在dataservice的包下面了orz】
 * @author zsq
 * @version Oct 23,2015
 */
public interface OrganizationDataService extends  DataService<OrganizationPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "OrganizationData";
	//这个接口好像用不到了
}
