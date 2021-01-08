package board.qna.vo;

public class Qna_a_vo {
	private int rep_num;		// 답글 번호
	private String manager_id;	// 답글 작성 관리자 아이디
	private String rep_date;	// 답글 작성일자
	private int qu_num;			// 질문 번호
	private String rep_content;	// 답글 내용
	
	public int getRep_num() {
		return rep_num;
	}
	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getRep_date() {
		return rep_date;
	}
	public void setRep_date(String rep_date) {
		this.rep_date = rep_date;
	}
	public int getQu_num() {
		return qu_num;
	}
	public void setQu_num(int qu_num) {
		this.qu_num = qu_num;
	}
	
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	
	
	
	
	
}
