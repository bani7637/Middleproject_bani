package board.qna.vo;

public class Qna_q_vo {
    private int qu_num;			// 질문번호
	private String mem_id;		// 작성자 아이디
	private String qu_title;	// 질문 제목
	private String qu_content;	// 질문 내용
	private String qu_date;		// 질문 작성일자
	
	public int getQu_num() {
		return qu_num;
	}
	public void setQu_num(int qu_num) {
		this.qu_num = qu_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getQu_title() {
		return qu_title;
	}
	public void setQu_title(String qu_title) {
		this.qu_title = qu_title;
	}
	public String getQu_content() {
		return qu_content;
	}
	public void setQu_content(String qu_content) {
		this.qu_content = qu_content;
	}
	public String getQu_date() {
		return qu_date;
	}
	public void setQu_date(String qu_date) {
		this.qu_date = qu_date;
	}
	
	
	
	
}
