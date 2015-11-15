package businesslogicservice;

import state.ConfirmState;

public interface BLService {
	/**
	 * 操作确认
	 * @return 确认结果
	 * @author czw
	 * @version Oct 22,2015
	 */
	public ConfirmState confirmOperation();
}
