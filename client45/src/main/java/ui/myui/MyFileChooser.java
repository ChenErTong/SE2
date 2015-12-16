package ui.myui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
/**
 * 文件选择器
 * @author zsq
 * @time 2015年12月15日下午1:23:13
 */
@SuppressWarnings("unused")
public class MyFileChooser {
	
	public MyFileChooser(){
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jfc.setMultiSelectionEnabled(true);
		int returnval = jfc.showDialog(new JLabel(), "导出");
		if(returnval==JFileChooser.APPROVE_OPTION){
			File[] files =jfc.getSelectedFiles();
			String str = "";
			for(File file:files){
				if(file.isDirectory()){
					str = file.getAbsolutePath();
				}else if(file.isFile()){
					str = file.getAbsolutePath()+file.getName();
				}
			}	
		}
	}
}
