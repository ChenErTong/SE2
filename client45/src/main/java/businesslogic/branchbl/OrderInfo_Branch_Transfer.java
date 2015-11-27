package businesslogic.branchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.OrderVO;

public interface OrderInfo_Branch_Transfer {
	/**
	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
	 * @author Ann
	 * @param message 历史轨迹信息
	 * @return
	 * @throws RemoteException 
	 */
	public void changeOrderState(ArrayList<OrderVO> orders,String message) throws RemoteException;
}
