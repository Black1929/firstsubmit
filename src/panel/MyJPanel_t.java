package panel;

import java.awt.*;

import java.net.*;


import javax.swing.*;
@SuppressWarnings("serial")
public class MyJPanel_t extends JPanel {
	
public void	paintComponent(Graphics g){//绘制图片
	try{ 
		//URL url = getClass().getResource("/om/mingrisoft/frame/buttonIcons/back.jpg");///com/mingrisoft/frame/buttonIcons/back.jpg
		ImageIcon image = new ImageIcon("src/pics/sea1.jpg");//918 587
		//solarSystem,pan1,lightblue,flower
		g.drawImage(image.getImage(), 0, 0, this); 
		}catch(Exception e){} 
	}
}
