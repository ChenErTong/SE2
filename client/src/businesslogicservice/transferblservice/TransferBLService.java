package businesslogicservice.transferblservice;

import java.util.ArrayList;
import po.receiptpo.TransferListPO;
import state.ResultMessage;
import vo.CommodityVO;
import vo.InventoryVO;
import vo.OrderVO;
import businesslogicservice.BLService;

/**
 * 实现中转中心运输管理界面所需要的服务
 * @author czw
 * @version Oct 22,2015
 */
public interface TransferBLService extends BLService{
	/**
	 * 得到中转中心到达单id
	 * @return 中转中心到达单id
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public String getReceiptID();
	
	/**
	 * 得到转运中转单id
	 * @return 转运中转单id
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public String getTransferID();
	
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
	 * @param planeTransferList 转运中转单集合
	 * @param orderNumber 订单号集合
	 * @param inventory 仓库持久化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public TransferListPO planeTransfer(ArrayList<TransferListPO> planeTransferList, String []orderNumber, OrderVO order, InventoryVO inventory);
	
	/**
	 * 自动计算运费
	 * 生成汽车转运中转单
	 * @return 汽车转运中转单
	 * @param planeTransferList 转运中转单集合
	 * @param orderNumber 订单号集合
	 * @param inventory 仓库持久化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public TransferListPO truckTransfer(ArrayList<TransferListPO> truckTransferList, String []orderNumber, OrderVO order, InventoryVO inventory);

	/**
	 * 自动计算运费
	 * 生成火车转运中转单
	 * @return 火车转运中转单
	 * @param planeTransferList 转运中转单集合
	 * @param orderNumber 订单号集合
	 * @param inventory 仓库持久化对象
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public TransferListPO trainTransfer(ArrayList<TransferListPO> trainTransferList, String []orderNumber, OrderVO order, InventoryVO inventory);
	
	/**
	 * 提交单据给总经理进行审批
	 * @return 处理结果
	 * @param transferList 转运中转单据
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage submit(TransferListPO transferList);
	
	/**
	 * 保存单据
	 * @return 处理结果
	 * @param transferList 转运中转单据
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public ResultMessage save(TransferListPO transferList);
	
	/**
	 * 生成中转中心到达单
	 * 申请入库
	 * @return 中转中心到达单
	 * @param commodities 货物集合
	 * @param transferListNumber 中转中心到达单集合
	 * @author czw 
	 * @version Oct 22,2015
	 */
	public TransferListPO receiptList(ArrayList<CommodityVO>commodities, ArrayList<TransferListPO> transferListNumber);
}