package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerSaveAndLoad<E> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<E> poList;
	private String fileName;
	@SuppressWarnings("unchecked")
	private void load(){
		/* 没有该文件夹就创建 */
		File dataFolder = new File("data");
		if (!dataFolder.isDirectory()) {
			dataFolder.mkdirs();
		}
		/* 如果没有该文件就创建 */
		File dataFile = new File(fileName);
		if (!dataFile.isFile()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 判断文件是否为空
		/* 这块用来修复文件里什么内容都没有的时候读出数据错误的bug */
		if (dataFile.length() == 0) {
			return;
		}
		/* 从文件中读取数据 */
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(dataFile));
			poList = (ArrayList<E>)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void save(){
		/* 将商品集合存入文件中 */
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(poList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public SerSaveAndLoad(String fileName) {
		this.fileName = fileName;
		this.load();
	}
}
