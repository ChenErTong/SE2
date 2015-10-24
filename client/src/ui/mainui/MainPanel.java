package ui.mainui;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

	/**
	 * default serial UID
	 */
	private static final long serialVersionUID = 1L;
	//Buttons,text of buttons and the methods which buttons call
	/**
	 * All Buttons
	 */
	JButton buttons[];
	/**
	 * Text of buttons
	 */
	ArrayList<String> buttonString=new ArrayList<>();
	/**
	 * Methods' names which buttons call
	 */
	ArrayList<String> allMethodNames=new ArrayList<>();
	
	public MainPanel(){
		//Initiate panel
		initPanel();
	}

	private void initPanel() {
		//Set layout to FlowLayout
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//Read data from Config file
		getConfigFromFile();
		//Initiate buttons
		initButtons();
		//Set panel visible
		setVisible(true);
	}

	

	private void getConfigFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("tempUiConfig.txt"));
			String line="";
			//button的text
			String buttonText;
			//相应button要调用的方法名
			String methodName;
			while((line=br.readLine())!=null){
				buttonText=line.split(",")[0];
				methodName=line.split(",")[1];
				buttonString.add(buttonText);
				allMethodNames.add(methodName);
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void initButtons() {
		//获得按钮的个数
		int size=buttonString.size();
		buttons = new JButton[size];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i]=new JButton();
			buttons[i].setText(buttonString.get(i));
			//添加监听类
			buttons[i].addMouseListener(new TestMethodAdapter(allMethodNames.get(i)));
			buttons[i].setVisible(true);
			this.add(buttons[i]);
		}
	}
	
	
	/**
	 * 监听类
	 * @author Ann
	 * 按钮要调用的方法名写在文件里，
	 * 按钮按下时，通过反射机制调用方法，
	 * 方法名在构造监听类时传入
	 */
	class TestMethodAdapter extends MouseAdapter{
		//方法名
		private String methodName;
		
		public TestMethodAdapter(String methodName){
			this.methodName=methodName;
		}
		/**
		 * 通过反射机制调用在MainPanel中的方法
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				//获得MainPanel引用
				MainPanel.this
				//获得MainPanel类
				.getClass()
				//根据方法名和参数列表得到相应方法（测试时参数为空）
				.getMethod(methodName, new Class[]{})
				//调用方法
				.invoke(MainPanel.this, new Object[]{});
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void add(){
		System.out.println("add Something!");
	}
	public void search(){
		System.out.println("search Something!");
	}
}
