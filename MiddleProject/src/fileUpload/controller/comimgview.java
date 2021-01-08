package fileUpload.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fileUpload.service.FileServiceImpl;
import fileUpload.service.IFileService;
import fileUpload.vo.FileUpVO;

/**
 * Servlet implementation class comimgview
 */
@WebServlet("/comimgview")
public class comimgview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comimgview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String file_writer = request.getParameter("mem_id");
		FileUpVO fileUpVO = new FileUpVO();
		fileUpVO.setFile_writer(file_writer);
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		
		try {
			fileUpVO = fileService.select(file_writer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("fileUpVO", fileUpVO);
		request.getRequestDispatcher("mem_view/imgdown.jsp").forward(request, response);
		
	}
}