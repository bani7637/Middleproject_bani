<%@page import="board.qna.vo.Qna_a_vo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    List<Qna_a_vo> list =(List<Qna_a_vo>) request.getAttribute("list");
    %>
    
    [
    <% 
    for(int i =0; i<list.size(); i++){
    	Qna_a_vo vo = list.get(i);
    	if(i>0) out.print(",");
    %>
    
{
	"rep_num" : "<%= vo.getRep_num() %>",		
	"rep_date"	: "<%= vo.getRep_date() %>",
	"qu_num"	:	"<%= vo.getQu_num() %>",
	"rep_content" : "<%= vo.getRep_content().trim().replaceAll("\\n|(\\r\\n)", "\\\\n") %>"
}    
<% 
    }
%>    
    ]