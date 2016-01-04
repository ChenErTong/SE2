package businesslogic.basebl;

import java.math.BigDecimal;
import java.util.ArrayList;

import po.BasePO;
import po.PolicyPO;
import state.SalaryPolicy;
import state.UserIdentity;
import vo.BaseVO;
import vo.PolicyVO;

/**
 * 成本常量和薪水策略VO和PO的转换
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:52
 */
public class BaseTrans {

	public static BaseVO convertPOtoVO(BasePO po) {
		if (po == null)
			return null;
		else {
			String iD = po.getID();
			String cityFrom = po.getCityFrom();
			String cityTo = po.getCityTo();
			BigDecimal distance = po.getDistance();
			BigDecimal price = po.getPrice();
			return new BaseVO(iD, cityFrom, cityTo, distance, price);
		}
	}

	public static PolicyVO convertPOtoVO(PolicyPO po) {
		if (po == null)
			return null;
		else {
			String iD = po.getID();
			UserIdentity userIdentity = po.getUserIdentity();
			SalaryPolicy salaryPolicy = po.getSalaryPolicy();
			String remark = po.getRemark();
			return new PolicyVO(iD, userIdentity, salaryPolicy, remark);
		}
	}

	public static ArrayList<BaseVO> convertBasePOstoVOs(ArrayList<BasePO> pos) {
		ArrayList<BaseVO> vos = new ArrayList<>();
		for (BasePO po : pos) {
			BaseVO vo = convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	public static ArrayList<PolicyVO> convertPolicyPOstoVOs(ArrayList<PolicyPO> pos) {
		ArrayList<PolicyVO> vos = new ArrayList<>();
		for (PolicyPO po : pos) {
			PolicyVO vo = convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	public static BasePO convertVOtoPO(BaseVO vo) {
		if (vo == null)
			return null;
		else {
			String id = vo.ID;
			String cityFrom = vo.cityFrom;
			String cityTo = vo.cityTo;
			BigDecimal distance = vo.distance;
			BigDecimal price = vo.price;
			return new BasePO(id, cityFrom, cityTo, distance, price);
		}
	}

	public static PolicyPO convertVOtoPO(PolicyVO vo) {
		if (vo == null)
			return null;
		else {
			String id = vo.ID;
			UserIdentity userIdentity = vo.userIdentity;
			SalaryPolicy salaryPolicy = vo.salaryPolicy;
			String remark = vo.remark;
			return new PolicyPO(id, userIdentity, salaryPolicy, remark);
		}
	}
}
