package mainFrame_t;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import bean_t.User;
import dao_t.Userdao_t;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class registerFrame extends JFrame {

	//protected static final JOptionPane JOptionPanel = null;
	private JPanel contentPane;
	private JTextField textField;
	private  JPasswordField textField_1;
	private  JPasswordField textField_2;

	/**
	 * Launch the application.
	 */

	public void	paintComponent(Graphics g){//绘制图片
		try{ 
			//URL url = getClass().getResource("/om/mingrisoft/frame/buttonIcons/back.jpg");///com/mingrisoft/frame/buttonIcons/back.jpg
			ImageIcon image = new ImageIcon("src/pics/register.jpg");//918 587
			//solarSystem,pan1,lightblue,flower
			g.drawImage(image.getImage(), 0, 0, this.getWidth(),this.getHeight(),this); 
			}catch(Exception e){} 
		}
	/**
	 * Create the frame.
	 */
	public registerFrame() {
		setFont(new Font("楷体", Font.PLAIN, 20));
		setDefaultCloseOperation(2);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/pics/top2.png"));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(registerFrame.class.getResource("/com/image/下载.jpg")));
		setTitle("注册");
		setBounds(530,180, 289, 359);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 44, 84, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("华文行楷", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(29, 95, 84, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("华文行楷", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(29, 146, 100, 39);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(87, 252, 106, 38);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("我同意注册成为用户");
		rdbtnNewRadioButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(29, 204, 209, 27);
		contentPane.add(rdbtnNewRadioButton);
		
		textField = new JTextField();
		textField.setBounds(114, 51, 113, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new  JPasswordField();
		textField_1.setBounds(114, 102, 113, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEchoChar('*');
		textField_2 = new  JPasswordField();
		textField_2.setBounds(114, 153, 113, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEchoChar('*');
		//注册事件监听
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String user=textField.getText();
				String password=textField_1.getText();
				String rePassword=textField_2.getText();
				User registerUser = new User();		//设置
				registerUser.setPassWord(password);
				registerUser.setUserName(user);
				Userdao_t Userdao = new Userdao_t();
				Userdao.insertUser(registerUser);
				
				if(user.equals("")||password.equals("")||rePassword.equals("")){
					JOptionPane.showMessageDialog(getContentPane(),"请重新确认信息是否完整与正确","注册失败",JOptionPane.OK_OPTION);					
				}
					//JOptionPane.showConfirmDialog(parent,"确实要","退出确认",JOptionPane.OK_OPTION);
					 //String result = (String)JOptionPane.showInputDialog(parent,"请选择一项运动项目","这是运动项目选择对话框",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"踢足球","打篮球","跑步","跳绳"},"跑步");
				else if(rdbtnNewRadioButton.isSelected()!=true){}
				else registerFrame.this.dispose();
												
			}							
		});
	}

	
}
