package board.qna.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import board.qna.service.IQnaService;
import board.qna.service.QnaServiceimpl;
import board.qna.vo.Qna_q_vo;

/**
 * Servlet implementation class updateQuestion
 */
@WebServlet("/UpdateQuestion")
public class UpdateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qu_num = Integer.parseInt(request.getParameter("qu_num"));
		IQnaService service = QnaServiceimpl.getService();
		Qna_q_vo qv= service.updateSelect(qu_num);
		request.setAttribute("questionvo", qv);
		request.getRequestDispatcher("mem_view/qna_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Qna_q_vo qv = new Qna_q_vo();
		
		try {
			BeanUtils.populate(qv, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IQnaService service = QnaServiceimpl.getService();
		
		int count = service.updateQuestion(qv);
		request.setAttribute("count", count);
		request.getRequestDispatcher("mem_view/chk.jsp").forward(request, response);
		
		
	}

}
