package businesslogic.organizationbl.branchbl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.CommonBusinessLogic;
import businesslogic.orderbl.OrderInfo;
import businesslogic.organizationbl.OrderInfo_Branch_Transfer;
import businesslogic.receiptbl.ReceiptInfo;
import config.RMIConfig;
import dataservice.branchdataservice.BranchDataService;
import po.BranchPO;
import state.CommodityState;
import state.ConfirmState;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import util.CityTrans;
import vo.BranchVO;
import vo.CommodityVO;
import vo.OrderVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:06
 */
public class Branch implements CommonBusinessLogic<BranchPO>{
	private OrderInfo_Branch_Transfer orderInfo;
	private ReceiptInfo_Branch receiptInfo;
	private BranchDataService branchData;
	
	
	public Branch() throws MalformedURLException, RemoteException, NotBoundException {
		
		branchData = (BranchDataService) Naming.lookup(RMIConfig.PREFIX + BranchDataService.NAME);
		orderInfo = new OrderInfo();
		receiptInfo = new ReceiptInfo();
	}

	public BranchDataService getData() throws MalformedURLException, RemoteException, NotBoundException {
		return (BranchDataService) Naming.lookup(RMIConfig.PREFIX + BranchDataService.NAME);
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	/**
	 * 得到所有的商品
	 * 
	 * @author Ann
	 * @return ArrayList<CommodityVO>型，所有的商品
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<CommodityVO> getAllCommodities() throws RemoteException {
		return orderInfo.getAllCommodities();
	}

	/**
	 * 获取所有的订单号
	 * 
	 * @return ArrayList<String>型，所有订单的编号
	 * @throws RemoteException
	 *             远程异常
	 */
	public ArrayList<String> getAllOrderNumber() throws RemoteException {
		ArrayList<OrderVO> orderVOs = getAllOrders();
		ArrayList<String> orderNumbers = new ArrayList<>();
		for (OrderVO orderVO : orderVOs) {
			orderNumbers.add(orderVO.ID);
		}
		return orderNumbers;
	}

	/**
	 * 生成营业厅到达单
	 * 
	 * @param departure
	 *            String型，营业厅地址
	 * @param orderState
	 *            CommodityState型，订单状态
	 * @param order
	 *            OrderVO型，订单
	 * @return BranchArrivalListVO型，营业厅到达单
	 * @throws RemoteException
	 *             远程异常
	 */
	public BranchArrivalListVO getBranchArrivalList(String departure, CommodityState state, OrderVO order)
			throws RemoteException {
		String transferListID = receiptInfo.getID();
		String orderID = order.ID;
		BranchArrivalListVO vo = new BranchArrivalListVO(transferListID, ReceiptType.BRANCH_ARRIVAL, transferListID,
				departure, state, orderID);
		// 更改VO状态
		orderInfo.changeOrderState(orderID, "货物已到达" + departure + "营业厅", state);
		receiptInfo.add(vo);
		return vo;
	}

	/**
	 * 生成订单派送单（派件单）
	 * 
	 * @param order
	 *            String型，订单编号
	 * @param courierName
	 *            String型，快递员姓名
	 * @return DeliveryListVO型，派件单
	 * @throws RemoteException
	 *             远程异常
	 */
	public DeliveryListVO getDeliveryList(String order, String courierName) throws RemoteException {
		String ID = receiptInfo.getID();
		DeliveryListVO vo = new DeliveryListVO(ID, ReceiptType.BRANCH_DELIVER, order, courierName);
		return vo;
	}

	/**
	 * 提交单据
	 * 
	 * @param receipt
	 *            ReceiptVO型，单据
	 * @return ResultMessage型，结果
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage submit(ReceiptVO receipt) throws RemoteException {
		receipt.receiptState = ReceiptState.APPROVALING;
		return receiptInfo.modify(receipt);
	}

	/**
	 * 保存草稿
	 * 
	 * @param receipt
	 *            ReceiptVO型，单据
	 * @return ResultMessage型，保存结果
	 * @throws RemoteException
	 *             远程异常
	 */
	public ResultMessage save(ReceiptVO receipt) throws RemoteException {
		receipt.receiptState = ReceiptState.DRAFT;
		return receiptInfo.add(receipt);
	}

	/**
	 * 生成营业厅装车单
	 * 
	 * @param branchID
	 *            String型，营业厅编号
	 * @param destination
	 *            String型，转送地址
	 * @param facilityID
	 *            String型，车辆编号
	 * @param courierName
	 *            String型，监装员、押运员姓名
	 * @param orders
	 *            ArrayList<String>型，订单列表
	 * @param money
	 *            BigDecimal型，运送价格
	 * @return LoadingListVO型，营业厅装车单
	 * @throws RemoteException
	 *             远程异常
	 */
	public LoadingListVO truckDeliver(String branchID, String destination, String facilityID, String courierName,
			ArrayList<String> orders, BigDecimal money) throws RemoteException {
		String ID = receiptInfo.getBranchTruckID();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateInID = df.format(new Date());
		ID = branchID + dateInID + ID;
		LoadingListVO vo = new LoadingListVO(ID, ReceiptType.BRANCH_TRUCK, branchID, destination, branchID, facilityID,
				courierName, courierName, orders, money);
		// 更改VO状态 TODO
		orderInfo.changeOrderState(orders, "货物已离开" + destination + "营业厅");
		receiptInfo.add(vo);
		return vo;
	}

	/**
	 * 获得所有的订单
	 * 
	 * @author Ann
	 * @return ArrayList<OrderVO>型，订单列表
	 * @throws RemoteException
	 *             远程异常
	 */
	private ArrayList<OrderVO> getAllOrders() throws RemoteException {
		return orderInfo.getAllOrders();
	}
	
	
	public String getBranchID(String city) throws RemoteException {
		String cityCode = CityTrans.getCodeByCity(city);
		String ID = branchData.getID();
		return cityCode + ID;
	}

	public ResultMessage add(BranchPO po) throws RemoteException {
		return branchData.add(po);
	}

	public BranchPO delete(String organizationID) throws RemoteException {
		return branchData.delete(organizationID);
	}

	public ResultMessage modify(BranchPO po) throws RemoteException {
		return branchData.modify(po);
	}

	public ArrayList<BranchVO> showBranch() throws RemoteException {
		ArrayList<BranchPO> branchPOs = branchData.find();
		return BranchTrans.convertPOstoVOs(branchPOs);
	}

	public ArrayList<String> getAllBranchNumbers() throws RemoteException {
		ArrayList<BranchPO> pos = branchData.find();
		ArrayList<String> branchNumbers = new ArrayList<>();
		for (BranchPO branchPO : pos) {
			branchNumbers.add(branchPO.getOrganizationID());
		}
		return branchNumbers;
	}

}
