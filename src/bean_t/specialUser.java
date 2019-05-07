package bean_t;

public class specialUser {
	private String name;
	private int sumComment;
	private int likeCountSum;
	public void setName(String na){
		this.name = na;
	}
	public String getName(){
		return name;
	}
	public void setSumComment(int cs){
		this.sumComment = cs;
	}
	public int getSumComment(){
		return sumComment;
	}
	public void setLikeCount(int lc){
		this.likeCountSum = lc;
	}
	public int getLikeCount(){
		return likeCountSum;
	}
}
