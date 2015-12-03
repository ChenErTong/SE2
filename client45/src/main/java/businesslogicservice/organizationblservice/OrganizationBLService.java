package businesslogicservice.organizationblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.BranchVO;
import vo.FacilityVO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;



/**
 * 提供进行公司机构管理界面所需要的服务【Orz感觉这个接口单独放好怪异】
 * @author zsq
 * @author Ann
 * @version Oct 22,2015
 */
public interface OrganizationBLService {
	
	public ArrayList<BranchVO> showBranch();
	/**
	 * 界面进行新建用户操作是得到一个可用的ID
	 * @return 
	 * @author zsq 
	 * @version Oct 22,2015
	 */
	public String getBranchID(String city);
	/**
	 * 添加一个机构
	 * @param vo OrganizationVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage addBranch(BranchVO vo);
	/**
	 * 删除一个机构
	 * @param organizationID
	 * @return 处理信息
	 * @author zsq
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deleteBranch(String organizationID);
	/**
	 * 更新一个机构的信息
	 * @param vo OrganizationVO
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateBranch(BranchVO vo);
	/**
	 * @return 全部的系统用户
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ArrayList<TransferVO> showTransfer();
	/**
	 * 界面进行新建用户操作是得到一个可用的ID
	 * @return 
	 * @author zsq 
	 * @version Oct 22,2015
	 */
	public String getTransferID(String city);
	/**
	 * 添加一个机构
	 * @param vo OrganizationVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage addTransfer(TransferVO vo);
	/**
	 * 删除一个机构
	 * @param organizationID
	 * @return 处理信息
	 * @author zsq
	 * @veersion Oct 22,2015
	 */

	public ResultMessage deleteTransfer(String organizationID);

	/**
	 * 更新一个机构的信息
	 * @param vo OrganizationVO
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 */

	public ResultMessage updateTransfer(TransferVO vo);
	/**
	 * 获得所有的营业厅编号
	 * @author Ann
	 */
	public ArrayList<String> getAllBranchNumbers();
	//branch和transfer都调这一个方法
	public ArrayList<AccountVO> getAccountByOrganizationID(String organizationID);
	public ArrayList<FacilityVO> getFacilitiesByBranchID(String branchID);
	public ArrayList<InventoryVO> getInventoriesByTransferID(String transferID);
}
