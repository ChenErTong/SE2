package businesslogicservice.branchblservice;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.BLService;
import state.CommodityState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.OrderVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;

/**
 * @author czw
 * @author Ann
 * @version 创建时间：2015年10月23日 下午3:40:37
 */
public interface BranchBLService extends BLService{
	/**
	 * 寰楀埌寰呰繍閫佸晢鍝佸垪琛�
	 * @return 鍟嗗搧闆嗗悎
	 * @author czw 
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ArrayList<CommodityVO> getAllCommodities () ;
	
	/**
	 * 寰楀埌鎵�鏈夎鍗曞彿
	 * @return 璁㈠崟鍙烽泦鍚�
	 * @author czw 
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ArrayList<String> getAllOrderNumber() ;
	
	/**
	 * 根据数据生成到达单保存到数据库并返回（我不知道到达单编号有什么用所以删掉了，如果别的用例需要编号你们可以补上）
	 * @param transferListID 到达单编号
	 * @param departure 营业厅离开点
	 * @param order 到达的订单对象
	 * @return
	 */
//	public BranchArrivalListVO getBranchArrivalList(String departure, CommodityState state, ArrayList<OrderVO> orders);
	public BranchArrivalListVO getBranchArrivalList(String departure, CommodityState state, OrderVO orders);
	/**
	 * 鐢熸垚钀ヤ笟鍘呮淳浠跺崟
	 * @return 钀ヤ笟鍘呮淳浠跺崟
	 * @param order 璁㈠崟缂栧彿
	 * @param courierName 娲鹃�佸憳濮撳悕
	 * @author czw 
	 * @version Oct 23,2015
	 */
	public DeliveryListVO getDeliveryList(String order, String courierName);
	
	/**
	 * 鎻愪氦鍗曟嵁缁欐�荤粡鐞嗚繘琛屽鎵�
	 * @return 澶勭悊缁撴灉
	 * @param receipt 钀ヤ笟鍘呭崟鎹�
	 * @author czw 
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ResultMessage submit(ReceiptVO receipt) ;
	
	/**
	 * 淇濆瓨鍗曟嵁
	 * @return 澶勭悊缁撴灉
	 * @param receipt 钀ヤ笟鍘呭崟鎹�
	 * @author czw 
	 * @version Oct 22,2015
	 * @throws RemoteException 
	 */
	public ResultMessage save(ReceiptVO receipt) ;
	
	/**
	 * @return 瑁呰溅鍗�
	 * @param branchID 钀ヤ笟鍘呯紪鍙�
	 * @param destination 鐩殑鍦�
	 * @param facilityID 杞﹁締浠ｅ彿
	 * @param courierName 鎶奸�佸憳濮撳悕
	 * @param orders 璁㈠崟缂栧彿
	 * @author czw 
	 * @version Oct 23,2015
	 */
	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName, ArrayList<String> orders, BigDecimal money);
}