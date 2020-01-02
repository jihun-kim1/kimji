<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel="stylesheet">
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<style>
	td { text-align: center; }
</style>
</head>
<body>
	<table id="example" class="row-border" style="width: 100%">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="noticeList" items="${noticeList }">
				<tr>
					<td>${noticeList.notice_seq}</td>
					<td>${noticeList.notice_title}</td>
					<td>${noticeList.notice_writer}</td>
					<td>${noticeList.notice_write_date}</td>
					<td>${noticeList.notice_view_count}</td>
				</tr>
			</c:forEach>
		</tbody>
		
		<script>
		$(document).ready(function() {
		    $('#example').DataTable();
		} );
		$($.fn.dataTable.tables(true)).DataTable()
		   .columns.adjust();
		</script>
</body>
</html>