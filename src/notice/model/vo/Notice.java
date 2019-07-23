package notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int nNo; // 공지사항 글 번호
	private String nTitle; // 공지사항 제목
	private String nContent; // 공지사항 내용
	private String nWriter; // 공지사항 작성자
	private int nCount; // 공지사항 조회 수
	private Date nDate; // 공지사항 작성일
	private String status; // 공지사항 삭제 상태
	
	public Notice() {}
	
	
	
	public Notice(String nTitle, String nWriter, String nContent) {
		this.nTitle = nTitle;
		this.nWriter = nWriter;
		this.nContent = nContent;
	}
	
	public Notice(int nNo, String nTitle, String nContent,
				  String nWriter, int nCount, Date nDate) {
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nWriter = nWriter;
		this.nCount = nCount;
		this.nDate = nDate;
	}
	
	public Notice(int nNo, String nTitle, String nContent,
				  String nWriter, int nCount, Date nDate, String status) {
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nWriter = nWriter;
		this.nCount = nCount;
		this.nDate = nDate;
		this.status = status;
	}

	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnWriter() {
		return nWriter;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public int getnCount() {
		return nCount;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Notice [nNo=" + nNo + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nWriter=" + nWriter
				+ ", nCount=" + nCount + ", nDate=" + nDate + ", status=" + status + "]";
	}
	
	

}