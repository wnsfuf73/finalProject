package kos.triple.project.etc;

public class JstringConverter {
	// JSON ���� �Ķ���͸� �Ѱܼ� ���񽺳� ��Ʈ�ѷ����� ���� ���
	// "�� ���ʿ� �߰��Ǿ �޾���.
	// �̷��� sql�� ���� ��� ���ϴ� ����� ã�� ���ϴ� ���� �߻�.
	// �Ʒ� �޼ҵ�� JSON���� ���� ���ڿ��� sql�� �ֱ� ���Բ� ��ȯ���ִ� �޼ҵ�
	
	private String target;
	
	public JstringConverter() {
	
	}
	
	public JstringConverter(String target) {
		this.target = target;
	}
	
	public void setTarget(String target) {
		
		this.target = target;
	}
	
	public String getTarget() {
		return target;
	}
	
	public String stringConverter(String convTarget) {
		
		String converted = convTarget.substring(1, convTarget.lastIndexOf('"'));
		
		return converted;
	}
	
}
