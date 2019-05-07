package mainFrame_t;

//import java.awt.Color;
//import java.awt.Container;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.net.URL;
//
//import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.SwingUtilities;
//import javax.swing.UIManager;
//import javax.swing.plaf.nimbus.NimbusLookAndFeel;
//
//import bean_t.User;
//import dao_t.Userdao_t;
//import mainFrame_t.RemoveFrame_t;
////import panel.EnterPanel;
//import util.Session;
//
//
//public class enwithpic extends JFrame{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private JTextField userNameTextField;
//	private JPasswordField passwordField;
//	private JTextField createField;
//	private JPanel backPanel;
//	private JTextField textField_1;
//	//private EnterPanel enterPanel;
//	/*//创建一个容器  
//    *Container ct;  
//    //创建背景面板。  
//    EnterPanel bgp; */
//	public static void main(String[] args){
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {																					//new NimbusLookAndFeel())是对控件设置字体
//					UIManager.setLookAndFeel(new NimbusLookAndFeel());//这是设置图形界面外观的.java的图形界面外观有3种,默认是java的金属外观,还有就是windows系统,motif系统外观.
//					SwingUtilities.invokeLater(new Runnable() {                    //它们都使事件派发线程上的可运行对象排队。当可运行对象排在事件派发队列的队首时，就调用其run方法。其效果是允许事件派发线程调用另一个线程中的任意一个代码块
//						public void run() {
//							EnterFrame_t mostly = new EnterFrame_t();
//							mostly.setLayout(null);
//							mostly.setVisible(true);
//
//						}
//					});
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	public enwithpic(){		
//		
//		getContentPane().setFont(new Font("宋体", Font.PLAIN, 30));
//		getContentPane().setBackground(Color.WHITE);
//		setResizable(false);
//		setIconImage(Toolkit.getDefaultToolkit().getImage(EnterFrame_t.class.getResource("下载.jpg")));
//		getContentPane().setEnabled(false);
//		setTitle("\u767B\u5F55\u7A97\u53E3");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(700, 280, 591, 395);
//		getContentPane().setLayout(null);
//		
//		JLabel lblNewLabel_1 = new JLabel("用户名");
//		lblNewLabel_1.setFont(new Font("华文行楷", Font.PLAIN, 20));
//		lblNewLabel_1.setBounds(54, 175, 87, 37);
//		getContentPane().add(lblNewLabel_1);
//		
//		textField_1 = new JTextField();
//		textField_1.setEditable(false);
//		textField_1.setFont(new Font("华文行楷", Font.PLAIN, 40));
//		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
//		textField_1.setText("网易云音乐");
//		textField_1.setForeground(Color.WHITE);
//		textField_1.setBackground(new Color(220, 20, 60));
//		textField_1.setBounds(0, 0, 589, 60);
//		getContentPane().add(textField_1);
//		textField_1.setColumns(10);
//		
//		//背景图片设置
//		/*ct=this.getContentPane();
//        bgp=new EnterPanel((new ImageIcon("src/image/2.jpg")).getImage());  
//        bgp.setBounds(0,0,this.getWidth(),this.getHeight());  
//        ct.add(bgp); */
//		
//		JLabel lblNewLabel_2 = new JLabel("密码");
//		lblNewLabel_2.setFont(new Font("华文行楷", Font.PLAIN, 20));
//		lblNewLabel_2.setBounds(69, 238, 72, 37);
//		getContentPane().add(lblNewLabel_2);
//		
//		JButton enterButton = new JButton("登录");
//		enterButton.setFont(new Font("宋体", Font.PLAIN, 20));	
//		enterButton.setBounds(325, 192, 118, 83);
//		getContentPane().add(enterButton);
//		
//		userNameTextField = new JTextField();
//		userNameTextField.setFont(new Font("宋体", Font.PLAIN, 26));
//		userNameTextField.setBounds(145, 173, 133, 40);
//		getContentPane().add(userNameTextField);
//		userNameTextField.setColumns(10);
//		
//		createField = new JTextField();
//		createField.setFont(new Font("华文行楷", Font.PLAIN, 26));
//		createField.setBorder(null);
//		createField.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				//CreateFrame create=new CreateFrame();
//				
//				//create.setVisible(true);
//			}
//		});
//		//textField_2.setBorder(false);
//		createField.setHorizontalAlignment(SwingConstants.LEFT);
//		createField.setEditable(false);
//		createField.setForeground(Color.RED);
//		createField.setBackground(Color.WHITE);
//		createField.setText("没有用户怎么办？点我...");
//		createField.setBounds(54, 310, 307, 40);
//		getContentPane().add(createField);
//		createField.setColumns(10);
//		
//		passwordField = new JPasswordField();
//		passwordField.setEchoChar('*');
//		passwordField.setFont(new Font("宋体", Font.PLAIN, 26));
//		passwordField.setBounds(145, 235, 133, 40);
//		getContentPane().add(passwordField);
//		
//		JLabel lblNewLabel_3 = new JLabel("权限：");
//		lblNewLabel_3.setFont(new Font("华文行楷", Font.PLAIN, 20));
//		lblNewLabel_3.setBounds(54, 107, 72, 40);
//		getContentPane().add(lblNewLabel_3);
//		
//		ButtonGroup buttonGroup=new ButtonGroup();
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("用户");
//		rdbtnNewRadioButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
//		rdbtnNewRadioButton.setSelected(true);
//		rdbtnNewRadioButton.setBackground(Color.WHITE);
//		rdbtnNewRadioButton.setBounds(141, 109, 104, 27);
//		getContentPane().add(rdbtnNewRadioButton);
//		buttonGroup.add(rdbtnNewRadioButton);
//		
//		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("管理员");
//		rdbtnNewRadioButton_1.setFont(new Font("华文行楷", Font.PLAIN, 20));
//		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
//		rdbtnNewRadioButton_1.setBounds(312, 111, 157, 27);
//		getContentPane().add(rdbtnNewRadioButton_1);
//		buttonGroup.add(rdbtnNewRadioButton_1);
//		
//		enterButton.addActionListener(new ActionListener() {		//按钮的单击事件
//			public void actionPerformed(ActionEvent e) {
//				Userdao_t userDao = new Userdao_t();					//创建保存有操作数据库类对象
//				User user = userDao.getUser(userNameTextField.getText(),passwordField.getText());	//以用户添加的用户名与密码为参数调用查询用户方法
//				if(user.getId()>0){					//判断用户编号是否大于0
//					Session.setUser(user);			//设置Session对象的User属性值
//					RemoveFrame_t frame = new RemoveFrame_t();		//创建主窗体对象
//					frame.setVisible(true);			//显示主窗体
//					enwithpic.this.dispose();			//销毁登录窗体
//				}
//				else{								//如果用户输入的用户名与密码错误
//					JOptionPane.showMessageDialog(getContentPane(), "用户名或密码错误");	//给出提示信息
//					userNameTextField.setText("");		//用户名文本框设置为空
//					passwordField.setText("");			//密码文本框设置为空
//				}
//			}
//		});
//	}
//	
//}



import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import bean_t.User;
import dao_t.Userdao_t;
import util.Session;


public class enwithpic extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	private JTextField createField;
	private JPanel backPanel;
	private JTextField textField_1;
	//private EnterPanel enterPanel;
	/*//创建一个容器  
    *Container ct;  
    //创建背景面板。  
    EnterPanel bgp; */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {																					//new NimbusLookAndFeel())是对控件设置字体
					UIManager.setLookAndFeel(new NimbusLookAndFeel());//这是设置图形界面外观的.java的图形界面外观有3种,默认是java的金属外观,还有就是windows系统,motif系统外观.
					SwingUtilities.invokeLater(new Runnable() {                    //它们都使事件派发线程上的可运行对象排队。当可运行对象排在事件派发队列的队首时，就调用其run方法。其效果是允许事件派发线程调用另一个线程中的任意一个代码块
						public void run() {
							enwithpic mostly = new enwithpic();
							mostly.setLayout(null);
							mostly.setVisible(true);

						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public enwithpic(){		
		
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 30));
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/pics/top2.png"));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(EnterFrame_t.class.getResource(".jpg")));
		getContentPane().setEnabled(false);
		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 150, 591, 395);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("用户名");
		lblNewLabel_1.setFont(new Font("华文行楷", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(54, 175, 87, 37);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("华文行楷", Font.PLAIN, 40));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("网易云音乐");
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(new Color(220, 20, 60));
		textField_1.setBounds(0, 0, 589, 60);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		//背景图片设置
		/*ct=this.getContentPane();
        bgp=new EnterPanel((new ImageIcon("src/image/2.jpg")).getImage());  
        bgp.setBounds(0,0,this.getWidth(),this.getHeight());  
        ct.add(bgp); */
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setFont(new Font("华文行楷", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(69, 238, 72, 37);
		getContentPane().add(lblNewLabel_2);
		
		JButton enterButton = new JButton("登录");
		enterButton.setFont(new Font("宋体", Font.PLAIN, 20));	
		enterButton.setBounds(325, 192, 118, 83);
		getContentPane().add(enterButton);
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("宋体", Font.PLAIN, 26));
		userNameTextField.setBounds(145, 173, 133, 40);
		getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);
		
		createField = new JTextField();
		createField.setFont(new Font("华文行楷", Font.PLAIN, 26));
		createField.setBorder(null);
		createField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			/*enwithpic create=new enwithpic();
			registerFrame enterFrame=new registerFrame();
			create.add(enterFrame);
			create.setVisible(true);*/
				registerFrame registerframe = new registerFrame();
				registerframe.setVisible(true);
			}
		});
		//textField_2.setBorder(false);
		createField.setHorizontalAlignment(SwingConstants.LEFT);
		createField.setEditable(false);
		createField.setForeground(Color.RED);
		createField.setBackground(Color.WHITE);
		createField.setText("没有用户怎么办？点我...");
		createField.setBounds(54, 310, 307, 40);
		getContentPane().add(createField);
		createField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("宋体", Font.PLAIN, 26));
		passwordField.setBounds(145, 235, 133, 40);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("权限：");
		lblNewLabel_3.setFont(new Font("华文行楷", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(54, 107, 72, 40);
		getContentPane().add(lblNewLabel_3);
		
		ButtonGroup buttonGroup=new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("用户");
		rdbtnNewRadioButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(141, 109, 104, 27);
		getContentPane().add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("管理员");
		rdbtnNewRadioButton_1.setFont(new Font("华文行楷", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(312, 111, 157, 27);
		getContentPane().add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_1);
		
		enterButton.addActionListener(new ActionListener() {		//按钮的单击事件
			public void actionPerformed(ActionEvent e) {
				Userdao_t userDao = new Userdao_t();					//创建保存有操作数据库类对象
				User user = userDao.getUser(userNameTextField.getText(),passwordField.getText());	//以用户添加的用户名与密码为参数调用查询用户方法
				if(user.getId()!= 1){					//判断用户编号是否大于0
					Session.setUser(user);			//设置Session对象的User属性值
					RemoveFrame_t frame = new RemoveFrame_t();		//创建主窗体对象
					frame.setVisible(true);			//显示主窗体
					enwithpic.this.dispose();			//销毁登录窗体
				}
				else{								//如果用户输入的用户名与密码错误
					JOptionPane.showMessageDialog(getContentPane(), "用户名或密码错误");	//给出提示信息
					userNameTextField.setText("");		//用户名文本框设置为空
					passwordField.setText("");			//密码文本框设置为空
				}
			}
		});
	}
	
}