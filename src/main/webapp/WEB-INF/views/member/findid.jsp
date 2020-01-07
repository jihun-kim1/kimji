<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#idfind_header{	
	    text-align: center;
	    background-color: #dedede;
	    color: white;
	    width: 700px;
	    height: 100px;
	    line-height: 50px;
	    margin: auto;
	    border-radius: 10px;
}
.inputinfo{
    margin-top: 20px;
    margin-bottom: 20px;
    margin-left: 130px;
    position: relative;
    left: 50px;
    }
    #frm{
    margin:auto;
    width:800px;
    }
    div:not(.inputinfo){
    text-align:center;}
    span{
    display: inline-block;
    text-align: right;
    width: 75px;
    right:10%;
    font-size:17px;
    margin-right:10px;
    }
    input[type=text]{
    width: 275px;
    height: 30px;
    margin-right:10px;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<form id="frm" action="findidProc.do" method="post">
<div id="idfind_header">
<h3>ID찾기</h3>
</div>
<div class="inputinfo">
<span>이름</span><input type="text" id="name" name="name" placeholder="이름입력">
</div>
<div class="inputinfo">
<span>이메일</span><input type="text" id="email" name="email" placeholder="이메일입력">
</div>
<p id="findval"></p>
<div>
<input type="button" id="find" value="찾기">
</div>
</form>
<script>
$("#find").on("click",function(){
	var name = $("#name").val();
	var email = $("#email").val();
	if(name!=null && email!=null){
	$.ajax({
			url:"${pageContext.request.contextPath}/member/findidProc.do",
			type:"post",
			data:{email:email,name:name}
		}).done(function(res){
			if(res == "회원목록없음"){
				$("#findval").html("회원목록에 없습니다");
			}
			else {
				$("#findval").html("회원님의 ID는 [ "+res+" ]입니다.");
			}
			nickvalid = 1;
		}).fail(function(res){
			$("#alert_nickname_form").html(res).css("color","red");
		});
	}else{
			alert("모두 입력해주세요")
		}
})
</script>
</body>
</html>