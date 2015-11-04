package businesslogicservice.organizationblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.OrganizationVO;


/**
 * 提供进行公司机构管理界面所需要的服务【Orz感觉这个接口单独放好怪异】
 * @author zsq
 * @version Oct 22,2015
 */
public interface OrganizationBLService {
	/**
	 * @return 全部的系统用户
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ArrayList<OrganizationVO> show();
	/**
	 * 界面进行新建用户操作是得到一个可用的ID
	 * @return 
	 * @author zsq 
	 * @version Oct 22,2015
	 */
	public String getID();
	/**
	 * 添加一个机构
	 * @param vo OrganizationVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage addOrganization(OrganizationVO vo);
	/**
	 * 删除一个机构
	 * @param organizationID
	 * @return 处理信息
	 * @author zsq
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deleteOrganization(String organizationID);
	/**
	 * 更新一个机构的信息
	 * @param vo OrganizationVO
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateUser(OrganizationVO vo);
}
