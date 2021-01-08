package board.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.qna.service.IQnaService;
import board.qna.service.QnaServiceimpl;
import board.qna.vo.Qna_a_vo;

/**
 * Servlet implementation class replyUpdate
 */
@WebServlet("/ReplyUpdate")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReplyUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String rep_content = request.getParameter("rep_content");
		int rep_num = Integer.parseInt(request.getParameter("rep_num"));
		
		Qna_a_vo vo = new Qna_a_vo();
		vo.setRep_content(rep_content);
		vo.setRep_num(rep_num);
		
		IQnaService service = QnaServiceimpl.getService();
		
		int count = service.replyUpdate(vo);
		request.setAttribute("count", count);
		request.getRequestDispatcher("mem_view/chk.jsp").forward(request, response);
	}

}
