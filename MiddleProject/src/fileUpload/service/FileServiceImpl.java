package fileUpload.service;

import java.sql.SQLException;
import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;

import fileUpload.controller.FileUploadRequestWrapper;
import fileUpload.controller.FileUploadRequestWrapper_verifi;
import fileUpload.dao.FileDaoImpl;
import fileUpload.dao.IFileDao;
import fileUpload.vo.FileUpVO;

public class FileServiceImpl implements IFileService{
	
	private static IFileService fileService;
	private IFileDao fileDao;
	
	private FileServiceImpl() {
		fileDao = FileDaoImpl.getInstance();
	}
	
	public static IFileService getInstance() {
		if(fileService == null) {
			fileService = new FileServiceImpl();
		}
		return fileService;
	}
	
	@Override
	public FileUpVO insertFile(FileItem item, String file_writer) throws Exception {
		String orignFileName = new File(item.getName()).getName();
		String fileExtension = orignFileName.lastIndexOf(".") < 0 ? "" : orignFileName.substring
								(orignFileName.lastIndexOf(".")+1);
		String saveFileName = UUID.randomUUID().toString().replace("-", "")+".png";
		
		File upload = new File(FileUploadRequestWrapper.UPLOAD_DIRECTORY);
		
		if(!upload.exists()) {
			upload.mkdirs();
		}
		
		// 파일저장 경로
		String filePath = FileUploadRequestWrapper.UPLOAD_DIRECTORY + File.separator + saveFileName;
//		String filePath = FileUploadRequestWrapper.UPLOAD_DIRECTORY;
		
		File saveFile = new File(filePath);
		
		try {
			item.write(saveFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //업로드 파일 저장
		
	
		FileUpVO vo = new FileUpVO();
		
		vo.setFile_name(orignFileName);
		vo.setFile_extend(fileExtension);
		vo.setFile_path(filePath);
		vo.setFile_writer(file_writer);
		
		// 첨부파일 정보저장
		try {
			fileDao.insertFile(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 임시파일 삭제
		item.delete();
		
		return vo;
	}
	
	
	@Override
	public List<FileUpVO> selectFile(FileUpVO fileUpVO){
		List<FileUpVO>list =null;
		try {
			list = fileDao.selectFile(fileUpVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public FileUpVO insertFileverifi(FileItem item, String file_writer) throws Exception {
		String orignFileName = new File(item.getName()).getName();
		String fileExtension = orignFileName.lastIndexOf(".") < 0 ? "" : orignFileName.substring
								(orignFileName.lastIndexOf(".")+1);
		String saveFileName = UUID.randomUUID().toString().replace("-", "");
	//	String saveFileName = orignFileName;
		
		File upload = new File(FileUploadRequestWrapper_verifi.UPLOAD_DIRECTORY);
		
		
		// 파일저장 경로
		String filePath = FileUploadRequestWrapper_verifi.UPLOAD_DIRECTORY + File.separator + saveFileName;
		
		File saveFile = new File(filePath);
		
		item.write(saveFile); //업로드 파일 저장
		
	
		
		FileUpVO vo2 = new FileUpVO();
		
		vo2.setFile_name(orignFileName);
		vo2.setFile_extend(fileExtension);
		vo2.setFile_path(filePath);
		vo2.setFile_writer(file_writer);

		
		// 첨부파일 정보저장
		fileDao.insertFile(vo2);
		
		// 임시파일 삭제
		item.delete();
		
		return vo2;
		
	}

	@Override
	public FileUpVO select(String file_writer) throws SQLException {
		return fileDao.select(file_writer);
	}

	@Override
	public int fileDelete(int file_num) throws SQLException {
		return fileDao.fileDelete(file_num);
	}

	
	@Override
	public FileUpVO filedown(int file_num) throws SQLException {
		FileUpVO fileUpVO = new FileUpVO(); 
		fileUpVO = fileDao.filedown(file_num);
		return fileUpVO;
	}

}