package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* 记录日志的信息类 
* @author Ann
* @version 创建时间：2015年12月4日 下午7:50:07 
*/
public class LogMessage implements Serializable{
	/**
	 * default version UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 使用者姓名
	 */
	public String userName;
	/**
	 * 日志生成时间
	 */
	public String time;
	/**
	 * 日志信息
	 */
	public String message;
	
	
	public LogMessage(String userName, String message) {
		this.userName = userName;
		this.message = message;
		/* 自动生成时间 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		this.time = sdf.format(new Date());
	}
	
	
}
