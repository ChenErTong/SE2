package util;

public class Util {
	/**
	 * 将int转化成String
	 * @param number 数字
	 * @param bit 转成String的位数,不足以0补齐
	 * @return 转化后的String
	 * @author Ann
	 */
	public static String transIntToString(int number,int bit){
		String res = Integer.toString(number);
		for(int i = res.length(); i < bit; i++) {
			res = 0 + res;
		}
		return res;
	}
	public static String max(int maxbit){
		String res = "";
		for (int i = 0; i < maxbit; i++) {
			res+=9;
		}
		return res;
	}
}
