package panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import bean_t.SongImf;
import dao_t.GetSongImf;
public class JButtonTablePanel_t  extends JPanel{
	private JTable table;
	DefaultTableModel dm = new DefaultTableModel();
	GetSongImf songimf = new GetSongImf();
	private JTextField conditionTextField;
	
	
	public JButtonTablePanel_t() {
		setLayout(null);
		setBackground(Color.BLACK);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 116, 520, 211);
		add(scrollPane);	
		dm.setDataVector(new Object[][]{{"","","","","","","",""}},
                new Object[]{"name","song","totalcomment","totalhotcomment","totallikeclick"});
		dm.removeRow(0);//col竖行，row横行
		table = new JTable(dm);
		scrollPane.setViewportView(table);
		
		JButton findButton = new JButton("搜索");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.setRowCount(0);			//将表格内容清空
			//	String condition = comboBox.getSelectedItem().toString();		//获取用户选择的查询条件
				String conditionText = conditionTextField.getText();			//获取用户添加的查询条件
				
												//如果用户选择按货品名称进行搜索
				   List list = songimf.getCommentTop10(conditionText);			//调用按货品名称查询数据方法
				   for(int i= 0;i<list.size();i++){								//循环遍历查询结果
					   SongImf songin = (SongImf)list.get(i);
						//String oid = stock.getOrderId();						//获取订单号信息
				    	//int id = dao.selectJoinStockByOid(oid);	    			//根据订单号查询入库信息										//如果该订单的货品在入库表中不存在
				    		 dm.addRow(new Object[]{songin.getName(),songin.getSong(),songin.getTotalcomments(),songin.getTotalhotcomments(),songin.getAllLikedCount()
				    				 });		//向表格中添加数据		 				    	
				}						
			 }
			});		
		findButton.setBounds(407, 68, 68, 23);
		add(findButton);
	}
}
