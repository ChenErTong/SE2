package state;

public enum UserAuthority {
	HIGHESTLEVEL("管理员权限"),//
	COMMONLEVEL("普通用户权限"),//
	MANAGER_LEVEL("总经理权限");//
	
	public  final String value;

	UserAuthority(String value) {
		this.value = value;
	}
}
