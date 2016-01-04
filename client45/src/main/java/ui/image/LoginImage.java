
package ui.image;

import javax.swing.ImageIcon;

	/**
	 * @author zsq
	 *
	 */
	public class LoginImage {
		//登录
		private static ImageIcon[] BUTTON_LOGIN = null;
		//物流查询
		private static ImageIcon[] BUTTON_LOGISTIC = null;
		
		public static ImageIcon[] getBUTTON_LOGIN(){
			if(BUTTON_LOGIN==null){
				BUTTON_LOGIN = Images.createImageIcons("image/button/登录.png");
			}
			return BUTTON_LOGIN;
		}
		
		public static ImageIcon[] getBUTTON_LOGISTIC(){
			if(BUTTON_LOGISTIC==null){
				BUTTON_LOGISTIC = Images.createImageIcons("image/button/物流信息查询.png");
			}
			return BUTTON_LOGISTIC;
		}
}