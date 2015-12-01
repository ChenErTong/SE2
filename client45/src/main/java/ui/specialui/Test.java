package ui.specialui;

public class Test {

	public static void main(String[] args) {
		String s = "编号：" + "123456789" + "\t日期：" + "2015-02-29";
		String[] ss = s.split("\t");
		for (String string : ss) {
			System.out.println(string.substring(3));
		}
	}
}
