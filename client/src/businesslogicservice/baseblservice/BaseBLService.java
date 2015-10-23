package businesslogicservice.baseblservice;

import java.util.ArrayList;
import state.FindTypeBase;
import state.ResultMessage;
import vo.BaseVO;
import businesslogicservice.BLService;
/**
 * 负责实现公司基础运营常量管理界面提供的服务
 * @author zsq
 *
 */
public interface BaseBLService extends BLService{
	/**
	 * 显示被查询的成本常量
	 * @param baseType 查看的常量类型：薪水策略、距离、单价
	 * @param accountID 公司员工账户ID[ACCOUNT类]
	 * @return BaseVO vo
	 * @author zsq 
	 * @version Oct 22,2015
	 */
	//TODO-
	public ArrayList<BaseVO> show(FindTypeBase baseType);
	/**
	 * 界面进行新建一个成本常量操作是得到一个可用的ID
	 * @param baseType 增加的常量类型：薪水策略、距离、单价
	 * @return ID
	 * @author zsq 
	 * @version Oct 22,2015
	 */
	public String getID(FindTypeBase baseType);
	/**
	 * 添加一个常量
	 * @param vo BaseVO
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage addBase(BaseVO vo);
	/**
	 * 删除一个常量
	 * @param ID
	 * @return 处理信息
	 * @author zsq
	 * @veersion Oct 22,2015
	 */
	public ResultMessage deleteBase(String ID);
	/**
	 * 更新一条成本常量信息
	 * @param vo BaseVO
	 * @return 处理结果
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public ResultMessage updateBase(BaseVO vo);
}
