package fileUpload.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;


public class FileUploadRequestWrapper_verifi extends HttpServletRequestWrapper{
	// 저장경로 웹서버 프로젝트안에 저장되어있기 때문에 업로드 해야 파일 보임
	// 학원 컴퓨터용
	public static final String UPLOAD_DIRECTORY = "D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\MiddleProject\\WebContent\\upload_file_verifi";
	
	// PL노트북
	//public static final String UPLOAD_DIRECTORY = "D:\\WS\\share\\MiddleProject\\WebContent\\upload_file_verifi";
	
	// 요청 데이터가 멀티파트인지 확인하기 위한 변수
	private boolean multipart = false;

	// 폼필드에 담긴 파라미터 데이터를 담기 위한 맵
	private Map<String, String[]> parameterMap;

	// FileItem을 담기위한 맵
	private Map<String, Object> fileitemMap;

	public FileUploadRequestWrapper_verifi(HttpServletRequest request) throws FileUploadException {
		this(request, -1, -1, -1, null);
	}

	public FileUploadRequestWrapper_verifi(HttpServletRequest request, int memoryThreashold, int fileSizeMax,
			int maxRequestSize, String respositoryPath) throws FileUploadException {

		super(request);

		parsing(request, memoryThreashold, fileSizeMax, maxRequestSize, respositoryPath);

	}


	/**
	 * @param request
	 * @param memoryThreashold
	 *            메모리 임계크기
	 * @param fileSizeMax
	 *            파일 1개당 최대 크기
	 * @param maxRequestSize
	 *            요청 파일 최대 크기
	 * @param respositoryPath
	 *            임시파일 저장경로
	 * @throws FileUploadException
	 */
	private void parsing(HttpServletRequest request, int memoryThreashold, int fileSizeMax, int maxRequestSize,
			String respositoryPath) throws FileUploadException {
		if (ServletFileUpload.isMultipartContent(request)) {
			multipart = true; // 멀티파트임을 설정함

			parameterMap = new HashMap<String, String[]>();
			fileitemMap = new HashMap<>();

			DiskFileItemFactory factory = new DiskFileItemFactory();

			if (memoryThreashold != -1) {
				factory.setSizeThreshold(memoryThreashold);
			}
			if (respositoryPath != null) {
				factory.setRepository(new File(respositoryPath));

			} else {
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			}
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			servletFileUpload.setFileSizeMax(fileSizeMax);
			servletFileUpload.setSizeMax(maxRequestSize);

			List<FileItem> list = servletFileUpload.parseRequest(request);

			for (int i = 0; i < list.size(); i++) {
				FileItem fileItem = (FileItem) list.get(i);
				String name = fileItem.getFieldName(); // 필트명 가져오기
				if (fileItem.isFormField()) { // 폼필드 인경우..
					String value = "";
					try {
						value = fileItem.getString("UTF-8");

					} catch (UnsupportedEncodingException ex) {
						ex.printStackTrace();
					}
					String[] values = (String[]) parameterMap.get(name);
					if (values == null) {
						values = new String[] { value };
					} else {
						String[] tempValue = new String[values.length + 1];
						System.arraycopy(values, 0, tempValue, 0, 1);
						tempValue[tempValue.length - 1] = value;
						values = tempValue;
					}
					parameterMap.put(name, values);

				} else {
					fileitemMap.put(name, fileItem);
				}
			}
		}
	}

	public boolean isMultipartContent() {
		return multipart;
	}

	public String getParameter(String name) {

		if (multipart) {
			String[] values = (String[]) parameterMap.get(name);
			if (values == null)
				return null;

			return values[0];

		} else {
			return super.getParameter(name);
		}
	}

	public String[] getParameterValues(String name) {
		if (multipart) {
			return (String[]) parameterMap.get(name);
		} else {
			return super.getParameterValues(name);
		}
	}

	public Enumeration<String> getParameterNames() {
		if (multipart) {
			return new Enumeration<String>() {
				Iterator<String> iter = parameterMap.keySet().iterator();

				@Override
				public boolean hasMoreElements() {
					return iter.hasNext();
				}

				@Override
				public String nextElement() {
					return iter.next();
				}
			};
		} else {
			return super.getParameterNames();
		}

	}

	public Map<String, String[]> getParameterMap() {
		if (multipart) {
			return parameterMap;
		} else {
			return super.getParameterMap();
		}
	}

	public Map<String, Object> getFileItemMap() {
		if (multipart) {
			return fileitemMap;
		} else {
			return null;
		}
	}

	public FileItem getFileItem(String name) {
		if (multipart) {
			return (FileItem) fileitemMap.get(name);
		} else {
			return null;
		}
	}
}
