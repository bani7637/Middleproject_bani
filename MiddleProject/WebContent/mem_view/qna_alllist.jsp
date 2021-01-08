<%@page import="board.qna.vo.Qna_q_vo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <% 
    List<Qna_q_vo> list = (List<Qna_q_vo>)request.getAttribute("listvalue");
    %>
    [
<% 
	for(int i=0; i<list.size(); i++){
	Qna_q_vo qv = list.get(i);
	if(i>0)out.print(",");
%>
	{
	"qu_num" : "<%= qv.getQu_num() %>",
	"mem_id" : "<%= qv.getMem_id() %>",
	"qu_title" : "<%= qv.getQu_title() %>",
	"qu_content" :"<%= qv.getQu_content().trim().replaceAll("\\n|(\\r\\n)", "\\\\n") %>",
	"qu_date" :"<%= qv.getQu_date() %>"
	}
<%	
	}
%>    
    ]
    