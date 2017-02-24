package businesslogicservice.transferblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.BLService;
import state.CommodityState;
import vo.CommodityVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

/**
 * 实现中转中心运输管理界面所需要的服务
 * @author Ann
 * @author czw
 * @version Oct 22,2015
 */
public interface TransferBLService extends BLService {
	/**
	 * 得到待运送商品列表
	 * 
	 * @return 商品集合
	 * @author czw
	 * @version Oct 22,2015
	 */
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException;

	/**
	 * 自动计算运费 生成飞机转运中转单
	 * 
	 * @return 飞机转运中转单
	 * @param facilityID
	 *            航班编号
	 * @param departure
	 *            始发地
	 * @param destination
	 *            目的地
	 * @param courierName
	 *            押送员姓名
	 * @param orders
	 *            订单编号
	 * @author czw
	 * @version Oct 22,2015
	 * @param id
	 * @param date
	 */
	public TransferOrderVO planeTransfer(String transfer,String facilityID, String departure,
			String destination, String courierName, ArrayList<String> orders,
			String date, String id) throws RemoteException;

	/**
	 * 自动计算运费 生成汽车转运中转单
	 * 
	 * @return 汽车转运中转单
	 * @param facilityID
	 *            汽车车次编号
	 * @param departure
	 *            始发地
	 * @param destination
	 *            目的地
	 * @param courierName
	 *            押送员姓名
	 * @param orders
	 *            订单编号
	 * @author czw
	 * @version Oct 22,2015
	 */
	public TransferOrderVO truckTransfer(String transfer,String facilityID, String departure,
			String destination, String courierName, ArrayList<String> orders,
			String date, String id) throws RemoteException;

	/**
	 * 自动计算运费 生成火车转运中转单
	 * 
	 * @return 火车转运中转单
	 * @param facilityID
	 *            火车车次编号
	 * @param departure
	 *            始发地
	 * @param destination
	 *            目的地
	 * @param courierName
	 *            押送员姓名
	 * @param orders
	 *            订单编号
	 * @author czw
	 * @version Oct 22,2015
	 * @param date
	 * @param id
	 */
	public TransferOrderVO trainTransfer(String transfer,String facilityID, String departure,
			String destination, String courierName, ArrayList<String> orders,
			String date, String id) throws RemoteException;

	/**
	 * 生成中转中心到达单 申请入库
	 * 
	 * @return 中转中心到达单
	 * @param transferID
	 *            中转中心编号
	 * @param departure
	 *            始发地
	 * @param state
	 *            货物到达状态
	 * @param orders
	 *            订单编号
	 * @author czw
	 * @version Oct 22,2015
	 */
	public TransferArrivalListVO receiptList(String transferID,
			String departure, String destination, CommodityState state,
			String orders) throws RemoteException;
	/**
	 * 获得所有的中转中心编号
	 * @return 所有的中转中心编号，添加user的时候调用
	 * @throws RemoteException 远程异常
	 */
	public ArrayList<String> getAllTransferNumbers() throws RemoteException;
}