package board.qna.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import board.qna.dao.IQnaDao;
import board.qna.dao.QnaDaoimpl;
import board.qna.vo.Qna_a_vo;
import board.qna.vo.Qna_q_vo;

public class QnaServiceimpl implements IQnaService {

	private IQnaDao dao;
	private static IQnaService service;

	private QnaServiceimpl() {
		dao = QnaDaoimpl.getDao();
	}

	public static IQnaService getService() {
		if (service == null)
			service = new QnaServiceimpl();
		return service;
	}

	@Override
	public List<Qna_q_vo> selectAll(Qna_q_vo vo) {
		List<Qna_q_vo> list = null;
		try {
			list = dao.selectAll(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertQuestion(Qna_q_vo vo) {
		int count = 0;
		try {
			count = dao.insertQuestion(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Qna_q_vo> adSelectAll() {
		List<Qna_q_vo> list = null;
		try {
			list = dao.adSelectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int replySave(Qna_a_vo vo) {
		int renum = 0;
		try {
			renum = dao.replySave(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return renum;
	}

	@Override
	public List<Qna_a_vo> replyList(int qu_num) {
		List<Qna_a_vo> list = null;
		try {
			list = dao.replyList(qu_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int replyUpdate(Qna_a_vo vo) {
		int count = 0;
		try {
			count = dao.replyUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int replyDelete(int renum) {
		int count = 0;
		try {
			count = dao.replyDelete(renum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int questionDelete(int qu_num) {
		int count = 0;
		try {
			count = dao.questionDelete(qu_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateQuestion(Qna_q_vo vo) {
		int count = 0;
		try {
			count = dao.updateQuestion(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Qna_q_vo updateSelect(int qu_num) {
		Qna_q_vo vo = null;
		try {
			vo = dao.updateSelect(qu_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int getTotalCount() {
		int count = 0;
		try {
			count = dao.getTotalCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Qna_q_vo> selectPage(Map<String, Integer> map) {
		List<Qna_q_vo> list = null;
		try {
			list = dao.selectPage(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Qna_q_vo> qna_search(Qna_q_vo qv) {
		List<Qna_q_vo> list = null;
		try {
			list = dao.qna_search(qv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
