package fileUpload.vo;

public class FileUpVO {
	
	private int file_num    ;    // 파일 번호
	private String file_name   ; // 원본 파일명
	private String file_extend ; // 파일 확장자
	private String file_path   ; // 저장경로
	private String file_writer ; // 파일 작성자?
	
	public String getFile_writer() {
		return file_writer;
	}
	public void setFile_writer(String file_writer) {
		this.file_writer = file_writer;
	}
	public int getFile_num() {
		return file_num;
	}
	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_extend() {
		return file_extend;
	}
	public void setFile_extend(String file_extend) {
		this.file_extend = file_extend;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
}
