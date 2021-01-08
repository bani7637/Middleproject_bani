/**
 * 
 */
//처음 페이지 1로 설정
currentpage= 1;





var replyDeleteServer = function(idx, button) {
	$.ajax({
		
		url : '/MiddleProject/ReplyDelete',
		type : 'post',
		dataType : 'json',
		data : {"rep_num" : idx},		
		success : function(res) {
			$(button).parents('.rep').remove();		
		},
		error : function(xhr) {
			alert("상태"+xhr.status);
		}
	})
}


var replyUpdateServer = function() {
	$.ajax({
		url : '/MiddleProject/ReplyUpdate',
		data : reply, //cont, renum
		type : 'post',
		dataType : 'json',
		success: function(res) {
		},
		error : function(xhr) {
			alert("상태"+xhr.status);
		}
	})
}


var replyListServer = function(button) {
	$.ajax({
		data : {"qu_num" : reply.qu_num},
		url : '/MiddleProject/ReplyList',
		type : 'get',
		dataType: 'json',
		error : function(xhr) {
			alert("상태 : "+xhr.status);
		},
		success : function(res) {	
			$(button).parents('.panel').find('.rep').remove();
			repl = "";
			$.each(res, function(i,v) {
				repl+='    <div class="panel-body rep">';
				repl+='    <p style="float: left; width : 70%">';
				repl+='    <img src="../images/adminIcon.png" "width=70px" height=70px>';
			    repl+='   <span class ="content">'+v.rep_content+'</span>';
			    repl+='    	</p>';
			    repl+='    <p style="float: right; width : 20%">';
			    repl+='	<input idx="'+v.rep_num+'" type="button" name="r_modify" class="action" value ="댓글수정">';
			    repl+='	<input idx="'+v.rep_num+'" type="button" name="r_delete" class="action" value ="댓글삭제">';
			    repl+='    </p>';
			    repl+='    </div>';
			})
			
			$(button).parents('.panel').find('.pbody').append(repl);
		}
	})  
}


var replySaveServer = function(button) {
	// reply 객체를 서버로 보낸다.
	button
	$.ajax({
		url : '/MiddleProject/ReplySave',
		data : reply,
		type : 'post',
		success : function(res) {
		//	alert(res.sw);
			//replyListServer(button);
			//$('#chk').css("display", "");
			//$('#chk').appendTo();
		},
		error : function(xhr) {
			alert("상태 : "+ xhr.status);
		},
		dataType : 'json'
	})
}


var readpageServer = function(cpage) {
	$('.box').empty();
	$.getJSON(
		'/MiddleProject/adSelectpage',
		{"page" : cpage},
		function(res) {

			code = ' <div class="panel-group" id="accordion">';
			$.each(res.data, function(i,v) {
				code+=' <div class="panel panel-default">';
			    code+='  <div class="panel-heading">';
			    code+='    <h4 class="panel-title">';
			    code+='      <a class="action" name= "list" idx="'+v.qu_num+'"data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.qu_num+'">'
			    				+v.qu_title+'</a>&nbsp;&nbsp;&nbsp;&nbsp;<span style="display: none" id="chk"></span>';
			    code+='    </h4>';
			    code+='  </div>';
			    code+='  <div id="collapse'+v.qu_num+'" class="panel-collapse collapse ">';
			    code+='    <div class="panel-body pbody">';
			    code+='    <p style="float: left; width : 70%">';
			    code+='    	작성자  : '+v.mem_id+' &nbsp;&nbsp;&nbsp;&nbsp;';
			    code+='    	작성일 : '+v.qu_date+' &nbsp;&nbsp;&nbsp;&nbsp;';
			    code+='    	</p>';
			    code+='    <p style="float: right; width : 20%">';
			    code+='    </p>';
			    code+='    <hr>';
			    
			    code+='    <p class="qq">';				    
			    code+='    </p>';
			    code+='    <p>';
			    code +='내용 :';
			    code+='    <br>';				    
			    code+= v.qu_content;
			    code+='    </p>';
			    code+='    <p>';
			    code+='     <textarea rows="3" cols="60"></textarea>';
			    code+='     <input idx="'+v.qu_num+'" type="button" name="reply" class="action" value="답글작성">';
			    code+='    </p>';
			    code+='    </div>';
			    code+='  </div>';
			    code+='</div>';
				
				
			})
			code += "</div>";
			$('.box').append(code);
			
			totalpage = res.tpage;
			startpage = res.spage;
			endpage = res.epage;
			currentpage = res.cpage;
			////////////////////////////////
			
			$('#btngroup1').empty();
			
			pager ="";
			// 페이지번호 출력
			pager ='<ul class="pagination">';
			for(i=startpage; i<=endpage; i++){
				if(currentpage ==i){
					pager+='<li class="active"><a href="#" class="paging">'+i+'</a></li>';
				}else{
					pager+='<li><a href="#" class="paging">'+i+'</a></li>';
				}
			}			
			pager += '</ul>';
			$(pager).appendTo('#btngroup1');	
				
		
		}
	)
}

var readServer = function(cpage) {   // html 파일에서 readServer(1), readServer(2), readServer(3)
	
	$(function() {

	$.getJSON(
			'/MiddleProject/adSelectAll',
			function(res){
				$('.box').empty();
				code = ' <div class="panel-group" id="accordion">';
				$.each(res, function(i,v) {
					code+=' <div class="panel panel-default">';
				    code+='  <div class="panel-heading">';
				    code+='    <h4 class="panel-title">';
				    code+='      <a data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.qu_num+'">'+v.qu_title+'</a>&nbsp;&nbsp;&nbsp;&nbsp;<span style="display: none" id="chk">완료</span>';
				    code+='    </h4>';
				    code+='  </div>';
				    code+='  <div id="collapse'+v.qu_num+'" class="panel-collapse collapse ">';
				    code+='    <div class="panel-body">';
				    code+='    <p style="float: left; width : 70%">';
				    code+='    	작성자  : '+v.mem_id+' &nbsp;&nbsp;&nbsp;&nbsp;';
				    code+='    	작성일 : '+v.qu_date+' &nbsp;&nbsp;&nbsp;&nbsp;';
				    code+='    	</p>';
				    code+='    <p style="float: right; width : 20%">';
				    code+='    </p>';
				    code+='    <hr>';
				    code+='    <p class="qq">';				    
				    code+='    </p>';
				    code+='    <p>';
				    code +='내용 :';
				    code+='    <br>';				    
				    code+= v.qu_content;
				    code+='    </p>';
				    code+='    <p>';
				    code+='     <textarea rows="3" cols="60"></textarea>';
				    code+='     <input idx="'+v.qu_num+'" type="button" name="reply" class="action" value="답글작성">';
				    code+='    </p>';
				    code+='    </div>';
				    code+='  </div>';
				    code+='</div>';
					
					
				})
				code += "</div>";
				$('.box').append(code);
			}
	)
	})



} 