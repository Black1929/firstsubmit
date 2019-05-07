package dao_t;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GetConnection_t {	
private Connection con;			
private PreparedStatement pstm;	
private String user="root";		//用户名
private String password="123456";		//密码
private String className="com.mysql.jdbc.Driver";	
private String url="jdbc:mysql://localhost:3306/cloudmusic?characterEncoding=UTF-8";		//数据库位置
public GetConnection_t(){
	//加载MySQL驱动程序
	try{
		Class.forName(className);
	}catch(ClassNotFoundException e){
		System.out.println("MySQL驱动程序加载失败");
		e.printStackTrace();
	}
}
public Connection getCon(){
	try {
		con=DriverManager.getConnection(url,user,password);		//尝试连接数据库
	} catch (SQLException e) {
		System.out.println("数据库连接失败!!");
		con=null;
		e.printStackTrace();
	}
	return con;					
}	

}
