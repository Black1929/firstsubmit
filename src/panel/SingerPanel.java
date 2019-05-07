package panel;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SingerPanel extends JPanel{
	public SingerPanel(){
		setLayout(null);
		setBounds(10, 63, 611, 343);
		JLabel singerName = new JLabel("用户评价最高的歌曲：");

		JButton songBtn = new JButton("搜索");
		singerName.setBounds(10, 10, 100, 20);
		
		songBtn.setMargin(new Insets(0,0,0,0));
		add(singerName);
		add(songBtn);
		
	}
	

}
