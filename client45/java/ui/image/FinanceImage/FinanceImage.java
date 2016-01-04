/**
 * @author
 * @version
 */
package ui.image.FinanceImage;

import javax.swing.ImageIcon;

import ui.image.Images;

/**
 * @author zsq
 *
 */
	public class FinanceImage {
			//结算管理
			private static ImageIcon[] BUTTON_JIESUAN = null;
			private static ImageIcon[] BUTTON_JIESUAN_ = null;
			//成本管理
			private static ImageIcon[] BUTTON_COST = null;
			private static ImageIcon[] BUTTON_COST_ = null;
			//银行账户
			private static ImageIcon[] BUTTON_BANK = null;
			private static ImageIcon[] BUTTON_BANK_ = null;
			//期初建账
			private static ImageIcon[] BUTTON_QICHU = null;
			private static ImageIcon[] BUTTON_QICHU_ = null;
			//经营情况表
			private static ImageIcon[] BUTTON_JINGYING = null;
			private static ImageIcon[] BUTTON_JINGYING_ = null;
			//成本收益
			private static ImageIcon[] BUTTON_CHENGBEN = null;
			private static ImageIcon[] BUTTON_CHENGBEN_ = null;
			//系统日志
			private static ImageIcon[] BUTTON_LOG = null;
			private static ImageIcon[] BUTTON_LOG_ = null;
			//合计收款单
			private static ImageIcon[] BUTTON_HEJISHOUKUAN = null;
			//查看所选收款单
			private static ImageIcon[] BUTTON_VIEWDEBIT = null;
			//搜索
			private static ImageIcon[] BUTTON_SEARCH = null;
			//查看所选收款单
			private static ImageIcon[] BUTTON_VIEWPAY = null;
			//删除收款单
			private static ImageIcon[] BUTTON_MODIFYPAY = null;
			//查看期初建账
			private static ImageIcon[] BUTTON_VIEWSTOCK = null;
			//新增期初建账
			private static ImageIcon[] BUTTON_ADDSTOCK = null;
			//预览
			private static ImageIcon[] BUTTON_VIEW = null;
			//导出经营情况表
			private static ImageIcon[] BUTTON_EXPORTBUSINESS = null;
			//导出成本收益表
			private static ImageIcon[] BUTTON_EXPORTINCOME = null;
			
			public static ImageIcon[] getBUTTON_JIESUAN(){
				if(BUTTON_JIESUAN == null){
					BUTTON_JIESUAN= Images.createImageIcons("image/button/结算管理.png");
				}
				return BUTTON_JIESUAN;
			}
			public static ImageIcon[] getBUTTON_JIESUAN_(){
				if(BUTTON_JIESUAN_ == null){
					BUTTON_JIESUAN_= Images.createImageIcons("image/button/结算导航.png");
				}
				return BUTTON_JIESUAN_;
			}
			
			public static ImageIcon[] getBUTTON_COST(){
				if(BUTTON_COST == null){
					BUTTON_COST = Images.createImageIcons("image/button/成本管理.png");
				}
				return BUTTON_COST;
			}
			
			public static ImageIcon[] getBUTTON_COST_(){
				if(BUTTON_COST_ == null){
					BUTTON_COST_ = Images.createImageIcons("image/button/成本导航.png");
				}
				return BUTTON_COST_;
			}
			
			public static ImageIcon[] getBUTTON_BANK(){
				if(BUTTON_BANK == null){
					BUTTON_BANK = Images.createImageIcons("image/button/银行账户管理.png");
				}
				return BUTTON_BANK;
			}
			
			public static ImageIcon[] getBUTTON_BANK_(){
				if(BUTTON_BANK_ == null){
					BUTTON_BANK_ = Images.createImageIcons("image/button/银行账户导航.png");
				}
				return BUTTON_BANK_;
			}
			
			public static ImageIcon[] getBUTTON_QICHU(){
				if(BUTTON_QICHU == null){
					BUTTON_QICHU = Images.createImageIcons("image/button/期初建账管理.png");
				}
				return BUTTON_QICHU;
			}
			public static ImageIcon[] getBUTTON_QICHU_(){
				if(BUTTON_QICHU_ == null){
					BUTTON_QICHU_ = Images.createImageIcons("image/button/期初建账导航.png");
				}
				return BUTTON_QICHU_;
			}
			
			public static ImageIcon[] getButton_JINGYING(){
				if(BUTTON_JINGYING==null){
					BUTTON_JINGYING = Images.createImageIcons("image/button/经营情况表.png");
				}
				return BUTTON_JINGYING;
			}
			
			public static ImageIcon[] getButton_JINGYING_(){
				if(BUTTON_JINGYING_==null){
					BUTTON_JINGYING_ = Images.createImageIcons("image/button/经营情况导航.png");
				}
				return BUTTON_JINGYING_;
			}
			
			public static ImageIcon[] getButton_CHENGBEN(){
				if(BUTTON_CHENGBEN==null){
					BUTTON_CHENGBEN = Images.createImageIcons("image/button/成本收益表.png");
				}
				return BUTTON_CHENGBEN;
			}
			
			public static ImageIcon[] getButton_CHENGBEN_(){
				if(BUTTON_CHENGBEN_==null){
					BUTTON_CHENGBEN_ = Images.createImageIcons("image/button/成本收益导航.png");
				}
				return BUTTON_CHENGBEN_;
			}
			
			public static ImageIcon[] getButton_LOG(){
				if(BUTTON_LOG==null){
					BUTTON_LOG = Images.createImageIcons("image/button/记录日志.png");
				}
				return BUTTON_LOG;
			}
			
			public static ImageIcon[] getButton_LOG_(){
				if(BUTTON_LOG_==null){
					BUTTON_LOG_ = Images.createImageIcons("image/button/系统日志导航.png");
				}
				return BUTTON_LOG_;
			}
			
			public static ImageIcon[] getButton_HEJISHOUKUAN(){
				if(BUTTON_HEJISHOUKUAN==null){
					BUTTON_HEJISHOUKUAN = Images.createImageIcons("image/button/合计收款单.png");
				}
				return BUTTON_HEJISHOUKUAN;
			}
			
			public static ImageIcon[] getBUTTON_VIEWDEBIT(){
				if(BUTTON_VIEWDEBIT==null){
					BUTTON_VIEWDEBIT = Images.createImageIcons("image/button/查看收款单.png");
				}
				return BUTTON_VIEWDEBIT;
			}
			
			public static ImageIcon[] getBUTTON_SEARCH(){
				if(BUTTON_SEARCH==null){
					BUTTON_SEARCH = Images.createImageIcons("image/button/搜索.png");
				}
				return BUTTON_SEARCH;
			}
			
			public static ImageIcon[] getBUTTON_VIEWPAY(){
				if(BUTTON_VIEWPAY==null){
					BUTTON_VIEWPAY = Images.createImageIcons("image/button/查看付款单.png");
				}
				return BUTTON_VIEWPAY;
			}
			
			public static ImageIcon[] getBUTTON_MODIFYPAY(){
				if(BUTTON_MODIFYPAY==null){
					BUTTON_MODIFYPAY = Images.createImageIcons("image/button/修改付款单.png");
				}
				return BUTTON_MODIFYPAY;
			}
			
			public static ImageIcon[] getBUTTON_VIEWSTOCK(){
				if(BUTTON_VIEWSTOCK==null){
					BUTTON_VIEWSTOCK = Images.createImageIcons("image/button/查看期初建账.png");
				}
				return BUTTON_VIEWSTOCK;
			}
			
			public static ImageIcon[] getBUTTON_ADDSTOCK(){
				if(BUTTON_ADDSTOCK==null){
					BUTTON_ADDSTOCK = Images.createImageIcons("image/button/期初建账.png");
				}
				return BUTTON_ADDSTOCK;
			}
			
			public static ImageIcon[] getBUTTON_VIEW(){
				if(BUTTON_VIEW==null){
					BUTTON_VIEW = Images.createImageIcons("image/button/预览.png");
				}
				return BUTTON_VIEW;
			}
			
			public static ImageIcon[] getBUTTON_EXPORTBUSINESS(){
				if(BUTTON_EXPORTBUSINESS==null){
					BUTTON_EXPORTBUSINESS = Images.createImageIcons("image/button/导出经营.png");
				}
				return BUTTON_EXPORTBUSINESS;
			}
			
			public static ImageIcon[] getBUTTON_EXPORTINCOME(){
				if(BUTTON_EXPORTINCOME==null){
					BUTTON_EXPORTINCOME = Images.createImageIcons("image/button/导出成本.png");
				}
				return BUTTON_EXPORTINCOME;
			}
}			
