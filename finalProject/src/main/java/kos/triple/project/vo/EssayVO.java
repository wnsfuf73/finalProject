package kos.triple.project.vo;

public class EssayVO {
	private int essayNo;
	private String essayTitle;
	private String essayContent;
	private String essayImg;
	private int security;
	private int essayGood;
	private String mem_id;
	private int commentNo;
	private String replyContent;
	private String replyRegdate;

	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyRegdate() {
		return replyRegdate;
	}
	public void setReplyRegdate(String replyRegdate) {
		this.replyRegdate = replyRegdate;
	}
	public int getEssayNo() {
		return essayNo;
	}
	public void setEssayNo(int essayNo) {
		this.essayNo = essayNo;
	}
	public String getEssayTitle() {
		return essayTitle;
	}
	public void setEssayTitle(String essayTitle) {
		this.essayTitle = essayTitle;
	}
	public String getEssayContent() {
		return essayContent;
	}
	public void setEssayContent(String essayContent) {
		this.essayContent = essayContent;
	}
	public String getEssayImg() {
		return essayImg;
	}
	public void setEssayImg(String essayImg) {
		this.essayImg = essayImg;
	}
	public int getSecurity() {
		return security;
	}
	public void setSecurity(int security) {
		this.security = security;
	}
	public int getEssayGood() {
		return essayGood;
	}
	public void setEssayGood(int essayGood) {
		this.essayGood = essayGood;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
}
