package businesslogic.transferbl;

import java.util.ArrayList;

import po.InventoryPO;
import po.TransferPO;
import po.accountpo.AccountPO;
import vo.TransferVO;

public class TransferTrans {
	public static TransferPO convertVOtoPO(TransferVO vo) {
		if (vo == null) {
			return null;
		}
		String ID = vo.getOrganizationID();
		String address = vo.getAddress();
		String date = vo.getDate();
		ArrayList<AccountPO> accounts = vo.getAccounts();
		ArrayList<InventoryPO> inventoryPOs =vo.getInventories();
		return new TransferPO(ID, address, date, accounts,inventoryPOs);
	}

	public static TransferVO convertPOtoVO(TransferPO po) {
		if (po == null) {
			return null;
		}
		String id = po.getID();
		String date = po.getDate();
		String address = po.getAddress();
		ArrayList<AccountPO> accounts = po.getAccounts();
		ArrayList<InventoryPO> inventorys =po.getInventories();
		return new TransferVO(id, address, date, accounts, inventorys);
	}

	public static ArrayList<TransferVO> convertPOstoVOs(ArrayList<TransferPO> pos) {
		ArrayList<TransferVO> vos = new ArrayList<>();
		for (TransferPO transferPO : pos) {
			TransferVO vo = convertPOtoVO(transferPO);
			vos.add(vo);
		}
		return vos;
	}
	
	public static ArrayList<TransferPO> convertVOstoPOs(ArrayList<TransferVO> vos) {
		ArrayList<TransferPO> pos = new ArrayList<>();
		for (TransferVO transferVO : vos) {
			TransferPO po = convertVOtoPO(transferVO);
			pos.add(po);
		}
		return pos;
	}
}
