package kos.triple.project.vo;

public class BannerVO {
	
	private int bannerNo;
	private String bannerName;
	private String bannerImg;
	private String bannerContent;
	private String bannerLocation;
	private String bannerLink;
	private int seq;

	public int getBannerNo() {
		return bannerNo;
	}
	public void setBannerNo(int bannerNo) {
		this.bannerNo = bannerNo;
	}
	public String getBannerName() {
		return bannerName;
	}
	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
	public String getBannerImg() {
		return bannerImg;
	}
	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}
	public String getBannerContent() {
		return bannerContent;
	}
	public void setBannerContent(String bannerContent) {
		this.bannerContent = bannerContent;
	}
	public String getBannerLocation() {
		return bannerLocation;
	}
	public void setBannerLocation(String bannerLocation) {
		this.bannerLocation = bannerLocation;
	}
	public String getBannerLink() {
		return bannerLink;
	}
	public void setBannerLink(String bannerLink) {
		this.bannerLink = bannerLink;
	}
	
	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
}
