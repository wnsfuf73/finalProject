package kos.triple.project.vo;

public class AirSaleVO {
	
	String key;
	int value;
	
	public AirSaleVO() {}
	
	public AirSaleVO(String key , int value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
