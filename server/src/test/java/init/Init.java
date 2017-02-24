package init;

import java.io.File;

import config.XMLReader;

/** 
* 程序的简单说明 
* @author Ann
* @version 创建时间：2015年12月13日 下午8:48:17 
*/
public class Init {
	public static void main(String[] args) {
		File folder = new File("config");
		File[] files = folder.listFiles();
		for (File file : files) {
			if(file.getName().endsWith("rmi.xml"))
				continue;
			XMLReader reader = new XMLReader(file.getPath());
			reader.setValue("maxID", "0");
		}
		File datafolder = new File("data");
		files = datafolder.listFiles();
		for (File file : files) {
			file.delete();
		}
	}
}
