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
import state.ResultMessage;
import vo.BaseVO;

public class Base {
	private BaseDataService baseData;

	public Base() {
		baseData=getData();
	}
	public BaseDataService getData(){
		try {
			return   (BaseDataService) Naming.lookup(RMIConfig.PREFIX + BaseDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public String getID() throws RemoteException {
		return baseData.getID();
	}

	public ResultMessage addBase(BaseVO vo) throws RemoteException {
		BasePO basePO = BaseTrans.convertVOtoPO(vo);
		return baseData.add(basePO);
	}

	public ResultMessage deleteBase(String ID) throws RemoteException {
		return baseData.delete(ID);
	}

	public ResultMessage updateBase(BaseVO vo) throws RemoteException {
		BasePO basePO = BaseTrans.convertVOtoPO(vo);
		return baseData.modify(basePO);
	}

	public ArrayList<BaseVO> show() throws RemoteException {
		ArrayList<BasePO> pos = baseData.find();
		ArrayList<BaseVO> vos = BaseTrans.convertBasePOstoVOs(pos);
		return vos;
	}

	public BaseVO find(String id) throws RemoteException {
		ArrayList<BasePO> pos = baseData.find();
		for (BasePO basePO : pos) {
			if(basePO.getID().equals(id))
				return BaseTrans.convertPOtoVO(basePO);
		}
		return null;
	}
	
}
