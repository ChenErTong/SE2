package businesslogicservice.branchblservice;

import java.util.ArrayList;

import po.CommodityPO;
import po.receiptpo.BranchDeliveryList;
import po.receiptpo.BranchList;
import po.receiptpo.BranchReceiptList;
import po.receiptpo.TruckDeliveryList;
import state.ResultMessage;
import vo.AccountVO;
import vo.CommodityVO;
import vo.FacilityVO;
import businesslogicservice.BLService;

/**
 * 实现营业厅运输管理界面所需要的服务
 * @author czw
 * @version Oct 22,2015
 */
public interface BranchBLService extends BLService{
	/**
	 * 得到装车单id
	 * @return 装车单id
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public String getDeliverID();
	
	/**
	 * 得到到达单id
	 * @return 到达单id
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public String getReceiptID();
	
	/**
	 * 得到派件单id
	 * @return 派件单id
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public String getExpressID();
	
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
	 * @param comoditiies 货物信息
	 * @param branchReceiptList 营业厅接收单
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public BranchReceiptList branchReceipt(CommodityVO comoditiies, ArrayList<BranchList> branchReceiptList);
	
	/**
	 * 生成营业厅装车单
	 * @return 营业厅装车单
	 * @param branchReceiptList 营业厅装车单集合
	 * @param account 司机可视化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public BranchDeliveryList branchDeliver(ArrayList<BranchList>branchReceiptList,AccountVO account);
	
	/**
	 * 提交单据给总经理进行审批
	 * @return 处理结果
	 * @param branchList 营业厅单据
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage submit(BranchList branchList);
	
	/**
	 * 保存单据
	 * @return 处理结果
	 * @param branchList 营业厅单据
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage save(BranchList branchList);
	
	/**
	 * 自动计算运费
	 * 生成装车单
	 * @return 装车单
	 * @param truckDeliveryList 营业厅单据
	 * @param facility 车辆可视化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public TruckDeliveryList truckDeliver(ArrayList<TruckDeliveryList> truckDeliveryList, FacilityVO facility);
}