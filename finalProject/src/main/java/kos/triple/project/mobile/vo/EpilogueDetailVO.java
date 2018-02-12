package kos.triple.project.mobile.vo;

import java.util.List;

public class EpilogueDetailVO {

	EpilogueMobileVO e;
	List<EpilogueMobileCourseVO> cList;
	
	public EpilogueDetailVO() {}
	public EpilogueDetailVO(EpilogueMobileVO e, List<EpilogueMobileCourseVO> cList) {
		super();
		this.e = e;
		this.cList = cList;
	}
	public EpilogueMobileVO getE() {
		return e;
	}
	public void setE(EpilogueMobileVO e) {
		this.e = e;
	}
	public List<EpilogueMobileCourseVO> getcList() {
		return cList;
	}
	public void setcList(List<EpilogueMobileCourseVO> cList) {
		this.cList = cList;
	}
	
	
	
}
