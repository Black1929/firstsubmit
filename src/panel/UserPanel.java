package panel;
import java.awt.Color;
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

import bean_t.specialUser;
import dao_t.getSpecialUser;

public class UserPanel extends JPanel{
	public UserPanel(){
		setLayout(null);
		setBounds(10, 63, 611, 343);
		JLabel superUser = new JLabel("寻找网易云音乐中的超级段子手-_-");
		superUser.setBounds(10, 10, 200, 20);
		add(superUser);
		String[] selectItem = {"评论总数","获赞总数"};
		JComboBox comboBox = new JComboBox();//下拉框
		comboBox.setEditable(false);
		comboBox.setMaximumRowCount(2);
		comboBox.insertItemAt("获赞总数",0);
		comboBox.insertItemAt("评论总数",1);
		comboBox.setSelectedItem("评论总数");
		comboBox.setBounds(250, 10, 90, 30);
		add(comboBox);
		JButton searchBtn = new JButton("查找");
		searchBtn.setFocusPainted(false);
		searchBtn.setBounds(350, 10, 90, 30);
		add(searchBtn);
		DefaultTableModel dm = new DefaultTableModel();
		//getCommentBySS commentInf = new getCommentBySS();
		dm.setDataVector(new Object[][]{{"","",""}},
                new Object[]{"名次","用户","数量"});//新的列名
			dm.removeRow(0);//col竖行，row横行
		JTable table = new JTable(dm);
		getSpecialUser getSpecialU = new getSpecialUser();	
		getSpecialUser getSpecialU1 = new getSpecialUser();
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.setRowCount(0);
				String a = comboBox.getSelectedItem().toString();
				//System.out.println(a);
				
				
				if(a.matches("评论总数")){//比较字符串
					List  list1 = getSpecialU.getSumCommenUserTop100();//返回的是集合，因为是查询结果，多个
					 for(int i= 0;i<list1.size();i++){	//可以从i=1开始,<=判断，但arrylist是数组，下标从0开始							//循环遍历查询结果
						   specialUser sUser = (specialUser)list1.get(i);//故最好i从0开始
//						   
					    	//添加一行到模型结尾，参数为一个对象
						   dm.addRow(new Object[]{i+1,sUser.getName(),sUser.getSumComment()});		//向表格中添加数据		 	
						 
					 }
					
				}
				else if(a.matches("获赞总数")){
					List  list2 = getSpecialU1.getSumCommenLikedTop100();
					for(int i= 0;i<list2.size();i++){								//循环遍历查询结果
						   specialUser sUser = (specialUser)list2.get(i);
//						   
					    	//添加一行到模型结尾，参数为一个对象
						   dm.addRow(new Object[]{i+1,sUser.getName(),sUser.getLikeCount()});		//向表格中添加数据		 	
						 
					 }
					
				}
			}			
		});
		table.setBounds(20, 50, 500, 300);
		//调整每一列的宽度
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		JScrollPane scrollPane = new JScrollPane(table);
		//panel_1.add(table);
		add(scrollPane);
		scrollPane.setBounds(1, 50, 610, 290);
		
		
		
		
	}
	

}
