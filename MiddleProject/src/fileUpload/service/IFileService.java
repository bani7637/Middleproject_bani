package fileUpload.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import fileUpload.vo.FileUpVO;

public interface IFileService {

	
	// 다운로드용
	public FileUpVO filedown(int file_num) throws SQLException;
	
//	// 첨부파일 저장
	public FileUpVO insertFile(FileItem item, String file_writer) throws Exception;
	
	// 증명서류 업로드
	public FileUpVO insertFileverifi(FileItem item, String file_writer) throws Exception;
	
	// 파일 삭제
	public int fileDelete(int file_num) throws SQLException;
	
	// 증명서류 리스트
	public List<FileUpVO> selectFile(FileUpVO fileUpVO) throws SQLException;
	
	// 증명사진용
	public FileUpVO select(String file_writer) throws SQLException;
	

	
}
