package businesslogic.organizationbl.branchbl;

import java.util.ArrayList;

import businesslogic.accountbl.AccountTrans;
import businesslogic.facilitybl.FacilityTrans;
import po.BranchPO;
import po.FacilityPO;
import po.accountpo.AccountPO;
import vo.BranchVO;
import vo.FacilityVO;
import vo.accountvo.AccountVO;

/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:33:20
 */
public class BranchTrans {
	public static BranchPO convertVOtoPO(BranchVO vo) {
		if (vo == null) {
			return null;
		}
		String ID = vo.organizationID;
		String address = vo.address;
		String date = vo.date;
		ArrayList<AccountPO> accounts = AccountTrans.convertVOstoPOs(vo.accounts);
		ArrayList<FacilityPO> facilities = FacilityTrans.convertVOstoPOs(vo.facilities);
		return new BranchPO(ID, address, date, accounts, facilities);
	}

	public static BranchVO convertPOtoVO(BranchPO po) {
		if (po == null) {
			return null;
		}
		String id = po.getID();
		String date = po.getDate();
		String address = po.getAddress();
		ArrayList<AccountVO> accounts = AccountTrans.convertPOstoVOs(po.getAccounts());
		ArrayList<FacilityVO> facilities = FacilityTrans.convertFacilityPOstoVOs(po.getFacilities());
		return new BranchVO(id, date, address, accounts, facilities);
	}

	public static ArrayList<BranchVO> convertPOstoVOs(ArrayList<BranchPO> pos) {
		ArrayList<BranchVO> vos = new ArrayList<>();
		for (BranchPO branchPO : pos) {
			BranchVO vo = convertPOtoVO(branchPO);
			vos.add(vo);
		}
		return vos;
	}

	public static ArrayList<BranchPO> convertVOstoPOs(ArrayList<BranchVO> vos) {
		ArrayList<BranchPO> pos = new ArrayList<>();
		for (BranchVO vo : vos) {
			BranchPO po = convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}
}
