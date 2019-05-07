package bean_t;

public class SongImf {
	private String name;
	private String song;
	private int totalcomments;
	private int totalhotcomments;
	private int allLikedCount;
	private int score;
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
	public void setTotalcomments(int comment){
		this.totalcomments = comment;
	}
	public int getTotalcomments(){
		 return totalcomments;
	}
	
	public void setTotalhotcomments(int hotcomment){
		this.totalhotcomments =hotcomment;
	}
	public int getTotalhotcomments(){
		 return totalhotcomments;
	}
	
	public void setAllLikedCount(int liked){
		this.allLikedCount =liked;
	}
	public int getAllLikedCount(){
		 return allLikedCount;
	}
	public void setScore(int sc){
		this.score = sc;
	}
	public int getScore(){
		return score;
	}
}
