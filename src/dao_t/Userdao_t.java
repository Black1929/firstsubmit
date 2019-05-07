package dao_t;

import java.sql.*;

import bean_t.User;
//import translationDB.Words;

public class Userdao_t{
GetConnection_t connection = new GetConnection_t();
Connection conn = null;
//编写按用户名密码查询用户方法
public User getUser(String userName,String passWord){
	User user = new User();				//创建JavaBean对象
	conn = connection.getCon();			//获取数据库连接
	try {
		String sql = "select * from user where username = ? and password = ?";	//定义查询预处理语句
		PreparedStatement statement = conn.prepareStatement(sql);		//实例化PreparedStatement对象
		statement.setString(1, userName);			//设置预处理语句参数
		statement.setString(2, passWord);
		ResultSet rest = statement.executeQuery();	//执行预处理语句
		while(rest.next()){
			//user.setId(rest.getInt(1));				//应用查询结果设置对象属性
			user.setUserName(rest.getString(1));
			user.setPassWord(rest.getString(2));
		}
	} catch (SQLException e) {			
		e.printStackTrace();
	}		
	return user;						//返回查询结果
}	

public void insertUser(User user) {
	conn = connection.getCon();			//建立一个数据库连接
	try {
		PreparedStatement statement = conn				//通过PreparedStatement实例执行动态的insert语句添加
				.prepareStatement("insert into user (userName,userPassword) values(?,?)");//id是自增的，默认不用添加
		statement.setString(2,user.getPassWord());
		statement.setString(1, user.getUserName());	
		statement.executeUpdate();      		//执行语句
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


}
