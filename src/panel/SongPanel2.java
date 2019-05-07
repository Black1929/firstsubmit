package panel;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bean_t.SongImf;
import dao_t.GetSongImf;
public class SongPanel2 extends JPanel{
	JTable table;
	public SongPanel2(){
		setLayout(null);
		setBounds(10, 63, 611, 343);
		JLabel singerName = new JLabel("用户评价最高的歌曲：");

		String[] selectItem = {"单曲评论数最多","单曲获赞数最多","综合排名"};
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(false);
		comboBox.setMaximumRowCount(3);
		comboBox.insertItemAt("单曲评论数最多",0);
		comboBox.insertItemAt("单曲获赞数最多",1);
		//comboBox.insertItemAt("单曲评论数最多",2)
		comboBox.insertItemAt("综合排名",1);
		comboBox.setSelectedItem("单曲评论数最多");
		comboBox.setBounds(180, 10, 100, 30);
		add(comboBox);
		
		JButton songBtn = new JButton("搜索");
		singerName.setBounds(10, 10, 200, 20);
		songBtn.setBounds(300, 10, 100, 30);
		songBtn.setFocusPainted(false);
		songBtn.setMargin(new Insets(0,0,0,0));
		add(singerName);
		add(songBtn);
			
		DefaultTableModel dm = new DefaultTableModel();
		GetSongImf getbestsong = new GetSongImf();
		
		songBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1 = comboBox.getSelectedItem().toString();
				dm.setRowCount(0);
				if(str1.matches("综合排名")){
					dm.setDataVector(new Object[][]{{"","","",""}},new Object[]{"名次","歌手","歌曲","综合值"});//新的列名
					dm.removeRow(0);//col竖行，row横行
					table = new JTable(dm);
					List  list1 = getbestsong.getBestSong();
					System.out.println(list1.size());
					for(int i= 0;i<list1.size();i++){								//循环遍历查询结果
						   SongImf bestsong = (SongImf)list1.get(i);
						   System.out.println(i+bestsong.getName());
						   System.out.println(i+bestsong.getSong());
						   //System.out.println(i +songin.getTotalcomments());
					    	//添加一行到模型结尾，参数为一个对象
						   dm.addRow(new Object[]{i+1,bestsong.getName(),bestsong.getSong(),bestsong.getScore()});		//向表格中添加数据												 
					}				
				}else if(str1.matches("单曲评论数最多")){
					dm.setDataVector(new Object[][]{{"","","",""}}, new Object[]{"名次","歌手","歌曲","用户评论数"});//新的列名
					dm.removeRow(0);//col竖行，row横行
					table = new JTable(dm);
					List  list2 = getbestsong.getBestSongByComments();
					System.out.println(list2.size());
					 for(int i= 0;i<list2.size();i++){								//循环遍历查询结果
						   SongImf bestsong = (SongImf)list2.get(i);
						   System.out.println(i+bestsong.getName());
						   System.out.println(i+bestsong.getSong());
						   dm.addRow(new Object[]{i+1,bestsong.getName(),bestsong.getSong(),bestsong.getTotalcomments()});		//向表格中添加数据		 							 
					 }
				}
				else{
					dm.setDataVector(new Object[][]{{"","","",""}},new Object[]{"名次","歌手","歌曲","用户点赞数"});//新的列名
					dm.removeRow(0);//col竖行，row横行
					table = new JTable(dm);
					List  list3 = getbestsong.getBestSongByLiked();
					System.out.println(list3.size());
					 for(int i= 0;i<list3.size();i++){								//循环遍历查询结果
						   SongImf bestsong = (SongImf)list3.get(i);
						   dm.addRow(new Object[]{i+1,bestsong.getName(),bestsong.getSong(),bestsong.getAllLikedCount()});		//向表格中添加数据								 
				}}
				table.setBounds(20, 50, 500, 300);
				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setPreferredWidth(200);
				table.getColumnModel().getColumn(2).setPreferredWidth(150);
				table.getColumnModel().getColumn(3).setPreferredWidth(100);
				JScrollPane scrollPane = new JScrollPane(table);
				add(scrollPane);
				scrollPane.setBounds(1, 50, 610, 290);
				 }			
		});
	}	
}
