package businesslogic.basebl;

import java.util.ArrayList;

import po.BasePO;
import vo.BaseVO;
/**
 * This class is TODO this class is todo
 * @author Ann 
 *
 */
public class BaseTrans {
	
	public static BaseVO convertPOtoVO(BasePO po) {
		BaseVO vo = null;
//				new BaseVO(po.getID(), po.getDistances(), po.getPrice(), po.getSalaryPolicies());
		return vo;
	}
	
	public static ArrayList<BaseVO> convertPOstoVOs(ArrayList<BasePO> pos){
		ArrayList<BaseVO> vos = new ArrayList<>();
		for (BasePO po : pos) {
			BaseVO vo = convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}
	
	public static BasePO convertVOtoPO(BaseVO vo) {
		
		BasePO po = new BasePO(vo.id, vo.distances, vo.price, vo.salaryPolicies);
		return po;
	}
}
