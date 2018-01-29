package kos.triple.project.etc;

import java.util.Random;

public class AuthenticationKeyCreate {

	private String key;
	
	public AuthenticationKeyCreate() {
		
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();

		for (int i = 0; i < 6; i++) {
			int rIndex = rnd.nextInt(2);
			switch (rIndex) {
			case 0:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 1:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}

		this.key = temp.toString();// StringBuffer 형식인 Key를 String으로 변환
		
	}
	
	
	public String getKey() {
		return this.key;
	}
	
}
