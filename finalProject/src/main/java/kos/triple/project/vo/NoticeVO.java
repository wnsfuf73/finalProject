package kos.triple.project.vo;

import java.sql.Timestamp;

public class NoticeVO {
	
	private int noticeNo;
	private String title;
	private String content;
	private int readCount;
	private Timestamp reg_Date;

	public NoticeVO() {
		
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Timestamp getReg_Date() {
		return reg_Date;
	}

	public void setReg_Date(Timestamp reg_Date) {
		this.reg_Date = reg_Date;
	}


}
