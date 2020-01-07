<%@ page import="kh.picsell.dto.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<div id="container">
<h1>회원관리</h1>
<c:choose>
<c:when test = "${list.size() ==0 }">
<h3>회원없음</h3>
</c:when>
<c:otherwise>
<table>
<tr>
<th>아이디
<th>이름
<th>별명
<th>이메일
<th>블랙리스트여부
<th>
</tr>
<c:forEach items = "${list}" var="dto">
<tr>
<td>${dto.id }</td>
<td>${dto.name }</td>
<td>${dto.nickname }</td>
<td>${dto.email }</td>
<td>${dto.black }</td>
<td><input type="button" value="블랙" id="blackup${dto.id}">
<input type="button" value="블랙해제" id="blackdown${dto.id}"></td>
</tr>
<script>
$("#blackup${dto.id}").on("click",function(){
	if(${dto.black}>=2){
		alert("더이상 블랙업을 할수 없습니다.")
	}else{
	$.ajax({
		url:"blackup.do",
		type:"post",
		data:{id:"${dto.id}"}
	}).done(function(res){
		if(res="블랙업"){alert("블랙up");
		location.href="manage.do"}
		else if(res="실패"){alert("블랙down")}
	}).fail(function(res){
		alert("서버에러입니다.")
	});}
})
$("#blackdown${dto.id}").on("click",function(){
	if(${dto.black}<=0){
		alert("더이상 블랙다운을 할수 없습니다");
	}else{
	$.ajax({
		url:"blackdown.do",
		type:"post",
		data:{id:"${dto.id}"}
	}).done(function(res){
		if(res="블랙다운"){alert("블랙down");
		location.href="manage.do"}
		else if(res="실패"){alert("블랙down")}
	}).fail(function(res){
		alert("서버에러입니다.")
	});
	}
})
</script>
</c:forEach>
</table>
</c:otherwise> 
</c:choose>
</div>
</body>
</html>