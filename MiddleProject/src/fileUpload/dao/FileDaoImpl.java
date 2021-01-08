package fileUpload.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

import fileUpload.vo.FileUpVO;
import ibatis.config.SqlMapClientFactory;

public class FileDaoImpl implements IFileDao {

	private SqlMapClient client;
	private static IFileDao fileDao;

	private FileDaoImpl() {
		client = SqlMapClientFactory.getClient();
	}

	public static IFileDao getInstance() {
		if (fileDao == null) {
			fileDao = new FileDaoImpl();
		}
		return fileDao;
	}

	@Override
	public int insertFile(FileUpVO fileUpVO) throws SQLException {

		Object obj = client.insert("fileUp.insertFile", fileUpVO);

		int cnt = 0;

		if (obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<FileUpVO> selectFile(FileUpVO fileUpVO) throws SQLException {
		return client.queryForList("fileUp.selectFile", fileUpVO);
	}

	@Override
	public int insertFileverifi(FileUpVO fileUpVO) throws SQLException {

		Object obj = client.insert("fileUp.insertFile", fileUpVO);

		int cnt = 0;

		if (obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public FileUpVO select(String file_writer) throws SQLException {
		FileUpVO fileUpVO = (FileUpVO) client.queryForObject("fileUp.select", file_writer);
		return fileUpVO;
	}

	@Override
	public int fileDelete(int file_num) throws SQLException {
		return (Integer) client.delete("fileUp.fileDelete", file_num);
	}

	@Override
	public FileUpVO filedown(int file_num) throws SQLException {
		return (FileUpVO) client.queryForObject("fileUp.filedown", file_num);
	}

	

}
