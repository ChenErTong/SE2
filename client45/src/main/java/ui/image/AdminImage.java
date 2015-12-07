
package ui.image;

import javax.swing.ImageIcon;

	/**
	 * @author zsq
	 *
	 */
		public class AdminImage {
			//添加用户
			private static ImageIcon[] BUTTON_ADDUSER = null;
			//修改用户
			private static ImageIcon[] BUTTON_MODIFY = null;
			//查看用户
			private static ImageIcon[] BUTTON_VIEWUSER = null;
			//删除用户
			private static ImageIcon[] BUTTON_DELETEUSER = null;
			//搜索
			private static ImageIcon[] BUTTON_SEARCH = null;
			//确认添加
			private static ImageIcon[] BUTTON_CONFIRMADD = null;
			//确认修改
			private static ImageIcon[] BUTTON_CONFIRMMODIFY = null;
			
			public static ImageIcon[] getBUTTON_ADDUSER(){
				if(BUTTON_ADDUSER == null){
					BUTTON_ADDUSER= Images.createImageIcons("image/button/添加用户.png");
				}
				return BUTTON_ADDUSER;
			}
			
			public static ImageIcon[] getBUTTON_MODIFY(){
				if(BUTTON_MODIFY == null){
					BUTTON_MODIFY = Images.createImageIcons("image/button/修改用户.png");
				}
				return BUTTON_MODIFY;
			}
			
			public static ImageIcon[] getBUTTON_VIEWUSER(){
				if(BUTTON_VIEWUSER == null){
					BUTTON_VIEWUSER = Images.createImageIcons("image/button/查看用户.png");
				}
				return BUTTON_VIEWUSER;
			}
			
			public static ImageIcon[] getBUTTON_DELETEUSER(){
				if(BUTTON_DELETEUSER == null){
					BUTTON_DELETEUSER = Images.createImageIcons("image/button/删除用户.png");
				}
				return BUTTON_DELETEUSER;
			}
			
			public static ImageIcon[] getBUTTON_SEARCH(){
				if(BUTTON_SEARCH == null){
					BUTTON_SEARCH = Images.createImageIcons("image/button/搜索.png");
				}
				return BUTTON_SEARCH;
			}
			
			public static ImageIcon[] getBUTTON_CONFIRMADD(){
				if(BUTTON_CONFIRMADD==null){
					BUTTON_CONFIRMADD = Images.createImageIcons("image/button/确认添加.png");
				}
				return BUTTON_CONFIRMADD;
			}
			
			public static ImageIcon[] getBUTTON_CONFIRMMODIFY(){
				if(BUTTON_CONFIRMMODIFY==null){
					BUTTON_CONFIRMMODIFY = Images.createImageIcons("image/button/确认修改.png");
				}
				return BUTTON_CONFIRMMODIFY;
			}
			
		}
