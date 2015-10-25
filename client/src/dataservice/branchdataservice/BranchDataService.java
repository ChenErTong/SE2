package dataservice.branchdataservice;

import po.BranchPO;
import state.ResultMessage;
/**
 * 先不写注释了，之后再补
 * @author Ann
 *
 */
public interface BranchDataService {
	public ResultMessage insert(BranchPO po);
	public BranchPO find(String id);
	public ResultMessage update(BranchPO po);
}
