package kos.triple.project.vo;

public class PlanVO {
	
	private int planNo;				//��ȹ��ȣ
	private String planTitle;		//��ȹ��
	private String planContent;		//����
	private String mem_Id;			//�ƾƵ�
	
	public PlanVO() {
	
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public String getPlanContent() {
		return planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	public String getMem_Id() {
		return mem_Id;
	}

	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
	
	
	
	
}
