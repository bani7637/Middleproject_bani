package fileUpload.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class selectFile
 */
@WebServlet("/selectFile_verifi")
public class selectFile_verifi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectFile_verifi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String file_writer = (String) session.getAttribute("id");
		
		FileUpVO fileUpVO = new FileUpVO();
		fileUpVO.setFile_writer(file_writer);
		
		IFileService fileService = FileServiceImpl.getInstance();
		
		List<FileUpVO> list= null;
		try {
			list = fileService.selectFile(fileUpVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("mem_view/filelist.jsp").forward(request, response);
		
	}
}
