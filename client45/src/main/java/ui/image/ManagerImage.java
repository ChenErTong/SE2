
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
		
		//单据审批
		private static ImageIcon[] BUTTON_APPROVE_ = null;
		//机构管理
		private static ImageIcon[] BUTTON_ORGANIZATION_ = null;
		//常量制定
		private static ImageIcon[] BUTTON_BASE_ = null;
		//策略
		private static ImageIcon[] BUTTON_POLICY_ = null;
		//员工信息
		private static ImageIcon[] BUTTON_ACCOUNT_ = null;
		
		
		//查看单据
		private static ImageIcon[] BUTTON_VIEWBILL = null;
		//批量审批
		private static ImageIcon[]  BUTTON_APPROVEALL = null;
		//修改单据
		private static ImageIcon[] BUTTON_MODIFYBILL = null;
		//通过单据
		private static ImageIcon[] BUTTON_PASSBILL = null;
		//不通过单据
		private static ImageIcon[] BUTTON_DONTPASS = null;
		//导出单据
		private static ImageIcon[]  BUTTON_EXPORTBILL = null;
		
		//添加机构
		private static ImageIcon[] BUTTON_ADDOR = null;
		//查看机构
		private static ImageIcon[] BUTTON_VIEWOR = null;
		//删除机构
		private static ImageIcon[] BUTTON_DELETEOR = null;
		//修改机构
		private static ImageIcon[] BUTTON_MODIFYOR = null;
		
		//删除常量
		private static ImageIcon[] BUTTON_DELETEBASE = null;
		//修改常量
		private static ImageIcon[] BUTTON_MODIFYBASE = null;
		
		//删除策略
		private static ImageIcon[] BUTTON_DELETEPOLICY = null;
		//修改策略
		private static ImageIcon[] BUTTON_MODIFYPOLICY = null;
		
		//查看员工
		private static ImageIcon[] BUTTON_VIEWACCOUNT = null;
		//删除员工
		private static ImageIcon[] BUTTON_DELETEACCOUNT = null;
		//修改员工
		private static ImageIcon[] BUTTON_MODIFYACCOUNT = null;
		
		//确认添加
		private static ImageIcon[] BUTTON_CONFIRMADD = null;
		//确认修改
		private static ImageIcon[] BUTTON_CONFIRMMODIFY = null;
		//返回
		private static ImageIcon[] BUTTON_RETURN = null;
		
		private static ImageIcon[] BUTTON_VIEWMSG = null;
		
		public static ImageIcon[] getBUTTON_VIEWMSG(){
			if(BUTTON_VIEWMSG == null){
				BUTTON_VIEWMSG = Images.createImageIcons("image/button/查看记录.png");
			}
			return BUTTON_VIEWMSG;
		}
		public static ImageIcon[] getBUTTON_RETURN(){
			if(BUTTON_RETURN==null){
				BUTTON_RETURN = Images.createImageIcons("image/button/结束.png");
			}
			return BUTTON_RETURN;
		}
		public static ImageIcon[] getBUTTON_APPROVE_(){
			if(BUTTON_APPROVE_ == null){
				BUTTON_APPROVE_= Images.createImageIcons("image/button/单据导航.png");
			}
			return BUTTON_APPROVE_;
		}
		
		public static ImageIcon[] getBUTTON_ORGANIZATION_(){
			if(BUTTON_ORGANIZATION_ == null){
				BUTTON_ORGANIZATION_ = Images.createImageIcons("image/button/机构导航.png");
			}
			return BUTTON_ORGANIZATION_;
		}
		
		public static ImageIcon[] getBUTTON_BASE_(){
			if(BUTTON_BASE_ == null){
				BUTTON_BASE_ = Images.createImageIcons("image/button/运营导航.png");
			}
			return BUTTON_BASE_;
		}
		
		public static ImageIcon[] getBUTTON_POLICY_(){
			if(BUTTON_POLICY_ == null){
				BUTTON_POLICY_ = Images.createImageIcons("image/button/薪水导航.png");
			}
			return BUTTON_POLICY_;
		}
		
		public static ImageIcon[] getBUTTON_ACCOUNT_(){
			if(BUTTON_ACCOUNT_ == null){
				BUTTON_ACCOUNT_ = Images.createImageIcons("image/button/员工信息导航.png");
			}
			return BUTTON_ACCOUNT_;
		}
		
		public static ImageIcon[] getBUTTON_APPROVE(){
			if(BUTTON_APPROVE == null){
				BUTTON_APPROVE= Images.createImageIcons("image/button/单据处理.png");
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
				BUTTON_BASE = Images.createImageIcons("image/button/成本常量.png");
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
				BUTTON_JINGYING = Images.createImageIcons("image/button/经营情况表.png");
			}
			return BUTTON_JINGYING;
		}
		
		public static ImageIcon[] getButton_CHENGBEN(){
			if(BUTTON_CHENGBEN==null){
				BUTTON_CHENGBEN = Images.createImageIcons("image/button/成本收益表.png");
			}
			return BUTTON_CHENGBEN;
		}
		
		public static ImageIcon[] getButton_LOG(){
			if(BUTTON_LOG==null){
				BUTTON_LOG = Images.createImageIcons("image/button/记录日志.png");
			}
			return BUTTON_LOG;
		}
		
		public static ImageIcon[] getBUTTON_VIEWBILL(){
			if(BUTTON_VIEWBILL==null){
				BUTTON_VIEWBILL = Images.createImageIcons("image/button/查看单据.png");
			}
			return BUTTON_VIEWBILL;
		}
		
		public static ImageIcon[] getBUTTON_APPROVEALL(){
			if(BUTTON_APPROVEALL==null){
				BUTTON_APPROVEALL = Images.createImageIcons("image/button/批量审批.png");
			}
			return BUTTON_APPROVEALL;
		}
		
		public static ImageIcon[] getBUTTON_MODIFYBILL(){
			if(BUTTON_MODIFYBILL==null){
				BUTTON_MODIFYBILL = Images.createImageIcons("image/button/修改单据.png");
			}
			return BUTTON_MODIFYBILL;
		}
		
		public static ImageIcon[] getBUTTON_PASSBILL(){
			if(BUTTON_PASSBILL==null){
				BUTTON_PASSBILL = Images.createImageIcons("image/button/通过单据.png");
			}
			return BUTTON_PASSBILL;
		}
		
		public static ImageIcon[] getBUTTON_DONTPASS(){
			if(BUTTON_DONTPASS==null){
				BUTTON_DONTPASS = Images.createImageIcons("image/button/不通过单据.png");
			}
			return BUTTON_DONTPASS;
		}
		
		public static ImageIcon[] getBUTTON_EXPORTBILL(){
			if(BUTTON_EXPORTBILL==null){
				BUTTON_EXPORTBILL = Images.createImageIcons("image/button/导出单据.png");
			}
			return BUTTON_EXPORTBILL;
		}

		public static ImageIcon[] getBUTTON_ADDOR(){
			if(BUTTON_ADDOR==null){
				BUTTON_ADDOR = Images.createImageIcons("image/button/添加机构.png");
			}
			return BUTTON_ADDOR;
		}
		
		public static ImageIcon[] getBUTTON_VIEWOR(){
			if(BUTTON_VIEWOR==null){
				BUTTON_VIEWOR = Images.createImageIcons("image/button/查看机构.png");
			}
			return BUTTON_VIEWOR;
		}
		
		public static ImageIcon[] getBUTTON_DELETEOR(){
			if(BUTTON_DELETEOR==null){
				BUTTON_DELETEOR = Images.createImageIcons("image/button/删除机构.png");
			}
			return BUTTON_DELETEOR;
		}
		
		public static ImageIcon[] getBUTTON_MODIFYOR(){
			if(BUTTON_MODIFYOR==null){
				BUTTON_MODIFYOR = Images.createImageIcons("image/button/修改机构.png");
			}
			return BUTTON_MODIFYOR;
		}
		
	

		public static ImageIcon[] getBUTTON_DELETEBASE(){
			if(BUTTON_DELETEBASE==null){
				BUTTON_DELETEBASE = Images.createImageIcons("image/button/删除常量.png");
			}
			return BUTTON_DELETEBASE;
		}
		
		public static ImageIcon[] getBUTTON_MODIFYBASE(){
			if(BUTTON_MODIFYBASE==null){
				BUTTON_MODIFYBASE = Images.createImageIcons("image/button/修改常量.png");
			}
			return BUTTON_MODIFYBASE;
		}
		
		public static ImageIcon[] getBUTTON_MODIFYPOLICY(){
			if(BUTTON_MODIFYPOLICY==null){
				BUTTON_MODIFYPOLICY = Images.createImageIcons("image/button/修改策略.png");
			}
			return BUTTON_MODIFYPOLICY;
		}
		
		public static ImageIcon[] getBUTTON_DELETEPOLICY(){
			if(BUTTON_DELETEPOLICY==null){
				BUTTON_DELETEPOLICY = Images.createImageIcons("image/button/删除策略.png");
			}
			return BUTTON_DELETEPOLICY;
		}

		public static ImageIcon[] getBUTTON_VIEWACCOUNT(){
			if(BUTTON_VIEWACCOUNT==null){
				BUTTON_VIEWACCOUNT = Images.createImageIcons("image/button/查看员工.png");
			}
			return BUTTON_VIEWACCOUNT;
		}
		
		public static ImageIcon[] getBUTTON_MODIFYACCOUNT(){
			if(BUTTON_MODIFYACCOUNT==null){
				BUTTON_MODIFYACCOUNT = Images.createImageIcons("image/button/修改员工.png");
			}
			return BUTTON_MODIFYACCOUNT;
		}
		
		public static ImageIcon[] getBUTTON_DELETEACCOUNT(){
			if(BUTTON_DELETEACCOUNT==null){
				BUTTON_DELETEACCOUNT = Images.createImageIcons("image/button/删除员工.png");
			}
			return BUTTON_DELETEACCOUNT;
		}
		
		public static ImageIcon[] getBUTTON_CONFIRMADD(){
			if(BUTTON_CONFIRMADD==null){
				BUTTON_CONFIRMADD = Images.createImageIcons("image/button/确认添加.png");
			}
			return BUTTON_DELETEACCOUNT;
		}

		public static ImageIcon[] getBUTTON_CONFIRMMODIFY(){
			if(BUTTON_CONFIRMMODIFY==null){
				BUTTON_CONFIRMMODIFY = Images.createImageIcons("image/button/确认修改.png");
			}
			return BUTTON_CONFIRMMODIFY;
		}
}
