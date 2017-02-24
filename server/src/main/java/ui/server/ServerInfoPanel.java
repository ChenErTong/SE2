package ui.server;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import ui.MyTranslucentPanel;

public class ServerInfoPanel extends MyTranslucentPanel{


	private static final long serialVersionUID = 1L;
	/** 显示的内容的x坐标 */
	private int x = 50+53;
	/** 显示的内容的y坐标 */
	private int y = 70;
	/** 内容的行间距 */
	private int interval = 30;
	
	private String hostAddr;
	private String hostName;
	private boolean isStarted;

	public ServerInfoPanel(String hostAddr, String hostName) {
		super(200,77,500,506-80-40);
	
		this.hostAddr = hostAddr;
		this.hostName = hostName;
	

	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paint(g2d);
		g2d.setFont(new Font("幼圆",Font.BOLD,24));
		g2d.setColor(new Color(0,0,0,0.6f));
		g2d.drawString("主机地址：" + hostAddr, x, y);
		g2d.drawString("主机名称：" + hostName, x, y + interval);
		if (isStarted) {
			g2d.drawString("主机状态：运行中", x, y + interval * 2);
		} else {
			g2d.drawString("主机状态：关闭", x, y + interval * 2);
		}
		g2d.drawString("运行时间：" + formatTime(hour, minute, second) + "." + millisecond, x, y + interval * 3);
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
		if (isStarted) {
			new Time().start();
		} else {
			resetTime();
		}
		repaint();
	}

	/** 服务器运行的时间 */
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	private int millisecond = 0;

	private void resetTime() {
		hour = 0;
		minute = 0;
		second = 0;
		millisecond = 0;
	}

	/**
	 * 时间格式的转换
	 * @param hour
	 * @param minute
	 * @param second
	 * @return 00:00:00格式
	 */
	private String formatTime(int hour, int minute, int second) {
		String hour_s = String.format("%2d", hour).replace(" ", "0");
		String minute_s = String.format("%2d", minute).replace(" ", "0");
		String second_s = String.format("%2d", second).replace(" ", "0");
		return hour_s + ":" + minute_s + ":" + second_s;
	}

	/**
	 * 计时器
	 */
	private class Time extends Thread {

		@Override
		public void run() {
			while(true) {
				if (!isStarted) {
					resetTime();
					break;
				}
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				millisecond++;
				if (millisecond == 10) {
					millisecond -= 10;
					second++;
					if (second == 60) {
						second -= 60;
						minute++;
						if (minute == 60) {
							minute -= 60;
							hour++;
						}
					}
				}
				repaint();
			}
		}
	}
	
	/**
	 * 睡眠方法
	 * @param time 睡眠时间（毫秒）
	 */
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
