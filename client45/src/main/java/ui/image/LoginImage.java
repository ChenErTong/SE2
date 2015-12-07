
package ui.image;

import javax.swing.ImageIcon;

	/**
	 * @author zsq
	 *
	 */
	public class LoginImage {
		//取消
		private static ImageIcon[] BUTTON_QUXIAO = null;
		//登录
		private static ImageIcon[] BUTTON_LOGIN = null;
		//物流查询
		private static ImageIcon[] BUTTON_LOGISTIC = null;
		
		public static ImageIcon[] getBUTTON_LOGIN(){
			if(BUTTON_LOGIN==null){
				BUTTON_LOGIN = Images.createImageIcons("image/button/搜索。png");
			}
			return BUTTON_LOGIN;
		}
		
		public static ImageIcon[] getBUTTON_QUXIAO(){
			if(BUTTON_QUXIAO==null){
				BUTTON_QUXIAO = Images.createImageIcons("image/button/取消。png");
			}
			return BUTTON_QUXIAO;
		}
		
		public static ImageIcon[] getBUTTON_LOGISTIC(){
			if(BUTTON_LOGISTIC==null){
				BUTTON_LOGISTIC = Images.createImageIcons("image/button/查询入口。png");
			}
			return BUTTON_LOGISTIC;
		}
}
