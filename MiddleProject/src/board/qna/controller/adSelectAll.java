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
import board.qna.vo.Qna_q_vo;

/**
 * Servlet implementation class adSelectAll
 */
@WebServlet("/adSelectAll")
public class adSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adSelectAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IQnaService service = QnaServiceimpl.getService();
		
		List<Qna_q_vo> list = service.adSelectAll();
		
		request.setAttribute("listvalue", list);
		request.getRequestDispatcher("admin_view/qnalistAll.jsp").forward(request, response);
	}

}
