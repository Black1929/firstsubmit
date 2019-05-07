package bean_t;

public class CommentInf {
	private String name;
	private String song;
	private String user;
	private String comment;
	private int likedcount;
	public void setName(String na){
		this.name = na;
	}
	public String getName(){
		 return name;
	}
	public void setSong(String so){
		this.song = so;
	}
	public String getSong(){
		 return song;
	}
	public void setUser(String user){
		this.user = user;
	}
	public String getUser(){
		 return user;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	public String getComment(){
		 return comment;
	}
	public void setLikedcount(int count){
		this.likedcount= count;
	}
	public int getLikedcount(){
		 return likedcount;
	}
}
