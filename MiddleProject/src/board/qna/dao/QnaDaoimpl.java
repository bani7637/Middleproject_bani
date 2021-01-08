package board.qna.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import board.qna.vo.Qna_a_vo;
import board.qna.vo.Qna_q_vo;
import ibatis.config.SqlMapClientFactory;

public class QnaDaoimpl implements IQnaDao {

	private SqlMapClient client;
	private static IQnaDao dao;

	public QnaDaoimpl() {
		client = SqlMapClientFactory.getClient();
	}

	public static IQnaDao getDao() {
		if (dao == null)
			dao = new QnaDaoimpl();
		return dao;
	}

	@Override
	public List<Qna_q_vo> selectAll(Qna_q_vo vo) throws SQLException {
		return client.queryForList("question.selectAll", vo);
	}

	@Override
	public int insertQuestion(Qna_q_vo vo) throws SQLException {
		return (Integer) client.insert("question.insertQuestion", vo);
	}

	@Override
	public List<Qna_q_vo> adSelectAll() throws SQLException {
		return client.queryForList("question.adselectAll");
	}

	@Override
	public int replySave(Qna_a_vo vo) throws SQLException {
		return (Integer) client.insert("reply.replySave", vo);
	}

	@Override
	public List<Qna_a_vo> replyList(int qu_num) throws SQLException {
		return client.queryForList("reply.replyList", qu_num);
	}

	@Override
	public int replyUpdate(Qna_a_vo vo) throws SQLException {
		return client.update("reply.replyUpdate", vo);
	}

	@Override
	public int replyDelete(int renum) throws SQLException {
		return client.delete("reply.replyDelete", renum);
	}

	@Override
	public int questionDelete(int qu_num) throws SQLException {
		return client.delete("question.questionDelete", qu_num);
	}

	@Override
	public int updateQuestion(Qna_q_vo vo) throws SQLException {
		return client.update("question.updateQuestion", vo);
	}

	@Override
	public Qna_q_vo updateSelect(int qu_num) throws SQLException {
		return (Qna_q_vo) client.queryForObject("question.updateSelect", qu_num);
	}

	@Override
	public int getTotalCount() throws SQLException {
		return (Integer) client.queryForObject("question.getTotalCount");
	}

	@Override
	public List<Qna_q_vo> selectPage(Map<String, Integer> map) throws SQLException {
		return client.queryForList("question.selectPage", map);
	}

	@Override
	public List<Qna_q_vo> qna_search(Qna_q_vo qv) throws SQLException {
		return client.queryForList("question.q_search", qv);
	}

}
