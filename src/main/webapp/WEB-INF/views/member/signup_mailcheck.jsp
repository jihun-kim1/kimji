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
<script>
console.log(email);
location.href="../mail/signmail.do?email="+email;
</script>
<div id="email_check_container">
		<br><br>
	이메일로 전송된 인증번호를 입력하세요<br><br>
	<input type="text" id="receive"> <br><br><br>
	<button type="button" id="btn">확인</button>
	</div>
	<script>

	$("#btn").on("click",function(){
		var input = $("#received").val();
		var email_key = "${sign}";
		
		var email_check_result;
		console.log(email_key);
		if(email_key==input){
			$.ajax({
   				url:"",
   				type:"post",
   				data:{email:email}
   			}).done(function(res){
   				if(res == "사용 가능한 메일주소입니다."){
   					$("#emailcheck").html("사용 가능한 메일주소입니다.").css("color","blue");
   					$("#phone").focus();
   					mailValid = 1;
   					console.log(mailValid);
   				}
   				else if(res == "중복된 메일주소입니다."){
   					$("#emailcheck").html("중복된 메일주소입니다.").css("color","red");
   					$("#email").val("");
   					mailValid = 0;
   					$("#email").focus();
   				}
   			}).fail(function(res){
   				alert("서버문제입니다 관리자에게 문의하세요");
   			});
			alert("인증번호로 비밀번호가 변경됩니다")
			window.opener.emailCheckValid = 1;
			setTimeout(function() {window.close();}, 0);

		}else{
			alert("이메일 인증에 실패하였습니다. 다시 인증해주세요");
			window.opener.emailCheckValid = 0;
		}
	})
		</script>
</body>
</html>