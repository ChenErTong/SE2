package businesslogic.facility;

import po.FacilityPO;
import vo.FacilityVO;

public class FacilityTrans {
	public static FacilityPO convertVOtoPO(FacilityVO vo){
		return new FacilityPO(vo.getFacilityIdString(), vo.getDateString(), vo.getManagerId(), vo.getDeliverHistory());
	}
	public static FacilityVO convertPOtoVO(FacilityPO po){
		return new FacilityVO(po.getManagerId(), po.getDeliverHistory(), po.getID(), po.getDate());
	}
}
