package fileUpload.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import fileUpload.service.FileServiceImpl;
import fileUpload.service.IFileService;
import fileUpload.vo.FileUpVO;

/**
 * Servlet implementation class insertfile
 */
@WebServlet("/insertfile")
public class insertfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FileUpVO fileUpVO = new FileUpVO();
	
	private IFileService fileservice = FileServiceImpl.getInstance();
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertfile() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String file_writer = (String) session.getAttribute("id");
		FileUploadRequestWrapper requestWrapper = null;
		try {
			requestWrapper = new FileUploadRequestWrapper(request);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}

		FileItem item = ((FileUploadRequestWrapper) requestWrapper).getFileItem("file");

		// FileItem item = requestWrapper.getFileItem("file");
		if (item != null && !item.getName().equals("")) {
			try {
				fileUpVO = fileservice.insertFile(item, file_writer);
			} catch (Exception e) {
				e.printStackTrace();
			}

			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			// out.println("<script>alert('사진이 등록되었습니다.'); location.href='이전
			// 페이지';</script>");
			out.println("<script>alert('사진이 등록되었습니다.');history.back();</script>");

			out.flush();

		}
	}

}