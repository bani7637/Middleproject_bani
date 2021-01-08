package board.qna.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.qna.service.IQnaService;
import board.qna.service.QnaServiceimpl;
import board.qna.vo.Qna_q_vo;

/**
 * Servlet implementation class qna_search
 */
@WebServlet("/qna_search")
public class qna_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qna_search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Qna_q_vo qv = new Qna_q_vo();
		HttpSession session = request.getSession(true);
		String mem_id = (String) session.getAttribute("id");
		
		qv.setMem_id(mem_id);
		
		String ch = request.getParameter("cfind");
		
		if(ch!=null) {
			ch = new String(ch.getBytes("8859_1"),"UTF-8");
		}

			
		qv.setQu_content(ch);
		qv.setQu_title(ch);
		
		IQnaService service = QnaServiceimpl.getService();
		List<Qna_q_vo> list = service.qna_search(qv);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("mem_view/qna_search.jsp").forward(request, response);
	
	}

}
