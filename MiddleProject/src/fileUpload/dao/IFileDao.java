package fileUpload.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import fileUpload.vo.FileUpVO;

public interface IFileDao {
	
	// 이미지 업로드
	public int insertFile(FileUpVO fileUpVO) throws SQLException;
	
	// 증명서류 리스트
	public List<FileUpVO> selectFile(FileUpVO fileUpVO) throws SQLException;
	
	// 증명서류 업로드
	public int insertFileverifi(FileUpVO fileUpVO) throws SQLException;
	
	// 이미지 출력용
	public FileUpVO select(String file_writer) throws SQLException;
	
	// 삭제
	public int fileDelete(int file_num) throws SQLException;
	
	// 다운로드용
	public FileUpVO filedown(int file_num) throws SQLException;
	

}
