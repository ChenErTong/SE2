package businesslogicservice.transferblservice;

import java.util.ArrayList;

import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.TransferArrivalListVO;
import vo.receiptvo.TransferOrderVO;
import businesslogicservice.BLService;

/**
 * 实现中转中心运输管理界面所需要的服务
 * @author czw
 * @version Oct 22,2015
 */
public interface TransferBLService extends BLService{	
	/**
	 * 得到待运送商品列表
	 * @return 商品集合
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ArrayList<CommodityVO> getAllCommodities();
	
	/**
	 * 自动计算运费
	 * 生成飞机转运中转单
	 * @return 飞机转运中转单
	 * @param facilityID 航班编号
	 * @param departure 始发地
	 * @param destination 目的地
	 * @param courierName 押送员姓名
	 * @param orders 订单编号
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public TransferOrderVO planeTransfer(String facilityID, String departure, String destination, String courierName, ArrayList<String> orders);
	
	/**
	 * 自动计算运费
	 * 生成汽车转运中转单
	 * @return 汽车转运中转单
	 * @param facilityID 汽车车次编号
	 * @param departure 始发地
	 * @param destination 目的地
	 * @param courierName 押送员姓名
	 * @param orders 订单编号
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public TransferOrderVO truckTransfer(String facilityID, String departure, String destination, String courierName, ArrayList<String> orders);

	/**
	 * 自动计算运费
	 * 生成火车转运中转单
	 * @return 火车转运中转单
	 * @param facilityID 火车车次编号
	 * @param departure 始发地
	 * @param destination 目的地
	 * @param courierName 押送员姓名
	 * @param orders 订单编号
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public TransferOrderVO trainTransfer(String facilityID, String departure, String destination, String courierName, ArrayList<String> orders);
	
	/**
	 * 提交单据给总经理进行审批
	 * @return 处理结果
	 * @param receipt 转运中转单据
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage submit(ReceiptPO receipt);
	
	/**
	 * 保存单据
	 * @return 处理结果
	 * @param receipt 转运中转单据
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage save(ReceiptPO receipt);
	
	/**
	 * 生成中转中心到达单
	 * 申请入库
	 * @return 中转中心到达单
	 * @param transferID 中转中心编号
	 * @param departure 始发地
	 * @param state 货物到达状态
	 * @param orders 订单编号
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public TransferArrivalListVO receiptList(String transferID, String departure, CommodityState state, ArrayList<String> orders);
}
