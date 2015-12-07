
package ui.image;

import javax.swing.ImageIcon;

/**
 * @author zsq
 * @version 2015/12/06 10:31
 */
	public class ManagerImage {
		//单据审批
		private static ImageIcon[] BUTTON_APPROVE = null;
		//机构管理
		private static ImageIcon[] BUTTON_ORGANIZATION = null;
		//常量制定
		private static ImageIcon[] BUTTON_BASE = null;
		//策略
		private static ImageIcon[] BUTTON_POLICY = null;
		//员工信息
		private static ImageIcon[] BUTTON_ACCOUNT = null;
		//经营情况表
		private static ImageIcon[] BUTTON_JINGYING = null;
		//成本收益
		private static ImageIcon[] BUTTON_CHENGBEN = null;
		//系统日志
		private static ImageIcon[] BUTTON_LOG = null;
		
		public static ImageIcon[] getBUTTON_APPROVE(){
			if(BUTTON_APPROVE == null){
				BUTTON_APPROVE= Images.createImageIcons("image/button/单据审批.png");
			}
			return BUTTON_APPROVE;
		}
		
		public static ImageIcon[] getBUTTON_ORGANIZATION(){
			if(BUTTON_ORGANIZATION == null){
				BUTTON_ORGANIZATION = Images.createImageIcons("image/button/公司机构管理.png");
			}
			return BUTTON_ORGANIZATION;
		}
		
		public static ImageIcon[] getBUTTON_BASE(){
			if(BUTTON_BASE == null){
				BUTTON_BASE = Images.createImageIcons("image/button/运营常量.png");
			}
			return BUTTON_BASE;
		}
		
		public static ImageIcon[] getBUTTON_POLICY(){
			if(BUTTON_POLICY == null){
				BUTTON_POLICY = Images.createImageIcons("image/button/薪水策略.png");
			}
			return BUTTON_POLICY;
		}
		
		public static ImageIcon[] getBUTTON_ACCOUNT(){
			if(BUTTON_ACCOUNT == null){
				BUTTON_ACCOUNT = Images.createImageIcons("image/button/员工信息.png");
			}
			return BUTTON_ACCOUNT;
		}
		
		public static ImageIcon[] getButton_JINGYING(){
			if(BUTTON_JINGYING==null){
				BUTTON_JINGYING = Images.createImageIcons("image/button/经营情况。png");
			}
			return BUTTON_JINGYING;
		}
		
		public static ImageIcon[] getButton_CHENGBEN(){
			if(BUTTON_CHENGBEN==null){
				BUTTON_CHENGBEN = Images.createImageIcons("image/button/成本收益.png");
			}
			return BUTTON_CHENGBEN;
		}
		
		public static ImageIcon[] getButton_LOG(){
			if(BUTTON_LOG==null){
				BUTTON_LOG = Images.createImageIcons("image/button/系统日志.png");
			}
			return BUTTON_LOG;
		}
}
