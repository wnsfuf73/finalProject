package kos.triple.project.etc;

public class JstringConverter {
	// JSON 에서 파라미터를 넘겨서 서비스나 컨트롤러에서 받을 경우
	// "가 양쪽에 추가되어서 받아짐.
	// 이렇게 sql에 넣을 경우 원하는 결과를 찾지 못하는 문제 발생.
	// 아래 메소드는 JSON에서 받은 문자열을 sql에 넣기 좋게끔 변환해주는 메소드
	
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
