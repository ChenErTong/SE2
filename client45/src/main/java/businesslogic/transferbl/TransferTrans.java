package businesslogic.transferbl;

import java.util.ArrayList;

import businesslogic.accountbl.AccountTrans;
import businesslogic.inventorybl.InventoryTrans;
import po.InventoryPO;
import po.TransferPO;
import po.accountpo.AccountPO;
import vo.InventoryVO;
import vo.TransferVO;
import vo.accountvo.AccountVO;

public class TransferTrans {
	public static TransferPO convertVOtoPO(TransferVO vo) {
		if (vo == null) {
			return null;
		}
		String ID = vo.organizationID;
		String address = vo.address;
		String date = vo.date;
		ArrayList<AccountPO> accounts = AccountTrans.convertVOstoPOs(vo.accounts);
		ArrayList<InventoryPO> inventoryPOs = InventoryTrans.convertInventoryVOstoPOs(vo.inventories);
		return new TransferPO(ID, address, date, accounts, inventoryPOs);
	}

	public static TransferVO convertPOtoVO(TransferPO po) {
		if (po == null) {
			return null;
		}
		String id = po.getID();
		String date = po.getDate();
		String address = po.getAddress();
		ArrayList<AccountVO> accounts = AccountTrans.convertPOstoVOs(po.getAccounts());
		ArrayList<InventoryVO> inventorys = InventoryTrans.convertInventoryPOstoVOs(po.getInventories());
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
