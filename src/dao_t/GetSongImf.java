package dao_t;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean_t.SongImf;

public class GetSongImf {
	GetConnection_t connection = new GetConnection_t();
	Connection conn = null;
	
	public List getCommentTop10(String name){
		List list = new ArrayList<SongImf>();
		conn = connection.getCon();
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select * from songinfo where name = '"+name+"' order by totalcomments DESC LIMIT 0,50" );
			while (rest.next()) {
				SongImf songimf = new SongImf();
				songimf.setName(rest.getString(2));
				songimf.setSong(rest.getString(3));
				songimf.setTotalcomments(rest.getInt(4));
				songimf.setTotalhotcomments(rest.getInt(5));
				songimf.setAllLikedCount(rest.getInt(6));
				list.add(songimf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "第一个单词必须为英文单词");
		}		
		return list;	
	}
	public List getBestSong(){
		List list = new ArrayList<SongImf>();
		conn = connection.getCon();
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("SELECT * FROM songinfo ORDER BY score DESC LIMIT 0,100" );
			while (rest.next()) {
				SongImf songimf = new SongImf();
				songimf.setName(rest.getString(2));
				songimf.setSong(rest.getString(3));
				songimf.setScore(rest.getInt(7));
				list.add(songimf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;	
	}
	public List getBestSongByComments(){
		List list = new ArrayList<SongImf>();
		conn = connection.getCon();
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("SELECT * FROM songinfo ORDER BY totalcomments DESC LIMIT 0,100" );
			while (rest.next()) {
				SongImf songimf = new SongImf();
				songimf.setName(rest.getString(2));
				songimf.setSong(rest.getString(3));
				songimf.setTotalcomments(rest.getInt(4));
				list.add(songimf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;	
	}
	public List getBestSongByLiked(){
		List list = new ArrayList<SongImf>();
		conn = connection.getCon();
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("SELECT * FROM songinfo ORDER BY allLikedCount DESC LIMIT 0,100" );
			while (rest.next()) {
				SongImf songimf = new SongImf();
				songimf.setName(rest.getString(2));
				songimf.setSong(rest.getString(3));
				songimf.setAllLikedCount(rest.getInt(6));
				list.add(songimf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;	
	}
}
