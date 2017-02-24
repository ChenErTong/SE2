package businesslogicservice.openingstockblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ResultMessage;
import vo.OpeningStockVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:43:01
 */
public interface OpeningStockBLService {
	/** 建立期初账目，持久化更新涉及的对象的数据 **/
	// public ResultMessage add(
	// ArrayList<TransferVO >commodities,
	// ArrayList<BranchVO > clients0,
	// ArrayList< AccountVO>clients1,
	// ArrayList< FacilityVO > clients2,
	// ArrayList< InventoryVO > clients3,
	// ArrayList< BankAccountVO > accounts) throws RemoteException;
	/**
	 * 添加一个起初账目
	 * 
	 * 系统自行到数据区查询相关数据 生成一个期初账目
	 * 
	 * @return ResultMessage型，添加是否成功
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage add() throws RemoteException;

	/**
	 * 返回所有的起初账目
	 * 
	 * @return ArrayList<OpeningStockVO>型，期初账目列表
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<OpeningStockVO> show() throws RemoteException;
}
