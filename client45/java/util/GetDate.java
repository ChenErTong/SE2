package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	/**
	 * 得到当前时间
	 * @return 当前时间
	 */
	public static String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
		return df.format(new Date());
	}
	
	/**
	 * 得到当前日期
	 * @return 当前日期
	 */
	public static String getDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
}
