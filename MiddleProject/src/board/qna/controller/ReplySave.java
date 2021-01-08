package board.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.engine.type.IntegerTypeHandler;

import board.qna.service.IQnaService;
import board.qna.service.QnaServiceimpl;
import board.qna.vo.Qna_a_vo;

/**
 * Servlet implementation class replySave
 */
@WebServlet("/ReplySave")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplySave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Qna_a_vo vo = new Qna_a_vo();
		
		int qu_num = Integer.parseInt(request.getParameter("qu_num"));
		vo.setQu_num(qu_num);
		
		vo.setRep_content(request.getParameter("rep_content"));
		
		IQnaService service = QnaServiceimpl.getService();
		
		int rep_num = service.replySave(vo);
		
		request.setAttribute("rep_num", rep_num);
		
		request.getRequestDispatcher("admin_view/qna_replysave.jsp").forward(request, response);
	}

}
