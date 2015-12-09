package ui;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.commonui.login.Frame_Login;
import ui.specialui.branch_conuterman.Frame_Branch;
import ui.specialui.courier.Frame_Courier;
import ui.specialui.inventory.Frame_Inventory;
import ui.specialui.transfer_counterman.Frame_Transfer;

public class mainForUITest2 {
	
	public static void main(String[] args) {
		try {
			UIManager.put("RootPane.setupButtonVisible",false);
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String userID = "010000001";
		new Frame_Login("0");
//		new Frame_Inventory(userID);
	//	new Frame_Transfer(userID);
//		new Frame_Courier(userID);
//	new Frame_Branch(userID);

	}
}