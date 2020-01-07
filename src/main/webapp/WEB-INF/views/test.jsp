<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<input type="button" id="notice" value="notice">
<p>a123<img src="/notice_summernote_files/1578362623368_훈현참여지원수당.jpg"></p>
	<script>
		$("#notice").on("click",function(){
			location.href="${pageContext.request.contextPath}/notice/notice.do"
		})
	</script>
</body>
</html>