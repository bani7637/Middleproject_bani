package board.qna.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import board.qna.service.IQnaService;
import board.qna.service.QnaServiceimpl;
import board.qna.vo.Qna_q_vo;

/**
 * Servlet implementation class insertQuestion
 */
@WebServlet("/InsertQuestion")
public class InsertQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Qna_q_vo qv = new Qna_q_vo();
		HttpSession session = request.getSession(true);
		String mem_id = (String) session.getAttribute("id");
		qv.setMem_id(mem_id);
		
		try {
			BeanUtils.populate(qv, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		IQnaService service = QnaServiceimpl.getService();
		
		int count = service.insertQuestion(qv);
		
		request.setAttribute("count", count);
		request.getRequestDispatcher("mem_view/chk.jsp").forward(request, response);
		
	}

}
