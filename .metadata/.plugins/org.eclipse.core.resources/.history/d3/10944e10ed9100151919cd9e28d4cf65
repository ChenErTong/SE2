package businesslogic.userbl;

import java.util.ArrayList;

import po.UserPO;
import vo.UserVO;

public class UserTrans {
		public static UserPO transVOtoPO(UserVO vo){
			if (vo==null) {
				return null;
			}
			String ID = vo.getId();
			String username = vo.getUserName();
			String password = vo.getPassword();
			String phoneNumber = vo.getPhoneNumber();
			String iden = vo.getIden();
			String authority = vo.getAuthority();
			String address = vo.getAddress();
			return new UserPO(ID, password, username ,phoneNumber, iden,authority,address);
		}
		
		public static UserVO transPOtoVO(UserPO po){
			if (po==null) {
				return null;
			}
			String ID = po.getId();
			String username = po.getUsername();
			String password = po.getPassword();
			String phoneNumber = po.getPhoneNumber();
			String iden = po.getIden();
			String authority = po.getAuthority();
			String address = po.getAddress();
			return new UserVO(ID, password, username ,phoneNumber, iden,authority,address);
		}
		
		public static ArrayList<UserVO> transPOstoVOs(ArrayList<UserPO> pos){
			ArrayList<UserVO> vos = new ArrayList<>();
			for (UserPO userPO : pos) {
				UserVO userVO = transPOtoVO(userPO);
				vos.add(userVO);
			}
			return vos;
		}
}
