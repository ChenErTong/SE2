package businesslogic.branchbl;

import java.util.ArrayList;

import po.BranchPO;
import po.FacilityPO;
import po.accountpo.AccountPO;
import vo.BranchVO;

public class BranchTrans {
	public static BranchPO convertVOtoPO(BranchVO vo ){
		if(vo==null){
			return null;
		}
		String ID = vo.getId();
		String address = vo.getAddress();
		String date = vo.getDate();
		ArrayList<AccountPO> accounts = vo.getAccounts();
		ArrayList<FacilityPO> facilities = vo.getFacilities();
		return new BranchPO(ID, address, date, accounts, facilities);
	}
	
	public static BranchVO convertPOtoVO(BranchPO po){
		if (po==null) {
			return null;
		}
		String id = po.getID();
		String date = po.getDate();
		String address = po.getAddress();
		ArrayList<AccountPO> accounts = po.getAccounts();
		ArrayList<FacilityPO> facilities = po.getFacilities();
		return new BranchVO(id, date, address, accounts, facilities);
	}
	
	public static ArrayList<BranchVO> convertPOstoVOs(ArrayList<BranchPO> pos){
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
