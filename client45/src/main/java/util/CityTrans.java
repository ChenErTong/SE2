package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CityTrans {
	public static HashMap<String, String> map=null;
	private static void read() {
		map=new HashMap<String, String>();
		BufferedReader bReader=null;
		try {
			 bReader = new BufferedReader(new FileReader("config/city.txt"));
			String line;
			while((line=bReader.readLine())!=null){
				String city=line.split(" ")[0];
				String code=line.split(" ")[1];
				map.put(city, code);
			}
			bReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getCodeByCity(String city){
		if(map==null)
			read();
		String cityCode=map.get(city);
		return cityCode;
	}
	public static String getTransferCode(String city){
		switch(city){
		case "北京市": return "1";
		case "上海市": return "2";
		case "广州市": return "3";
		case "南京市": return "4";
		}
		return "0";
	}
}
