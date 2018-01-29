package kos.triple.project.vo;

import java.sql.Timestamp;

public class BoardVO {

	private int boardNo;
	private String kind;
	private String title;
	private String content;
	private String mem_id;
	private int readCount;
	private int answerCount;
	private Timestamp reg_Date;
	
	public BoardVO() {}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Timestamp getReg_Date() {
		return reg_Date;
	}

	public void setReg_Date(Timestamp reg_date) {
		this.reg_Date = reg_date;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	
	
}
