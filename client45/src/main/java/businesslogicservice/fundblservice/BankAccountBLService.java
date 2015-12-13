package businesslogicservice.fundblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.BLService;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

/**
 * 负责实现公司账户界面所需要的服务
 * 
 * 账户管理（账户指的是此家公司的银行账户，仅限最高权限可以查看账户名称和余额。
 * 账号的属性有：名称和金额。余额不可修改，此数据项取决于收款单和付款单。
 * 账户的增删改查包括增加账户、删除账户、修改账户属性和查询账户。
 * 账号的查询可以通过输入关键字进行模糊查找。仅限最高权限可进行这些操作。
 * @author zsq
 * @author Ann
 * @version 创建时间：2015年10月22日 下午3:41:31
 */
public interface BankAccountBLService extends BLService{
	/**
	 * 提出创建/新增银行账户时返回账户ID
	 * @return ID
	 * @author zsq
	 * @version Oct 22,2015
	 */
	public String getID() throws RemoteException;
	/**
	 * 显示当前公司的全部银行账户
	 * @return 全部银行账户的ArrayList
	 */
	public ArrayList<BankAccountVO> show() throws RemoteException;
	/**
	 * 添加银行账户
	 * @param vo BankAccoutVO
	 * @return  处理结果
	 */
	public ResultMessage add(BankAccountVO vo) throws RemoteException;
	/**
	 * 根据账户ID删除账户
	 * @param ID
	 * @return 处理结果
	 */
	public ResultMessage delete(String ID) throws RemoteException;
	/**
	 * 更新账户信息
	 * @param vo BankAccoutVO
	 * @return 处理信息
	 */
	public ResultMessage update(BankAccountVO vo) throws RemoteException;
	/**
	 * 进行关键字模糊查询
	 * @param keywords
	 * @param type 进行的查找类型
	 * @return 符合关键字的全部账户VO
	 * @author zsq
	 * @version Oct 22,2015
	 * @param <FindTypeAccout>
	 * @throws RemoteException 
	 */
	public ArrayList<BankAccountVO> find(String keywords,FindTypeAccount type)  throws RemoteException;
	/**
	 * 是否可以进行撤销操作
	 * 
	 * @return boolean型，返回true，表示可以进行撤销操作，此时撤销按钮应设为可以按下
	 *         返回false，表示不可以进行撤销操作，此时撤销按钮应设为不可以按下
	 */
	public boolean canUndo();
	/**
	 * 是否可以进行回撤操作
	 * 
	 * @return boolean型，返回true，表示可以进行回撤操作，此时回撤按钮应设为可以按下
	 *         返回false，表示不可以进行回撤操作，此时回撤按钮应设为不可以按下
	 */
	public boolean canRedo();
	/**
	 * 执行撤销操作
	 * @return 操作结果
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage undo() throws RemoteException;
	/**
	 * 执行回撤操作
	 * @return 操作结果
	 * @throws RemoteException 远程异常
	 */
	public ResultMessage redo() throws RemoteException;
	}
