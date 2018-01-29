package kos.triple.project.vo;

public class Epilogue_JSONVO {
	private String epilogueNo;
	private String epilogue_courseNo;
	
	public Epilogue_JSONVO() {
		
	}

	public Epilogue_JSONVO(String epilogueNo, String epilogue_courseNo) {
		super();
		this.epilogueNo = epilogueNo;
		this.epilogue_courseNo = epilogue_courseNo;
	}

	public String getEpilogueNo() {
		return epilogueNo;
	}

	public void setEpilogueNo(String epilogueNo) {
		this.epilogueNo = epilogueNo;
	}

	public String getEpilogue_courseNo() {
		return epilogue_courseNo;
	}

	public void setEpilogue_courseNo(String epilogue_courseNo) {
		this.epilogue_courseNo = epilogue_courseNo;
	}
	
	
}
