<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/public.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../js/jquery-3.5.1.min.js"></script>
<script src="../js/memberchk.js"></script>   
  <script src= "../js/fileview.js"></script>

<style>
	#leftlist{
		width : 350px;
		height : auto;
		float : left;
	}
	
	#center{
		width : calc(100% - 400px);
		height : auto;
	}
	
	#tb1{
		width : 700px;
		height : 400px;
	}
	
	#footer{
		width : 100%;
	}
	
	.list-group-item.active, .list-group-item.active:focus, .list-group-item.active:hover{
		background-color : #2e8ec9;
		border-color : #2e8ec9;
	}
	#file{
	position : absolute;
	top : 20%;
	left : 30%;
}
	.box{
	position : absolute; 
	top : 30%;
	left : 30%;
	width :200px;
	}
	#res{
	width : 400px;
	}
	#file_css{
	width:30px;
	hight:30px;
	float:left;
	margin-right:20px;
	clear: both;
	}
	#foot{
	position : absolute; 
	top : 68%;
	
	width :100%;
	}
 		
</style>
<script>
blurbview();
$(function() {
	blurbview();
	$('#action3').on('click', function() {
		$.ajax({
			url : '/MiddleProject/selectFile_verifi',
			type : 'get',
			success : function(res){
			code='<table id="res">';
				$.each(res, function(i,v) {
			code+='<tr><td id='+v.file_num+'><img id="file_css" src="../images/file_css.png"><h4><a href="/MiddleProject/FileDownload?file_num='+v.file_num+'">'+v.file_name+'</a></td><td><a href="/MiddleProject/fileDelete?file_num='+v.file_num+'"><span class="glyphicon glyphicon-trash"></span></a></td></tr></h4>';
				})
			code+='</table>';
				$('.box').html(code);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
			
		})
	})
	
})


</script>

<body>
<jsp:include page="../main_view/header1.jsp"></jsp:include>
<jsp:include page="../main_view/header2.jsp"></jsp:include>
<div id="list-group">
	<ul id="leftlist" style="list-style: none;">
		      			<li><a href="#" class="list-group-item disabled active">마이페이지</a></li>
		        <li><a href="<%=request.getContextPath() %>/mem_view/myfile.jsp" class="list-group-item">업로드파일관리</a></li>
		     <li><a href="<%=request.getContextPath() %>/ModifyDegree?memId=<%=session.getAttribute("id")%>" class="list-group-item">학적사항관리</a></li>
		     <li><a href="<%= request.getContextPath() %>/mem_view/bookmarkview.jsp" class="list-group-item">관심기업</a></li>
		     <li><a href="<%=request.getContextPath() %>/member/updatemempage.jsp" class="list-group-item">내정보수정</a></li>
		     <li><a href="<%=request.getContextPath() %>/member/changemempass.jsp" class="list-group-item">비밀번호변경</a></li>
		     <li><a href="<%=request.getContextPath() %>/member/memdelpage.jsp" class="list-group-item">회원탈퇴</a></li>
	</ul>
</div>






<div id ="file">
	<form method="post" enctype="multipart/form-data" action="/MiddleProject/insertFileverifi" style="display:inline">			
		<input name="file" type="file" class="btn btn-primary"  style="display:inline">
		<input type="submit" value="Upload" id="action2" class="btn btn-primary" style="display:inline"/>
	</form>
<input type="button" name="select" id="action3" class="btn btn-primary" value="Upload_File확인" style="display:inline"/>

	</div>
	
	
	<div class="box"></div>
	
	<div id="Advertising" style="float: right; padding-right: 3%; ">
	<a href="../company_view/eachrecruitlist.jsp"><img src="../images/blurb1.png" id="img1" alt="광고없음"></a>
	</div>
	
	<div id="foot">
<jsp:include page="../main_view/cmmfooter.jsp"></jsp:include>
</div>
	
</body>