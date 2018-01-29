package kos.triple.project.vo;

import java.sql.Timestamp;

public class AnswerVO {
	
	private int answerNo;
	private String kind;
	private String title;
	private String content;
	private Timestamp reg_Date;
	private int boardNo;
	
	public AnswerVO() {
		
	}

	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getReg_Date() {
		return reg_Date;
	}

	public void setReg_date(Timestamp reg_Date) {
		this.reg_Date = reg_Date;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
}
