<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<style type="text/css">
#foo{
position: absolute;
width: 100%;
bottom:0px;

}

</style>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" href="../css/qna.css">
</head>
<body>
 	<jsp:include page="../main_view/header1.jsp"></jsp:include>
<jsp:include page="../main_view/header2.jsp"></jsp:include>
      <jsp:include page="qna_board.html"></jsp:include>
     <div id="foo">
<jsp:include page="../main_view/cmmfooter.jsp"></jsp:include>
</div>
</body>
</html>