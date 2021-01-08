// 키워드 검색 메서드



var searchboardServer = function(cfind) {
	
	$.ajax({
		url : '/MiddleProject/qna_search',
		data : {"cfind" : cfind},
		type : 'get',
		dataType: 'json',
		error : function(xhr) {
		},
		success : function(res) {
			$('.result').empty();
			if(res==""){
				repl='<img src="../images/qna_s_null.png" "width=500px" height=500px>';
				$('.result').append(repl);
			}
			if(res!=""){
				code = '<div class="panel-group" id="accordion" style="width:80%; padding:2px; float:left;">';
				//code = '<div class="panel-group" id="accordion">';
				$.each(res, function(i,v) {
					code+=' <div class="panel panel-default">';
				    code+='  <div class="panel-heading">';
				    code+='    <h4 class="panel-title">';
				    code+='      <a class="action" name= "list" idx="'+v.qu_num+'" data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.qu_num+'">'+v.qu_title+'</a>&nbsp;&nbsp;&nbsp;&nbsp;<span style="display: none" id="chk">완료</span>';
				    code+='    </h4>';
				    code+='  </div>';
				    code+='  <div id="collapse'+v.qu_num+'" class="panel-collapse collapse ">';
				    code+='    <div class="panel-body pbody">';
				    code+='    <p style="float: left; width : 70%">';
				    code+='    	작성자  : '+v.mem_id+' &nbsp;&nbsp;&nbsp;&nbsp;';
				    code+='    	작성일 : '+v.qu_date+' &nbsp;&nbsp;&nbsp;&nbsp;';
				    code+='    	</p>';
				    code+='    <p style="float: right; width : 20%">';
					code+='	<input idx="'+v.qu_num+'" type="button" name="modify" class="action" value ="수정">';
					code+='	<input  idx="'+v.qu_num+'" type="button" name="delete" class="action" value ="삭제">';
				    code+='    </p>';
				    code+='    <hr>';
				    code+='    <p>';				    
				    code +='내용 :';
				    code+='    <br>';				    
				    code+= v.qu_content;
				    code+='    </p>';
				    code+='    <p>';
				    code+='    </p>';
				    code+='    </div>';
				    code+='  </div>';
				    code+='</div>';
			
					})

					code+= '</div>';
				
					$('.result').append(code);
			}
		}
	})
}


// 답글 리스트 보여주는 메서드
var replyListServer = function(button) {
	$.ajax({
		data : {"qu_num" : reply.qu_num},
		url : '/MiddleProject/ReplyList',
		type : 'get',
		dataType: 'json',
		error : function(xhr) {
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
			    repl+='    </p>';
			    repl+='    </div>';
			})
			
			$(button).parents('.panel').find('.pbody').append(repl);
		}
	})  
}


// 질문 수정 메서드
var updateboardServer = function() {
	$.ajax({
		url : '/MiddleProject/UpdateQuestion',
		type : 'post',
		dataType : 'json',
		data : $('#uform').serialize(),
		success : function(res) {
			location.reload();
		},
		error : function(xhr) {
		}
		
	})
}


// 질문 수정 후 보여주는 메서드
var viewServer = function() {
	$.ajax({
		url : '/MiddleProject/UpdateQuestion',
		type : 'get',
		data : {"qu_num": idx},
		dataType : 'json',
		success : function(res) {
			
			$('#uqu_num').val(res.qu_num);
			$('#uqu_title').val(res.qu_title);
			$('#uqu_content').val(res.qu_content);
			
			$('#uModal').modal('show');
			
		}, 
		error : function(xhr) {
		}
	})
}


// 질문 삭제 메서드
var deleteServer = function() {
	$.ajax({
		url : '/MiddleProject/QuestionDelete',
		type : 'post',
		dataType : 'json',
		data : {"qu_num" : idx},		
		success : function(res) {	
			location.reload();
		},
		error : function(xhr) {
		}
	})
}


// 질문 작성 메서드
var writeServer = function() {
	$.ajax({
		url : '/MiddleProject/InsertQuestion',
		data : $('#wform').serialize(),
		dataType : 'json',
		type : 'post',
		success : function(res) {
			location.reload();
		},
		error : function(xhr) {
		}
		
	})
}




// 전체 질문 나타내는 메서드
var readServer = function() {   
	$(function() {
	$.getJSON(
			'/MiddleProject/SelectAll',
			function(res){
				$('.result').empty();
				
				if(res==""){
					repl='<img src="../images/qna_null.png" "width=500px" height=500px>';
					$('.result').append(repl);
				}
				if(res!=""){
					code = '<div class="panel-group" id="accordion" style="width:80%; padding:10px; float:left;">';
					$.each(res, function(i,v) {
						code+=' <div class="panel panel-default">';
					    code+='  <div class="panel-heading">';
					    code+='    <h4 class="panel-title" >';
					    code+='      <a class="action" name= "list" idx="'+v.qu_num+'" data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.qu_num+'">'+v.qu_title+'</a>&nbsp;&nbsp;&nbsp;&nbsp;';
					    code+='    </h4>';
					    code+='  </div>';
					    code+='  <div id="collapse'+v.qu_num+'" class="panel-collapse collapse ">';
					    code+='    <div class="panel-body pbody">';
					    code+='    <p style="float: left; width : 70%">';
					    code+='    	작성자  : '+v.mem_id+' &nbsp;&nbsp;&nbsp;&nbsp;';
					    code+='    	작성일 : '+v.qu_date+' &nbsp;&nbsp;&nbsp;&nbsp;';
					    code+='    	</p>';
					    code+='    <p style="float: right; width : 20%">';
						code+='	<input idx="'+v.qu_num+'" type="button" name="modify" class="action" value ="수정">';
						code+='	<input  idx="'+v.qu_num+'" type="button" name="delete" class="action" value ="삭제">';
					    code+='    </p>';
					    code+='    <hr>';
					    code+='    <p>';				    
					    code+='내용 :';
					    code+='    <br>';				    
					    code+= v.qu_content;
					    code+='    </p>';
					    code+='    <p>';
					    code+='    </p>';
					    code+='    </div>';
					    code+='  </div>';
					    code+='</div>';
					})
					code += "</div>";
					
					$('.result').append(code);
				}
				
			}
			
			
		)
	})


}


	


