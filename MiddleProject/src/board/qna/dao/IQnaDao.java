package board.qna.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import board.qna.vo.Qna_a_vo;
import board.qna.vo.Qna_q_vo;

public interface IQnaDao {

	// 전체 질문리스트 중 내질문만 가져오기-구직자
	public List<Qna_q_vo> selectAll(Qna_q_vo vo) throws SQLException;
	
	// 전체 질문 리스트 가져오기 - 관리자
	public List<Qna_q_vo> adSelectAll() throws SQLException;
	
	// 답글 저장 - 관리자
	public int replySave(Qna_a_vo vo) throws SQLException;
	
	// 답글 리스트 - 구직자
	public List<Qna_a_vo> replyList(int qu_num) throws SQLException;
	
	// 답글 수정 -관리자
	public int replyUpdate(Qna_a_vo vo) throws SQLException; 
	
	// 답글 삭제 - 관리자
	public int  replyDelete(int renum) throws SQLException;
	
	// 질문 삭제 - 구직자
	public int  questionDelete(int qu_num) throws SQLException;
	
	// 질문 작성 - 구직자
	public int insertQuestion(Qna_q_vo vo) throws SQLException;

	// 질문 수정 - 구직자
	public int updateQuestion(Qna_q_vo vo) throws SQLException;
	
	// 수정할 질문 가져오기- 구직자
	public Qna_q_vo updateSelect(int qu_num) throws SQLException;

	// 질문  수 가져오기
	public int getTotalCount() throws SQLException;
	
	// 페이징
	public List<Qna_q_vo> selectPage(Map<String, Integer> map) throws SQLException;
	
	// 키워드 검색
	public List<Qna_q_vo> qna_search(Qna_q_vo qv) throws SQLException;
}
