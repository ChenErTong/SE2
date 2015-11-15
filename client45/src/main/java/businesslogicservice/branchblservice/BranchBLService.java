package businesslogicservice.branchblservice;

import java.util.ArrayList;

import businesslogicservice.BLService;
import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.BranchArrivalListVO;
import vo.receiptvo.DeliveryListVO;
import vo.receiptvo.LoadingListVO;

/**
 * 瀹炵幇钀ヤ笟鍘呰繍杈撶鐞嗙晫闈㈡墍闇�瑕佺殑鏈嶅姟
 * @author czw
 * @version Oct 23,2015
 */
public interface BranchBLService extends BLService{
	/**
	 * 寰楀埌寰呰繍閫佸晢鍝佸垪琛�
	 * @return 鍟嗗搧闆嗗悎
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ArrayList<CommodityVO> getAllCommodities ();
	
	/**
	 * 寰楀埌鎵�鏈夎鍗曞彿
	 * @return 璁㈠崟鍙烽泦鍚�
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ArrayList<String> getAllOrderNumber();
	
	/**
	 * 鐢熸垚钀ヤ笟鍘呭埌杈惧崟
	 * @return 钀ヤ笟鍘呭埌杈惧崟
	 * @param transferListID 涓浆鍗曠紪鍙�
	 * @param departure 鍑哄彂鍦�
	 * @param state 璐х墿鐘舵��
	 * @param orders 璁㈠崟缂栧彿
	 * @author czw 
	 * @version Oct 23,2015
	 */
	public BranchArrivalListVO getBranchArrivalList(String transferListID, String departure, CommodityState state, ArrayList<String> orders);
	
	/**
	 * 鐢熸垚钀ヤ笟鍘呮淳浠跺崟
	 * @return 钀ヤ笟鍘呮淳浠跺崟
	 * @param orders 璁㈠崟缂栧彿
	 * @param courierName 娲鹃�佸憳濮撳悕
	 * @author czw 
	 * @version Oct 23,2015
	 */
	public DeliveryListVO getDeliveryList(ArrayList<String> orders, String courierName);
	
	/**
	 * 鎻愪氦鍗曟嵁缁欐�荤粡鐞嗚繘琛屽鎵�
	 * @return 澶勭悊缁撴灉
	 * @param receipt 钀ヤ笟鍘呭崟鎹�
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage submit(ReceiptPO receipt);
	
	/**
	 * 淇濆瓨鍗曟嵁
	 * @return 澶勭悊缁撴灉
	 * @param receipt 钀ヤ笟鍘呭崟鎹�
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage save(ReceiptPO receipt);
	
	/**
	 * 鑷姩璁＄畻杩愯垂
	 * 鐢熸垚瑁呰溅鍗�
	 * @return 瑁呰溅鍗�
	 * @param branchID 钀ヤ笟鍘呯紪鍙�
	 * @param destination 鐩殑鍦�
	 * @param facilityID 杞﹁締浠ｅ彿
	 * @param courierName 鎶奸�佸憳濮撳悕
	 * @param orders 璁㈠崟缂栧彿
	 * @author czw 
	 * @version Oct 23,2015
	 */
	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName, ArrayList<String> orders);
}