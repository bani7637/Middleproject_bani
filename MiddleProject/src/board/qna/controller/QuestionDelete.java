package board.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.qna.service.IQnaService;
import board.qna.service.QnaServiceimpl;
import board.qna.vo.Qna_q_vo;

/**
 * Servlet implementation class questionDelete
 */
@WebServlet("/QuestionDelete")
public class QuestionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int qu_num = Integer.parseInt(request.getParameter("qu_num"));
		
		IQnaService service = QnaServiceimpl.getService();
		int count = service.questionDelete(qu_num);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("mem_view/chk.jsp").forward(request, response);
	}

}
