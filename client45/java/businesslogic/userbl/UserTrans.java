package businesslogic.userbl;

import java.util.ArrayList;

import po.UserPO;
import state.UserAuthority;
import state.UserIdentity;
import vo.UserVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:39:03
 */
public class UserTrans {
	public static UserPO transVOtoPO(UserVO vo) {
		if (vo == null) {
			return null;
		}
		String ID = vo.id;
		String username = vo.userName;
		String password = vo.password;
		String phoneNumber = vo.phoneNumber;
		UserIdentity iden = vo.iden;
		UserAuthority authority = vo.authority;
		String address = vo.address;
		return new UserPO(ID, username, password, iden, phoneNumber, authority, address);
	}

	public static UserVO transPOtoVO(UserPO po) {
		if (po == null) {
			return null;
		}
		String ID = po.getID();
		String username = po.getUserName();
		String password = po.getPassword();
		String phoneNumber = po.getPhoneNumber();
		UserIdentity iden = po.getIden();
		UserAuthority authority = po.getAuthority();
		String address = po.getAddress();
		return new UserVO(ID, password, username, phoneNumber, iden, authority, address);
	}

	public static ArrayList<UserVO> transPOstoVOs(ArrayList<UserPO> pos) {
		ArrayList<UserVO> vos = new ArrayList<>();
		for (UserPO userPO : pos) {
			UserVO userVO = transPOtoVO(userPO);
			vos.add(userVO);
		}
		return vos;
	}
}
