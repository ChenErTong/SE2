package businesslogic.facility;

import java.util.ArrayList;

import po.FacilityPO;
import po.receiptpo.LoadingListPO;
import vo.FacilityVO;

public class FacilityTrans {
	public static FacilityPO convertVOtoPO(FacilityVO vo) {
		if (vo == null)
			return null;
		else {
			String ID = vo.getFacilityIdString();
			String date = vo.getDateString();
			String manageID = vo.getManagerId();
			ArrayList<LoadingListPO> deliverHistory = vo.getDeliverHistory();
			return new FacilityPO(ID, date, manageID, deliverHistory);
		}
	}

	public static FacilityVO convertPOtoVO(FacilityPO po) {
		if (po == null)
			return null;
		else{
			String ID = po.getID();
			String date = po.getDate();
			String manageID = po.getManagerId();
			ArrayList<LoadingListPO> deliverHistory = po.getDeliverHistory();
			return new FacilityVO(manageID, deliverHistory, ID, date);
		}
	}
}
