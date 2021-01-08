package board.qna.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.qna.service.IQnaService;
import board.qna.service.QnaServiceimpl;
import board.qna.vo.Qna_q_vo;

/**
 * Servlet implementation class adSelectpage
 */
@WebServlet("/adSelectpage")
public class adSelectpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adSelectpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트 요청시  cpage값 가져오기
				int cpage = Integer.parseInt(request.getParameter("page"));
				
				// 2. service객체 얻어오기
				IQnaService service = QnaServiceimpl.getService();
				
				// 3. 전체글 갯수 구하는 메서드 호출하기
				// 한페이지당 출력글 갯수 5 or 10
				int perlist = 5;
				int totalcount = service.getTotalCount();
				
				// 전체페이지수 
				int totalpage = (int)(Math.ceil((double)totalcount / perlist));
				
				int perblock = totalcount/5+1; // 한화면에 표현되는 페이지 수    한화면에 표현되는 페이지수(2개)      ==> [1][2]////[3][4]////[5][6].. 
				
				//5->[5][6] 6->[5][6] 7->[7][8]
				int startpage = ((cpage-1) / perblock * perblock) + 1;
				int endpage = startpage + perblock-1;
				if(endpage> totalpage) endpage = totalpage;
		 		
				// cpage값에 따라서  start와 end구하기 1페이지 일때는 1~3 2페이지 일때는 4~6 3페이지 일때는 7~9
				// map에 설정하기 10~12, 13~15 16~19 20~22
				int start = (cpage-1) * perlist +1;
				int end = start + perlist -1;
				
				//end=22 total=20
				if(end> totalcount) end =totalcount;
				Map<String, Integer> map = new HashMap<>();
				map.put("start", start);
				map.put("end", end);
				
				// 4. 페이지별 리스트 메서드 호출하기
				List<Qna_q_vo> list = service.selectPage(map);
				
				// requeat에 결과 저장하기
				request.setAttribute("listvalue", list);
				request.setAttribute("spage", startpage);
				request.setAttribute("epage", endpage);
				request.setAttribute("tpage", totalpage);
				request.setAttribute("cpage", cpage);
				
				// jsp
				request.getRequestDispatcher("admin_view/qnalistPage.jsp").forward(request, response);
			}
}
