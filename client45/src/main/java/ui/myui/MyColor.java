package ui.myui;

import java.awt.Color;

public class MyColor {
	public static Color color;

	public MyColor(){
		color = new Color(46, 52, 101);
	}
	
	public static void setColor(int i){
		//TODO
		switch(i){
		case 1 : color = new Color(47, 76, 130);break;
		case 2 : color = new Color(113, 55, 73);break;
		case 3 : color = new Color(29, 72, 33);break;
		case 4 : color = new Color(26, 119, 119);break;
		}	
	}
	
	public static Color getColor(){
		return color;
	}
}
