package businesslogic.userbl;

import po.UserPO;
import state.UserIdentity;
import vo.UserVO;

public class UserTrans {
		public static UserPO transVOtoPO(UserVO vo){
			if (vo==null) {
				return null;
			}
			String ID = "UserVO里没ID";
			String username = vo.getUsername();
			String name = vo.getName();
			String password = vo.getPassword();
			UserIdentity iden = vo.getIden();
			return new UserPO(ID, username, name, password, iden);
		}
		
		public static UserVO transPOtoVO(UserPO po){
			if (po==null) {
				return null;
			}
			String username = po.getUsername();
			String name = po.getName();
			String password = po.getPassword();
			UserIdentity iden = po.getIden();
			return new UserVO(username, name, password, iden);
		}
}
