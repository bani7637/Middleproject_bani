<%@page import="board.qna.vo.Qna_q_vo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	Qna_q_vo vo = (Qna_q_vo) request.getAttribute("questionvo");
    	
    
    %>
    
{
		"qu_num" : "<%= vo.getQu_num() %>",
		"mem_id" : "<%= vo.getMem_id() %>",
		"qu_title" : "<%= vo.getQu_title() %>",
		"qu_date" : "<%= vo.getQu_date() %>",

		<%-- 방법1 --%>
		"qu_content" : "<%= vo.getQu_content().trim().replaceAll("\\n|(\\r\\n)", "\\\\n") %>"
		
		}
		
		
	