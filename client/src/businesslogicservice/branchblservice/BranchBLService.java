package businesslogicservice.branchblservice;

import java.util.ArrayList;

import po.OrderPO;
import po.receiptpo.BranchArrivalListPO;
import po.receiptpo.LoadingListPO;
import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.FacilityVO;
import vo.accountvo.DriverVO;
import vo.receiptpo.BranchArrivalListVO;
import vo.receiptpo.DeliveryListVO;
import vo.receiptpo.LoadingListVO;
import businesslogicservice.BLService;

/**
 * 实现营业厅运输管理界面所需要的服务
 * @author czw
 * @version Oct 23,2015
 */
public interface BranchBLService extends BLService{
	/**
	 * 得到待运送商品列表
	 * @return 商品集合
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ArrayList<CommodityVO> getAllCommodities ();
	
	/**
	 * 得到所有订单号
	 * @return 订单号集合
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ArrayList<String> getAllOrderNumber();
	
	/**
	 * 生成营业厅到达单
	 * @return 营业厅到达单
	 * @param transferListID 中转单编号
	 * @param departure 出发地
	 * @param state 货物状态
	 * @param orders 订单编号
	 * @author czw 
	 * @version Oct 23,2015
	 */
	public BranchArrivalListVO getBranchArrivalList(String transferListID, String departure, CommodityState state, ArrayList<String> orders);
	
	/**
	 * 生成营业厅派件单
	 * @return 营业厅派件单
	 * @param orders 订单编号
	 * @param courierName 派送员姓名
	 * @author czw 
	 * @version Oct 23,2015
	 */
	public DeliveryListVO getDeliveryList(ArrayList<String> orders, String courierName);
	
	/**
	 * 提交单据给总经理进行审批
	 * @return 处理结果
	 * @param receipt 营业厅单据
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage submit(ReceiptPO receipt);
	
	/**
	 * 保存单据
	 * @return 处理结果
	 * @param receipt 营业厅单据
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage save(ReceiptPO receipt);
	
	/**
	 * 自动计算运费
	 * 生成装车单
	 * @return 装车单
	 * @param branchID 营业厅编号
	 * @param destination 目的地
	 * @param facilityID 车辆代号
	 * @param courierName 押送员姓名
	 * @param orders 订单编号
	 * @author czw 
	 * @version Oct 23,2015
	 */
	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName, ArrayList<String> orders);
}