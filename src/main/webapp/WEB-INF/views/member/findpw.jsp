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
<form id="frm" action="findpwProc.do" method="post">
<div id="idfind_header">
<h3>비밀번호 찾기</h3>
</div>
<div class="inputinfo">
<span>ID</span><input type="text" id="id" name="id" placeholder="ID입력">
</div>
<div class="inputinfo">
<span>이메일</span><input type="text" id="email" name="email" placeholder="이메일입력"><input type="button" id="sendmail" value="인증번호받기">
</div>
<div class="inputinfo">
<span>인증번호입력</span><input type="text" id="mailvalue" placeholder="인증번호">
</div>
<div>
<input type="button" id="find" value="찾기">
</div>
</form>
<script>
//이메일인증
	$("#sendmail").on("click",function(){
	var email = $("#email").val();
	var id = $("#id").val();
	if(id==""){
	alert("ID를 입력해주세요");
	return;
	}else if(email==""){
		alert("이메일을 입력해주세요");
		return;
	}
	else if(email != "" || id != ""){
	$.ajax({
		url:"${pageContext.request.contextPath}/mail/mail.do",
		type:"post",
		data:{email:email}
	}).done(function(res){
		alert("인증번호가 발송되었습니다");
	}).fail(function(res){
		alert("메일주소를 확인해주세요");
	});
	}
})
$("#find").on("click",function(){
	var input = $("#mailvalue").val();
	//var email_key = "${AuthenticationKey}"; //이걸 컨트롤러로 보내서처리
	var id = $("#id").val();
	var email = $("#email").val();

		$.ajax({
				url:"${pageContext.request.contextPath}/member/pwchange.do",
				type:"post",
				data:{email:email,input:input,id:id}
			}).done(function(res){
				if(res == "변경완료"){
					alert("인증번호로 임시비밀번호가 변경되었습니다.");
					location.href="../home";
				}
				else if(res == "변경실패"){
					alert("아이디와 이메일을 다시한번 확인해주세요");
				}else if(res == "인증번호"){
					alert("인증번호를 다시 확인해주세요");
				}
			}).fail(function(res){
				if(res=="실패했습니다"){
					alert("서버에러입니다 관리자에게 문의하세요");
				}
			});

	
})
</script>
</body>
</html>