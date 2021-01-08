package board.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.qna.service.IQnaService;
import board.qna.service.QnaServiceimpl;
import board.qna.vo.Qna_a_vo;
import board.qna.vo.Qna_q_vo;

/**
 * Servlet implementation class selectAll
 */
@WebServlet("/SelectAll")
public class SelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
		String mem_id = (String) session.getAttribute("id");
		
		Qna_q_vo qv = new Qna_q_vo();

		
		qv.setMem_id(mem_id);
		
		
		IQnaService service = QnaServiceimpl.getService();
		
		List<Qna_q_vo> list = service.selectAll(qv);
		request.setAttribute("listvalue", list);
		request.getRequestDispatcher("mem_view/qna_alllist.jsp").forward(request, response);
	}

}
