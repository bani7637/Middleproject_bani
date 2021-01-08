package fileUpload.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fileUpload.service.FileServiceImpl;
import fileUpload.service.IFileService;
import fileUpload.vo.FileUpVO;

/**
 * Servlet implementation class fileDelete
 */
@WebServlet("/fileDelete")
public class fileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private IFileService fileservice = FileServiceImpl.getInstance();

	FileUpVO fileUpVO = new FileUpVO();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int file_num = Integer.parseInt(request.getParameter("file_num"));

		try {
			int count = fileservice.fileDelete(file_num);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		 
		//out.println("<script>alert('사진이 등록되었습니다.'); location.href='이전 페이지';</script>");
		out.println("<script>alert('삭제완료.');history.back();location.reload;</script>");
		 
		out.flush();

	}

	
	
}
