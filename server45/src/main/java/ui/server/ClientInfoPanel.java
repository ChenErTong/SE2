package ui.server;

import java.awt.Dimension;
import java.awt.Point;

import ui.MyTranslucentPanel;
import ui.ServerTable;

public class ClientInfoPanel extends MyTranslucentPanel{


	private static final long serialVersionUID = 1L;
	/** 当前登录用户信息的表格 */
	private ServerTable usersTable;
	/** ClientInfoPanel横轴内边距 */
	private int PaddingX = 25;
	/** ClientInfoPanel纵轴内边距 */
	private int PaddingY = 46;
	public ClientInfoPanel() {
		super(580,77,600,565);
		this.initComponent();
	}

	public void initComponent() {
		String[] columnNames = {"用户名", "密码", "姓名", "登录IP"};
	/*	String[][] rowData = new String[UserData.usersInfo.size()][columnNames.length];
		for(int i = 0; i < UserData.usersInfo.size(); i++) {
			LoginUserInfo tempInfo = UserData.usersInfo.get(i);
			rowData[i][0] = tempInfo.userName;
			rowData[i][1] = tempInfo.password;
			rowData[i][2] = tempInfo.name;
			rowData[i][3] = tempInfo.IP;
		}*/
		String[][] rowData = {};
		usersTable = new ServerTable(columnNames, rowData);
		Point usersTablePoint = new Point(PaddingX, PaddingY);
		usersTable.setLocation(usersTablePoint);
		Dimension usersTableDimen = new Dimension(600 - PaddingX * 2, 565 - PaddingY * 2);
		usersTable.setSize(usersTableDimen);
		usersTable.init();
		this.add(usersTable);
		
	}

}
