package panel;
//import java.awt.Font;
//import java.awt.RenderingHints;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.title.TextTitle;
//import org.jfree.data.general.DefaultPieDataset;
//import java.awt.Font;  
//import java.awt.RenderingHints;  
//import java.io.FileOutputStream;  
//  
//import org.jfree.chart.ChartFactory;  
//import org.jfree.chart.ChartFrame;  
//import org.jfree.chart.ChartUtilities;  
//import org.jfree.chart.JFreeChart;  
//import org.jfree.chart.axis.CategoryAxis;  
//import org.jfree.chart.axis.ValueAxis;  
//import org.jfree.chart.plot.CategoryPlot;  
//import org.jfree.chart.plot.PlotOrientation;  
//import org.jfree.chart.title.TextTitle;  
//import org.jfree.data.category.CategoryDataset;  
//import org.jfree.data.category.DefaultCategoryDataset; 
//public class ChartTest
//{
//    public static void main(String[] args)
//    {
//        DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
//        dpd.setValue("管理人员", 25);  //输入数据
//        dpd.setValue("市场人员", 25);
//        dpd.setValue("开发人员", 45);
//        dpd.setValue("其他人员", 10);
//        
//        
//        JFreeChart chart=ChartFactory.createPieChart("某公司人员组织数据图",dpd,true,true,false); 
//        //可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
//       // CategoryPlot plot = chart.getCategoryPlot();  
//      //  CategoryAxis domainAxis = plot.getDomainAxis();  
//       // ValueAxis rAxis = plot.getRangeAxis(); 
//        chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,  
//                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);  
//        TextTitle textTitle = chart.getTitle();  
//        textTitle.setFont(new Font("宋体", Font.PLAIN, 20));  
//      //  domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
//        //domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
//        //rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
//        //rAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
//        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));  
//        ChartFrame chartFrame=new ChartFrame("某公司人员组织数据图",chart); 
//        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
//        chartFrame.pack(); //以合适的大小展现图形
//        chartFrame.setVisible(true);//图形是否可见
//        
//    }
//}
import java.awt.Font; 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.axis.CategoryAxis; 
import org.jfree.chart.axis.ValueAxis; 
import org.jfree.chart.plot.CategoryPlot; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
public class ChartTest { 
	public static void main(String[] args){
		ChartTest charBar = new ChartTest();
	}
//  ChartPanel frame1; 
  public  ChartTest(){ 
    CategoryDataset dataset = getDataSet(); //createBarChart3D
    JFreeChart chart = ChartFactory.createBarChart( 
               "水果", // 图表标题 
              "水果种类", // 目录轴的显示标签 
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
     domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));     //水平底部标题 
     domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12)); //垂直标题 
     ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状 
     rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15)); 
     chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15)); 
     chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体 
     //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题 
   //  frame1=new ChartPanel(chart,true);    //这里也可以用chartFrame,可以直接生成一个独立的Frame 
     ChartFrame chartFrame=new ChartFrame("某公司人员组织数据图",chart); 
     chartFrame.pack(); //以合适的大小展现图形
     chartFrame.setVisible(true);//图形是否可见
  } 
    public  CategoryDataset getDataSet() { 
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
      dataset.addValue(4500, "b","米兰"); 
      dataset.addValue(4000, "b","马德里"); 
      dataset.addValue(5030, "b","hengda"); 
      dataset.addValue(5040, "b","huxing"); 
      dataset.addValue(5010, "b","guoan"); 
      dataset.addValue(2000, "b","chongq"); 
      dataset.addValue(5050, "b","helan"); 
      dataset.addValue(5010, "b","henbei"); 
      dataset.addValue(5200, "b","hexi"); 
      dataset.addValue(5030, "b","hendong"); 
      dataset.addValue(5030, "b","heren"); 
      dataset.addValue(4530, "b","hea"); 
      dataset.addValue(300, "b","hngda"); 
      return dataset; 
} 

}