package ui.image;

import java.awt.Image;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {
	//根据路径导入图片ImageIcon
	protected static ImageIcon createImageIcon(String path){
		ImageIcon icon = new ImageIcon(path);
		return icon;
	}
	
	/**
	 * 返回按钮图片组
	 * @param path三张图片的地址，例如"xxx.png"，则三张图片名称分别为"xxx1.png"、"xxx2.png"、"xxx3.png"
	 * @return
	 */
	public static ImageIcon[] createImageIcons(String path){
		ImageIcon[] icons = new ImageIcon[3];
		for(int i = 0; i < 3; i++){
			String[] paths = path.split("\\.");
			icons[i] = new ImageIcon(paths[0] + Integer.toString(i + 1) + "." + paths[1]);
		}
		return icons;
	}
		
	//根据路径导入图片Image
	protected static Image createImage(String path) {
		try { 
			Image image = ImageIO.read(new FileInputStream(path));
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
