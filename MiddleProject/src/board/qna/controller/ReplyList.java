package board.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.qna.service.IQnaService;
import board.qna.service.QnaServiceimpl;
import board.qna.vo.Qna_a_vo;

/**
 * Servlet implementation class replyList
 */
@WebServlet("/ReplyList")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qu_num = Integer.parseInt(request.getParameter("qu_num"));
		
		IQnaService service = QnaServiceimpl.getService();
		
		List<Qna_a_vo>list = service.replyList(qu_num);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("admin_view/qna_adreplylist.jsp").forward(request, response);
	}

}
