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
public class SenderImage {
	//取消
	private static ImageIcon[] BUTTON_QUXIAO = null;
	//搜索
	private static ImageIcon[] BUTTON_SEARCH = null;
	
	public static ImageIcon[] getBUTTON_SEARCH(){
		if(BUTTON_SEARCH==null){
			BUTTON_SEARCH = Images.createImageIcons("image/button/查询.png");
		}
		return BUTTON_SEARCH;
	}
	
	public static ImageIcon[] getBUTTON_QUXIAO(){
		if(BUTTON_QUXIAO==null){
			BUTTON_QUXIAO = Images.createImageIcons("image/button/取消.png");
		}
		return BUTTON_QUXIAO;
	}
}
