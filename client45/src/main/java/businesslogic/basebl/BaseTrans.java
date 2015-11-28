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
		if(po==null)
			return null;
		else {
			String iD = po.getID();
			String cityFrom = po.getCityFrom();
			String cityTo = po.getCityTo();
			double distance = po.getDistance();
			double price = po.getPrice();
			return new BaseVO(iD, cityFrom, cityTo, distance, price);
		}
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
		if(vo==null)
			return null;
		else {
			String id = vo.ID;
			String cityFrom = vo.cityFrom;
			String cityTo = vo.cityTo;
			double distance = vo.distance;
			double price = vo.price;
			return new BasePO(id, cityFrom, cityTo, distance, price);
		}
	}
}
