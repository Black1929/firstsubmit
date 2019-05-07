package dao_t;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bean_t.specialUser;
public class getSpecialUser {
	GetConnection_t connection = new GetConnection_t();
	Connection conn = null;
	public List getSumCommenLikedTop100(){//获赞总数
		List list = new ArrayList<specialUser>();//list api有两个，一个是awt下的，表格中展示几行数
		conn = connection.getCon();		//一种是有序集，用来装类对象的，这儿的这种
		try {
			Statement statement = conn.createStatement();//SELECT user,sum(likedcount) from comment GROUP BY user ORDER BY sum(likedcount) DESC LIMIT 0,100
			ResultSet rest = statement.executeQuery("SELECT * from userandliked LIMIT 0,50" );
			while (rest.next()) {
				specialUser specialuser = new specialUser();
				specialuser.setName(rest.getString(1));
				specialuser.setLikeCount(rest.getInt(2));	
				list.add(specialuser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List getSumCommenUserTop100(){//评论总数
		List list = new ArrayList<specialUser>();
		conn = connection.getCon();
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("SELECT user,count(comment) from comment GROUP BY user ORDER BY count(comment) DESC LIMIT 0,100" );
			while (rest.next()) {
				specialUser specialuser = new specialUser();
				specialuser.setName(rest.getString(1));
				specialuser.setSumComment(rest.getInt(2));
				list.add(specialuser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
