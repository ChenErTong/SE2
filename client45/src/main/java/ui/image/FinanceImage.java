/**
 * @author
 * @version
 */
package ui.image;

import javax.swing.ImageIcon;

/**
 * @author zsq
 *
 */
	public class FinanceImage {
			//结算管理
			private static ImageIcon[] BUTTON_JIESUAN = null;
			//成本管理
			private static ImageIcon[] BUTTON_COST = null;
			//银行账户
			private static ImageIcon[] BUTTON_BANK = null;
			//期初建账
			private static ImageIcon[] BUTTON_QICHU = null;
			//经营情况表
			private static ImageIcon[] BUTTON_JINGYING = null;
			//成本收益
			private static ImageIcon[] BUTTON_CHENGBEN = null;
			//系统日志
			private static ImageIcon[] BUTTON_LOG = null;
			//合计收款单
			private static ImageIcon[] BUTTON_HEJISHOUKUAN = null;
			//查看所选收款单
			private static ImageIcon[] BUTTON_VIEWDEBIT = null;
			//搜索
			private static ImageIcon[] BUTTON_SEARCH = null;
			
			
			public static ImageIcon[] getBUTTON_JIESUAN(){
				if(BUTTON_JIESUAN == null){
					BUTTON_JIESUAN= Images.createImageIcons("image/button/结算管理.png");
				}
				return BUTTON_JIESUAN;
			}
			
			public static ImageIcon[] getBUTTON_COST(){
				if(BUTTON_COST == null){
					BUTTON_COST = Images.createImageIcons("image/button/成本管理.png");
				}
				return BUTTON_COST;
			}
			
			public static ImageIcon[] getBUTTON_BANK(){
				if(BUTTON_BANK == null){
					BUTTON_BANK = Images.createImageIcons("image/button/银行账户.png");
				}
				return BUTTON_BANK;
			}
			
			public static ImageIcon[] getBUTTON_QICHU(){
				if(BUTTON_QICHU == null){
					BUTTON_QICHU = Images.createImageIcons("image/button/期初建账.png");
				}
				return BUTTON_QICHU;
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
			
			public static ImageIcon[] getButton_HEJISHOUKUAN(){
				if(BUTTON_HEJISHOUKUAN==null){
					BUTTON_HEJISHOUKUAN = Images.createImageIcons("image/button/合计收款.png");
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
					BUTTON_SEARCH = Images.createImageIcons("image/button/搜索。png");
				}
				return BUTTON_SEARCH;
			}
}
