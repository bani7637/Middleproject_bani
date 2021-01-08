<%@page import="java.util.List"%>
<%@page import="fileUpload.vo.FileUpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	List<FileUpVO> list = (List<FileUpVO>) request.getAttribute("list");
    %>
    
    
    
[
<% 
for(int i=0; i<list.size();i++){
	FileUpVO vo = list.get(i);

	if(i>0) out.print(",");
	
%>
    
    {
 	"file_name" : "<%= vo.getFile_name() %>",
	"file_num" : "<%= vo.getFile_num() %>"
	
	
    }
    
    <%
}
%>
]
    