package kh.picsell.dto;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class NoticeFileDTO {
	private int noticeFile_seq;
	private int noticeFile_parentSeq;
	private MultipartFile[] noticeFile_file;
	private String noticeFile_oriName;
	private String noticeFile_sysName;
	
	public NoticeFileDTO() {}

	public NoticeFileDTO(int noticeFile_seq, int noticeFile_parentSeq, MultipartFile[] noticeFile_file,
			String noticeFile_oriName, String noticeFile_sysName) {
		super();
		this.noticeFile_seq = noticeFile_seq;
		this.noticeFile_parentSeq = noticeFile_parentSeq;
		this.noticeFile_file = noticeFile_file;
		this.noticeFile_oriName = noticeFile_oriName;
		this.noticeFile_sysName = noticeFile_sysName;
	}

	public int getNoticeFile_seq() {
		return noticeFile_seq;
	}

	public void setNoticeFile_seq(int noticeFile_seq) {
		this.noticeFile_seq = noticeFile_seq;
	}

	public int getNoticeFile_parentSeq() {
		return noticeFile_parentSeq;
	}

	public void setNoticeFile_parentSeq(int noticeFile_parentSeq) {
		this.noticeFile_parentSeq = noticeFile_parentSeq;
	}

	public MultipartFile[] getNoticeFile_file() {
		return noticeFile_file;
	}

	public void setNoticeFile_file(MultipartFile[] noticeFile_file) {
		this.noticeFile_file = noticeFile_file;
	}

	public String getNoticeFile_oriName() {
		return noticeFile_oriName;
	}

	public void setNoticeFile_oriName(String noticeFile_oriName) {
		this.noticeFile_oriName = noticeFile_oriName;
	}

	public String getNoticeFile_sysName() {
		return noticeFile_sysName;
	}

	public void setNoticeFile_sysName(String noticeFile_sysName) {
		this.noticeFile_sysName = noticeFile_sysName;
	}

	@Override
	public String toString() {
		return "NoticeFileDTO [noticeFile_seq=" + noticeFile_seq + ", noticeFile_parentSeq=" + noticeFile_parentSeq
				+ ", noticeFile_file=" + Arrays.toString(noticeFile_file) + ", noticeFile_oriName=" + noticeFile_oriName
				+ ", noticeFile_sysName=" + noticeFile_sysName + "]";
	}
	
}
