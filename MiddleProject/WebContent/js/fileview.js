//<script src= "../js/fileview.js"></script>
//사진보여주기용
var photoview = function() {
	$.ajax({
				url : '/MiddleProject/selectFile',
				type : 'get',
				success : function(res) {

					rrr = '<img id ="' + res.file_name
							+ '" src="../upload_file_img/' + res.file_path
							+ '">';
					rrr +='<br><a href="/MiddleProject/fileDelete?file_num='+res.file_num+'">삭제</a>'
						
					$('#po').append(rrr);
					
					$('.hidd').hide();
				},
				error : function(xhr) {

				},
				dataType : 'json'

			})
}

var blurbview = function() {
	arr = [ "../images/blurb1.png", "../images/blurb2.png", "../images/blurb3.png",
		"../images/blurb4.png", "../images/blurb5.png", "../images/blurb6.png",
		"../images/blurb7.png","../images/blurb8.png", "../images/blurb9.png", "../images/blurb10.png" ];
	a = setInterval(function() {
		rand = Math.floor(Math.random() * arr.length);
		b = arr[rand];
		img1.src = b;
	}, 3000);
	
	blurbimg = document.createElement("img");
}

var introducelength = function() {
	//현재 입력된 글자수
	var chkCnt1 = document.wform.ap_introduce.value.length;
	var cnt1=chkCnt1;
	document.wform.cnt1.value=cnt1;
	if(cnt1==700){
		alert("작성가능 글자수700");
	}
}
var motivationlength = function() {
	//현재 입력된 글자수
	var chkCnt2 = document.wform.ap_motivation.value.length;
	var cnt2=chkCnt2;
	document.wform.cnt2.value=cnt2;
	if(cnt2==700){
		alert("작성가능 글자수700");
	}
}
var planlength = function() {
	//현재 입력된 글자수
	var chkCnt3 = document.wform.ap_plan.value.length;
	var cnt3=chkCnt3;
	document.wform.cnt3.value=cnt3;
	if(cnt3==700){
		alert("작성가능 글자수700");
	}
}


