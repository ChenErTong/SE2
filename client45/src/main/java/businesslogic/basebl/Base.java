package businesslogic.basebl;

/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
import state.ConfirmState;
import state.FindTypeBase;
import state.ResultMessage;
import vo.BaseVO;

public class Base {
	private BaseDataService baseData;

	public Base() {
		try {
			baseData = (BaseDataService) Naming.lookup(RMIConfig.PREFIX + BaseDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ArrayList<BaseVO> show(FindTypeBase baseType) throws RemoteException {
		ArrayList<BasePO> pos = baseData.find(baseType);
		ArrayList<BaseVO> vos =BaseTrans.convertPOstoVOs(pos);
		return vos;
	}

	

	

	public String getID(FindTypeBase baseType) throws RemoteException {
		return baseData.getID(baseType);
	}

	public ResultMessage addBase(BaseVO vo) throws RemoteException {
		BasePO PO = BaseTrans.convertVOtoPO(vo);
		return baseData.add(PO);
	}

	public ResultMessage deleteBase(String ID) throws RemoteException {
		return baseData.delete(ID);
	}

	public ResultMessage updateBase(BaseVO vo) throws RemoteException {
		BasePO PO = BaseTrans.convertVOtoPO(vo);
		return baseData.modify(PO);
	}
}
