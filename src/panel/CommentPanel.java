package panel;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import dao_t.getCommentBySS;
import bean_t.CommentInf;

public class CommentPanel extends JPanel{
	
	public CommentPanel(){
		//this.setBackground(Color.blue);
		//setSize(631, 420);
		//setBounds(0,0,631,223);
		setLayout(null);
		setBounds(10, 63, 611, 343);
		JLabel singerName = new JLabel("歌手名:");
		JLabel songName = new JLabel("歌曲名:");
		JButton getCommentBtn = new JButton("查询");
		JTextField singerInput = new JTextField();
		JTextField songInput = new JTextField();
		singerName.setBounds(10, 10, 100, 20);
		singerInput.setBounds(60, 10, 200, 30);
		songName.setBounds(270,10,50,20);
		songInput.setBounds(320,10,200,30);
		getCommentBtn.setBounds(530,10,60,30);//550,10,60,30
		getCommentBtn.setFocusPainted(false);
		getCommentBtn.setMargin(new Insets(0,0,0,0));
		add(singerName);
		add(singerInput);
		add(songName);
		add(songInput);
		add(getCommentBtn);
		DefaultTableModel dm = new DefaultTableModel();
		getCommentBySS commentInf = new getCommentBySS();
		dm.setDataVector(new Object[][]{{"","",""}},
                new Object[]{"用户","评论","点赞数"});//新的列名
			dm.removeRow(0);//col竖行，row横行
		JTable table = new JTable(dm);
		
		getCommentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.setRowCount(0);
				String singerStr = singerInput.getText();
				String songStr = songInput.getText();
				List  list = commentInf.getSongCommentTop10(singerStr, songStr);
				System.out.println(list.size());
				 for(int i= 0;i<list.size();i++){								//循环遍历查询结果
					   CommentInf songin = (CommentInf)list.get(i);
					   System.out.println(i+songin.getName());
					   System.out.println(i+songin.getSong());
					   //System.out.println(i +songin.getTotalcomments());
				    	//添加一行到模型结尾，参数为一个对象
					   dm.addRow(new Object[]{songin.getUser(),songin.getComment(),songin.getLikedcount()});		//向表格中添加数据		 	
					 
				 }
				}			
		});
		
		table.setBounds(20, 50, 500, 300);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		JScrollPane scrollPane = new JScrollPane(table);
		//panel_1.add(table);
		add(scrollPane);
		scrollPane.setBounds(1, 50, 610, 290);
	}	
	//寻找超级段子手
	//评论数排行SELECT user,count(comment) from comment GROUP BY user ORDER BY count(comment) DESC;
	//点赞总数排行SELECT user,sum(likedcount) from comment GROUP BY user ORDER BY sum(likedcount) DESC;
	
}
