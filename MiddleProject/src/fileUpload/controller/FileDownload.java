package fileUpload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
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
 * Servlet implementation class FileDownload
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private IFileService fileservice = FileServiceImpl.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int file_num =Integer.parseInt(request.getParameter("file_num"));
		FileUpVO fileVO =null;
		
		try {
			fileVO = fileservice.filedown(file_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 파일 다운로드 처리를 위한 응답헤더 정보 설정하기
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileVO.getFile_name(), "utf-8") + "\"");
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileVO.getFile_path()));
		//BufferedInputStream bis = new BufferedInputStream(new FileInputStream(DOWNLOAD_DIR+fileName));
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		
		int c;
		
		while((c = bis.read()) != -1) {
			bos.write(c);
		}
		bis.close();
		bos.close();
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
