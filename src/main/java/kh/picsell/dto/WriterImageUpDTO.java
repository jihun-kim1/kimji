package kh.picsell.dto;

public class WriterImageUpDTO {
	private int img_seq;
	private String nickName, usage, copyright, tag, file_extension, oriName, sysName;
	private int img_like, viewCount, downCount,price;
	
	public WriterImageUpDTO() {}
	
	//이미지등록할때.
	public WriterImageUpDTO(int img_seq, String nickName, String usage, String copyright, String tag, String file_extension,
			String oriName, String sysName) {
		super();
		this.img_seq = img_seq;
		this.nickName = nickName;
		this.usage = usage;
		this.copyright = copyright;
		this.tag = tag;
		this.file_extension = file_extension;
		this.oriName = oriName;
		this.sysName = sysName;
	}
	public WriterImageUpDTO(int img_seq, String nickName, String usage, String copyright, String tag, String file_extension,
			String oriName, String sysName, int img_like, int viewCount, int downCount, int price) {
		super();
		this.img_seq = img_seq;
		this.nickName = nickName;
		this.usage = usage;
		this.copyright = copyright;
		this.tag = tag;
		this.file_extension = file_extension;
		this.oriName = oriName;
		this.sysName = sysName;
		this.img_like = img_like;
		this.viewCount = viewCount;
		this.downCount = downCount;
		this.price = price;
	}
	public int getImg_seq() {
		return img_seq;
	}
	public void setImg_seq(int img_seq) {
		this.img_seq = img_seq;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getFile_extension() {
		return file_extension;
	}
	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public int getImg_like() {
		return img_like;
	}
	public void setImg_like(int img_like) {
		this.img_like = img_like;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getDownCount() {
		return downCount;
	}
	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
