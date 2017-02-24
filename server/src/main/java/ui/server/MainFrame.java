package ui.server;

import ui.ServerFrame;
import ui.ServerPanel;
import ui.CommonImage;

public class MainFrame extends ServerFrame{
	private static final long serialVersionUID = 1L;

	private ServerPanel StartPanel;
	public MainFrame() {
		super("1");
		
		StartPanel = new StartPanel();
		this.add(StartPanel);
		this.setBackground(CommonImage.BACKGROUND);
		this.repaint();
	}
}