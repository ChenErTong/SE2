package ui.myui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
/**
 * 文件选择器
 * @author zsq
 * @time 2015年12月15日下午1:23:13
 */
public class MyFileChooser {
	public String str;
	public MyFileChooser(){
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setMultiSelectionEnabled(true);
		int returnval = jfc.showDialog(new JLabel(), "导出");
		if(returnval==JFileChooser.APPROVE_OPTION){
			File[] files =jfc.getSelectedFiles();
			str = "";
			for(File file:files){
				str = file.getAbsolutePath();
			}
		//	System.out.println(str);
		}
	}
	
}
