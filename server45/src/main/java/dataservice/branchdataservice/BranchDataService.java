package dataservice.branchdataservice;

import dataservice.DataService;
import po.BranchPO;
import state.ResultMessage;
/**
 * 先不写注释了，之后再补
 * @author Ann
 *
 */
public interface BranchDataService  extends DataService{
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "BranchData";
	public ResultMessage insert(BranchPO po);
	public BranchPO find(String id);
	public ResultMessage update(BranchPO po);
}
