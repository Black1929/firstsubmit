package mainFrame_t;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import bean_t.SongImf;
import dao_t.GetSongImf;
import panel.CommentPanel;
import panel.MyJPanel_t;
import panel.SongPanel;
import panel.SongPanel2;
import panel.UserPanel;
public class RemoveFrame_t  extends JFrame{

		public static void main(String[] args){
			RemoveFrame_t frame = new RemoveFrame_t();
			frame.setVisible(true);
		}	
	String[] songName = new String[15];
	int[] totalcomments = new int[15];
	private static final long serialVersionUID = 1L;
	private MyJPanel_t contentPane;
	//private BGPanel backPanel;
	private JPanel backPanel;
	private JPanel panel;
	JTextField singerNamePut;
	JLabel fristLabel = new JLabel("歌手信息");
	private JPanel jPanel ; 
	private ButtonGroup buttonGroup = null; 
	JButton singerButton ;
	private JButton songButton ;
	private JButton userButton ;
	private JButton commentButton ;
	private JTextField textField_1;
	JPanel panel_1 = new JPanel();
	JLabel label_1 = new JLabel("您当前的位置是: ");
	
//*******初始化主窗体界面
	public RemoveFrame_t(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 120, 639, 546);//250, 100, 934, 625 最初的大小 //250, 100, 924, 595
		contentPane = new MyJPanel_t();//contentPane对象是一个初始化的面板，且这个对象重写了一个背景图片方法
		setContentPane(contentPane);//getContentPanel（）方法就是默认的面板，因为底层面板是绝对布局
		setTitle("网易云音乐信息查询系统");//所以相当于在底层面板上加了一个任意位置的面板，包括下面的
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/pics/top2.png"));
		contentPane.setLayout(null);//textField_1和四个按钮也是在底层面板上直接加的
		setResizable(false);//****所以除了整个frame中要变换的部分，放在一个panel中，其他的只要放在底层
		contentPane.add(getContentPanel()); //panel中就行了，就不用写那么多panel了，当然不怕麻烦，也可以
		//contentPane.add(getJPanel()); 			一一实现，最后加到底层panel中
		singerButton = new JButton("歌手");
		songButton = new JButton("歌曲");
		userButton = new JButton("用户");
		commentButton = new JButton("评论");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("华文行楷", Font.PLAIN, 40));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("网易云音乐");
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(new Color(220, 20, 60));
		textField_1.setBounds(0, 0, 639, 60);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		singerButton.setBounds(0, 60, 158, 40);
		songButton.setBounds(159, 60, 158, 40);
		userButton.setBounds(318, 60, 158, 40);
		commentButton.setBounds(477,60, 168, 40);
		
		contentPane.add(commentButton);
		contentPane.add(singerButton);
		contentPane.add(userButton);
		contentPane.add(songButton);
		singerButton.setFont(new Font("华文行楷", Font.PLAIN, 26));
		singerButton.setMargin(new Insets(0,0,0,0));
		songButton.setMargin(new Insets(0,0,0,0));
		commentButton.setMargin(new Insets(0,0,0,0));
		userButton.setMargin(new Insets(0,0,0,0));//按钮中的文字 对上下左右四个方向的边距取零
		userButton.setBackground(new Color(83,207,206));
		songButton.setBackground(new Color(83,207,206)); //67,68,68
		singerButton.setBackground(new Color(83,207,206));
		commentButton.setBackground(new Color(83,207,206));
		singerButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
		songButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
		userButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
		commentButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
		singerButton.setFocusPainted(false);
		songButton.setFocusPainted(false);
		userButton.setFocusPainted(false);
		commentButton.setFocusPainted(false);
		

		singerButton.addActionListener(new toolsButtonActionAdapter());
		songButton.addActionListener(new toolsButtonActionAdapter());
		userButton.addActionListener(new toolsButtonActionAdapter());
		commentButton.addActionListener(new toolsButtonActionAdapter());

		// 把所有按钮添加到一个组控件中

		singerButton.addMouseListener( new toolsButtonMouseAdapter());
		songButton.addMouseListener(new toolsButtonMouseAdapter());
		userButton.addMouseListener(new toolsButtonMouseAdapter());
		commentButton.addMouseListener(new toolsButtonMouseAdapter());
		//contentPane.add(songButton);
		
	}
	
	//*************默认的初始显示面板，返回一个面板，即这儿的backPanel
	private JPanel getContentPanel() {		
		if (backPanel == null) {
			backPanel = new JPanel();
			backPanel.setBackground(new Color(71,201,223));//71,201,223 198,47,47 160 
			backPanel.setSize(639, 486); // 内容显示区主面板629, 416
			//backPanel.setLocation(279, 149);
			backPanel.setLocation(0, 101);
			backPanel.setLayout(null);
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setVerticalAlignment(SwingConstants.BOTTOM);
			//label_1.setFont(new Font("华文行楷", Font.PLAIN, 18));
			//label_1.setForeground(Color.white);
			label_1.setBounds(0, 25, 112, 15);//38, 38, 96, 15 //10, 38, 110, 15
			backPanel.add(label_1);		
			fristLabel.setBounds(114, 25, 123, 15);//133, 38, 123, 15
			backPanel.add(fristLabel);
			JLabel singerName = new JLabel("歌手名：");
			//fristLabel.setForeground(Color.white);
			singerName.setBounds(10, 10, 100, 20);
//			JPanel panel_1 = new JPanel();
		
			panel_1.setLayout(null);
			//panel_1.setBackground(Color.red);
			panel_1.setBounds(10, 63, 611, 343);//10, 63, 611, 343
			panel_1.add(singerName);
			//backPanel.add(panel_1);
			singerNamePut = new JTextField();
			singerNamePut.setBounds(80, 10, 200, 30);
			panel_1.add(singerNamePut);
			JButton selectButton = new JButton("查询");
			selectButton.setBounds(300, 10,100, 30);
			selectButton.setFocusPainted(false);
			selectButton.setMargin(new Insets(0,0,0,0));
			panel_1.add(selectButton);
			JButton showSongPic = new JButton("图形展示");
			showSongPic.setBounds(450, 10, 100, 30);
			showSongPic.setMargin(new Insets(0,0,0,0));
			showSongPic.setFocusPainted(false);
			panel_1.add(showSongPic);
			DefaultTableModel dm = new DefaultTableModel();
			GetSongImf songimf = new GetSongImf();
			//JScrollPane scrollPane = new JScrollPane(table);
			//scrollPane.setBounds(43, 116, 520, 211);
			//add(scrollPane);	
			//具体的表格内容
			//Object[][] 数组中的第一个索引是行索引，第二个索引是列索引。
			//参数：
			//data - 表的数据
			//columnNames - 列的名称
			//第行个全是空字符串？
			//"","","","","","","",""
		    dm.setDataVector(new Object[][]{{"","","","",""}},
                new Object[]{"姓名","歌曲名","总评论数","热评数","点赞数"});//新的列名
			dm.removeRow(0);//col竖行，row横行
			JTable table = new JTable(dm);
			
			selectButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dm.setRowCount(0);			//将表格内容清空
				//	String condition = comboBox.getSelectedItem().toString();		//获取用户选择的查询条件
					String conditionText =singerNamePut.getText();			//获取用户添加的查询条件
					
													//如果用户选择按货品名称进行搜索
					   List list = songimf.getCommentTop10(conditionText);			//调用按货品名称查询数据方法
					   System.out.println(list.size());
					   for(int i= 0;i<list.size();i++){								//循环遍历查询结果
						   SongImf songin = (SongImf)list.get(i);
							//String oid = stock.getOrderId();						//获取订单号信息
					    	//int id = dao.selectJoinStockByOid(oid);	    			//根据订单号查询入库信息	
						   //如果该订单的货品在入库表中不存在
						   System.out.println(i+songin.getName());
						   System.out.println(i+songin.getSong());
						   System.out.println(i +songin.getTotalcomments());
					    	//添加一行到模型结尾，参数为一个对象
						   dm.addRow(new Object[]{songin.getName(),songin.getSong(),songin.getTotalcomments(),songin.getTotalhotcomments(),songin.getAllLikedCount()});		//向表格中添加数据		 	
					   }
					   int a = dm.getRowCount();
					   int b  = dm.getColumnCount();
					   String f = dm.getColumnName(4);
					//   Object c = dm.getValueAt(0, 1);
					  // String d = c.toString();
					   System.out.println("长度是"+a);
					   System.out.println("列数度是"+b);
					  // System.out.println("这个单位的值是"+d);
					   System.out.println("这个单位的值是"+f);
					   for(int i = 0; i<15; i ++){
						   Object col4;
							 col4 = table.getModel().getValueAt(i,1);//获取第四列的值
							String col4toString = col4.toString();
							System.out.println(col4toString);
							songName[i] = col4toString;
							}
					   for(int i = 0; i<15; i ++){
						   Object col2;
							 col2 = table.getModel().getValueAt(i,2);//获取第四列的值
							int col2toint = (int) (col2);
							System.out.println(col2toint);
							totalcomments[i] = col2toint;
							}					   
					   for(int i=0;i<15;i++){
						   System.out.println(songName[i]);
					   }
					   //这里是一个绘制图形的代码					     					 
				}});
			showSongPic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CategoryDataset dataset = getDataSet(); //createBarChart3D
				    JFreeChart chart = ChartFactory.createBarChart( 
				               "评论数量", // 图表标题 
				              "", // 目录轴的显示标签 
				              "数量", // 数值轴的显示标签 
				              dataset, // 数据集 
				              PlotOrientation.VERTICAL, // 图表方向：水平、垂直 
				              true,      // 是否显示图例(对于简单的柱状图必须是false) 
				              false,     // 是否生成工具 
				              false      // 是否生成URL链接 
				              ); 
				    //从这里开始 
				    CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象 
				    CategoryAxis domainAxis=plot.getDomainAxis();     //水平底部列表 
				     domainAxis.setLabelFont(new Font("黑体",Font.BOLD,8));     //水平底部标题 
				     domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,8)); //垂直标题 
				     ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状 
				     rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15)); 
				     chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15)); 
				     chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体 
				     //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题 
				   //  frame1=new ChartPanel(chart,true);    //这里也可以用chartFrame,可以直接生成一个独立的Frame 
				     ChartFrame chartFrame=new ChartFrame("网易云音乐数据图",chart); 
				     chartFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/pics/top2.png"));
				     chartFrame.pack(); //以合适的大小展现图形
				     chartFrame.setBounds(300, 50, 900, 600);
				     chartFrame.setBackground(Color.RED);
				     chartFrame.setVisible(true);//图形是否可见
				     
				}
			});
			String g = table.getColumnName(4);
			TableCellRenderer h = table.getCellRenderer(1, 2);
			String l = h.toString();
			table.setBounds(20, 50, 500, 300);//20, 50, 200, 300
			JScrollPane scrollPane = new JScrollPane(table);
			//panel_1.add(table);
			
			panel_1.add(scrollPane);
			scrollPane.setBounds(1, 50, 610, 290);//20, 50, 500, 200  1, 50, 610, 250
			System.out.println("table的列"+g);
			System.out.println("table的列"+l);
			backPanel.add(panel_1);
					   }
		return backPanel;
	}
    public  CategoryDataset getDataSet() { 
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
    for(int i = 0;i < 15;i++){
    	dataset.addValue(totalcomments[i], "",songName[i]);
    }			         
    return dataset; 
} 

    		
	 class toolsButtonMouseAdapter implements MouseListener{
		 public void mouseClicked(MouseEvent e){ 
			 if (e.getSource() == songButton) {//找到e的来源
					songButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
					songButton.setBackground(new Color(198,47,47));
				}
		 }
		 public void mouseExited(MouseEvent e){		
			 if (e.getSource() == singerButton) {//找到e的来源
					singerButton.setBackground(new Color(83,207,206));
					//Font f=new Font("楷体",Font.CENTER_BASELINE,15);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
				singerButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
					//singerButton.setFont(f);
				}
			 if (e.getSource() == songButton) {//找到e的来源
					songButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
					songButton.setBackground(new Color(83,207,206));
				}
			 if (e.getSource() == userButton) {//找到e的来源
					userButton.setBackground(new Color(83,207,206));
					userButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
				}
			 if (e.getSource() == commentButton) {//找到e的来源
					commentButton.setBackground(new Color(83,207,206));
					commentButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
				}
		 } 
		public void mouseEntered(MouseEvent e){
			if (e.getSource() == singerButton) {//找到e的来源
				singerButton.setBackground(new Color(198,47,47));
				singerButton.setBorderPainted(false);
			}
			if (e.getSource() == songButton) {
				songButton.setBackground(new Color(198,47,47));
				songButton.setBorderPainted(false);
			}
			if (e.getSource() == userButton) {
				userButton.setBackground(new Color(198,47,47));
				userButton.setBorderPainted(false);
			}
			if (e.getSource() == commentButton) {
				commentButton.setBackground(new Color(198,47,47));
				commentButton.setBorderPainted(false);
			}
		}
		public void mouseReleased(MouseEvent e){
			if (e.getSource() == singerButton) {//找到e的来源
				singerButton.setBackground(new Color(198,47,47));
			}
		}
		public void mousePressed(MouseEvent e){
			if (e.getSource() == singerButton) {//找到e的来源
				singerButton.setBackground(new Color(198,47,47));
			}
			if (e.getSource() == songButton) {//找到e的来源
				songButton.setBackground(new Color(198,47,47));
			}
			if (e.getSource() == userButton) {//找到e的来源
				userButton.setBackground(new Color(198,47,47));
			}
			if (e.getSource() == commentButton) {//找到e的来源
				commentButton.setBackground(new Color(198,47,47));
			}
		}
	}
	class toolsButtonActionAdapter implements ActionListener { //按钮的监听器
//内部类
		@Override
	//对多个事件进行同时处理
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == singerButton) {//找到e的来源
				backPanel.removeAll();
				backPanel.add(label_1);
				fristLabel.setBounds(114, 25, 123, 15);
				backPanel.add(fristLabel);
				panel_1.setBounds(10, 63, 611, 343);
				backPanel.add(panel_1);  //panel_1原来是拿来放第一块主要面板的
				fristLabel.setText("歌手");
				repaint();
			}
			if (e.getSource() == songButton) {
				backPanel.removeAll();		//先清除面板上面的东西，再逐步添加，比如label_1的东西
				backPanel.add(label_1);
				fristLabel.setBounds(114, 25, 123, 15);
				backPanel.add(fristLabel);
				//panel_1.setBounds(10, 63, 611, 393);
				SongPanel2 stockPanl = new SongPanel2();//.这里加载进了stockPanel
				fristLabel.setText("歌曲");
				backPanel.add(stockPanl);
				repaint();//repaint()这个方法是一个具有刷新页面效果的方法，如果你要页面进行重画就可以调用;repaint()通过调用线程再由线程去调用update()方法清除当前显示并再调用paint()方法进行绘制下一个需要显示的内容
			}
			if (e.getSource() == userButton) {
				backPanel.removeAll();
				backPanel.add(label_1);
				fristLabel.setBounds(114, 25, 123, 15);
				backPanel.add(fristLabel);
				//panel_1.setBounds(10, 63, 611, 343);//10, 63, 611, 386
				UserPanel userPanel = new UserPanel();
				backPanel.add(userPanel);
				fristLabel.setText("用户");
				repaint();
			}
			if (e.getSource() ==commentButton) {
				backPanel.removeAll();
				backPanel.add(label_1);
				fristLabel.setBounds(114, 25, 123, 15);
				backPanel.add(fristLabel);
				panel_1.setBounds(10, 63, 611, 386);
				CommentPanel commentPanel = new CommentPanel();
				backPanel.add(commentPanel);
				fristLabel.setText("用户评论");
				repaint();
			}
		
		}

	}
			}
