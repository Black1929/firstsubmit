package dao_t;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean_t.CommentInf;
import bean_t.SongImf;
//在comment表中根据歌手名字和歌曲名字搜索评论获赞数最多的15个用户
public class getCommentBySS {
	GetConnection_t connection = new GetConnection_t();
	Connection conn = null;
	
	public List getSongCommentTop10(String SingerName,String SongName){
		List list = new ArrayList<CommentInf>();
		conn = connection.getCon();
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select * from comment where name = '"+SingerName+"' and song ='"+SongName+"'  order by likedcount DESC LIMIT 0,50" );
			while (rest.next()) {
				CommentInf commentInf = new CommentInf();
				commentInf.setName(rest.getString(2));//同时修改大量错误名称，快捷键alt + shift+r
				commentInf.setSong(rest.getString(3));
				commentInf.setUser(rest.getString(4));
				commentInf.setComment(rest.getString(5));
				commentInf.setLikedcount(rest.getInt(6));
				list.add(commentInf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
