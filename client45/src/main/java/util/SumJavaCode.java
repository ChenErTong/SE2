package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author jun
 * @author Ann
 */
public class SumJavaCode {

	static long normalLines = 0; // 代码行
	static long commentLines = 0; // 注释行
	static long whiteLines = 0; // 空行
	static int count=0;

	public static void main(String[] args) {
		SumJavaCode sjc = new SumJavaCode();
		File f = new File("D:/SE2/client45");
		System.out.println(f.getName());
		sjc.treeFile(f);
		System.out.println("空行" + whiteLines);
		System.out.println("注释行" + commentLines);
		System.out.println("代码行" + normalLines);
		System.out.println("总计"+(whiteLines+commentLines+normalLines));
	}

	private void treeFile(File f) {

		File[] childs = f.listFiles();
		for (int i = 0; i < childs.length; i++) {
			if (!childs[i].isDirectory()) {
				if (childs[i].getName().matches(".*\\.java$")) {
					count ++;
					System.out.println(count+childs[i].getName());
					sumCode(childs[i]);
				}
			} else {
				treeFile(childs[i]);
			}
		}
	}

	private void sumCode(File file) {
		BufferedReader br = null;
		boolean comment = false;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			try {
				while ((line = br.readLine()) != null) {
					line = line.trim();
					if (line.matches("^[//s&&[^//n]]*$")) {
						whiteLines++;
					} else if (line.startsWith("/*") && !line.endsWith("*/")) {
						commentLines++;
						comment = true;
					} else if (true == comment) {
						commentLines++;
						if (line.endsWith("*/")) {
							comment = false;
						}
					} else if (line.startsWith("//")) {
						commentLines++;
					} else {
						normalLines++;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
